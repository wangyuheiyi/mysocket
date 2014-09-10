package com.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.common.globals.server.impl.ServerManager;
import com.common.handler.impl.MessageHandlerServer;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.MissionBean.MissionInfo;
/**
 * 根据消息类型分发消息队列中
 * @author Administrator
 *
 */
public class MessageServerHandler extends SimpleChannelInboundHandler<Object>{
	@Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		BaseMessage baseBean=(BaseMessage)msg;
		MessageHandlerServer.getInstance().putMessageToMsgQueue(ctx.channel(), baseBean);
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
