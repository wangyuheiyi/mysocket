package com.common.persistance.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
@Service
public class HumanUpdater implements POUpdater{

	@Override
	public void save(PersistanceObject<?, ?> obj) {
		HumanDao humanDao=ServerManager.getInstance().getDbServer().getHumanDao();
		SaveObjectOperation<HumanEntity,Human> saveObjectOperation= new SaveObjectOperation<HumanEntity,Human>((Human) obj, humanDao);
		saveObjectOperation.execute();
	}

	@Override
	public void delete(PersistanceObject<?, ?> obj) {
	}

}
