package com.gameserver.human.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.context.ContextFactiry;
import com.gameserver.human.Human;
import com.gameserver.human.manager.IHumanManager;

/**
 * 数据管理总和
 * @author Administrator
 *
 */
@Component
public class HumanAllManager implements IHumanManager{
	/** 心跳任务处理器 */
//	private HeartbeatTaskExecutor hbTaskExecutor;
	/**//// 各个功能的管理器/////*/
	/** 建筑物数据管理器*/
	@Resource(name="humanBuildManager")
	private IHumanManager humanBuildManager;
	
	public static HumanAllManager getInstance() 
	{
	     return ContextFactiry.getContext("managerContext").getBean(HumanAllManager.class);
	}

	@Override
	public void init(Human human) {
		humanBuildManager.init(human);
	}

	@Override
	public void load() {
		humanBuildManager.load();
	}

	@Override
	public void checkAfterRoleLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkBeforeRoleEnter() {
		// TODO Auto-generated method stub
		
	}

	public HumanBuildManager getHumanBuildManager() {
		return (HumanBuildManager)humanBuildManager;
	}

	@Override
	public void onHeartBeat() {
		// TODO Auto-generated method stub
		
	}

	
	
}
