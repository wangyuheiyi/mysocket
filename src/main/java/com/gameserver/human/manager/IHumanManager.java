package com.gameserver.human.manager;

import com.gameserver.human.Human;

/**
 * 所有human数据管理的接口
 * @author Administrator
 *
 */
public interface IHumanManager {
	/**
	 * 初始化方法
	 * @param human
	 */
	public void init(Human human);
	/**
	 * 加载数据
	 */
	public void load();
	/**
	 * 加载后调用的方法
	 */
	public void checkAfterRoleLoad();
	/**
	 * 进入游戏前调用的方法
	 */
	public void checkBeforeRoleEnter();
}
