package com.sjhy.platform.biz.verify;

import com.sjhy.platform.biz.bo.VerifySessionBO;
import com.sjhy.platform.client.dto.game.GameChannelSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("2200")
public class YyhVerifyService implements IVerifySession{
	private static final Logger logger = LoggerFactory.getLogger( YyhVerifyService.class );
	
	@Override
	public String verify(String channelId, String token, Map<String, Object> extraParams) {
		// 联想参数取得
		Object gameId = extraParams.get("gameId");
		
		GameChannelSetting channelSetting = VerifySessionBO.getGameChannelSetting(gameId.toString(), channelId);
		
		if(channelSetting == null){
			logger.error("YyhVerifyService|method=verify|error=应用汇参数错误，gameId为空");
			
			return "";
		}
		
		return null;
	}

	
}
