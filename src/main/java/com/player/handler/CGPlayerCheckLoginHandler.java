package com.player.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.handler.IMessageHandler;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGPlayerCheckLogin;
import com.common.msg.PlayerBean.GCPlayerCheckLogin;
import com.player.Player;
@Scope("prototype")
@Component
public class CGPlayerCheckLoginHandler implements IMessageHandler{
	private CGPlayerCheckLogin cgPlayerCheckLogin;
	private Player player;
	@Override
	public void execute() {
		BaseMessage.Builder myMessage=BaseMessage.newBuilder();
		GCPlayerCheckLogin.Builder gcPlayerCheckLogin=GCPlayerCheckLogin.newBuilder();
		gcPlayerCheckLogin.setPlayerId(cgPlayerCheckLogin.getPlayerId());
		myMessage.setType(BaseMessage.Type.GLOBALMESSAGE);
		myMessage.setMessageCode(BaseMessage.MessageCode.GCPLAYERCHECKLOGIN);
		myMessage.setExtension(BaseBean.gcPlayerCheckLogin, gcPlayerCheckLogin.build());
		 //连接成功后加载在线玩家
//      OnLinePlayerServer onLinePlayerServer = ContextFactiry.getContext("serverContext").getBean(OnLinePlayerServer.class);
//      onLinePlayerServer.onPlayerEnterServer(0l, ctx.channel(), player);
		player.sendMessage(myMessage.build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgPlayerCheckLogin=baseMessage.getExtension(BaseBean.cgPlayerCheckLogin);
		this.player=player;
	}

}
