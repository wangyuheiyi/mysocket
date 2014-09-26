package com.human.template;

import com.core.annotation.ExcelRowBinding;
import java.util.Map;
import com.google.common.collect.Maps;

import com.core.template.TemplateObject;
import com.common.exception.TemplateConfigException;
import com.core.util.StringUtils;
import com.core.annotation.ExcelCellBinding;

/**
 * 角色信息表
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class HumanTemplateVO extends TemplateObject {

	/** 职业名称多语言Id */
	@ExcelCellBinding(offset = 1)
	protected int vocationNameLangId;

	/** 职业名称 */
	@ExcelCellBinding(offset = 2)
	protected String vocationName;

	/** 性别 */
	@ExcelCellBinding(offset = 3)
	protected int sex;

	/** 头像 */
	@ExcelCellBinding(offset = 4)
	protected int photo;

	/** 全身像 */
	@ExcelCellBinding(offset = 5)
	protected int head;

	/** 基础统帅 */
	@ExcelCellBinding(offset = 6)
	protected int baseControl;

	/** 统帅成长*/
	@ExcelCellBinding(offset = 7)
	protected int controlGrow;
	
	/** 基础攻击 */
	@ExcelCellBinding(offset = 8)
	protected int baseAttack;
	
	/** 攻击成长 */
	@ExcelCellBinding(offset = 9)
	protected int attackGrow;

	/** 基础防御 */
	@ExcelCellBinding(offset = 10)
	protected int baseDefence;
	
	/** 防御成长 */
	@ExcelCellBinding(offset = 11)
	protected int defenceGrow;

	/** 基础法力 */
	@ExcelCellBinding(offset = 12)
	protected float baseMagic;

	/** 法力成长 */
	@ExcelCellBinding(offset = 13)
	protected float magicGrow;
	
	/** 基础幸运 */
	@ExcelCellBinding(offset = 14)
	protected float baseLucky;
	
	/** 幸运成长 */
	@ExcelCellBinding(offset = 15)
	protected float luckyGrow;

	/** 基础命中 */
	@ExcelCellBinding(offset = 16)
	protected int baseHit;
	
	/** 命中成长 */
	@ExcelCellBinding(offset = 17)
	protected int hitGrow;

	/** 基础闪避 */
	@ExcelCellBinding(offset = 18)
	protected int baseDodge;
	
	/** 闪避成长 */
	@ExcelCellBinding(offset = 19)
	protected int dodgeGrow;

	/** 基础免伤 */
	@ExcelCellBinding(offset = 20)
	protected int baseAvoidDamage;
	
	/** 免伤成长 */
	@ExcelCellBinding(offset = 21)
	protected int avoidDamageGrow;

	/** 基础暴击 */
	@ExcelCellBinding(offset = 22)
	protected int baseCrit;

	/** 暴击成长 */
	@ExcelCellBinding(offset = 22)
	protected int critGrow;

	/** 移动速度 */
	@ExcelCellBinding(offset = 23)
	protected int moveSpeed;

	/** 职业类型 */
	@ExcelCellBinding(offset = 24)
	protected int vocationType;

	/** 是否开放 */
	@ExcelCellBinding(offset = 25)
	protected int open;

	/** 职业说明多语言Id */
	@ExcelCellBinding(offset = 26)
	protected int vocationDescriptionLangId;

	/** 角色界面排序 */
	@ExcelCellBinding(offset = 27)
	protected int roleInterfaceSort;

	/** 角色界面外观 */
	@ExcelCellBinding(offset = 41)
	protected int roleInterfaceAppearance;



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
					3, "[职业名称]vocationName不可以为空");
		}
		this.vocationName = vocationName;
	}
	
	public int getSex() {
		return this.sex;
	}


	public final static int getSexMinLimit() {
		return 0;
	}
	public final static int getSexMaxLimit() {
		return 1;
	}

	public void setSex(int sex) {
		if (sex > 1 || sex < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					4, "[性别]sex的值不合法，应为0至1之间");
		}
		this.sex = sex;
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
					5, "[头像]photo的值不得小于0");
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
					6, "[全身像]head的值不得小于0");
		}
		this.head = head;
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
					9, "[基础攻击]baseAttack的值不得小于0");
		}
		this.baseAttack = baseAttack;
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
					10, "[基础防御]baseDefence的值不得小于0");
		}
		this.baseDefence = baseDefence;
	}
	


	
	public int getAttackGrow() {
		return this.attackGrow;
	}


	public final static int getAttackGrowMinLimit() {
		return 0;
	}

	public void setAttackGrow(int growthAttack) {
		if (growthAttack < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					12, "[攻击成长]growthAttack的值不得小于0");
		}
		this.attackGrow = growthAttack;
	}
	
	public int getBaseControl() {
		return baseControl;
	}

	public final static int getBaseControlMinLimit() {
		return 0;
	}

	public void setBaseControl(int baseControl) {
		this.baseControl = baseControl;
	}



	public int getControlGrow() {
		return controlGrow;
	}



	public void setControlGrow(int controlGrow) {
		this.controlGrow = controlGrow;
	}



	public int getDefenceGrow() {
		return defenceGrow;
	}



	public void setDefenceGrow(int defenceGrow) {
		this.defenceGrow = defenceGrow;
	}



	public float getBaseMagic() {
		return baseMagic;
	}



	public void setBaseMagic(float baseMagic) {
		this.baseMagic = baseMagic;
	}



	public float getMagicGrow() {
		return magicGrow;
	}



	public void setMagicGrow(float magicGrow) {
		this.magicGrow = magicGrow;
	}



	public float getBaseLucky() {
		return baseLucky;
	}



	public void setBaseLucky(float baseLucky) {
		this.baseLucky = baseLucky;
	}



	public float getLuckyGrow() {
		return luckyGrow;
	}



	public void setLuckyGrow(float luckyGrow) {
		this.luckyGrow = luckyGrow;
	}



	public int getBaseHit() {
		return baseHit;
	}



	public void setBaseHit(int baseHit) {
		this.baseHit = baseHit;
	}



	public int getHitGrow() {
		return hitGrow;
	}



	public void setHitGrow(int hitGrow) {
		this.hitGrow = hitGrow;
	}



	public int getBaseDodge() {
		return baseDodge;
	}



	public void setBaseDodge(int baseDodge) {
		this.baseDodge = baseDodge;
	}



	public int getDodgeGrow() {
		return dodgeGrow;
	}



	public void setDodgeGrow(int dodgeGrow) {
		this.dodgeGrow = dodgeGrow;
	}



	public int getBaseAvoidDamage() {
		return baseAvoidDamage;
	}



	public void setBaseAvoidDamage(int baseAvoidDamage) {
		this.baseAvoidDamage = baseAvoidDamage;
	}



	public int getAvoidDamageGrow() {
		return avoidDamageGrow;
	}



	public void setAvoidDamageGrow(int avoidDamageGrow) {
		this.avoidDamageGrow = avoidDamageGrow;
	}



	public int getBaseCrit() {
		return baseCrit;
	}



	public void setBaseCrit(int baseCrit) {
		this.baseCrit = baseCrit;
	}



	public int getCritGrow() {
		return critGrow;
	}



	public void setCritGrow(int critGrow) {
		this.critGrow = critGrow;
	}



	public int getVocationType() {
		return vocationType;
	}



	public void setVocationType(int vocationType) {
		this.vocationType = vocationType;
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
					21, "[移动速度]moveSpeed的值不得小于0");
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
	
	public int getRoleInterfaceSort() {
		return this.roleInterfaceSort;
	}



	public void setRoleInterfaceSort(int roleInterfaceSort) {
		this.roleInterfaceSort = roleInterfaceSort;
	}
	
	public int getRoleInterfaceAppearance() {
		return this.roleInterfaceAppearance;
	}



	public void setRoleInterfaceAppearance(int roleInterfaceAppearance) {
		this.roleInterfaceAppearance = roleInterfaceAppearance;
	}
	
	
	/** 模板字典 */
	protected final static Map<Integer, HumanTemplateVO> _templates = Maps.newTreeMap();

	@Override
	public void check() 
		throws TemplateConfigException {
	}

	@SuppressWarnings("unchecked")
	public static <T extends HumanTemplateVO> T getTemplate(int templateID) {
		return  (T)_templates.get(templateID);
	}

	/**
	 * 获取模板列表
	 * 
	 */
	public final static Map<Integer, HumanTemplateVO> getTemplates() {
		return _templates;
	}

	@Override
	public String toString() {
		return "HumanTemplateVO [  vocationNameLangId=" + vocationNameLangId + ", vocationName=" + vocationName + ", sex=" + sex + ", photo=" + photo + ", head=" + head+"]";
	}
}