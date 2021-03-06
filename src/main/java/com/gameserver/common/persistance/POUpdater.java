package com.gameserver.common.persistance;

import com.gameserver.common.operation.PersistanceObject;

/**
 * 可持久化业务对象更新器
 * @author Thinker
 */

public interface POUpdater
{
	/**
	 * 保存
	 * 
	 * @param obj
	 */
	public void save(PersistanceObject<?, ?> obj);

	/**
	 * 删除
	 * 
	 * @param obj
	 */
	public void delete(PersistanceObject<?, ?> obj);
}
