package com.common.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocket13FrameEncoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import com.common.msg.bean.BaseBean;
import com.google.protobuf.ExtensionRegistry;

public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel>{

    public WebSocketServerInitializer() {
    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerHandler());
//        pipeline.addLast(new WebSocket13FrameEncoder(true));
        pipeline.addLast(new WebSocketSendHandler());
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        ExtensionRegistry registry = ExtensionRegistry.newInstance();
        BaseBean.registerAllExtensions(registry);
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(BaseBean.BaseMessage.getDefaultInstance(),registry));
//        pipeline.addLast(new MessageServerHandler());
    }
}
