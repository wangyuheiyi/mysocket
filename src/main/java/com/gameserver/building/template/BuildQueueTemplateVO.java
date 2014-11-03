package com.gameserver.building.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.google.common.collect.Maps;

/**
 * 建筑队列信息
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class BuildQueueTemplateVO extends TemplateObject {

	/** vip等级下限 */
	@ExcelCellBinding(offset = 1)
	protected int minLevel;

	/** vip等级上限 */
	@ExcelCellBinding(offset = 2)
	protected int maxLevel;

	/** 队列数量 */
	@ExcelCellBinding(offset = 3)
	protected int queueCount;


	public int getMinLevel() {
		return this.minLevel;
	}


	public final static int getMinLevelMinLimit() {
		return 0;
	}

	public void setMinLevel(int minLevel) {
		if (minLevel < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					2, "[等级下限]minLevel的值不得小于0");
		}
		this.minLevel = minLevel;
	}
	
	public int getMaxLevel() {
		return this.maxLevel;
	}


	public final static int getMaxLevelMinLimit() {
		return 0;
	}

	public void setMaxLevel(int maxLevel) {
		if (maxLevel < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					3, "[等级上限]maxLevel的值不得小于0");
		}
		this.maxLevel = maxLevel;
	}
	
	public int getQueueCount() {
		return this.queueCount;
	}


	public final static int getQueueCountMinLimit() {
		return 1;
	}

	public void setQueueCount(int queueCount) {
		if (queueCount < 1) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					4, "[队列数量]queueCount的值不得小于1");
		}
		this.queueCount = queueCount;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, BuildQueueTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends BuildQueueTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, BuildQueueTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "BuildQueueTemplateVO [  minLevel=" + minLevel + ", maxLevel=" + maxLevel + ", queueCount=" + queueCount + ",]";
	}
}