package com.gameserver.human.template;

import java.util.Map;

import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelCellBinding;
import com.core.annotation.ExcelRowBinding;
import com.core.templates.TemplateObject;
import com.core.util.StringUtils;
import com.google.common.collect.Maps;

/**
 * 角色信息表
 * 
 * @author CodeGenerator, don't modify this file please.
 * 
 */
@ExcelRowBinding
public abstract class HumanTemplateVO extends TemplateObject {

	/** 种族名称多语言Id */
	@ExcelCellBinding(offset = 1)
	protected int vocationNameLangId;

	/** 种族名称 */
	@ExcelCellBinding(offset = 2)
	protected String vocationName;

	/** 种族 */
	@ExcelCellBinding(offset = 3)
	protected int allianceType;

	/** 标志 */
	@ExcelCellBinding(offset = 4)
	protected int logo;

	/** 旗帜 */
	@ExcelCellBinding(offset = 5)
	protected int flags;

	/** 是否开放 */
	@ExcelCellBinding(offset = 6)
	protected int open;

	/** 种族说明多语言Id */
	@ExcelCellBinding(offset = 7)
	protected int allianceDescriptionLangId;

	/** 角色界面排序 */
	@ExcelCellBinding(offset = 8)
	protected int roleInterfaceSort;

	/** 种族界面外观 */
	@ExcelCellBinding(offset = 9)
	protected int allianceAppearance;

	/** 种族技能 */
	@ExcelCellBinding(offset = 10)
	protected int allianceSkill;

	/** 特殊建筑 */
	@ExcelCellBinding(offset = 11)
	protected int specialBuilding;

	/** 特殊资源 */
	@ExcelCellBinding(offset = 12)
	protected int specialResource;


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
					3, "[种族名称]vocationName不可以为空");
		}
		this.vocationName = vocationName;
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
	
	public int getLogo() {
		return this.logo;
	}


	public final static int getLogoMinLimit() {
		return 0;
	}

	public void setLogo(int logo) {
		if (logo < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					5, "[标志]logo的值不得小于0");
		}
		this.logo = logo;
	}
	
	public int getFlags() {
		return this.flags;
	}


	public final static int getFlagsMinLimit() {
		return 0;
	}

	public void setFlags(int flags) {
		if (flags < 0) {
			throw new TemplateConfigException(this.getSheetName(), this.getId(),
					6, "[旗帜]flags的值不得小于0");
		}
		this.flags = flags;
	}
	
	public int getOpen() {
		return this.open;
	}



	public void setOpen(int open) {
		this.open = open;
	}
	
	public int getAllianceDescriptionLangId() {
		return this.allianceDescriptionLangId;
	}



	public void setAllianceDescriptionLangId(int allianceDescriptionLangId) {
		this.allianceDescriptionLangId = allianceDescriptionLangId;
	}
	
	public int getRoleInterfaceSort() {
		return this.roleInterfaceSort;
	}



	public void setRoleInterfaceSort(int roleInterfaceSort) {
		this.roleInterfaceSort = roleInterfaceSort;
	}
	
	public int getAllianceAppearance() {
		return this.allianceAppearance;
	}



	public void setAllianceAppearance(int allianceAppearance) {
		this.allianceAppearance = allianceAppearance;
	}
	
	public int getAllianceSkill() {
		return this.allianceSkill;
	}



	public void setAllianceSkill(int allianceSkill) {
		this.allianceSkill = allianceSkill;
	}
	
	public int getSpecialBuilding() {
		return this.specialBuilding;
	}



	public void setSpecialBuilding(int specialBuilding) {
		this.specialBuilding = specialBuilding;
	}
	
	public int getSpecialResource() {
		return this.specialResource;
	}



	public void setSpecialResource(int specialResource) {
		this.specialResource = specialResource;
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
		return "HumanTestTemplateVO [  vocationNameLangId=" + vocationNameLangId + ", vocationName=" + vocationName + ", allianceType=" + allianceType + ", logo=" + logo + ", flags=" + flags + ", open=" + open + ", allianceDescriptionLangId=" + allianceDescriptionLangId + ", roleInterfaceSort=" + roleInterfaceSort + ", allianceAppearance=" + allianceAppearance + ", allianceSkill=" + allianceSkill + ", specialBuilding=" + specialBuilding + ", specialResource=" + specialResource + ",]";
	}
}