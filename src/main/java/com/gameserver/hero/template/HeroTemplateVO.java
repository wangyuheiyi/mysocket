package com.gameserver.hero.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.core.util.StringUtils;
import com.google.common.collect.Maps;

/**
 * 英雄信息表
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class HeroTemplateVO extends TemplateObject {

	/** 英雄名称多语言Id */
	@ExcelCellBinding(offset = 1)
	protected int heroNameLangId;

	/** 英雄名称 */
	@ExcelCellBinding(offset = 2)
	protected String heroName;

	/** 职业名称多语言Id */
	@ExcelCellBinding(offset = 3)
	protected int vocationNameLangId;

	/** 职业名称 */
	@ExcelCellBinding(offset = 4)
	protected String vocationName;

	/** 职业类型 */
	@ExcelCellBinding(offset = 5)
	protected int vocationType;

	/** 种族 */
	@ExcelCellBinding(offset = 6)
	protected int allianceType;

	/** 头像 */
	@ExcelCellBinding(offset = 7)
	protected int photo;

	/** 全身像 */
	@ExcelCellBinding(offset = 8)
	protected int head;

	/** 品质 */
	@ExcelCellBinding(offset = 9)
	protected int quality;

	/** 品阶 */
	@ExcelCellBinding(offset = 10)
	protected int qualityStep;

	/** 基础统帅 */
	@ExcelCellBinding(offset = 11)
	protected int baseControl;

	/** 统帅成长 */
	@ExcelCellBinding(offset = 12)
	protected int controlGrow;

	/** 基础攻击 */
	@ExcelCellBinding(offset = 13)
	protected int baseAttack;

	/** 攻击成长 */
	@ExcelCellBinding(offset = 14)
	protected int attackGrow;

	/** 基础防御 */
	@ExcelCellBinding(offset = 15)
	protected int baseDefence;

	/** 防御成长 */
	@ExcelCellBinding(offset = 16)
	protected int defenceGrow;

	/** 基础法力 */
	@ExcelCellBinding(offset = 17)
	protected int baseMagic;

	/** 法力成长 */
	@ExcelCellBinding(offset = 18)
	protected int magicGrow;

	/** 基础幸运 */
	@ExcelCellBinding(offset = 19)
	protected int baseLucky;

	/** 幸运成长 */
	@ExcelCellBinding(offset = 20)
	protected int luckyGrow;

	/** 基础命中 */
	@ExcelCellBinding(offset = 21)
	protected int baseHit;

	/** 命中成长 */
	@ExcelCellBinding(offset = 22)
	protected int hitGrow;

	/** 基础闪避 */
	@ExcelCellBinding(offset = 23)
	protected int baseDodge;

	/** 闪避成长 */
	@ExcelCellBinding(offset = 24)
	protected int dodgeGrow;

	/** 基础免伤 */
	@ExcelCellBinding(offset = 25)
	protected int baseAvoidDamage;

	/** 免伤成长 */
	@ExcelCellBinding(offset = 26)
	protected int avoidDamageGrow;

	/** 基础暴击 */
	@ExcelCellBinding(offset = 27)
	protected int baseCrit;

	/** 暴击成长 */
	@ExcelCellBinding(offset = 28)
	protected int critGrow;

	/** 移动速度 */
	@ExcelCellBinding(offset = 29)
	protected int moveSpeed;

	/** 是否开放 */
	@ExcelCellBinding(offset = 30)
	protected int open;

	/** 职业说明多语言Id */
	@ExcelCellBinding(offset = 31)
	protected int vocationDescriptionLangId;

	/** 被动技能A */
	@ExcelCellBinding(offset = 32)
	protected int passiveSkillA;

	/** 被动技能B */
	@ExcelCellBinding(offset = 33)
	protected int passiveSkillB;


	public int getHeroNameLangId() {
		return this.heroNameLangId;
	}



	public void setHeroNameLangId(int heroNameLangId) {
		this.heroNameLangId = heroNameLangId;
	}
	
	public String getHeroName() {
		return this.heroName;
	}



	public void setHeroName(String heroName) {
		if (StringUtils.isEmpty(heroName)) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					3, "[英雄名称]heroName不可以为空");
		}
		this.heroName = heroName;
	}
	
	public int getVocationNameLangId() {
		return this.vocationNameLangId;
	}



	public void setVocationNameLangId(int vocationNameLangId) {
		this.vocationNameLangId = vocationNameLangId;
	}
	
	public String getVocationName() {
		return this.vocationName;
	}



	public void setVocationName(String vocationName) {
		if (StringUtils.isEmpty(vocationName)) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					5, "[职业名称]vocationName不可以为空");
		}
		this.vocationName = vocationName;
	}
	
	public int getVocationType() {
		return this.vocationType;
	}


	public final static int getVocationTypeMinLimit() {
		return 0;
	}

	public void setVocationType(int vocationType) {
		if (vocationType < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					6, "[职业类型]vocationType的值不得小于0");
		}
		this.vocationType = vocationType;
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
					7, "[种族]allianceType的值不得小于0");
		}
		this.allianceType = allianceType;
	}
	
	public int getPhoto() {
		return this.photo;
	}


	public final static int getPhotoMinLimit() {
		return 0;
	}

	public void setPhoto(int photo) {
		if (photo < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					8, "[头像]photo的值不得小于0");
		}
		this.photo = photo;
	}
	
	public int getHead() {
		return this.head;
	}


	public final static int getHeadMinLimit() {
		return 0;
	}

	public void setHead(int head) {
		if (head < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					9, "[全身像]head的值不得小于0");
		}
		this.head = head;
	}
	
	public int getQuality() {
		return this.quality;
	}


	public final static int getQualityMinLimit() {
		return 1;
	}

	public void setQuality(int quality) {
		if (quality < 1) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					10, "[品质]quality的值不得小于1");
		}
		this.quality = quality;
	}
	
	public int getQualityStep() {
		return this.qualityStep;
	}


	public final static int getQualityStepMinLimit() {
		return 0;
	}

	public void setQualityStep(int qualityStep) {
		if (qualityStep < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					11, "[品阶]qualityStep的值不得小于0");
		}
		this.qualityStep = qualityStep;
	}
	
	public int getBaseControl() {
		return this.baseControl;
	}


	public final static int getBaseControlMinLimit() {
		return 0;
	}

	public void setBaseControl(int baseControl) {
		if (baseControl < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					12, "[基础统帅]baseControl的值不得小于0");
		}
		this.baseControl = baseControl;
	}
	
	public int getControlGrow() {
		return this.controlGrow;
	}


	public final static int getControlGrowMinLimit() {
		return 0;
	}

	public void setControlGrow(int controlGrow) {
		if (controlGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					13, "[统帅成长]controlGrow的值不得小于0");
		}
		this.controlGrow = controlGrow;
	}
	
	public int getBaseAttack() {
		return this.baseAttack;
	}


	public final static int getBaseAttackMinLimit() {
		return 0;
	}

	public void setBaseAttack(int baseAttack) {
		if (baseAttack < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					14, "[基础攻击]baseAttack的值不得小于0");
		}
		this.baseAttack = baseAttack;
	}
	
	public int getAttackGrow() {
		return this.attackGrow;
	}


	public final static int getAttackGrowMinLimit() {
		return 0;
	}

	public void setAttackGrow(int attackGrow) {
		if (attackGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					15, "[攻击成长]attackGrow的值不得小于0");
		}
		this.attackGrow = attackGrow;
	}
	
	public int getBaseDefence() {
		return this.baseDefence;
	}


	public final static int getBaseDefenceMinLimit() {
		return 0;
	}

	public void setBaseDefence(int baseDefence) {
		if (baseDefence < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					16, "[基础防御]baseDefence的值不得小于0");
		}
		this.baseDefence = baseDefence;
	}
	
	public int getDefenceGrow() {
		return this.defenceGrow;
	}


	public final static int getDefenceGrowMinLimit() {
		return 0;
	}

	public void setDefenceGrow(int defenceGrow) {
		if (defenceGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					17, "[防御成长]defenceGrow的值不得小于0");
		}
		this.defenceGrow = defenceGrow;
	}
	
	public int getBaseMagic() {
		return this.baseMagic;
	}


	public final static int getBaseMagicMinLimit() {
		return 0;
	}

	public void setBaseMagic(int baseMagic) {
		if (baseMagic < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					18, "[基础法力]baseMagic的值不得小于0");
		}
		this.baseMagic = baseMagic;
	}
	
	public int getMagicGrow() {
		return this.magicGrow;
	}


	public final static int getMagicGrowMinLimit() {
		return 0;
	}

	public void setMagicGrow(int magicGrow) {
		if (magicGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					19, "[法力成长]magicGrow的值不得小于0");
		}
		this.magicGrow = magicGrow;
	}
	
	public int getBaseLucky() {
		return this.baseLucky;
	}


	public final static int getBaseLuckyMinLimit() {
		return 0;
	}

	public void setBaseLucky(int baseLucky) {
		if (baseLucky < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					20, "[基础幸运]baseLucky的值不得小于0");
		}
		this.baseLucky = baseLucky;
	}
	
	public int getLuckyGrow() {
		return this.luckyGrow;
	}


	public final static int getLuckyGrowMinLimit() {
		return 0;
	}

	public void setLuckyGrow(int luckyGrow) {
		if (luckyGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					21, "[幸运成长]luckyGrow的值不得小于0");
		}
		this.luckyGrow = luckyGrow;
	}
	
	public int getBaseHit() {
		return this.baseHit;
	}


	public final static int getBaseHitMinLimit() {
		return 0;
	}

	public void setBaseHit(int baseHit) {
		if (baseHit < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					22, "[基础命中]baseHit的值不得小于0");
		}
		this.baseHit = baseHit;
	}
	
	public int getHitGrow() {
		return this.hitGrow;
	}


	public final static int getHitGrowMinLimit() {
		return 0;
	}

	public void setHitGrow(int hitGrow) {
		if (hitGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					23, "[命中成长]hitGrow的值不得小于0");
		}
		this.hitGrow = hitGrow;
	}
	
	public int getBaseDodge() {
		return this.baseDodge;
	}


	public final static int getBaseDodgeMinLimit() {
		return 0;
	}

	public void setBaseDodge(int baseDodge) {
		if (baseDodge < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					24, "[基础闪避]baseDodge的值不得小于0");
		}
		this.baseDodge = baseDodge;
	}
	
	public int getDodgeGrow() {
		return this.dodgeGrow;
	}


	public final static int getDodgeGrowMinLimit() {
		return 0;
	}

	public void setDodgeGrow(int dodgeGrow) {
		if (dodgeGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					25, "[闪避成长]dodgeGrow的值不得小于0");
		}
		this.dodgeGrow = dodgeGrow;
	}
	
	public int getBaseAvoidDamage() {
		return this.baseAvoidDamage;
	}


	public final static int getBaseAvoidDamageMinLimit() {
		return 0;
	}

	public void setBaseAvoidDamage(int baseAvoidDamage) {
		if (baseAvoidDamage < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					26, "[基础免伤]baseAvoidDamage的值不得小于0");
		}
		this.baseAvoidDamage = baseAvoidDamage;
	}
	
	public int getAvoidDamageGrow() {
		return this.avoidDamageGrow;
	}


	public final static int getAvoidDamageGrowMinLimit() {
		return 0;
	}

	public void setAvoidDamageGrow(int avoidDamageGrow) {
		if (avoidDamageGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					27, "[免伤成长]avoidDamageGrow的值不得小于0");
		}
		this.avoidDamageGrow = avoidDamageGrow;
	}
	
	public int getBaseCrit() {
		return this.baseCrit;
	}


	public final static int getBaseCritMinLimit() {
		return 0;
	}

	public void setBaseCrit(int baseCrit) {
		if (baseCrit < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					28, "[基础暴击]baseCrit的值不得小于0");
		}
		this.baseCrit = baseCrit;
	}
	
	public int getCritGrow() {
		return this.critGrow;
	}


	public final static int getCritGrowMinLimit() {
		return 0;
	}

	public void setCritGrow(int critGrow) {
		if (critGrow < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					29, "[暴击成长]critGrow的值不得小于0");
		}
		this.critGrow = critGrow;
	}
	
	public int getMoveSpeed() {
		return this.moveSpeed;
	}


	public final static int getMoveSpeedMinLimit() {
		return 0;
	}

	public void setMoveSpeed(int moveSpeed) {
		if (moveSpeed < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					30, "[移动速度]moveSpeed的值不得小于0");
		}
		this.moveSpeed = moveSpeed;
	}
	
	public int getOpen() {
		return this.open;
	}



	public void setOpen(int open) {
		this.open = open;
	}
	
	public int getVocationDescriptionLangId() {
		return this.vocationDescriptionLangId;
	}



	public void setVocationDescriptionLangId(int vocationDescriptionLangId) {
		this.vocationDescriptionLangId = vocationDescriptionLangId;
	}
	
	public int getPassiveSkillA() {
		return this.passiveSkillA;
	}



	public void setPassiveSkillA(int passiveSkillA) {
		this.passiveSkillA = passiveSkillA;
	}
	
	public int getPassiveSkillB() {
		return this.passiveSkillB;
	}



	public void setPassiveSkillB(int passiveSkillB) {
		this.passiveSkillB = passiveSkillB;
	}
	

	/** 模板字典 */
	protected final static Map<Integer, HeroTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends HeroTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, HeroTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "HeroTemplateVO [  heroNameLangId=" + heroNameLangId + ", heroName=" + heroName + ", vocationNameLangId=" + vocationNameLangId + ", vocationName=" + vocationName + ", vocationType=" + vocationType + ", allianceType=" + allianceType + ", photo=" + photo + ", head=" + head + ", quality=" + quality + ", qualityStep=" + qualityStep + ", baseControl=" + baseControl + ", controlGrow=" + controlGrow + ", baseAttack=" + baseAttack + ", attackGrow=" + attackGrow + ", baseDefence=" + baseDefence + ", defenceGrow=" + defenceGrow + ", baseMagic=" + baseMagic + ", magicGrow=" + magicGrow + ", baseLucky=" + baseLucky + ", luckyGrow=" + luckyGrow + ", baseHit=" + baseHit + ", hitGrow=" + hitGrow + ", baseDodge=" + baseDodge + ", dodgeGrow=" + dodgeGrow + ", baseAvoidDamage=" + baseAvoidDamage + ", avoidDamageGrow=" + avoidDamageGrow + ", baseCrit=" + baseCrit + ", critGrow=" + critGrow + ", moveSpeed=" + moveSpeed + ", open=" + open + ", vocationDescriptionLangId=" + vocationDescriptionLangId + ", passiveSkillA=" + passiveSkillA + ", passiveSkillB=" + passiveSkillB + ",]";
	}
}