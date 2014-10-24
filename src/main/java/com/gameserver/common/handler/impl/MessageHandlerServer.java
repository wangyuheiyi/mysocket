package com.gameserver.common.handler.impl;



import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.common.context.ContextFactiry;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BaseBean.BaseMessage.MessageCode;
import com.gameserver.building.handler.CGCreateBuildHandler;
import com.gameserver.common.globals.server.impl.OnLinePlayerServer;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.player.Player;
import com.gameserver.player.handler.CGCreateRoleHandler;
import com.gameserver.player.handler.CGGetRoleListHandler;
import com.gameserver.player.handler.CGPlayerCheckLoginHandler;
import com.gameserver.player.handler.CGRoleReNameHandler;
import com.gameserver.player.handler.CGSelectRoleHandler;
@Service
public class MessageHandlerServer{
	
	public static MessageHandlerServer getInstance() 
	{
	    return ContextFactiry.getContext("handlerContext").getBean(MessageHandlerServer.class);
	}
	
	//消息句柄注册
	public Map<MessageCode,IMessageHandler>  handlerMap=new HashMap<MessageCode,IMessageHandler>();
	
    public MessageHandlerServer() {
    }
    
    public void registerMessageHandler(MessageCode code,IMessageHandler iHandler){
    	handlerMap.put(code, iHandler);
    }
    
    public IMessageHandler getMessageHandler(Channel channel,BaseMessage baseBean){
    	Player player=null;
    	OnLinePlayerServer onLinePlayerServer = ServerManager.getInstance().getOnLinePlayerServer();
    	player=onLinePlayerServer.getPlayerByChannel(channel);
    	switch (baseBean.getMessageCode()){
    	case CGPLAYERCHECKLOGIN:
    		player=new Player();
    		player.setChannel(channel);
    		break;
    	}
		return handlerMap.get(baseBean.getMessageCode());
    }
    
    @Async
    public void putMessageToMsgQueue(Channel channel,BaseMessage baseBean){
    	IMessageHandler iHandler=null;
    	switch (baseBean.getType()) {
		case GLOBALMESSAGE:
			//设置对象
			iHandler=MessageHandlerServer.getInstance().getMessageHandler(channel, baseBean);
			ServerManager.getInstance().getGlobalLogicRunner().put(iHandler);
			break;
		case PLAYERMESSAGE:
			Player player=ServerManager.getInstance().getOnLinePlayerServer().getPlayerByChannel(channel);
			//设置对象
			iHandler=MessageHandlerServer.getInstance().getMessageHandler(channel, baseBean);
			player.putMessage(iHandler);
			break;
		default:
			break;
		}
    }
}
