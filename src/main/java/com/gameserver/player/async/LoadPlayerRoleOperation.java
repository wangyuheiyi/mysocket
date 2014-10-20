package com.gameserver.player.async;

import org.slf4j.Logger;

import com.common.async.IIoOperation;
import com.common.constants.Loggers;
import com.db.dao.impl.HumanDao;
import com.db.model.impl.HumanEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.human.manager.HumanInitManager;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;

/**
 * 加载角色所有数据的异步操作
 * @author Thinker
 * 
 */
public class LoadPlayerRoleOperation implements IIoOperation
{
	private static Logger logger = Loggers.playerLogger;
	private final Player player;
	/** 角色 */
	private Human human;
	private long roleUUID;
	/** 是否数据库操作成功 */
	private boolean isOperateSucc = false;

	public LoadPlayerRoleOperation(Player player, long roleUUID,Human human)
	{
		this.player = player;
		this.roleUUID = roleUUID;
		this.human=human;
	}

	@Override
	public int doIo() 
	{
		do
		{
			try 
			{
				if(human==null){
					HumanEntity entity=ServerManager.getInstance().getDbServer().getHumanDao().get(roleUUID);
					human=new Human(player);
					human.fromEntity(entity);
				}
				
				// 初始化背包
//				human.initInventory();
				
				player.setHuman(human);
				human.getHumanAllManager().load();
				// 初始化武将装备包裹
//				human.getInventory().initPetBags();	
//				
//				human.getWeekLoginManager().load();
//				human.getHumanChargeManager().load();
//				// 加载武将
//				human.getPetManager().load();
//				//加载武将酒馆信息
//				human.getPetPubManager().load();
//				//加载摇钱树信息
//				human.getMoneyTreeManager().load();
//				// 加载物品
//				human.getInventory().load();
//				//加载神器信息
//				human.getGodEquipManager().load();
//				// 加载任务
//				human.getTaskDiary().load();
//				// 加载副本 要在人物之后加载因为需要获取玩家完成的任务
//				human.getMissionManager().load();
//				//加载好友信息
//				human.getRelationManager().load();
//				//加载用户vip信息
//				human.getVipManager().load();
//				//加载竞技场
//				human.getArenaManager().load();
//				//加载邮件信息
//				human.getMailManager().load();
//				//加载过关斩将信息
//				human.getCutPetManager().load();
//				//角色一些简单数据
//				human.getPublicManager().load();
//				//加载角色体力值的信息
//				human.getHumanVimManager().load();
//				//加载角色活跃度的信息
//				human.getLivenessManager().load();
//				//加载珍宝阁信息
//				human.getJumboCourtManager().load();
//
//				//加载角色附身武将的信息
//				human.getPetPossessedManager().load();
//				//加载武将PVP
//				human.getPetPvPManager().load();
//				//加载角色聚宝盆的信息
//				human.getTreasurebowlManager().load();
//				//加载玩家的世界boss信息
//				human.getWorldBossManager().load();
//				//加载复活系统
//				human.getRevivalManager().load();		
//				//加载玩家离线组队信息管理
//				human.getOfflineTeamManager().load();
//				
//				//加载神秘商店管理器
//				human.getMysteryMallManager().load();
//				//加载玩家活动信息
//				human.getHumanActivityManager().load();
//				//加载玩家活动信息
//				human.getHumanGodBookManager().load();
//				//加载无尽副本信息
//				human.getHumanEndLessManager().load();
//				
//				//加载运营活动副本信息
//				human.getOprationActivityManager().load();
				
//				logger.info("player " + player.getPassportName() + " checkAfterRoleLoad");
				// 因为涉及的到数据量可能较大,在加载完成后执行进入游戏的预处理,将相关的对象设置为Live
				human.checkAfterRoleLoad();
				// 数据加载完成之后初始化
				human.onInit();

				human.afterLogin();
				
				human.resetChange();
				
				isOperateSucc = true;
			} catch (Exception e) 
			{
				e.printStackTrace();
				isOperateSucc = false;
				logger.error("player.getRoleUUID()#GS.CharacterLoad.doIo"+ e.getMessage());
			}
		} while (false);
		return STAGE_IO_DONE;
	}
	

	@Override
	public int doStart()
	{			
		return STAGE_START_DONE;
	}

	@Override
	public int doStop()
	{
		final Human human = player.getHuman();
		try
		{
			logger.info("player " + player.getId() + " doStop");
			if (player.getState() == PlayerState.logouting || !isOperateSucc || human == null)
			{				
//				player.sendMessage(new GCNotifyException(
//						DisconnectReason.FINISH_LOAD_HUMAN_EXCEPTION.code, Globals.getLangService().readSysLang(LangConstants.LOAD_PLAYER_SELECTED_ROLE)));
//				player.exitReason = PlayerExitReason.SERVER_ERROR;
				player.disconnect();
			} else 
			{
				logger.info(player.getHuman().getName()+" in select role and will humanlogin");
				HumanInitManager.getInstance().humanLogin(human);
				player.setState(PlayerState.gaming);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			logger.error("player.getRoleUUID()#GS.CharacterLoad.doIo"+ e.getMessage());
//			player.sendMessage(new GCNotifyException(
//					DisconnectReason.FINISH_LOAD_HUMAN_EXCEPTION.code, Globals.getLangService().readSysLang(LangConstants.LOAD_PLAYER_SELECTED_ROLE)));
//			player.exitReason = PlayerExitReason.SERVER_ERROR;
			player.disconnect();
		}
		return STAGE_STOP_DONE;
	}
}
