package com.sjhy.platform.sanguo;
/**
 * ios支付
 */

import com.alibaba.fastjson.JSONObject;
import com.sjhy.platform.biz.utils.DbVerifyUtils;
import com.sjhy.platform.client.deploy.config.IosCode;
import com.sjhy.platform.client.dto.history.PlayerPayLog;
import com.sjhy.platform.persist.mysql.game.GameContentMapper;
import com.sjhy.platform.persist.mysql.game.PayGoodsMapper;
import com.sjhy.platform.persist.mysql.history.PlayerPayLogMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

@RestController
@RequestMapping("/iap")
public class IapController {
    private static final Logger logger = LoggerFactory.getLogger(IapController.class);

    @Autowired
    private PlayerPayLogMapper playerPayLogMapper;
    @Autowired
    private DbVerifyUtils dbVerify;
    @Autowired
    private PayGoodsMapper payGoodsMapper;
    @Autowired
    private GameContentMapper gameContentMapper;

    //购买凭证验证地址
    private static final String certificateUrl = "https://buy.itunes.apple.com/verifyReceipt";

    //测试的购买凭证验证地址
    private static final String certificateUrlTest = "https://sandbox.itunes.apple.com/verifyReceipt";

    /**
     * 重写X509TrustManager
     */
    private static TrustManager myX509TrustManager = new X509TrustManager() {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
    };

    /**
     * 接收iOS端发过来的购买凭证
     * @param iosId 设备唯一id
     * @param receipt 购买凭证
     * @param product_id 商品名称
     * @param transaction_id 订单号
     */
    @RequestMapping(value = "/setIapCertificate",method = RequestMethod.POST)
    public String setIapCertificate(@RequestParam Long iosId, @RequestParam String receipt, @RequestParam String product_id, @RequestParam String transaction_id,
                                               @RequestParam String gameId, @RequestParam String channelId/*, @RequestParam BigDecimal rmb*/) {

        //验证传参是否为空
        if (dbVerify.isHasIos(iosId,gameId,channelId) && StringUtils.isNotEmpty(receipt) && StringUtils.isNotEmpty(product_id) && StringUtils.isNotEmpty(transaction_id)) {

            // 查询订单
            PlayerPayLog payLog = playerPayLogMapper.selectByIosPayLog(gameId, iosId, transaction_id);
            String res = null;
            // 判断订单是否存在，如果状态值不为4则返回
            if (payLog != null) {
                if (payLog.getPayStatus() != 4){
                    res = IosCode.ERROR_FAILURE.getErrorCode();
                }
            }

            // 如果未查询到该订单，则插入数据库
            if (res == null){
                playerPayLogMapper.insert(new PlayerPayLog(null,iosId,gameId,channelId,product_id,new Date(),
                        BigDecimal.valueOf(0),null,null,transaction_id,4,null,receipt,null));
            }
            // 更新查询支付信息数据
            payLog = playerPayLogMapper.selectByIosPayLog(gameId,iosId,transaction_id);

            // 查询游戏包名
            // String gamePackage = gameMapper.selectByGameId(gameId).getNameEn();

            String url = null;    // 苹果服务器地址
            boolean bol = false; // 返回参数判断
            int status = -1;      // 苹果返回支付状态

            url = certificateUrl;
            final String certificateCode = receipt;

            int j = 0;
            try {
                while (j < 2) {
                    j++;
                    // 发送请求
                    String receipt_data = sendHttpsCoon(url, certificateCode);
                    System.out.println("=============[][][1][][]" + receipt_data);
                    // 解析最外层json
                    JSONObject job = JSONObject.parseObject(receipt_data);
                    // 获取状态值并进行判断
                    status = (int) job.get("status");
                    if (status == 0) {
                        bol = true;
                        // 解析receipt层json
                        /*JSONObject jobReceipt = job.getJSONObject("receipt");
                        // 判断是否存在in_app和游戏包名是否一致
                        if (StringUtils.isNotEmpty(String.valueOf(jobReceipt.getJSONObject("in_app"))) && gamePackage.equalsIgnoreCase(String.valueOf(jobReceipt.get("bid")))) {
                            JSONObject jobIn = JSONObject.parseObject(String.valueOf(jobReceipt));
                            // 遍历in_app
                            for (int i = 1; i < jobIn.size(); i++) {
                                // 判断商品id和订单号是否相同
                                if (jobIn.get("transaction_id").equals(transaction_id) && jobIn.get("product_id ").equals(product_id)) {
                                    bol = true;
                                    break;
                                }
                            }
                        } else {
                            status = 30000;// 没有in_app数值
                        }*/
                    }else if (status == 21007){
                        url = certificateUrlTest;
                        continue;
                    }
                    break;
                }
                // 判断是否成功
                if (bol == true){
                    updatePlayerPayLogStatus(payLog.getId(),5,null);
                    return IosCode.OK.getErrorCode() + "@" + product_id;
                }else {
                    updatePlayerPayLogStatus(payLog.getId(),6,String.valueOf(status));
                    return IosCode.ERROR_FAILURE.getErrorCode();
                }

            }catch (Exception e){
                return IosCode.ERROR_UNKNOWN.getErrorCode();
            }
        }
        return IosCode.ERROR_CLIENT_VALUE.getErrorCode();
    }

    /**
     * 验证商品
     * @param goodsName
     * @param channelId
     * @param gameId
     * @return
     */
    /*public Boolean verifyGoods(String goodsName, String channelId, String gameId){
        PayGoods payGoods = payGoodsMapper.selectByGChannelId(goodsName,channelId,gameId);
        String good = "money";
        if (payGoods != null){
            Boolean status = goodsName.contains(good);
            if (status){

            }
        }
    }*/

    /**
     * 修改支付订单表订单状态
     * @param id
     * @param payStatus
     * @param iosStatus
     */
    public void updatePlayerPayLogStatus(int id, int payStatus, String iosStatus){
        playerPayLogMapper.updateByPrimaryKeySelective(new PlayerPayLog(id, null, null, null, null,
                null, null, null, null, null, payStatus, iosStatus, null,null));
    }

    /**
     * 写入日志
     * @param iosId
     * @param gameId
     * @param channelId
     * @param msg
     */
    @RequestMapping(value = "/writeLog", method = RequestMethod.POST)
    public String writeLog(@RequestParam Long iosId, @RequestParam String gameId, @RequestParam String channelId, @RequestParam String msg){
        logger.info("{time："+new Date()+";gameId："+gameId+";channelId："+channelId+";roleId："+iosId+";msg："+msg+";}");
        return IosCode.OK.getErrorCode();
    }

    /**
     * 发送请求
     * @param url
     * @param code
     * @return
     */
    private String sendHttpsCoon(@RequestParam String url, @RequestParam String code){
        if(url.isEmpty()){
            return null;
        }
        try {
            //设置SSLContext
            SSLContext ssl = SSLContext.getInstance("SSL");
            ssl.init(null, new TrustManager[]{myX509TrustManager}, null);

            //打开连接
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            //设置套接工厂
            conn.setSSLSocketFactory(ssl.getSocketFactory());
            //加入数据
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-type","application/json");

            JSONObject obj = new JSONObject();
            obj.put("receipt-data", code);

            BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
            buffOutStr.write(obj.toString().getBytes());
            buffOutStr.flush();
            buffOutStr.close();

            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line = reader.readLine())!= null){
                sb.append(line);
            }
            return sb.toString();

        } catch (Exception e) {
            return null;
        }
    }
}
