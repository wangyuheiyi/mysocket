package com.gameserver.player.server;

import org.springframework.stereotype.Component;

import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
import com.gameserver.player.async.LoadPlayerRoleOperation;
@Component
public class PlayerServer implements IBaseServer{


	@Override
	public void init(GameConfigServer config) {
	}

	/**
	 * 玩家选择角色
	 * 
	 * @param player
	 * @param roleUUID
	 */
	public void selectRole(Player player, long roleUUID,Human human) 
	{		
		// 正常登录，设置为加载角色列表 状态
		player.setState(PlayerState.loading);
		// 异步加载角色列表
		LoadPlayerRoleOperation _loadTask = new LoadPlayerRoleOperation(player,roleUUID,human);
		ServerManager.getInstance().getGameAsyncService().createOperationAndExecuteAtOnce(_loadTask);		
	}
}
