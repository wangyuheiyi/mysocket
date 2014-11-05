package com.gameserver.player.handler;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BaseBean.BaseMessage.MessageCode;
import com.common.msg.DataBean.HumanInfo;
import com.common.msg.PlayerBean.CGGetRoleList;
import com.common.msg.PlayerBean.GCGetRoleList;
import com.db.model.impl.HumanEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.common.handler.impl.MessageHandlerServer;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
/**
 * 选择用户消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGGetRoleListHandler implements IMessageHandler{
	private CGGetRoleList cgGetRoleList;
	private Player player;

	@Override
	public void execute() {
		GCGetRoleList.Builder gcGetRoleList=GCGetRoleList.newBuilder();
		HumanInfo.Builder humanInfo=null;
		player.setState(PlayerState.loadingrolelist);
		List<HumanEntity> humanEntityList=null;
		try {
			humanEntityList=ServerManager.getInstance().getDbServer().getHumanDao().getHumanAllList(cgGetRoleList.getPlayerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//根据用户列表组装用户信息，给客户端发送
		if(humanEntityList!=null)
		{
			for(HumanEntity humanEntity:humanEntityList){
				humanInfo=HumanInfo.newBuilder();
				humanInfo.setRoleId(humanEntity.getId());
				humanInfo.setRoleName(humanEntity.getName());
				humanInfo.setLevel(humanEntity.getLevel());
				humanInfo.setAllianceTypeId(humanEntity.getAllianceTypeId());
				gcGetRoleList.addHumanInfo(humanInfo.build());
			}
		}
		gcGetRoleList.setPlayerId(cgGetRoleList.getPlayerId());
		player.setState(PlayerState.waitingselectrole);
		//将玩家的角色信息发送给玩家
		player.sendMessage(player.buildBeseMessage(BaseMessage.Type.GLOBALMESSAGE, BaseMessage.MessageCode.GCGETROLELIST).
				setExtension(BaseBean.gcGetRoleList, gcGetRoleList.build()).build());
		System.out.println("================CGGetRoleList end======================");
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgGetRoleList=baseMessage.getExtension(BaseBean.cgGetRoleList);
		this.player=player;
	}

}
