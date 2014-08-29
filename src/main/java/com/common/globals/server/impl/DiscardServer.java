package com.common.globals.server.impl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import org.springframework.stereotype.Component;

import com.common.globals.config.GameConfigServer;
import com.common.globals.server.IBaseServer;
import com.common.handler.WebSocketServerInitializer;
@Component
public class DiscardServer implements IBaseServer{
	private int port;
    public DiscardServer() {
    }

    public void run() throws Exception {
    	
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
              .channel(NioServerSocketChannel.class)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new WebSocketServerInitializer());

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

	@Override
	public void init(GameConfigServer config) {
        this.port = Integer.parseInt(config.getPorts());
	}

}
