package com.gameserver.human.sever;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.core.templates.TemplateService;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.human.template.HumanTemplate;
@Component
public class HumanSever implements IBaseServer{

	/** 模板数据管理器 */
	private TemplateService templateService;
	
	@Override
	public void init(GameConfigServer config) {
		this.templateService=ServerManager.getInstance().getTemplateService();
	}

	/**
	 * 根据Id获取人物模板
	 * @return
	 */
	public HumanTemplate getHumanTemplById(int humanTemplId)
	{
		return this.templateService.get(humanTemplId,HumanTemplate.class);
	}
	
	/**
	 * 根据Id获取人物模板
	 * @return
	 */
	public Map<Integer,HumanTemplate> getAllHumanTempl()
	{
		return this.templateService.getAll(HumanTemplate.class);
	}
	
	public HumanTemplate getHumanTemplByAvatar(int avatar){
		for(HumanTemplate humanTemplate:getAllHumanTempl().values()){
			if(humanTemplate.getRoleInterfaceAppearance()==avatar) return humanTemplate;
		}
		return null;
	}
}
