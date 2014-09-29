package com.gameserver.common.globals.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.core.uuids.UUID64;
import com.core.uuids.UUIDType;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;

/**
 * UUID管理器
 * @author Thinker
 * 
 * 
 */
@Component
public class UuidService implements IBaseServer
{
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(UuidService.class);
	/** 每次服务器启动跳过的ID数 */
	private static final int UUID_STEP = 1000;
	/** UUID64 */
	private final UUID64[] uuid64 = new UUID64[UUIDType.values().length];
	/** 大区的ID */
	private int rid;
	/** 服的ID */
	private int sid;
	/** 线的ID */
	private int lid;

	public long getNextUUID(UUIDType uuidType)
	{
		return this.uuid64[uuidType.getIndex()].getNextUUID();
	}

	/**
	 * 检查是大区id,服id和线ID是否有效
	 * 
	 * @exception IllegalArgumentException
	 *                当大区id,服id或者线id有一个小于等于0时,会抛出此异常
	 */
	public void check() 
	{
		if (this.rid <= 0 || this.sid <= 0 || this.lid <= 0) 
		{
			throw new IllegalArgumentException("All the rid,sid and the lid must be >0");
		}
	}

	@Override
	public void init(GameConfigServer config)
	{
		this.rid = Integer.parseInt(config.getRegionId());
		this.sid = Integer.parseInt(config.getServerGroupId());
		this.lid = config.getServerIndex();
		check();
		
		for (UUIDType _type : UUIDType.values())
		{
			long _initOid = queryOId(_type.getIndex());
			this.uuid64[_type.getIndex()] = UUID64.buildDefaultUUID(rid, sid,lid, _initOid);
			UUID64 _uuid64 = this.uuid64[_type.getIndex()];
			logger.info("Get UUID for [rid:" + this.rid + ",sid:" + this.sid
					+ ",lid:" + this.lid + ",type:" + _type + "] initOid["
					+ _initOid + "] cur uuid[Hex:"
					+ Long.toHexString(_uuid64.getCurUUID()) + " "
					+ _uuid64.getCurUUID() + "]");
		}
	}

	private long queryOId(final int typeIndex)
	{
		UUID64 _uuid64 = UUID64.buildDefaultUUID(this.rid, this.sid, this.lid,
				0);
		final String[] _paramName = new String[] { "minId", "maxId" };
		final Object[] _paramValues = new Object[] 
		{
			(long) _uuid64.getMinUUID(), (long) _uuid64.getMaxUUID()
		};
		long _curUUID = ServerManager.getInstance().getDbServer().getMaxId(typeIndex, _paramName, _paramValues);
		_curUUID = _uuid64.getOid(((Number) (_curUUID)).longValue());
		_curUUID = _curUUID + UUID_STEP;
		return _curUUID;
	}

}
