package com.gameserver.building.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.core.util.StringUtils;
import com.google.common.collect.Maps;

/**
 * 建筑信息
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class BuildTemplateVO extends TemplateObject {

	/** 建筑名称多语言Id */
	@ExcelCellBinding(offset = 1)
	protected int buildNameLangId;

	/** 建筑名称 */
	@ExcelCellBinding(offset = 2)
	protected String buildName;

	/** 种族 */
	@ExcelCellBinding(offset = 3)
	protected int allianceType;

	/** 外观 */
	@ExcelCellBinding(offset = 4)
	protected int appearance;

	/** 等级 */
	@ExcelCellBinding(offset = 5)
	protected int level;

	/** 升级后id */
	@ExcelCellBinding(offset = 6)
	protected int levelUpdateId;

	/** 转型等级 */
	@ExcelCellBinding(offset = 7)
	protected int transitionLevel;

	/** 转型后id */
	@ExcelCellBinding(offset = 8)
	protected int transitionId;

	/** 消耗金币 */
	@ExcelCellBinding(offset = 9)
	protected int consumeGold;

	/** 消耗钻石 */
	@ExcelCellBinding(offset = 10)
	protected int consumeDiamond;

	/** 消耗木材 */
	@ExcelCellBinding(offset = 11)
	protected int consumeWood;

	/** 消耗石头 */
	@ExcelCellBinding(offset = 12)
	protected int consumeStone;

	/** 消耗水晶 */
	@ExcelCellBinding(offset = 13)
	protected int consumeCrystal;

	/** 消耗特殊资源 */
	@ExcelCellBinding(offset = 14)
	protected int consumeSpecial;

	/** 建筑时间 */
	@ExcelCellBinding(offset = 15)
	protected int buildTime;

	/** 是否开放 */
	@ExcelCellBinding(offset = 16)
	protected int open;

	/** 产出类型 */
	@ExcelCellBinding(offset = 17)
	protected int outputType;

	/** 产出数量 */
	@ExcelCellBinding(offset = 18)
	protected int outputCount;

	/** 产出物品id */
	@ExcelCellBinding(offset = 19)
	protected int outputId;

	/** 产出间隔（秒） */
	@ExcelCellBinding(offset = 20)
	protected int outputInterval;

	/** 产出最大容量 */
	@ExcelCellBinding(offset = 21)
	protected int outputMax;

	/** 建筑简介多语言Id */
	@ExcelCellBinding(offset = 22)
	protected int descriptionLangId;

	/** 效果类型 */
	@ExcelCellBinding(offset = 23)
	protected int effectType;

	/** 效果id */
	@ExcelCellBinding(offset = 24)
	protected int effectId;

	/** 玩家需求等级 */
	@ExcelCellBinding(offset = 25)
	protected int humanLevel;

	/** 可建造数量 */
	@ExcelCellBinding(offset = 26)
	protected int buildTimes;


	public int getBuildNameLangId() {
		return this.buildNameLangId;
	}



	public void setBuildNameLangId(int buildNameLangId) {
		this.buildNameLangId = buildNameLangId;
	}
	
	public String getBuildName() {
		return this.buildName;
	}



	public void setBuildName(String buildName) {
		if (StringUtils.isEmpty(buildName)) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					3, "[建筑名称]buildName不可以为空");
		}
		this.buildName = buildName;
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
					4, "[种族]allianceType的值不得小于0");
		}
		this.allianceType = allianceType;
	}
	
	public int getAppearance() {
		return this.appearance;
	}


	public final static int getAppearanceMinLimit() {
		return 0;
	}

	public void setAppearance(int appearance) {
		if (appearance < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					5, "[外观]appearance的值不得小于0");
		}
		this.appearance = appearance;
	}
	
	public int getLevel() {
		return this.level;
	}


	public final static int getLevelMinLimit() {
		return 1;
	}

	public void setLevel(int level) {
		if (level < 1) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					6, "[等级]level的值不得小于1");
		}
		this.level = level;
	}
	
	public int getLevelUpdateId() {
		return this.levelUpdateId;
	}


	public final static int getLevelUpdateIdMinLimit() {
		return 0;
	}

	public void setLevelUpdateId(int levelUpdateId) {
		if (levelUpdateId < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					7, "[升级后id]levelUpdateId的值不得小于0");
		}
		this.levelUpdateId = levelUpdateId;
	}
	
	public int getTransitionLevel() {
		return this.transitionLevel;
	}


	public final static int getTransitionLevelMinLimit() {
		return 0;
	}

	public void setTransitionLevel(int transitionLevel) {
		if (transitionLevel < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					8, "[转型等级]transitionLevel的值不得小于0");
		}
		this.transitionLevel = transitionLevel;
	}
	
	public int getTransitionId() {
		return this.transitionId;
	}


	public final static int getTransitionIdMinLimit() {
		return 0;
	}

	public void setTransitionId(int transitionId) {
		if (transitionId < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					9, "[转型后id]transitionId的值不得小于0");
		}
		this.transitionId = transitionId;
	}
	
	public int getConsumeGold() {
		return this.consumeGold;
	}


	public final static int getConsumeGoldMinLimit() {
		return 0;
	}

	public void setConsumeGold(int consumeGold) {
		if (consumeGold < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					10, "[消耗金币]consumeGold的值不得小于0");
		}
		this.consumeGold = consumeGold;
	}
	
	public int getConsumeDiamond() {
		return this.consumeDiamond;
	}


	public final static int getConsumeDiamondMinLimit() {
		return 0;
	}

	public void setConsumeDiamond(int consumeDiamond) {
		if (consumeDiamond < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					11, "[消耗钻石]consumeDiamond的值不得小于0");
		}
		this.consumeDiamond = consumeDiamond;
	}
	
	public int getConsumeWood() {
		return this.consumeWood;
	}


	public final static int getConsumeWoodMinLimit() {
		return 0;
	}

	public void setConsumeWood(int consumeWood) {
		if (consumeWood < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					12, "[消耗木材]consumeWood的值不得小于0");
		}
		this.consumeWood = consumeWood;
	}
	
	public int getConsumeStone() {
		return this.consumeStone;
	}


	public final static int getConsumeStoneMinLimit() {
		return 0;
	}

	public void setConsumeStone(int consumeStone) {
		if (consumeStone < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					13, "[消耗石头]consumeStone的值不得小于0");
		}
		this.consumeStone = consumeStone;
	}
	
	public int getConsumeCrystal() {
		return this.consumeCrystal;
	}


	public final static int getConsumeCrystalMinLimit() {
		return 0;
	}

	public void setConsumeCrystal(int consumeCrystal) {
		if (consumeCrystal < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					14, "[消耗水晶]consumeCrystal的值不得小于0");
		}
		this.consumeCrystal = consumeCrystal;
	}
	
	public int getConsumeSpecial() {
		return this.consumeSpecial;
	}


	public final static int getConsumeSpecialMinLimit() {
		return 0;
	}

	public void setConsumeSpecial(int consumeSpecial) {
		if (consumeSpecial < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					15, "[消耗特殊资源]consumeSpecial的值不得小于0");
		}
		this.consumeSpecial = consumeSpecial;
	}
	
	public int getBuildTime() {
		return this.buildTime;
	}


	public final static int getBuildTimeMinLimit() {
		return 0;
	}

	public void setBuildTime(int buildTime) {
		if (buildTime < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					16, "[建筑时间]buildTime的值不得小于0");
		}
		this.buildTime = buildTime;
	}
	
	public int getOpen() {
		return this.open;
	}



	public void setOpen(int open) {
		this.open = open;
	}
	
	public int getOutputType() {
		return this.outputType;
	}



	public void setOutputType(int outputType) {
		this.outputType = outputType;
	}
	
	public int getOutputCount() {
		return this.outputCount;
	}



	public void setOutputCount(int outputCount) {
		this.outputCount = outputCount;
	}
	
	public int getOutputId() {
		return this.outputId;
	}



	public void setOutputId(int outputId) {
		this.outputId = outputId;
	}
	
	public int getOutputInterval() {
		return this.outputInterval;
	}



	public void setOutputInterval(int outputInterval) {
		this.outputInterval = outputInterval;
	}
	
	public int getOutputMax() {
		return this.outputMax;
	}



	public void setOutputMax(int outputMax) {
		this.outputMax = outputMax;
	}
	
	public int getDescriptionLangId() {
		return this.descriptionLangId;
	}



	public void setDescriptionLangId(int descriptionLangId) {
		this.descriptionLangId = descriptionLangId;
	}
	
	public int getEffectType() {
		return this.effectType;
	}



	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}
	
	public int getEffectId() {
		return this.effectId;
	}



	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}
	
	public int getHumanLevel() {
		return this.humanLevel;
	}



	public void setHumanLevel(int humanLevel) {
		this.humanLevel = humanLevel;
	}
	
	public int getBuildTimes() {
		return this.buildTimes;
	}



	public void setBuildTimes(int buildTimes) {
		this.buildTimes = buildTimes;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, BuildTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends BuildTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, BuildTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "BuildTemplateVO [  buildNameLangId=" + buildNameLangId + ", buildName=" + buildName + ", allianceType=" + allianceType + ", appearance=" + appearance + ", level=" + level + ", levelUpdateId=" + levelUpdateId + ", transitionLevel=" + transitionLevel + ", transitionId=" + transitionId + ", consumeGold=" + consumeGold + ", consumeDiamond=" + consumeDiamond + ", consumeWood=" + consumeWood + ", consumeStone=" + consumeStone + ", consumeCrystal=" + consumeCrystal + ", consumeSpecial=" + consumeSpecial + ", buildTime=" + buildTime + ", open=" + open + ", outputType=" + outputType + ", outputCount=" + outputCount + ", outputId=" + outputId + ", outputInterval=" + outputInterval + ", outputMax=" + outputMax + ", descriptionLangId=" + descriptionLangId + ", effectType=" + effectType + ", effectId=" + effectId + ", humanLevel=" + humanLevel + ", buildTimes=" + buildTimes + ",]";
	}
}