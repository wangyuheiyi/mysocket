package com.gameserver.player.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGRoleReName;
import com.common.msg.PlayerBean.GCGetRoleList;
import com.common.msg.PlayerBean.GCRoleReName;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
/**
 * 用户重命名消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGRoleReNameHandler implements IMessageHandler{
	private CGRoleReName cgRoleReName;
	private Player player;
	@Override
	public void execute() {
		Human human=player.getHuman();
		if(human==null) return;
		long roleId=cgRoleReName.getRoleId();
		String roleName=cgRoleReName.getRoleName();
		human.setName(roleName);
		GCRoleReName.Builder gcRoleReName=GCRoleReName.newBuilder();
		gcRoleReName.setRoleName(roleName);
		player.sendMessage(player.buildBeseMessage(BaseMessage.Type.PLAYERMESSAGE, BaseMessage.MessageCode.GCROLERENAME).
				setExtension(BaseBean.gcRoleReName, gcRoleReName.build()).build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgRoleReName=baseMessage.getExtension(BaseBean.cgRoleReName);
		this.player=player;
	}

}
