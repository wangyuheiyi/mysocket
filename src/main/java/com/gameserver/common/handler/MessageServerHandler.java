package com.gameserver.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.common.msg.BaseBean.BaseMessage;
import com.gameserver.common.handler.impl.MessageHandlerServer;
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
