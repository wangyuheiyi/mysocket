package com.gameserver.player;

import io.netty.channel.Channel;

import org.springframework.util.Assert;

import com.common.constants.CommonErrorLogInfo;
import com.common.constants.Loggers;
import com.core.heartbeat.HeartBeatAble;
import com.core.util.ErrorsUtil;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.globals.server.impl.UpdaterServer;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.common.msg.MessageQueue;
import com.gameserver.human.Human;



public class Player implements HeartBeatAble{
	private final static int maxMsgCountProcess = 1024;
	/** 玩家的id*/
	private long id;
	/** 玩家的消息队列 */
	private MessageQueue msgQueue;
	/** 玩家消息通道*/
	private Channel channel;
	/** 玩家ip地址 */
	private String clientIp;
	/** 玩家数据更新调度器 */
	private UpdaterServer _dataUpdater;
	/** 处理的出错消息个数 */
	private static volatile int playerErrorMessageCount = 0;
	
	/** 处理的消息总数,为避免同步，在主线程中修改 */
	private static volatile long playerMessageCount = 0;
	
	/** 玩家当前使用的角色 */
	private Human human;
	/** 玩家的状态 */
	private PlayerStateManager _stateManager;
	
	
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
    	_dataUpdater=ServerManager.getInstance().getUpdaterServer();
    	this._stateManager = new PlayerStateManager(this);
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
	 * 处理服务器收到的来自玩家的消息，在玩家当前所属的场景线程中调用
	 */
	public void processMessage() 
	{
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
	
	/**
	 * 将消息发送给Player
	 * @param msg
	 */
	public void sendMessage(Object msg)
	{
		channel.writeAndFlush(msg);
	}



	public String getClientIp() {
		return clientIp;
	}



	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public int getSceneId() {
		return this.human.getSceneId();
	}
	
	

	@Override
	public void heartBeat() {
		this.updateData();
	}
	
	
	
	public Human getHuman() {
		return human;
	}



	public void setHuman(Human human) {
		this.human = human;
	}

	public PlayerState getState() 
	{
		return this._stateManager.getState();
	}
	
	public boolean setState(PlayerState state)
	{
		if (state == PlayerState.logouting 
				&& this.getState() == PlayerState.logouting)
		{
			return true;
		}
		return this._stateManager.setState(state);
	}
	
	public UpdaterServer getDataUpdater() {
		return _dataUpdater;
	}



	/**
	 * 更新数据
	 */
	private void updateData() 
	{
		try
		{
			this._dataUpdater.update();
		} catch (Exception ex)
		{
			if (Loggers.updateLogger.isErrorEnabled()) 
			{
				Loggers.updateLogger.error(ErrorsUtil.error(CommonErrorLogInfo.INVALID_STATE,
					"#GS.ServiceBuilder.buildGameMessageHandler", ""),ex);
			}
		}
	}
	
	/**
	 * 关闭用户连接, 解除和 session 的绑定
	 * 
	 * @see GameServerIoHandler#sessionClosed(IoSession)
	 * 
	 */
	public void disconnect() 
	{
		
	}
}
