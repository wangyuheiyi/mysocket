package com.gameserver.common.handler.impl;



import io.netty.channel.Channel;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.common.context.ContextFactiry;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.MissionBean.MissionInfo;
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
	
    public MessageHandlerServer() {
    }

    public IMessageHandler getMessageHandler(Channel channel,BaseMessage baseBean){
    	Player player=null;
    	OnLinePlayerServer onLinePlayerServer = ServerManager.getInstance().getOnLinePlayerServer();
    	player=onLinePlayerServer.getPlayerByChannel(channel);
    	switch (baseBean.getMessageCode()){
    	case CGPLAYERCHECKLOGIN:
    		player=new Player();
    		player.setChannel(channel);
    		CGPlayerCheckLoginHandler cgPlayerCheckLoginHandler=ContextFactiry.getContext("handlerContext").getBean(CGPlayerCheckLoginHandler.class);
    		cgPlayerCheckLoginHandler.setMessage(baseBean, player);
    		return cgPlayerCheckLoginHandler;
    	case CGGETROLELIST:
    		CGGetRoleListHandler cgGetRoleListHandler=ContextFactiry.getContext("handlerContext").getBean(CGGetRoleListHandler.class);
    		cgGetRoleListHandler.setMessage(baseBean, player);
    		return cgGetRoleListHandler;
    	case CGCREATEROLE:
    		CGCreateRoleHandler cgCreateRoleHandler=ContextFactiry.getContext("handlerContext").getBean(CGCreateRoleHandler.class);
    		cgCreateRoleHandler.setMessage(baseBean, player);
    		return cgCreateRoleHandler;
    	case CGSELECTROLE:
    		CGSelectRoleHandler cgSelectRoleHandler=ContextFactiry.getContext("handlerContext").getBean(CGSelectRoleHandler.class);
    		cgSelectRoleHandler.setMessage(baseBean, player);
    		return cgSelectRoleHandler;
    	case CGROLERENAME:
    		CGRoleReNameHandler cgRoleReNameHandler=ContextFactiry.getContext("handlerContext").getBean(CGRoleReNameHandler.class);
    		cgRoleReNameHandler.setMessage(baseBean, player);
    		return cgRoleReNameHandler;
    	}
		return null;
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
//			System.out.println("missionId:"+missionInfo.getMissionId());
			break;
		default:
			break;
		}
    }
}
