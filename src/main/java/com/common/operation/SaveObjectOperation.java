package com.common.operation;

import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;

import com.common.constants.CommonErrorLogInfo;
import com.common.constants.Loggers;
import com.core.util.ErrorsUtil;
import com.db.dao.BaseDao;
import com.db.model.BaseEntity;

/**
 * 保存主键是UUID的对象数据到数据库中
 * @author Thinker
 * 
 */
public class SaveObjectOperation<E extends BaseEntity<?>, P extends PersistanceObject<?, E>>
{
	private static final Logger logger = Loggers.errorLogger;

	/** 业务对象 */
	protected final P persistObject;

	/** 实体对象 */
	private E entity;

	/** 是否执行插入操作,如果为false,则执行更新操作 */
	protected boolean save = true;

	private final BaseDao<E> dao;


	public SaveObjectOperation(P persistObject, BaseDao<E> dao) 
	{
		this.persistObject = persistObject;
		this.dao = dao;
	}

	@Async
	public void execute()
	{
		if (persistObject.getDbId() == null)
		{
			// dbId为空时,程序中有bug?停止保存
			if (logger.isErrorEnabled())
			{
				logger.error(ErrorsUtil.error(CommonErrorLogInfo.DB_NO_ID,"#GS.SaveObjectOperation.doStart",
						"The db id must be set before save or update."),new IllegalStateException());
			}
			
		}
		save = !(persistObject.isInDb());
		persistObject.setInDb(true);
		entity = persistObject.toEntity();
		try 
		{
			//保存数据
			if (save)
			{
				dao.save(entity);
			} else
			{
				dao.update(entity);
			}
		} catch (DataAccessException e)
		{
			if (save) 
			{
				persistObject.setInDb(false);
			}
			if (logger.isErrorEnabled())
			{
				logger.error(ErrorsUtil.error(CommonErrorLogInfo.DB_OPERATE_FAIL,
						"#GS.SaveObjectOperation.doIo", null), e);
			}
		}
	}


}
