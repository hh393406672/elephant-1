package com.sjhy.platform.persist.mysql.game;

import com.sjhy.platform.client.dto.game.ModuleSwitch;

public interface ModuleSwitchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleSwitch record);

    int insertSelective(ModuleSwitch record);

    ModuleSwitch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleSwitch record);

    int updateByPrimaryKey(ModuleSwitch record);
}