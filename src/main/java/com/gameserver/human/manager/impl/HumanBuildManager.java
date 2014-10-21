package com.gameserver.human.manager.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.core.uuids.UUIDType;
import com.db.model.impl.BuildEntity;
import com.gameserver.building.Build;
import com.gameserver.building.data.BuildIngData;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.Human;
import com.gameserver.human.manager.IHumanManager;
@Component
public class HumanBuildManager implements IHumanManager{
	/** 主人 */
	private Human owner;
	
	/** 建筑列表*/
	private List<Build> buildDataList=new ArrayList<Build>();
	
	public HumanBuildManager(){
		
	}


	public List<Build> getBuildDataList() {
		return buildDataList;
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
		List<BuildEntity> buildEntityList=ServerManager.getInstance().getDbServer().getBuildDao().getBuildEntity(charId);
		if(buildEntityList!=null){
			Build build=null;
			for(BuildEntity buildEntity:buildEntityList){
				build=new Build();
				build.setOwner(owner);
				build.fromEntity(buildEntity);
				buildDataList.add(build);
			}
		}
	}
	
	/**
	 * 获取建筑完成或者为完成的列表
	 * @param isFinish
	 * @return
	 */
	public List<Build> getBuildFinishList(int isFinish){
		List<Build> buildFinishList=new ArrayList<Build>();
		for(Build build:buildDataList){
			if(build.getIsFinish()==isFinish) buildFinishList.add(build);
		}
		return buildFinishList;
	}

	@Override
	public void checkAfterRoleLoad() {
		
	}

	@Override
	public void checkBeforeRoleEnter() {
		
	}
	
	
}
