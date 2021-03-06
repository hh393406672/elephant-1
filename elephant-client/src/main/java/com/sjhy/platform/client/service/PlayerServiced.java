package com.sjhy.platform.client.service;
/**
 * @HJ
 */
import com.sjhy.platform.client.dto.common.ResultDTO;
import com.sjhy.platform.client.dto.common.ServiceContext;
import com.sjhy.platform.client.dto.player.Player;
import com.sjhy.platform.client.dto.vo.AccountVO;

public interface PlayerServiced {
    // 获取渠道验证
    ResultDTO<AccountVO> getAccount(ServiceContext sc, String deviceUniqueID);

    // 查询玩家总数
    ResultDTO<Integer> getTotalPlayerNum();

    // 根据玩家唯一标示创建玩家id
    ResultDTO<Player> createNewPlayerByCooperate(ServiceContext sc, String deviceUniquelyId, String deviceModel, String ip);

    // 创建渠道用户id
    ResultDTO createPlayer(ServiceContext sc);

    // 验证是否需要激活码
    ResultDTO<Boolean> checkModule(ServiceContext sc,String moduleName);

}
