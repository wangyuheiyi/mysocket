package com.gameserver.common.globals.server;

import com.gameserver.common.globals.config.GameConfigServer;

/**
 * 所有server的公共接口
 * @author Administrator
 *
 */

public interface IBaseServer {
		public void init(GameConfigServer config);
}
