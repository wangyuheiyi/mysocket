package com.common.handler.impl.player;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.handler.IMessageHandler;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGCreatRole;
import com.common.msg.PlayerBean.GCCreatRole;
import com.player.Player;
import com.player.PlayerState;
/**
 * 创建用户消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGCreatRoleHandler implements IMessageHandler{
	private CGCreatRole cgCreatRole;
	private Player player;
	@Override
	public void execute() {
		BaseMessage.Builder myMessage=BaseMessage.newBuilder();
		GCCreatRole.Builder gcGetRoleList=GCCreatRole.newBuilder();
		int playerId=cgCreatRole.getPlayerId();
		int avatar=cgCreatRole.getAvatar();
		//穿件角色信息
		player.setState(PlayerState.creatingrole);
		
		myMessage.setType(BaseMessage.Type.GLOBALMESSAGE);
		myMessage.setMessageCode(BaseMessage.MessageCode.GCCREATROLE);
		myMessage.setExtension(BaseBean.gcCreatRole, gcGetRoleList.build());
		player.sendMessage(myMessage.build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgCreatRole=baseMessage.getExtension(BaseBean.cgCreatRole);
		this.player=player;
	}

}
