package com.common.constants;

import java.util.List;

import com.core.enums.IndexedEnum;
import com.core.enums.IndexedEnum.IndexedEnumUtil;
import com.core.util.EnumUtil;


/**
 * 玩家职业类型枚举
 * 
 * @author Thinker
 * 
 */
public enum VocationTypeEnum implements IndexedEnum
{
	/** 战士 */
	MAGE(1, "战士"), 
	/** 军师 */
	POWER(2, "军师"),
	/** 弓手 */
	WIT(3, "弓手"),
	/** 双刀 */
	SPEED(4, "双刀"),
;

	private VocationTypeEnum(int index,String name)
	{
		this.index = index;
	}

	public final int index;
	
	public String name;

	@Override
	public int getIndex()
	{
		return index;
	}
	
	
	public String getName()
	{
		return name;
	}
	/**
	 * 将整数值解析为枚举对象
	 * 
	 * @param intVal
	 * @return 
	 * 
	 */
	public static VocationTypeEnum valueOf(int index)
	{
		return EnumUtil.valueOf(values, index);
	}

	private static final List<VocationTypeEnum> values = IndexedEnumUtil.toIndexes(VocationTypeEnum.values());
}
