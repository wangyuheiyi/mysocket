package com.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.common.msg.bean.BaseBean;
import com.common.msg.bean.BaseBean.BaseMessage;
import com.common.msg.bean.MissionBean.MissionInfo;

public class MessageServerHandler extends SimpleChannelInboundHandler<Object>{
	@Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		BaseMessage baseBean=(BaseMessage)msg;
		switch (baseBean.getType()) {
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
