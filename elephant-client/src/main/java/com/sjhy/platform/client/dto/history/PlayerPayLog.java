package com.sjhy.platform.client.dto.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 玩家购买物品信息表
 * 
 * @author wcyong
 * 
 * @date 2018-12-07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPayLog {
    /**
     * ID
     */
    private Integer id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 游戏id
     */
    private Integer gameId;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 充值金额
     */
    private Float rmb;

    /**
     * 发送虚拟货币
     */
    private Integer currencyGet;

    /**
     * 附加虚拟货币
     */
    private Integer currencyGetExtra;

    /**
     * 订单号
     */
    private String orderId;
}