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
			checkBuildFinshed(false);
		}
	}
	
	
	/**
	 * 判断某些建筑是否完成了
	 * @param buildIngList
	 */
	public void checkBuildFinshed(boolean needNotify){
		List<Build> buildIngList=getBuildFinishList(BuildFinishType.UNFINISH.getIndex());
		if(buildIngList.size()==0)return;
		long now =ServerManager.getInstance().getSystemTimeService().now();
		BuildTemplate buildTemplate=null;
		GCUpdateBuildData.Builder gcUpdateBuildData=GCUpdateBuildData.newBuilder();
		for(Build build:buildIngList){
			buildTemplate=ServerManager.getInstance().getBuildSever().getHumanTemplById(build.getTemplateId());
			if(build.getBuildStartTime()+(buildTemplate.getBuildTime()*TimeUtils.SECOND)>now)continue;
			build.setIsFinish(BuildFinishType.FINISH.getIndex());
			if(buildTemplate.getOutputType()!=0){
				build.setOutPutTime(now+buildTemplate.getOutputInterval()*TimeUtils.SECOND);
			}
			build.setModified();
			gcUpdateBuildData.addBuildData(BuildListLogic.getInstance().getBuildClientData(build,BuildUpdateState.ADD.getIndex()));
		}
		if(needNotify&&gcUpdateBuildData.getBuildDataCount()!=0)
			owner.sendMessage(owner.getPlayer().buildBeseMessage(BaseMessage.Type.PLAYERMESSAGE, BaseMessage.MessageCode.GCUPDATEBUILDDATA).
				setExtension(BaseBean.gcUpdateBuildData, gcUpdateBuildData.build()).build());
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
	
	/**
	 * 根据id获取建筑信息
	 * @param BuildId
	 * @return
	 */
	public Build getBuildById(long buildId){
		for(Build build:buildDataList){
			if(build.getDbId()==buildId) return build;
		}
		return null;
	}
	
	
	public Build creatBuildInfo(int templateId){
		long now=ServerManager.getInstance().getSystemTimeService().now();
		Build build=new Build();
		build.setDbId(ServerManager.getInstance().getuUIDService().getNextUUID(UUIDType.BUILD));
		build.setOwner(owner);
		build.setTemplateId(templateId);
		build.setCharId(owner.getCharId());
		build.setInDb(false);
		build.setIsFinish(BuildFinishType.UNFINISH.getIndex());
		build.setBuildStartTime(now);
		build.setDeleted(0);
		build.setCreateTime(new Timestamp(now));
		build.active();
		build.setModified();
		buildDataList.add(build);
		return build;
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
		checkBuildFinshed(true);
	}
	
	
}
