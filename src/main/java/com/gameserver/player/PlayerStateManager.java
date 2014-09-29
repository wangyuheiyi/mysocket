package com.gameserver.player;

import java.util.concurrent.TimeUnit;

import org.springframework.util.Assert;

import com.common.constants.Loggers;
import com.core.heartbeat.HeartBeatAble;
import com.gameserver.common.globals.server.impl.ServerManager;

/**
 * 玩家状态管理器，管理玩家登陆、退出、切换场景等大的状态
 * @author Thinker
 */
public class PlayerStateManager implements HeartBeatAble
{
	/** 无超时时间 */
	public static final int STATE_NO_OVERTIME = 0;

	/** 所属玩家 */
	private Player player;
	/** 当前状态 */
	private volatile PlayerState state;
	/** 状态到期时间 */
	private long deadLine;
	/** 到期后返回的状态 */
	private PlayerState newState;
	private PlayerStateExitCallback exitCallback = null;

	public PlayerStateManager(Player player)
	{
		this.player = player;
		this.state = PlayerState.init;
		this.deadLine = Long.MAX_VALUE;
		this.newState = null;
	}
	

	/**
	 * 判断是否需要向当前状态下的玩家发送指定类型的消息
	 * 
	 * @param messageType
	 * @return
	 */
	public boolean needSend(short messageType)
	{
		switch (this.getState())
		{
			case logouting:
				return false;
			default:
				break;
		}
		return true;
	}

	public boolean setState(PlayerState state)
	{
		return this.enterState(state,PlayerStateManager.STATE_NO_OVERTIME,state);
	}

	public PlayerState getState()
	{
		return state;
	}

	/**
	 * 进入指定状态
	 * 
	 * @param targetState
	 *            期望进入的状态
	 * @param overTime
	 *            超时时间（秒）
	 * @param overTimeState
	 *            超时后返回的状态，若设置了超时时间，这里必须不为null
	 * @param stateContext
	 *            设置状态的上下文
	 * @return 如果成功设置了状态返回真
	 */
	public boolean enterState(PlayerState targetState,int overTime,PlayerState overTimeState)
	{
		if (!this.state.canEnter(targetState))
		{
			Loggers.stateLogger.warn(String.format("Can't change state from [%s] to [%s]!",this.state,targetState));
			return false;
		}
		if (overTime > 0)
		{
			Assert.notNull(overTimeState);
			deadLine = ServerManager.getInstance().getSystemTimeService().now()+ TimeUnit.SECONDS.toMillis(overTime);
			this.newState = overTimeState;
		} else 
		{
			deadLine = Long.MAX_VALUE;
			newState = null;
		}
		this.state = targetState;
		return true;
	}

	@Override
	public void heartBeat() {
		if (deadLine != Long.MAX_VALUE && newState != null)
		{
			if (ServerManager.getInstance().getSystemTimeService().timeUp(deadLine))
			{
				this.setState(this.newState);
				if (exitCallback != null) 
				{
					exitCallback.onExitCurState();
					exitCallback = null;
				}
			}
		}
	}


}
