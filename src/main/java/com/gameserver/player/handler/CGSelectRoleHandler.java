package com.gameserver.player.handler;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BaseBean.BaseMessage.MessageCode;
import com.common.msg.PlayerBean.CGSelectRole;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.common.handler.impl.MessageHandlerServer;
import com.gameserver.human.Human;
import com.gameserver.human.template.HumanTemplate;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
import com.gameserver.player.async.CreateRoleOperation;
/**
 * 创建用户消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGSelectRoleHandler implements IMessageHandler{
	private CGSelectRole cgSelectRole;
	private Player player;

	@Override
	public void execute() {
		
		long playerId=cgSelectRole.getPlayerId();
		long roleId=cgSelectRole.getRoleId();
		//选择角色
		player.setState(PlayerState.waitingselectrole);
		ServerManager.getInstance().getPlayerServer().selectRole(player, roleId,null);
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgSelectRole=baseMessage.getExtension(BaseBean.cgSelectRole);
		this.player=player;
	}

}
