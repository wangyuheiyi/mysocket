package com.gameserver.hero.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.google.common.collect.Maps;

/**
 * 英雄招募池数据
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class HeroRecruitPoolTemplateVO extends TemplateObject {

	/** 种族 */
	@ExcelCellBinding(offset = 1)
	protected int allianceType;

	/** 道具权重绿 */
	@ExcelCellBinding(offset = 2)
	protected int itemWeightGreen;

	/** 道具权重兰 */
	@ExcelCellBinding(offset = 3)
	protected int itemWeightBlue;

	/** 道具权重紫 */
	@ExcelCellBinding(offset = 4)
	protected int itemWeightPurple;

	/** 指定道具 */
	@ExcelCellBinding(offset = 5)
	protected int specifyItemId;

	/** 英雄权重绿 */
	@ExcelCellBinding(offset = 6)
	protected int heroWeightGreen;

	/** 英雄权重兰 */
	@ExcelCellBinding(offset = 7)
	protected int heroWeightBlue;

	/** 英雄权重紫 */
	@ExcelCellBinding(offset = 8)
	protected int heroWeightPurple;

	/** 英雄权重绿2阶 */
	@ExcelCellBinding(offset = 9)
	protected int heroQualitySecWeightGreen;

	/** 英雄权重兰2阶 */
	@ExcelCellBinding(offset = 10)
	protected int heroQualitySecWeightBlue;

	/** 英雄权重紫2阶 */
	@ExcelCellBinding(offset = 11)
	protected int heroQualitySecWeightPurple;

	/** 指定英雄 */
	@ExcelCellBinding(offset = 12)
	protected int specifyHeroId;


	public int getAllianceType() {
		return this.allianceType;
	}


	public final static int getAllianceTypeMinLimit() {
		return 0;
	}

	public void setAllianceType(int allianceType) {
		if (allianceType < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					2, "[种族]allianceType的值不得小于0");
		}
		this.allianceType = allianceType;
	}
	
	public int getItemWeightGreen() {
		return this.itemWeightGreen;
	}



	public void setItemWeightGreen(int itemWeightGreen) {
		this.itemWeightGreen = itemWeightGreen;
	}
	
	public int getItemWeightBlue() {
		return this.itemWeightBlue;
	}



	public void setItemWeightBlue(int itemWeightBlue) {
		this.itemWeightBlue = itemWeightBlue;
	}
	
	public int getItemWeightPurple() {
		return this.itemWeightPurple;
	}



	public void setItemWeightPurple(int itemWeightPurple) {
		this.itemWeightPurple = itemWeightPurple;
	}
	
	public int getSpecifyItemId() {
		return this.specifyItemId;
	}



	public void setSpecifyItemId(int specifyItemId) {
		this.specifyItemId = specifyItemId;
	}
	
	public int getHeroWeightGreen() {
		return this.heroWeightGreen;
	}



	public void setHeroWeightGreen(int heroWeightGreen) {
		this.heroWeightGreen = heroWeightGreen;
	}
	
	public int getHeroWeightBlue() {
		return this.heroWeightBlue;
	}



	public void setHeroWeightBlue(int heroWeightBlue) {
		this.heroWeightBlue = heroWeightBlue;
	}
	
	public int getHeroWeightPurple() {
		return this.heroWeightPurple;
	}



	public void setHeroWeightPurple(int heroWeightPurple) {
		this.heroWeightPurple = heroWeightPurple;
	}
	
	public int getHeroQualitySecWeightGreen() {
		return this.heroQualitySecWeightGreen;
	}



	public void setHeroQualitySecWeightGreen(int heroQualitySecWeightGreen) {
		this.heroQualitySecWeightGreen = heroQualitySecWeightGreen;
	}
	
	public int getHeroQualitySecWeightBlue() {
		return this.heroQualitySecWeightBlue;
	}



	public void setHeroQualitySecWeightBlue(int heroQualitySecWeightBlue) {
		this.heroQualitySecWeightBlue = heroQualitySecWeightBlue;
	}
	
	public int getHeroQualitySecWeightPurple() {
		return this.heroQualitySecWeightPurple;
	}



	public void setHeroQualitySecWeightPurple(int heroQualitySecWeightPurple) {
		this.heroQualitySecWeightPurple = heroQualitySecWeightPurple;
	}
	
	public int getSpecifyHeroId() {
		return this.specifyHeroId;
	}



	public void setSpecifyHeroId(int specifyHeroId) {
		this.specifyHeroId = specifyHeroId;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, HeroRecruitPoolTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends HeroRecruitPoolTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, HeroRecruitPoolTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "HeroRecruitPoolTemplateVO [  allianceType=" + allianceType + ", itemWeightGreen=" + itemWeightGreen + ", itemWeightBlue=" + itemWeightBlue + ", itemWeightPurple=" + itemWeightPurple + ", specifyItemId=" + specifyItemId + ", heroWeightGreen=" + heroWeightGreen + ", heroWeightBlue=" + heroWeightBlue + ", heroWeightPurple=" + heroWeightPurple + ", heroQualitySecWeightGreen=" + heroQualitySecWeightGreen + ", heroQualitySecWeightBlue=" + heroQualitySecWeightBlue + ", heroQualitySecWeightPurple=" + heroQualitySecWeightPurple + ", specifyHeroId=" + specifyHeroId + ",]";
	}
}