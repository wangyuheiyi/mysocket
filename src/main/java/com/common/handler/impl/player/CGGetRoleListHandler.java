package com.common.handler.impl.player;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.globals.server.impl.ServerManager;
import com.common.handler.IMessageHandler;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGGetRoleList;
import com.common.msg.PlayerBean.GCGetRoleList;
import com.common.msg.PlayerBean.HumanInfo;
import com.db.model.impl.HumanEntity;
import com.player.Player;
import com.player.PlayerState;
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
		BaseMessage.Builder myMessage=BaseMessage.newBuilder();
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
				humanInfo.setAvatar(humanEntity.getAvatar());
				humanInfo.setVocationType(humanEntity.getVocationType());
				gcGetRoleList.addHumanInfo(humanInfo.build());
			}
		}
		gcGetRoleList.setPlayerId(cgGetRoleList.getPlayerId());
		myMessage.setType(BaseMessage.Type.GLOBALMESSAGE);
		myMessage.setMessageCode(BaseMessage.MessageCode.GCGETROLELIST);
		myMessage.setExtension(BaseBean.gcGetRoleList, gcGetRoleList.build());
		player.setState(PlayerState.waitingselectrole);
		player.sendMessage(myMessage.build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgGetRoleList=baseMessage.getExtension(BaseBean.cgGetRoleList);
		this.player=player;
	}

}
