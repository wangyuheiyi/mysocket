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

	/** 统帅成长 */
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
	protected int baseMagic;

	/** 法力成长 */
	@ExcelCellBinding(offset = 13)
	protected int magicGrow;

	/** 基础幸运 */
	@ExcelCellBinding(offset = 14)
	protected int baseLucky;

	/** 幸运成长 */
	@ExcelCellBinding(offset = 15)
	protected int luckyGrow;

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
	@ExcelCellBinding(offset = 23)
	protected int critGrow;

	/** 移动速度 */
	@ExcelCellBinding(offset = 24)
	protected int moveSpeed;

	/** 职业类型 */
	@ExcelCellBinding(offset = 25)
	protected int vocationType;

	/** 是否开放 */
	@ExcelCellBinding(offset = 26)
	protected int open;

	/** 职业说明多语言Id */
	@ExcelCellBinding(offset = 27)
	protected int vocationDescriptionLangId;

	/** 角色界面排序 */
	@ExcelCellBinding(offset = 28)
	protected int roleInterfaceSort;

	/** 角色界面外观 */
	@ExcelCellBinding(offset = 29)
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
	
	public int getBaseControl() {
		return this.baseControl;
	}



	public void setBaseControl(int baseControl) {
		this.baseControl = baseControl;
	}
	
	public int getControlGrow() {
		return this.controlGrow;
	}



	public void setControlGrow(int controlGrow) {
		this.controlGrow = controlGrow;
	}
	
	public int getBaseAttack() {
		return this.baseAttack;
	}



	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}
	
	public int getAttackGrow() {
		return this.attackGrow;
	}



	public void setAttackGrow(int attackGrow) {
		this.attackGrow = attackGrow;
	}
	
	public int getBaseDefence() {
		return this.baseDefence;
	}



	public void setBaseDefence(int baseDefence) {
		this.baseDefence = baseDefence;
	}
	
	public int getDefenceGrow() {
		return this.defenceGrow;
	}



	public void setDefenceGrow(int defenceGrow) {
		this.defenceGrow = defenceGrow;
	}
	
	public int getBaseMagic() {
		return this.baseMagic;
	}



	public void setBaseMagic(int baseMagic) {
		this.baseMagic = baseMagic;
	}
	
	public int getMagicGrow() {
		return this.magicGrow;
	}



	public void setMagicGrow(int magicGrow) {
		this.magicGrow = magicGrow;
	}
	
	public int getBaseLucky() {
		return this.baseLucky;
	}



	public void setBaseLucky(int baseLucky) {
		this.baseLucky = baseLucky;
	}
	
	public int getLuckyGrow() {
		return this.luckyGrow;
	}



	public void setLuckyGrow(int luckyGrow) {
		this.luckyGrow = luckyGrow;
	}
	
	public int getBaseHit() {
		return this.baseHit;
	}



	public void setBaseHit(int baseHit) {
		this.baseHit = baseHit;
	}
	
	public int getHitGrow() {
		return this.hitGrow;
	}



	public void setHitGrow(int hitGrow) {
		this.hitGrow = hitGrow;
	}
	
	public int getBaseDodge() {
		return this.baseDodge;
	}



	public void setBaseDodge(int baseDodge) {
		this.baseDodge = baseDodge;
	}
	
	public int getDodgeGrow() {
		return this.dodgeGrow;
	}



	public void setDodgeGrow(int dodgeGrow) {
		this.dodgeGrow = dodgeGrow;
	}
	
	public int getBaseAvoidDamage() {
		return this.baseAvoidDamage;
	}



	public void setBaseAvoidDamage(int baseAvoidDamage) {
		this.baseAvoidDamage = baseAvoidDamage;
	}
	
	public int getAvoidDamageGrow() {
		return this.avoidDamageGrow;
	}



	public void setAvoidDamageGrow(int avoidDamageGrow) {
		this.avoidDamageGrow = avoidDamageGrow;
	}
	
	public int getBaseCrit() {
		return this.baseCrit;
	}



	public void setBaseCrit(int baseCrit) {
		this.baseCrit = baseCrit;
	}
	
	public int getCritGrow() {
		return this.critGrow;
	}



	public void setCritGrow(int critGrow) {
		this.critGrow = critGrow;
	}
	
	public int getMoveSpeed() {
		return this.moveSpeed;
	}



	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	public int getVocationType() {
		return this.vocationType;
	}



	public void setVocationType(int vocationType) {
		this.vocationType = vocationType;
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
		return "HumanTestTemplateVO [  vocationNameLangId=" + vocationNameLangId + ", vocationName=" + vocationName + ", sex=" + sex + ", photo=" + photo + ", head=" + head + ", baseControl=" + baseControl + ", controlGrow=" + controlGrow + ", baseAttack=" + baseAttack + ", attackGrow=" + attackGrow + ", baseDefence=" + baseDefence + ", defenceGrow=" + defenceGrow + ", baseMagic=" + baseMagic + ", magicGrow=" + magicGrow + ", baseLucky=" + baseLucky + ", luckyGrow=" + luckyGrow + ", baseHit=" + baseHit + ", hitGrow=" + hitGrow + ", baseDodge=" + baseDodge + ", dodgeGrow=" + dodgeGrow + ", baseAvoidDamage=" + baseAvoidDamage + ", avoidDamageGrow=" + avoidDamageGrow + ", baseCrit=" + baseCrit + ", critGrow=" + critGrow + ", moveSpeed=" + moveSpeed + ", vocationType=" + vocationType + ", open=" + open + ", vocationDescriptionLangId=" + vocationDescriptionLangId + ", roleInterfaceSort=" + roleInterfaceSort + ", roleInterfaceAppearance=" + roleInterfaceAppearance + ",]";
	}
}