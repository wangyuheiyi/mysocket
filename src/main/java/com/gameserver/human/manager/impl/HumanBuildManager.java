package com.gameserver.human.manager.impl;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.core.uuids.UUIDType;
import com.db.model.impl.BuildEntity;
import com.gameserver.building.Build;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.human.manager.IHumanManager;
@Component
public class HumanBuildManager implements IHumanManager{
	private Build build;
	/** 主人 */
	private Human owner;
	
	public HumanBuildManager(){
		
	}

	public Build getBuild() {
		return build;
	}

	@Override
	public void init(Human human) {
		this.owner=human;
	}

	@Override
	public void load() {
		loadDataFromDb();
	}
	
	private void loadDataFromDb(){
		long charId=owner.getCharId();
		BuildEntity buildEntity=ServerManager.getInstance().getDbServer().getBuildDao().getBuildEntity(charId);
		build=new Build();
		build.setOwner(owner);
		if(buildEntity!=null){
			build.fromEntity(buildEntity);
		}else{
			build.setDbId(ServerManager.getInstance().getuUIDService().getNextUUID(UUIDType.BUILD));
			build.setCreateTime(new Timestamp(ServerManager.getInstance().getSystemTimeService().now()));
			build.setInDb(false);
			build.active();
			build.setModified();
		}
	}

	@Override
	public void checkAfterRoleLoad() {
		
	}

	@Override
	public void checkBeforeRoleEnter() {
		
	}
	
	
}
