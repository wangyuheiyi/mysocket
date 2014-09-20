package com.player.async;

import com.common.async.IIoOperation;
import com.common.globals.server.impl.ServerManager;
import com.human.Human;
import com.player.Player;
import com.player.PlayerState;

/**
 * 异步IO操作： 保存一个新角色
 * 
 * @author Thinker
 */
public class CreateRoleOperation implements IIoOperation 
{
	/** 玩家 */
	private Player player;
	/** 角色 */
	private Human human;
	/** 是否创建成功 */
	private boolean isCreateSucc = false;

	public CreateRoleOperation(Player player, Human human)
	{
		this.player = player;
		this.human = human;
	}

	@Override
	public int doIo()
	{
		do 
		{
			// 保存到数据库
			isCreateSucc = ServerManager.getInstance().getOnLinePlayerServer().createRole(player, human);
		} while (false);
		return STAGE_IO_DONE;
	}

	@Override
	public int doStart()
	{
		return STAGE_START_DONE;
	}

	@Override
	public int doStop() 
	{
		if (player.getState() == PlayerState.creatingrole)
		{
			if (isCreateSucc) 
			{
				player.setHuman(human);
				player.setState(PlayerState.loadingrolelist);
				player.setState(PlayerState.waitingselectrole);
//				GCCreateRole gcCreateRole=new GCCreateRole();
//				gcCreateRole.setRole(roleInfo);
//				player.sendMessage(gcCreateRole);
			} else
			{
				player.setState(PlayerState.waitingselectrole);
			}
		}
		return STAGE_STOP_DONE;
	}
}
