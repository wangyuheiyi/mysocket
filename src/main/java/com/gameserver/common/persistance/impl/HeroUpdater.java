package com.gameserver.common.persistance.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.db.dao.impl.HeroDao;
import com.db.model.impl.HeroEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.operation.PersistanceObject;
import com.gameserver.common.operation.SaveObjectOperation;
import com.gameserver.common.persistance.POUpdater;
import com.gameserver.hero.Hero;

/**
 * 玩家角色英雄基本信息更新器
 * @author Thinker
 */
@Scope("prototype")
@Component("heroUpdater")
public class HeroUpdater implements POUpdater{

	@Async
	@Override
	public void save(PersistanceObject<?, ?> obj) {
		HeroDao heroDao=ServerManager.getInstance().getDbServer().getHeroDao();
		SaveObjectOperation<HeroEntity,Hero> saveObjectOperation= new SaveObjectOperation<HeroEntity,Hero>((Hero) obj, heroDao);
		saveObjectOperation.execute();
	}

	@Async
	@Override
	public void delete(PersistanceObject<?, ?> obj) {
	}

}
