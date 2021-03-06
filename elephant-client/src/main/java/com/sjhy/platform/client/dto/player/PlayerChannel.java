package com.sjhy.platform.client.dto.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 渠道玩家信息表
 * 
 * @author HJ
 * 
 * @date 2018-12-17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerChannel implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 游戏id
     */
    private String gameId;

    /**
     * 渠道id
     */
    private String channelId;

    /**
     * 子渠道
     */
    private Integer subChannel;

    /**
     * 渠道用户id
     */
    private String channelUserId;

    /**
     * 玩家id
     */
    private Long playerId;

    /**
     * ios玩家id,等同于playerId和roleId
     */
    private Long iosId;
}