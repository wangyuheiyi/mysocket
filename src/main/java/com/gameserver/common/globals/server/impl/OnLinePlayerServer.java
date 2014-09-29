package com.gameserver.common.globals.server.impl;

import io.netty.channel.Channel;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.common.constants.Loggers;
import com.core.uuids.UUIDType;
import com.db.model.impl.HumanEntity;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.human.Human;
import com.gameserver.player.Player;

@Component
public class OnLinePlayerServer implements IBaseServer{
	public static final Logger logger = Loggers.playerLogger;
	/** 最多同时在线的人数 */
	private int maxPlayerNum;
	/** 在线玩家的会话管理 */
	private Map<Channel, Player> sessionPlayers;
	/** 在线玩家列表，方便查询，key：玩家当前角色UUID，value：玩家引用 */
	private Map<Long, Player> _onlinePlayersMap;
	
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock readLock = rwl.readLock();
	private final Lock writeLock = rwl.writeLock();
	
	/**
	 * 初始化在线玩家实例数组
	 * 
	 * @param maxPlayerNum
	 *            最多同时在线的人数
	 */
	public OnLinePlayerServer()
	{
	}
	
	
	public boolean onPlayerEnterServer(long roleUUID, Player player)
	{
		Assert.notNull(player);
		if (_onlinePlayersMap.size() >= maxPlayerNum) return false;
		writeLock.lock();
		_onlinePlayersMap.put(roleUUID, player);
		sessionPlayers.put(player.getChannel(), player);
		logger.info("Player login, passportId: " + player.getId());
		writeLock.unlock();
		return true;
	}
	
	/**
	 * 获得玩家实例
	 * 
	 * @param playerId
	 * @return
	 */
	public Player getPlayerById(Long playerId) 
	{
		readLock.lock();
		try 
		{
			Player player = _onlinePlayersMap.get(playerId);
			return player;
		} finally
		{
			readLock.unlock();
		}
	}
	
	public Player getPlayerByChannel(Channel channel){
		readLock.lock();
		try 
		{
			Player player = sessionPlayers.get(channel);
			return player;
		} finally
		{
			readLock.unlock();
		}
	}
	
	/**
	 * 创建角色
	 * @param player
	 * @param roleInfo
	 * @return
	 */
	public boolean createRole(Player player, Human human) 
	{
		try 
		{
			//插入角色对象:UUID
			human.setDbId(ServerManager.getInstance().getuUIDService().getNextUUID(UUIDType.HUMAN));
			HumanEntity he = human.toEntity();
			he.setCreateTime(new Timestamp(ServerManager.getInstance().getSystemTimeService().now()));
			ServerManager.getInstance().getDbServer().getHumanDao().save(he);
			return true;
		} catch (org.springframework.dao.DataAccessException e)
		{
			e.printStackTrace();
//			player.sendErrorMessage(Globals.getLangService().getSysLangSerivce().read(LangConstants.LOGIN_UNKOWN_ERROR));
			return false;
		}
	}

	@Override
	public void init(GameConfigServer config) {
		this.maxPlayerNum=config.getMaxOnlineUsers();
		_onlinePlayersMap = new ConcurrentHashMap<Long, Player>(maxPlayerNum);
		sessionPlayers=new ConcurrentHashMap<Channel, Player>(maxPlayerNum);
	}
	
	public int getOnlinePlayerCount() 
	{
		return _onlinePlayersMap.size();
	}
	
}
