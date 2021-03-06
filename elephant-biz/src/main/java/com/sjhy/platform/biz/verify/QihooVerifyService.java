package com.sjhy.platform.biz.verify;

import com.alibaba.fastjson.JSON;
import com.sjhy.platform.biz.bo.VerifySessionBO;
import com.sjhy.platform.biz.utils.HttpUtil;
import com.sjhy.platform.biz.utils.StringUtils;
import com.sjhy.platform.client.dto.game.GameChannelSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("1200")
public class QihooVerifyService implements IVerifySession{
	private static final Logger logger = LoggerFactory.getLogger( QihooVerifyService.class );
	
	@Override
	public String verify(String channelId, String token, Map<String, Object> extraParams) {
		// oppo参数取得
		Object gameId = extraParams.get("gameId");
		
		GameChannelSetting channelSetting = VerifySessionBO.getGameChannelSetting(gameId.toString(), channelId);
		
		if(channelSetting == null){
			logger.error("QihooVerifyService|method=verify|error=qihoo验证错误，channelSetting为空");
			
			return "";
		}
		
		String checkUrl = "https://openapi.360.cn/user/me.json?access_token=_access_token_&fields=id,name,avatar,sex,area";
		
		checkUrl = checkUrl.replace("_access_token_", token);
		
		HttpUtil httpUtil = new HttpUtil();
		
		String res = httpUtil.getRequest(checkUrl);
		if(StringUtils.isBlank(res)){
			logger.error("QihooVerifyService|method=verify|error=qihoo验证错误，res为空");
			
			return "";
		}
		
		logger.error("QihooVerifyService|method=verify|me.json=" + res);
		
		try{
			Map result = JSON.parseObject(res, Map.class);
			
			if(result != null && result.get("id") != null){
				
				return result.get("id").toString();
			}
			
		}catch(Exception e){
			logger.error("QihooVerifyService|method=verify|error="+e.getMessage());
		}
		
		return null;
	}

}
