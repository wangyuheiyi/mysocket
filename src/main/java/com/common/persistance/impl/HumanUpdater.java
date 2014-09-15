package com.common.persistance.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.common.globals.server.impl.ServerManager;
import com.common.operation.PersistanceObject;
import com.common.operation.SaveObjectOperation;
import com.common.persistance.POUpdater;
import com.db.dao.impl.HumanDao;
import com.db.model.impl.HumanEntity;
import com.human.Human;

/**
 * 玩家角色基本信息更新器
 * @author Thinker
 */
@Scope("prototype")
@Component("humanUpdater")
public class HumanUpdater implements POUpdater{

	@Async
	@Override
	public void save(PersistanceObject<?, ?> obj) {
		HumanDao humanDao=ServerManager.getInstance().getDbServer().getHumanDao();
		SaveObjectOperation<HumanEntity,Human> saveObjectOperation= new SaveObjectOperation<HumanEntity,Human>((Human) obj, humanDao);
		saveObjectOperation.execute();
	}

	@Async
	@Override
	public void delete(PersistanceObject<?, ?> obj) {
	}

}
