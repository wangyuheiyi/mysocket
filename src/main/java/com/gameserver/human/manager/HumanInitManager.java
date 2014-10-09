package com.gameserver.human.manager;


import org.slf4j.Logger;

import com.common.constants.Loggers;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
import com.gameserver.scene.Scene;

/**
 * 角色初始化过程
 * @author Thinker
 * 
 */
public final class HumanInitManager
{
	private static final Logger logger = Loggers.humanLogger;
	/** 单例对象 */
	private static HumanInitManager instance = null;

	private HumanInitManager()
	{
		
	}

	/**
	 * 获取单例对象
	 * @return 
	 * 
	 */
	public static HumanInitManager getInstance() 
	{
		if(instance==null) instance = new HumanInitManager();
		return instance;
	}


	/**
	 * <pre>
	 * 异步加载玩家角色列表之后调用此方法
	 * 此方法在主线程中调用
	 * <pre>
	 *
	 */
	public void humanLogin(Human human)
	{	
		Player player = human.getPlayer();
		boolean isFirstLogin = human.getLastLoginTime() == null ? true : false;
		
		human.onLogin(isFirstLogin);
		int sceneId=ServerManager.getInstance().getSceneService().getFirstSceneId();
		// 玩家进入主场景
		Scene scene = ServerManager.getInstance().getSceneService().getScene(sceneId);
		scene.onPlayerEnter(player, sceneId);
		
//		human.getOpenFuncManager().checkOpenFuncWithAction(false);
//		human.getOpenSceneManager().checkOpenSceneWithAction();
//		human.getPublicManager().checkGemItemOpenFeature();
//		human.getWeekLoginManager().checkHumanWeekLogin();
//		human.getPetPubManager().checkUserPetPub();
		
		player.setState(PlayerState.incoming);
		player.setState(PlayerState.entering);
		player.setState(PlayerState.gaming);
		
		// 激活此角色
		human.getLifeCycle().activate();
		//加载数据后,更新数据,实际就是为了设置更改状态
//		human.getPropertyManager().updateProperty(RolePropertyManager.PROP_FROM_MARK_ALL);
		//同步缓存
//		Globals.getHumanService().syncCacheEntity(human);
//		//通知活动服务
//		Globals.getActivityService().getActivityListener().onLogin(human);
		// 通知消息
		noticeHuman(human);
	}

	/**
	 * 发送初始的消息接口
	 */
	private void noticeHuman(Human human)
	{		
		logger.info("玩家id["+human.getCharId()+"]玩家名["+human.getName()+"]初始消息发送成功");
	}
}