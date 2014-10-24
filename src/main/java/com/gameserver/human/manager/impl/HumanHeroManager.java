package com.gameserver.human.manager.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BuildBean.GCUpdateBuildData;
import com.core.util.TimeUtils;
import com.core.uuids.UUIDType;
import com.db.model.impl.BuildEntity;
import com.gameserver.building.Build;
import com.gameserver.building.BuildListLogic;
import com.gameserver.building.BuildDef.BuildFinishType;
import com.gameserver.building.BuildDef.BuildUpdateState;
import com.gameserver.building.template.BuildTemplate;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.human.manager.IHumanManager;
@Component("humanHeroManager")
public class HumanHeroManager implements IHumanManager{
	/** 主人 */
	private Human owner;
	
	public HumanHeroManager(){
		
	}

	@Override
	public void init(Human human) {
		this.owner=human;
	}

	@Override
	public void load() {
//		loadDataFromDb();
	}
	

	@Override
	public void checkAfterRoleLoad() {
		
	}

	@Override
	public void checkBeforeRoleEnter() {
		
	}


	@Override
	@Async
	public void onHeartBeat() {
	}
	
	
}
