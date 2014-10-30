package com.gameserver.hero.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.core.util.StringUtils;
import com.google.common.collect.Maps;

/**
 * 英雄招募数据
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class HeroRecruitTemplateVO extends TemplateObject {

	/** 招募类型 */
	@ExcelCellBinding(offset = 1)
	protected int recruitType;

	/** 种族 */
	@ExcelCellBinding(offset = 2)
	protected int allianceType;

	/** 英雄祭坛名称多语言Id */
	@ExcelCellBinding(offset = 3)
	protected int heroAltarNameLangId;

	/** 英雄祭坛名称 */
	@ExcelCellBinding(offset = 4)
	protected String heroAltarName;

	/** 描述多语言ID */
	@ExcelCellBinding(offset = 5)
	protected int depictLangId;

	/** 普通产出池 */
	@ExcelCellBinding(offset = 6)
	protected int normalPoolId;

	/** 免费间隔时间 */
	@ExcelCellBinding(offset = 7)
	protected int freeInterval;

	/** 首次招募池 */
	@ExcelCellBinding(offset = 8)
	protected int firstPoolId;

	/** 连续招募次数 */
	@ExcelCellBinding(offset = 9)
	protected int continuCount;

	/** 连续招募池 */
	@ExcelCellBinding(offset = 10)
	protected int continuePoolId;

	/** 连续招募折扣 */
	@ExcelCellBinding(offset = 11)
	protected int continueAiscount;

	/** 招募货币类型 */
	@ExcelCellBinding(offset = 12)
	protected int recruitMoneyType;

	/** 招募货币花费 */
	@ExcelCellBinding(offset = 13)
	protected int recruitMoney;


	public int getRecruitType() {
		return this.recruitType;
	}



	public void setRecruitType(int recruitType) {
		this.recruitType = recruitType;
	}
	
	public int getAllianceType() {
		return this.allianceType;
	}


	public final static int getAllianceTypeMinLimit() {
		return 0;
	}

	public void setAllianceType(int allianceType) {
		if (allianceType < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					3, "[种族]allianceType的值不得小于0");
		}
		this.allianceType = allianceType;
	}
	
	public int getHeroAltarNameLangId() {
		return this.heroAltarNameLangId;
	}



	public void setHeroAltarNameLangId(int heroAltarNameLangId) {
		this.heroAltarNameLangId = heroAltarNameLangId;
	}
	
	public String getHeroAltarName() {
		return this.heroAltarName;
	}



	public void setHeroAltarName(String heroAltarName) {
		if (StringUtils.isEmpty(heroAltarName)) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					5, "[英雄祭坛名称]heroAltarName不可以为空");
		}
		this.heroAltarName = heroAltarName;
	}
	
	public int getDepictLangId() {
		return this.depictLangId;
	}



	public void setDepictLangId(int depictLangId) {
		this.depictLangId = depictLangId;
	}
	
	public int getNormalPoolId() {
		return this.normalPoolId;
	}



	public void setNormalPoolId(int normalPoolId) {
		this.normalPoolId = normalPoolId;
	}
	
	public int getFreeInterval() {
		return this.freeInterval;
	}



	public void setFreeInterval(int freeInterval) {
		this.freeInterval = freeInterval;
	}
	
	public int getFirstPoolId() {
		return this.firstPoolId;
	}



	public void setFirstPoolId(int firstPoolId) {
		this.firstPoolId = firstPoolId;
	}
	
	public int getContinuCount() {
		return this.continuCount;
	}



	public void setContinuCount(int continuCount) {
		this.continuCount = continuCount;
	}
	
	public int getContinuePoolId() {
		return this.continuePoolId;
	}



	public void setContinuePoolId(int continuePoolId) {
		this.continuePoolId = continuePoolId;
	}
	
	public int getContinueAiscount() {
		return this.continueAiscount;
	}



	public void setContinueAiscount(int continueAiscount) {
		this.continueAiscount = continueAiscount;
	}
	
	public int getRecruitMoneyType() {
		return this.recruitMoneyType;
	}



	public void setRecruitMoneyType(int recruitMoneyType) {
		this.recruitMoneyType = recruitMoneyType;
	}
	
	public int getRecruitMoney() {
		return this.recruitMoney;
	}



	public void setRecruitMoney(int recruitMoney) {
		this.recruitMoney = recruitMoney;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, HeroRecruitTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends HeroRecruitTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, HeroRecruitTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "HeroRecruitTemplateVO [  recruitType=" + recruitType + ", allianceType=" + allianceType + ", heroAltarNameLangId=" + heroAltarNameLangId + ", heroAltarName=" + heroAltarName + ", depictLangId=" + depictLangId + ", normalPoolId=" + normalPoolId + ", freeInterval=" + freeInterval + ", firstPoolId=" + firstPoolId + ", continuCount=" + continuCount + ", continuePoolId=" + continuePoolId + ", continueAiscount=" + continueAiscount + ", recruitMoneyType=" + recruitMoneyType + ", recruitMoney=" + recruitMoney + ",]";
	}
}