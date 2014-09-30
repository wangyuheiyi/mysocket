package com.gameserver.human.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.google.common.collect.Maps;

/**
 * 升级经验配置
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class ExperienceTemplateVO extends TemplateObject {

	/** 角色经验 */
	@ExcelCellBinding(offset = 1)
	protected int humanExperience;


	public int getHumanExperience() {
		return this.humanExperience;
	}



	public void setHumanExperience(int humanExperience) {
		this.humanExperience = humanExperience;
	}
	
	

	/** 模板字典 */
	protected final static Map<Integer, ExperienceTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends ExperienceTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, ExperienceTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "ExperienceTemplateVO [  humanExperience=" + humanExperience + ",]";
	}
}