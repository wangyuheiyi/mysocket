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
	protected int baseHp;

	/** 基础攻击 */
	@ExcelCellBinding(offset = 8)
	protected int baseAttack;

	/** 基础防御 */
	@ExcelCellBinding(offset = 9)
	protected int baseDefence;

	/** 血量成长 */
	@ExcelCellBinding(offset = 10)
	protected float growthHp;

	/** 攻击成长 */
	@ExcelCellBinding(offset = 11)
	protected float growthAttack;

	/** 防御成长 */
	@ExcelCellBinding(offset = 12)
	protected float growthDefence;

	/** 爆击 */
	@ExcelCellBinding(offset = 13)
	protected int crit;

	/** 爆击抵抗 */
	@ExcelCellBinding(offset = 14)
	protected int critResist;

	/** 命中 */
	@ExcelCellBinding(offset = 15)
	protected int hit;

	/** 闪避 */
	@ExcelCellBinding(offset = 16)
	protected int dodge;

	/** 免伤 */
	@ExcelCellBinding(offset = 17)
	protected int avoidDamage;

	/** 暴击伤害 */
	@ExcelCellBinding(offset = 18)
	protected int critDamage;

	/** 破甲伤害 */
	@ExcelCellBinding(offset = 19)
	protected int wreckArmorDamage;

	/** 移动速度 */
	@ExcelCellBinding(offset = 20)
	protected int moveSpeed;

	/** 帽子装备 */
	@ExcelCellBinding(offset = 21)
	protected int capEquip;

	/** 武器装备 */
	@ExcelCellBinding(offset = 22)
	protected int weaponEquip;

	/** 衣服装备 */
	@ExcelCellBinding(offset = 23)
	protected int clothesEquip;

	/** 鞋子装备 */
	@ExcelCellBinding(offset = 24)
	protected int bootsEquip;

	/** 护腕装备 */
	@ExcelCellBinding(offset = 25)
	protected int bracersEquip;

	/** 饰品装备 */
	@ExcelCellBinding(offset = 26)
	protected int talismanEquip;

	/** 普通攻击 */
	@ExcelCellBinding(offset = 27)
	protected int commonAttack;

	/** 主动技能1 */
	@ExcelCellBinding(offset = 28)
	protected int activeSkill1;

	/** 主动技能2 */
	@ExcelCellBinding(offset = 29)
	protected int activeSkill2;

	/** 主动技能3 */
	@ExcelCellBinding(offset = 30)
	protected int activeSkill3;

	/** 主动技能4 */
	@ExcelCellBinding(offset = 31)
	protected int activeSkill4;

	/** 被动技能1 */
	@ExcelCellBinding(offset = 32)
	protected int passiveSkill1;

	/** 被动技能2 */
	@ExcelCellBinding(offset = 33)
	protected int passiveSkill2;

	/** 被动技能3 */
	@ExcelCellBinding(offset = 34)
	protected int passiveSkill3;

	/** 碰撞块长 */
	@ExcelCellBinding(offset = 35)
	protected int collisionLength;

	/** 碰撞块宽 */
	@ExcelCellBinding(offset = 36)
	protected int collisionWidth;

	/** 碰撞块高 */
	@ExcelCellBinding(offset = 37)
	protected int collisionHeight;

	/** 是否开放 */
	@ExcelCellBinding(offset = 38)
	protected int open;

	/** 职业说明多语言Id */
	@ExcelCellBinding(offset = 39)
	protected int vocationDescriptionLangId;

	/** 角色界面排序 */
	@ExcelCellBinding(offset = 40)
	protected int roleInterfaceSort;

	/** 角色界面外观 */
	@ExcelCellBinding(offset = 41)
	protected int roleInterfaceAppearance;

	/** 被击硬直时间 */
	@ExcelCellBinding(offset = 42)
	protected float stiffTime;


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
	
	
	public int getBaseHp() {
		return this.baseHp;
	}


	public final static int getBaseHpMinLimit() {
		return 0;
	}

	public void setBaseHp(int baseHp) {
		if (baseHp < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					8, "[基础血量]baseHp的值不得小于0");
		}
		this.baseHp = baseHp;
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
	
	public float getGrowthHp() {
		return this.growthHp;
	}


	public final static float getGrowthHpMinLimit() {
		return 0;
	}

	public void setGrowthHp(float growthHp) {
		if (growthHp < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					11, "[血量成长]growthHp的值不得小于0");
		}
		this.growthHp = growthHp;
	}
	
	public float getGrowthAttack() {
		return this.growthAttack;
	}


	public final static float getGrowthAttackMinLimit() {
		return 0;
	}

	public void setGrowthAttack(float growthAttack) {
		if (growthAttack < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					12, "[攻击成长]growthAttack的值不得小于0");
		}
		this.growthAttack = growthAttack;
	}
	
	public float getGrowthDefence() {
		return this.growthDefence;
	}


	public final static float getGrowthDefenceMinLimit() {
		return 0;
	}

	public void setGrowthDefence(float growthDefence) {
		if (growthDefence < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					13, "[防御成长]growthDefence的值不得小于0");
		}
		this.growthDefence = growthDefence;
	}
	
	public int getCrit() {
		return this.crit;
	}


	public final static int getCritMinLimit() {
		return 0;
	}

	public void setCrit(int crit) {
		if (crit < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					14, "[爆击]crit的值不得小于0");
		}
		this.crit = crit;
	}
	
	public int getCritResist() {
		return this.critResist;
	}


	public final static int getCritResistMinLimit() {
		return 0;
	}

	public void setCritResist(int critResist) {
		if (critResist < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					15, "[爆击抵抗]critResist的值不得小于0");
		}
		this.critResist = critResist;
	}
	
	public int getHit() {
		return this.hit;
	}


	public final static int getHitMinLimit() {
		return 0;
	}

	public void setHit(int hit) {
		if (hit < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					16, "[命中]hit的值不得小于0");
		}
		this.hit = hit;
	}
	
	public int getDodge() {
		return this.dodge;
	}


	public final static int getDodgeMinLimit() {
		return 0;
	}

	public void setDodge(int dodge) {
		if (dodge < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					17, "[闪避]dodge的值不得小于0");
		}
		this.dodge = dodge;
	}
	
	public int getAvoidDamage() {
		return this.avoidDamage;
	}


	public final static int getAvoidDamageMinLimit() {
		return 0;
	}

	public void setAvoidDamage(int avoidDamage) {
		if (avoidDamage < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					18, "[免伤]avoidDamage的值不得小于0");
		}
		this.avoidDamage = avoidDamage;
	}
	
	public int getCritDamage() {
		return this.critDamage;
	}


	public final static int getCritDamageMinLimit() {
		return 0;
	}

	public void setCritDamage(int critDamage) {
		if (critDamage < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					19, "[暴击伤害]critDamage的值不得小于0");
		}
		this.critDamage = critDamage;
	}
	
	public int getWreckArmorDamage() {
		return this.wreckArmorDamage;
	}


	public final static int getWreckArmorDamageMinLimit() {
		return 0;
	}

	public void setWreckArmorDamage(int wreckArmorDamage) {
		if (wreckArmorDamage < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					20, "[破甲伤害]wreckArmorDamage的值不得小于0");
		}
		this.wreckArmorDamage = wreckArmorDamage;
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
	
	public int getCapEquip() {
		return this.capEquip;
	}



	public void setCapEquip(int capEquip) {
		if (capEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					22, "[帽子装备]capEquip不可以为0");
		}
		this.capEquip = capEquip;
	}
	
	public int getWeaponEquip() {
		return this.weaponEquip;
	}



	public void setWeaponEquip(int weaponEquip) {
		if (weaponEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					23, "[武器装备]weaponEquip不可以为0");
		}
		this.weaponEquip = weaponEquip;
	}
	
	public int getClothesEquip() {
		return this.clothesEquip;
	}



	public void setClothesEquip(int clothesEquip) {
		if (clothesEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					24, "[衣服装备]clothesEquip不可以为0");
		}
		this.clothesEquip = clothesEquip;
	}
	
	public int getBootsEquip() {
		return this.bootsEquip;
	}



	public void setBootsEquip(int bootsEquip) {
		if (bootsEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					25, "[鞋子装备]bootsEquip不可以为0");
		}
		this.bootsEquip = bootsEquip;
	}
	
	public int getBracersEquip() {
		return this.bracersEquip;
	}



	public void setBracersEquip(int bracersEquip) {
		if (bracersEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					26, "[护腕装备]bracersEquip不可以为0");
		}
		this.bracersEquip = bracersEquip;
	}
	
	public int getTalismanEquip() {
		return this.talismanEquip;
	}



	public void setTalismanEquip(int talismanEquip) {
		if (talismanEquip == 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					27, "[饰品装备]talismanEquip不可以为0");
		}
		this.talismanEquip = talismanEquip;
	}
	
	public int getCommonAttack() {
		return this.commonAttack;
	}


	public final static int getCommonAttackMinLimit() {
		return 0;
	}

	public void setCommonAttack(int commonAttack) {
		if (commonAttack < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					28, "[普通攻击]commonAttack的值不得小于0");
		}
		this.commonAttack = commonAttack;
	}
	
	public int getActiveSkill1() {
		return this.activeSkill1;
	}



	public void setActiveSkill1(int activeSkill1) {
		this.activeSkill1 = activeSkill1;
	}
	
	public int getActiveSkill2() {
		return this.activeSkill2;
	}



	public void setActiveSkill2(int activeSkill2) {
		this.activeSkill2 = activeSkill2;
	}
	
	public int getActiveSkill3() {
		return this.activeSkill3;
	}



	public void setActiveSkill3(int activeSkill3) {
		this.activeSkill3 = activeSkill3;
	}
	
	public int getActiveSkill4() {
		return this.activeSkill4;
	}



	public void setActiveSkill4(int activeSkill4) {
		this.activeSkill4 = activeSkill4;
	}
	
	public int getPassiveSkill1() {
		return this.passiveSkill1;
	}



	public void setPassiveSkill1(int passiveSkill1) {
		this.passiveSkill1 = passiveSkill1;
	}
	
	public int getPassiveSkill2() {
		return this.passiveSkill2;
	}



	public void setPassiveSkill2(int passiveSkill2) {
		this.passiveSkill2 = passiveSkill2;
	}
	
	public int getPassiveSkill3() {
		return this.passiveSkill3;
	}



	public void setPassiveSkill3(int passiveSkill3) {
		this.passiveSkill3 = passiveSkill3;
	}
	
	public int getCollisionLength() {
		return this.collisionLength;
	}


	public final static int getCollisionLengthMinLimit() {
		return 0;
	}

	public void setCollisionLength(int collisionLength) {
		if (collisionLength < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					36, "[碰撞块长]collisionLength的值不得小于0");
		}
		this.collisionLength = collisionLength;
	}
	
	public int getCollisionWidth() {
		return this.collisionWidth;
	}


	public final static int getCollisionWidthMinLimit() {
		return 0;
	}

	public void setCollisionWidth(int collisionWidth) {
		if (collisionWidth < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					37, "[碰撞块宽]collisionWidth的值不得小于0");
		}
		this.collisionWidth = collisionWidth;
	}
	
	public int getCollisionHeight() {
		return this.collisionHeight;
	}


	public final static int getCollisionHeightMinLimit() {
		return 0;
	}

	public void setCollisionHeight(int collisionHeight) {
		if (collisionHeight < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					38, "[碰撞块高]collisionHeight的值不得小于0");
		}
		this.collisionHeight = collisionHeight;
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
	
	public float getStiffTime() {
		return this.stiffTime;
	}



	public void setStiffTime(float stiffTime) {
		this.stiffTime = stiffTime;
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
		return "HumanTemplateVO [  vocationNameLangId=" + vocationNameLangId + ", vocationName=" + vocationName + ", sex=" + sex + ", photo=" + photo + ", head=" + head + ", baseHp=" + baseHp + ", baseAttack=" + baseAttack + ", baseDefence=" + baseDefence + ", growthHp=" + growthHp + ", growthAttack=" + growthAttack + ", growthDefence=" + growthDefence + ", crit=" + crit + ", critResist=" + critResist + ", hit=" + hit + ", dodge=" + dodge + ", avoidDamage=" + avoidDamage + ", critDamage=" + critDamage + ", wreckArmorDamage=" + wreckArmorDamage + ", moveSpeed=" + moveSpeed + ", capEquip=" + capEquip + ", weaponEquip=" + weaponEquip + ", clothesEquip=" + clothesEquip + ", bootsEquip=" + bootsEquip + ", bracersEquip=" + bracersEquip + ", talismanEquip=" + talismanEquip + ", commonAttack=" + commonAttack + ", activeSkill1=" + activeSkill1 + ", activeSkill2=" + activeSkill2 + ", activeSkill3=" + activeSkill3 + ", activeSkill4=" + activeSkill4 + ", passiveSkill1=" + passiveSkill1 + ", passiveSkill2=" + passiveSkill2 + ", passiveSkill3=" + passiveSkill3 + ", collisionLength=" + collisionLength + ", collisionWidth=" + collisionWidth + ", collisionHeight=" + collisionHeight + ", open=" + open + ", vocationDescriptionLangId=" + vocationDescriptionLangId + ", roleInterfaceSort=" + roleInterfaceSort + ", roleInterfaceAppearance=" + roleInterfaceAppearance + ", stiffTime=" + stiffTime + ",]";
	}
}