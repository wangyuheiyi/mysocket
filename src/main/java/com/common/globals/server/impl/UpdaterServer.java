package com.common.globals.server.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.common.context.ContextFactiry;
import com.common.globals.config.GameConfigServer;
import com.common.globals.server.IBaseServer;
import com.common.operation.LifeCycle;
import com.common.operation.PersistanceObject;
import com.common.persistance.AbstractDataUpdater;
import com.common.persistance.POUpdater;
import com.common.persistance.impl.HumanUpdater;
import com.human.Human;

/**
 * 
 * Player数据更新接口:角色要保持的数据都在这里注册
 * @author Thinker:异步存储必须这里注册
 * 
 */
@Component
public class UpdaterServer extends AbstractDataUpdater implements IBaseServer
{
	private static Map<Class<? extends PersistanceObject<?, ?>>, POUpdater> operationDbMap = new LinkedHashMap<Class<? extends PersistanceObject<?, ?>>, POUpdater>();

	public UpdaterServer()
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

	@Override
	public void init(GameConfigServer config) {
		operationDbMap.put(Human.class, (POUpdater)ContextFactiry.getContext("operationContext").getBean(HumanUpdater.class));
	}
}
