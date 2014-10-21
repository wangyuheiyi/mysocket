package com.gameserver.common.currencys;


import java.util.List;

import com.common.constants.LangConstants;
import com.core.enums.IndexedEnum;
import com.core.util.EnumUtil;
import com.gameserver.role.properties.RoleBaseIntProperties;

/**
 * 货币类型
 * 
 * @author Thinker
 * 
 */
public enum Currency implements IndexedEnum
{
	NULL(0, -1, 0),
	/** 钻石,  由充值所得*/
	DIAMOND(1,RoleBaseIntProperties.DIAMOND, LangConstants.CURRENCY_NAME_DIAMOND), 
	/** 金币, 游戏内获得 */
	GOLD(2,RoleBaseIntProperties.GOLD, LangConstants.CURRENCY_NAME_GOLD),
	/** 点券, 由运营发放也是钻石 */
	COUPON(3,RoleBaseIntProperties.COUPON, LangConstants.CURRENCY_NAME_COUPON), 
	/** 木材 */
	WOOD(4,RoleBaseIntProperties.WOOD, LangConstants.CURRENCY_NAME_WOOD),
	/** 石头 */
	STONE(5,RoleBaseIntProperties.STONE,LangConstants.CURRENCY_NAME_STONE),
	/** 水晶 */
	CRYSTAL(6,RoleBaseIntProperties.CRYSTAL,LangConstants.CURRENCY_NAME_CRYSTAL),
	/** 特殊资源 */
	SPECIAL(7,RoleBaseIntProperties.SPECIAL,LangConstants.CURRENCY_NAME_SPECIAL),
;

	/** 枚举的索引 */
	public final int index;
	
	/** 此货币类型在任务属性常量中的索引 @see {@link RoleBaseIntProperties} */
	private final int roleBaseIntPropIndex;
	
	/** 货币名称的key */
	private final Integer nameKey;
	
	/** 按索引顺序存放的枚举数组 */
	private static final List<Currency> indexes = IndexedEnum.IndexedEnumUtil.toIndexes(Currency.values());

	
	private Currency(int index, int roleBaseIntPropIndex, Integer nameKey) {
		this.index = index;
		this.roleBaseIntPropIndex = roleBaseIntPropIndex;
		this.nameKey = nameKey;
	}
	
	/**
	 * 获取货币索引
	 */
	@Override
	public int getIndex() {
		return index;
	}
	
	/**
	 * 取得货币的名称key
	 * 
	 * @return
	 */
	public Integer getNameKey() {
		return this.nameKey;
	}
	
	/**
	 * 获取货币的基本属性索引
	 * @return
	 */
	public int getRoleBaseIntPropIndex() {
		return roleBaseIntPropIndex;
	}

	/**
	 * 根据指定的索引获取枚举的定义
	 * 
	 * @param index
	 *            枚举的索引
	 * @return
	 */
	public static Currency valueOf(final int index) {
		return EnumUtil.valueOf(indexes, index);
	}
}
