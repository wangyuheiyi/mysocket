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
		List<HumanEntity> humanEntityList=ServerManager.getInstance().getDbServer().getHumanDao().getHumanAllList(cgGetRoleList.getPlayerId());
		if(humanEntityList!=null)
		{
			for(HumanEntity humanEntity:humanEntityList){
				humanInfo=HumanInfo.newBuilder();
				humanInfo.setRoleId(humanEntity.getId());
				humanInfo.setRoleName(humanEntity.getName());
				humanInfo.setLevel(humanEntity.getLevel());
				gcGetRoleList.addHumanInfo(humanInfo.build());
			}
		}

		myMessage.setType(BaseMessage.Type.GLOBALMESSAGE);
		myMessage.setMessageCode(BaseMessage.MessageCode.GCGETROLELIST);
		myMessage.setExtension(BaseBean.gcGetRoleList, gcGetRoleList.build());
		player.sendMessage(myMessage.build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgGetRoleList=baseMessage.getExtension(BaseBean.cgGetRoleList);
		this.player=player;
	}

}
