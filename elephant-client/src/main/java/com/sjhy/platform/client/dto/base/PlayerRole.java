package com.sjhy.platform.client.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 游戏角色信息表
 * 
 * @author HJ
 * 
 * @date 2018-12-06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRole {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 玩家id
     */
    private Long playerId;

    /**
     * 角色名字
     */
    private String roleName;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 游戏id
     */
    private Integer gameId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 最后登陆服务器
     */
    private Integer lastLoginServer;

    /**
     * 好友id
     */
    private Integer friendid;

    /**
     * 国家
     */
    private String country;

    /**
     * 在线时间
     */
    private Long minute;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 添加好友数量
     */
    private Byte regFriend;

    /**
     * 删除好友数量
     */
    private Byte isDeleted;

    /**
     * 去广告
     */
    private Date adtime;

    /**
     * 黄金会员
     */
    private Date viptime;

    /**
     * 虚拟货币数量
     */
    private Integer currency;

}