package com.common.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class WebSocketSendHandler extends ChannelOutboundHandlerAdapter{
	@Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		if (!(msg instanceof FullHttpResponse)) {
			WebSocketFrame frame =(WebSocketFrame) msg;
			if (frame instanceof TextWebSocketFrame) {
				ctx.writeAndFlush(msg);
			}else{
				BinaryWebSocketFrame message=new BinaryWebSocketFrame((ByteBuf)msg);
		        ctx.writeAndFlush(message);
			}
        }else{
        	ctx.writeAndFlush(msg);
        }
    }
}
