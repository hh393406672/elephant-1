package com.sjhy.platform.persist.mysql.game;

import com.sjhy.platform.client.dto.game.GameNotify;

public interface GameNotifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameNotify record);

    int insertSelective(GameNotify record);

    GameNotify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameNotify record);

    int updateByPrimaryKey(GameNotify record);
}