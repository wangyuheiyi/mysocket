package com.common.persistance;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.common.operation.PersistanceObject;

/**
 * 可持久化业务对象更新器
 * @author Thinker
 */
@Service
public interface POUpdater
{
	/**
	 * 保存
	 * 
	 * @param obj
	 */
	@Async
	public void save(PersistanceObject<?, ?> obj);

	/**
	 * 删除
	 * 
	 * @param obj
	 */
	@Async
	public void delete(PersistanceObject<?, ?> obj);
}
