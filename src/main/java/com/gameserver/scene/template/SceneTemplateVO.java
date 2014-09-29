package com.gameserver.scene.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.core.util.StringUtils;
import com.google.common.collect.Maps;

/**
 * 城镇表
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class SceneTemplateVO extends TemplateObject {

	/** 场景名称多语言Id */
	@ExcelCellBinding(offset = 1)
	protected int sceneNameLangId;

	/** 场景名称 */
	@ExcelCellBinding(offset = 2)
	protected String sceneName;

	/** 下一个场景id */
	@ExcelCellBinding(offset = 3)
	protected int nextSceneId;

	/** 场景最低等级 */
	@ExcelCellBinding(offset = 4)
	protected int minLevel;

	/** 场景最高等级 */
	@ExcelCellBinding(offset = 5)
	protected int maxLevel;

	/** 需求任务ID */
	@ExcelCellBinding(offset = 6)
	protected int needTaskId;

	/** 背景场景 */
	@ExcelCellBinding(offset = 7)
	protected String backgroundScence;
	
	public int getSceneNameLangId() {
		return sceneNameLangId;
	}



	public void setSceneNameLangId(int sceneNameLangId) {
		this.sceneNameLangId = sceneNameLangId;
	}



	public String getSceneName() {
		return this.sceneName;
	}



	public void setSceneName(String sceneName) {
		if (StringUtils.isEmpty(sceneName)) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					3, "[场景名称]sceneName不可以为空");
		}
		this.sceneName = sceneName;
	}
	
	public int getNextSceneId() {
		return this.nextSceneId;
	}


	public final static int getNextSceneIdMinLimit() {
		return 0;
	}

	public void setNextSceneId(int nextSceneId) {
		if (nextSceneId < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					4, "[下一个场景id]nextCityId的值不得小于0");
		}
		this.nextSceneId = nextSceneId;
	}
	
	public int getMinLevel() {
		return this.minLevel;
	}


	public final static int getMinLevelMinLimit() {
		return 0;
	}

	public void setMinLevel(int minLevel) {
		if (minLevel < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					5, "[城镇最低等级]minLevel的值不得小于0");
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
					6, "[城镇最高等级]maxLevel的值不得小于0");
		}
		this.maxLevel = maxLevel;
	}
	
	
	public int getNeedTaskId() {
		return this.needTaskId;
	}


	public final static int getNeedTaskIdMinLimit() {
		return 0;
	}

	public void setNeedTaskId(int needTaskId) {
		if (needTaskId < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					8, "[需求任务ID]needTaskId的值不得小于0");
		}
		this.needTaskId = needTaskId;
	}
	
	public String getBackgroundScence() {
		return this.backgroundScence;
	}



	public void setBackgroundScence(String backgroundScence) {
		this.backgroundScence = backgroundScence;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, SceneTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends SceneTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, SceneTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "SceneTemplateVO [  sceneNameLangId=" + sceneNameLangId + ", sceneName=" + sceneName + ", nextSceneId=" + nextSceneId + ", minLevel=" + minLevel + ", maxLevel=" + maxLevel + ", needTaskId=" + needTaskId + ", backgroundScence=" + backgroundScence + ",]";
	}
}