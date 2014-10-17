package com.gameserver.building.server;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.core.templates.TemplateService;
import com.gameserver.building.template.BuildQueueTemplate;
import com.gameserver.building.template.BuildTemplate;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.common.globals.server.impl.ServerManager;
@Component
public class BuildSever implements IBaseServer{

	/** 模板数据管理器 */
	private TemplateService templateService;
	@Override
	public void init(GameConfigServer config) {
		this.templateService=ServerManager.getInstance().getTemplateService();
	}

	/**
	 * 根据Id获取建筑模板
	 * @return
	 */
	public BuildTemplate getHumanTemplById(int buildTemplId)
	{
		return this.templateService.get(buildTemplId,BuildTemplate.class);
	}
	
	/**
	 * 根据Id获取全部建筑模板
	 * @return
	 */
	public Map<Integer,BuildTemplate> getAllBuildTempl()
	{
		return this.templateService.getAll(BuildTemplate.class);
	}
	
	
	/**
	 * 根据Id获取全部建筑队列模板
	 * @return
	 */
	public Map<Integer,BuildQueueTemplate> getAllBuildQueueTempl()
	{
		return this.templateService.getAll(BuildQueueTemplate.class);
	}
	
	
	/**
	 * 根据等级获取建筑队列表
	 * @param level
	 * @return
	 */
	public BuildQueueTemplate getBuildQueueByLevel(int level){
		for(BuildQueueTemplate buildQueueTemplate:getAllBuildQueueTempl().values()){
			if(level>=buildQueueTemplate.getMinLevel()&&level<=buildQueueTemplate.getMaxLevel()) return buildQueueTemplate;
		}
		return null;
	}
	
}
