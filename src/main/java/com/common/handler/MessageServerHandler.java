package com.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.common.globals.context.ContextFactiry;
import com.common.globals.server.impl.GlobalLogicRunner;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.MissionBean.MissionInfo;
import com.player.Player;

public class MessageServerHandler extends SimpleChannelInboundHandler<Object>{
	@Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		BaseMessage baseBean=(BaseMessage)msg;
		switch (baseBean.getType()) {
		case GLOBALMESSAGE:
            Player player=new Player();
            player.setChannel(ctx.channel());
			//设置对象
			IMessageHandler cgPlayerCheckLoginHandler=ContextFactiry.getContext("handlerContext").getBean(IMessageHandler.class);
			cgPlayerCheckLoginHandler.setMessage(baseBean, player);
			ContextFactiry.getContext("serverContext").getBean(GlobalLogicRunner.class).put(cgPlayerCheckLoginHandler);
			break;
		case PLAYERMESSAGE:
			MissionInfo missionInfo=baseBean.getExtension(BaseBean.missionInfo);
			System.out.println("missionId:"+missionInfo.getMissionId());
			break;
		default:
			break;
		}

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
