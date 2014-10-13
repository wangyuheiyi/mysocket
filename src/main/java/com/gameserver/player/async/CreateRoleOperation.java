package com.gameserver.player.async;

import com.common.async.IIoOperation;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.DataBean.HumanInfo;
import com.common.msg.PlayerBean.GCCreateRole;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;

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
				BaseMessage.Builder myMessage=BaseMessage.newBuilder();
				player.setHuman(human);
				GCCreateRole.Builder gcCreateRole=GCCreateRole.newBuilder();
				gcCreateRole.setPlayerId(human.getPassportId());
				HumanInfo humanInfo=ServerManager.getInstance().getHumanSever().getHumanInfo(human);
				gcCreateRole.setHumanInfo(humanInfo);
				//玩家选择角色登录
				ServerManager.getInstance().getPlayerServer().selectRole(player, human.getCharId(), human);
				//将玩家的角色信息发送给玩家
				myMessage.setType(BaseMessage.Type.GLOBALMESSAGE);
				myMessage.setMessageCode(BaseMessage.MessageCode.GCCREATEROLE);
				myMessage.setExtension(BaseBean.gcCreateRole, gcCreateRole.build());
				player.sendMessage(myMessage.build());
				
			} else
			{
				player.setState(PlayerState.waitingselectrole);
			}
		}
		return STAGE_STOP_DONE;
	}
}
