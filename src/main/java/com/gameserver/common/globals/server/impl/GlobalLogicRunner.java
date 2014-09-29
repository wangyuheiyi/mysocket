package com.gameserver.common.globals.server.impl;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.common.constants.Loggers;
import com.core.heartbeat.HeartBeatAble;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.common.msg.MessageQueue;

/**
 * 全局逻辑业务
 * 比如公会战、Boss战、竞技场等全局性业务的刷新和心跳都应该放在这里
 * @author Thinker
 *
 */
@Component
public class GlobalLogicRunner implements Callable<Integer>,IBaseServer,HeartBeatAble
{
	private final static int maxMsgCountProcess = 1024;

	/** 运行的线程id * */
	private long threadId;
	/** 消息队列 */
	private MessageQueue msgQueue;
	
	public long getThreadId() {
		return threadId;
	}
	
	@Override
	public Integer call() throws Exception {
		try {
			tick();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void tick(){
		threadId = Thread.currentThread().getId();
		this.processMessage();
	}

	/**
	 * 处理消息
	 */
	private void processMessage() {
		for (int i = 0; i < maxMsgCountProcess; ++i) {
			if (msgQueue.isEmpty()) {
				break;
			}
			IMessageHandler msgHandler = msgQueue.get();
			Assert.notNull(msgHandler);
			long begin = System.nanoTime();
			try{
				msgHandler.execute();
			}catch(Throwable t){
				Loggers.errorLogger.error("Global Logic process message error!", t);

			}finally{
				long time = (System.nanoTime() - begin) / (1000 * 1000);
				if (time > 1) {
					Loggers.errorLogger.info("Global Logic process message cost " + time +" ms!");
				}
			}
		}
	}

	@Override
	public void init(GameConfigServer config) {
		msgQueue = new MessageQueue();
	}

	public void put(IMessageHandler msg) {
		this.msgQueue.put(msg);
	}

	@Override
	public void heartBeat() {
	}
}
