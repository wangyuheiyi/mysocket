package com.templates.human;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.core.template.TemplateService;
import com.human.template.HumanTemplate;
import com.templates.ITemplates;
@Component
public class HumanTemplateSever implements ITemplates{

	/** 模板数据管理器 */
	private TemplateService templateService;
	
	@Override
	public void init(TemplateService templateService) {
		this.templateService=templateService;
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
