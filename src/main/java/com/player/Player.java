package com.player;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import com.common.constants.Loggers;
import com.common.handler.IMessageHandler;
import com.common.msg.MessageQueue;



public class Player {
	/** 玩家的id*/
	private long id;
	/** 玩家的消息队列 */
	private MessageQueue msgQueue;
	/** 玩家消息通道*/
	private Channel channel;
	
	/** 处理的消息总数,为避免同步，在主线程中修改 */
	private static volatile long playerMessageCount = 0;
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Channel getChannel() {
		return channel;
	}



	public void setChannel(Channel channel) {
		this.channel = channel;
	}

    public Player(){
    	msgQueue=new MessageQueue();
    }
    

	/**
	 * 放置玩家需要处理的消息
	 * @param msg
	 */
	public void putMessage(IMessageHandler msg)
	{
		this.msgQueue.put(msg);
		// 记录玩家处理消息个数
		playerMessageCount++;
	}
	
	/**
	 * 将消息发送给Player
	 * @param msg
	 */
	public void sendMessage(Object msg)
	{
		channel.writeAndFlush(msg);
	}
}
