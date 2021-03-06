package com.gameserver.player.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGPlayerCheckLogin;
import com.common.msg.PlayerBean.GCPlayerCheckLogin;
import com.gameserver.common.globals.server.impl.OnLinePlayerServer;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
import com.test.BuildMissionInfo;
@Scope("prototype")
@Component
public class CGPlayerCheckLoginHandler implements IMessageHandler{
	private CGPlayerCheckLogin cgPlayerCheckLogin;
	private Player player;
	
	public CGPlayerCheckLoginHandler(){
		System.out.println("CGPlayerCheckLoginHandler");
	}

	@Override
	public void execute() {
		GCPlayerCheckLogin.Builder gcPlayerCheckLogin=GCPlayerCheckLogin.newBuilder();
		gcPlayerCheckLogin.setPlayerId(cgPlayerCheckLogin.getPlayerId());
		player.setId(cgPlayerCheckLogin.getPlayerId());
		player.setState(PlayerState.connected);
		 //连接成功后加载在线玩家
		OnLinePlayerServer onLinePlayerServer = ServerManager.getInstance().getOnLinePlayerServer();
		player.setState(PlayerState.auth);
		onLinePlayerServer.onPlayerEnterServer(player.getId(), player);
//		player.sendMessage(BuildMissionInfo.getBuildMissionInfo());
		
		player.sendMessage(player.buildBeseMessage(BaseMessage.Type.GLOBALMESSAGE, BaseMessage.MessageCode.GCPLAYERCHECKLOGIN).
				setExtension(BaseBean.gcPlayerCheckLogin, gcPlayerCheckLogin.build()).build());
		System.out.println("================CGPlayerCheckLogin end======================");
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgPlayerCheckLogin=baseMessage.getExtension(BaseBean.cgPlayerCheckLogin);
		this.player=player;
	}

}
