package com.gameserver.human.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.context.ContextFactiry;
import com.gameserver.human.Human;

/**
 * 数据管理总和
 * @author Administrator
 *
 */
@Component
public class HumanAllManager {
	/**//// 各个功能的管理器/////*/
	/** 建筑物数据管理器*/
	@Resource(name="humanBuildManager")
	private HumanBuildManager humanBuildManager;
	
	public HumanAllManager(){
		System.out.println("HumanAllManager");
	}
	
	
	public static HumanAllManager getInstance() 
	{
	     return ContextFactiry.getContext("managerContext").getBean(HumanAllManager.class);
	}


	public void init(Human human) {
		humanBuildManager.init(human);
	}


	public void load() {
		humanBuildManager.load();
	}

	public void checkAfterRoleLoad() {
		// TODO Auto-generated method stub
		
	}

	public void checkBeforeRoleEnter() {
		// TODO Auto-generated method stub
		
	}

	public HumanBuildManager getHumanBuildManager() {
		return (HumanBuildManager)humanBuildManager;
	}

	public void onHeartBeat() {

	}

	
	
}
