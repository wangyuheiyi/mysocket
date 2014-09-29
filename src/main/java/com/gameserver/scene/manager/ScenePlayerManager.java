package com.gameserver.scene.manager;

import java.util.ArrayList;
import java.util.List;

import com.core.heartbeat.HeartBeatAble;
import com.gameserver.common.globals.server.impl.OnLinePlayerServer;
import com.gameserver.player.Player;
import com.gameserver.scene.Scene;

/**
 * 管理场景内玩家列表
 * 
 */
public class ScenePlayerManager implements HeartBeatAble {
	
	/** 当前场景对象 **/
	private Scene scene;
	/** 所有在线玩家的管理器,根据此对象取得玩家的实例 **/
	private OnLinePlayerServer onlinePlayerManager;
	/** 玩家ID的列表.此处不引用玩家的实例,获取玩家实例需调用onlinePlayerManager **/
	private List<Long> playerIds;
	
	/** 场景玩家ID.不包括进入竞技场和过关斩将的玩家**/
	private List<Long> scenePlayerIds;
	/** 镜像人数,仅用于非实时性的一些需求,且可能在多线程中调用 */
	private volatile int mirrorPlayerNum;

	public ScenePlayerManager(Scene scene,
			OnLinePlayerServer onlinePlayerManager, int maxPlayerCount) {
		this.scene = scene;
		this.onlinePlayerManager = onlinePlayerManager;
		playerIds = new ArrayList<Long>(maxPlayerCount);
		scenePlayerIds = new ArrayList<Long>(maxPlayerCount);
	}

	public void addPlayer(Long playerId)
	{
		if(containPlayer(playerId)) playerIds.remove(playerId);
		playerIds.add(playerId);
	}

	/**
	 * 当前场景中是否包含某个玩家
	 * 
	 * @param playerId
	 * @return
	 */
	public boolean containPlayer(Long playerId) {
		return this.playerIds.contains(playerId);
	}

	public void removePlayer(Long playerId)
	{
		this.playerIds.remove(playerId);
	}
	
	
	public void addScenePlayer(Long playerId)
	{
		if(containScenePlayer(playerId)) scenePlayerIds.remove(playerId);
		scenePlayerIds.add(playerId);
	}
	/**
	 * 当前场景中是否包含某个玩家
	 * 
	 * @param playerId
	 * @return
	 */
	public boolean containScenePlayer(Long playerId) {
		return this.scenePlayerIds.contains(playerId);
	}

	public void removeScenePlayer(Long playerId)
	{
		this.scenePlayerIds.remove(playerId);
	}
	
	/**
	 * 处理场景内玩家的输入输出消息
	 */
	public void tick()
	{
		List<Long> removePlayerId=new ArrayList<Long>();
		Long playerId=null;
		for (int i=0;i<playerIds.size();i++)
		{
			playerId=playerIds.get(i);
			Player player = onlinePlayerManager.getPlayerById(playerId);
			// 如果玩家已不在在线列表中,或已经不属于当前场景，则从ID列表中删除
			if (player == null  || player.getSceneId() != scene.getId())
			{
				removePlayerId.add(playerId);
				continue;
			}
			player.processMessage();
		}
		playerIds.removeAll(removePlayerId);
		scenePlayerIds.removeAll(removePlayerId);
	}

	@Override
	public void heartBeat() 
	{
		List<Long> removePlayerId=new ArrayList<Long>();
		Long playerId=null;
		
		for (int i=0;i<playerIds.size();i++)
		{
			playerId=playerIds.get(i);
			Player player = onlinePlayerManager.getPlayerById(playerId);
			// 如果玩家已不在在线列表中,或已经不属于当前场景，则从ID列表中删除
			if (player == null || player.getSceneId() != scene.getId())
			{
				removePlayerId.add(playerId);
				continue;
			}
			player.heartBeat();
		}
		
		playerIds.removeAll(removePlayerId);
		scenePlayerIds.removeAll(removePlayerId);
		
		mirrorPlayerNum = playerIds.size();
	}

	public List<Long> getPlayerIds() {
		return this.playerIds;
	}
	public List<Long> getScenePlayerIds() {
		return this.scenePlayerIds;
	}
	/**
	 * 当前场景一个非实时的人数
	 * @see #mirrorPlayerNum
	 * 
	 * @return
	 */
	public int getMirrorPlayerNum() {
		return mirrorPlayerNum;
	}
}
