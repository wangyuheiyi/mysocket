package com.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.common.globals.context.ContextFactiry;
import com.common.globals.server.impl.GlobalLogicRunner;
import com.common.globals.server.impl.OnLinePlayerServer;
import com.common.msg.bean.BaseBean;
import com.common.msg.bean.BaseBean.BaseMessage;
import com.common.msg.bean.MissionBean.MissionInfo;
import com.common.msg.bean.PlayerBean.CGPlayerCheckLogin;
import com.player.Player;
import com.player.handler.CGPlayerCheckLoginHandler;

public class MessageServerHandler extends SimpleChannelInboundHandler<Object>{
	@Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		
		BaseMessage baseBean=(BaseMessage)msg;
		switch (baseBean.getType()) {
		case CGPLAYERCHECKLOGIN:
			 //连接成功后加载在线玩家
//            OnLinePlayerServer onLinePlayerServer = ContextFactiry.getContext("serverContext").getBean(OnLinePlayerServer.class);
            Player player=new Player();
            player.setChannel(ctx.channel());
//            onLinePlayerServer.onPlayerEnterServer(0l, ctx.channel(), player);
			//设置对象
			IMessageHandler cgPlayerCheckLoginHandler=ContextFactiry.getContext("handlerContext").getBean(CGPlayerCheckLoginHandler.class);
			cgPlayerCheckLoginHandler.setMessage(baseBean, player);
			ContextFactiry.getContext("serverContext").getBean(GlobalLogicRunner.class).put(cgPlayerCheckLoginHandler);
			break;
		case MISSIONINFO:
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
