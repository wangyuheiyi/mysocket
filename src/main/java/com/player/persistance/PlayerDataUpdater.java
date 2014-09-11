package com.player.persistance;

import java.util.LinkedHashMap;
import java.util.Map;

import com.common.operation.LifeCycle;
import com.common.operation.PersistanceObject;
import com.common.persistance.AbstractDataUpdater;
import com.common.persistance.POUpdater;
import com.human.Human;
import com.human.HumanUpdater;

/**
 * 
 * Player数据更新接口:角色要保持的数据都在这里注册
 * @author Thinker:异步存储必须这里注册
 * 
 */
public class PlayerDataUpdater extends AbstractDataUpdater
{
	private static Map<Class<? extends PersistanceObject<?, ?>>, POUpdater> operationDbMap = new LinkedHashMap<Class<? extends PersistanceObject<?, ?>>, POUpdater>();

	static
	{
		operationDbMap.put(Human.class, new HumanUpdater());
	}

	public PlayerDataUpdater()
	{
		super();
		setUpdaterName("PlayerDataUpdater");
	}

	@Override
	protected void doUpdate(LifeCycle lc)
	{
		if(!lc.isActive())
		{
			throw new IllegalStateException("Only the live object can be updated.");
		}
		PersistanceObject<?, ?> po = lc.getPO();
		POUpdater poUpdater = operationDbMap.get(po.getClass());

		if (poUpdater == null) 
		{
			// 抛出运行时异常
			throw new RuntimeException("cannot find Updater for "+ po.getClass().getName());
		}
		poUpdater.save(po);
	}

	@Override
	protected void doDel(LifeCycle lc)
	{
		if(!lc.isDestroyed())
		{
			throw new IllegalStateException("Only the destroyed object can be deleted.");
		}
		PersistanceObject<?, ?> po = lc.getPO();
		operationDbMap.get(po.getClass()).delete(po);
	}
}
