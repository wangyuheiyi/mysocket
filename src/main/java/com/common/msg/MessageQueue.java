package com.common.msg;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.common.constants.Loggers;
import com.common.msg.bean.BaseBean;

/**
 * 消息队列，使用{@link BlockingQueue}实现
 * 
 * @see BlockingQueue
 */
public class MessageQueue {
	/** 玩家的消息队列 */
	private BlockingQueue<BaseBean> msgQueue;

	public MessageQueue() {
		msgQueue = new LinkedBlockingQueue<BaseBean>();
	}

	/**
	 * @param msg
	 */
	public void put(BaseBean msg) {
		if (msg == null) {
			return;
		}
		try {
			msgQueue.put(msg);
		} catch (InterruptedException e) {
			Loggers.msgLogger.error("",e);
		}
	}

	/**
	 * 返回消息队列中的一个消息
	 * 
	 * @return
	 */
	public BaseBean get() {
		if (isEmpty()) {
			return null;
		}
		try {
			return msgQueue.take();
		} catch (InterruptedException e) {
			Loggers.msgLogger.error("",e);
			return null;
		}
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return msgQueue.isEmpty();
	}

	@Override
	public String toString() {
		return "MessageQueue [msgQueue=" + msgQueue + "]";
	}
}
