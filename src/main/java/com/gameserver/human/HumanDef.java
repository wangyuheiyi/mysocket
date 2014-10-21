package com.gameserver.human;

import java.util.List;

import com.core.enums.IndexedEnum;
import com.core.util.EnumUtil;


/**
 * 角色相关定义
 * @author Thinker
 *
 */
public interface HumanDef
{
	
	/**
	 * 种族类型
	 * 
	 */
	public static enum AllianceType implements IndexedEnum 
	{
		/** 人类 */
		HUMAN(1),
		/** 精灵*/
		ELVES(2),
		/** 矮人 */
		DWARF(3),
		/** 亡灵 */
		UNDEAD(4),
		;
		
		private AllianceType(int index)
		{
			this.index = index;
		}

		public final int index;

		@Override
		public int getIndex()
		{
			return index;
		}

		private static final List<AllianceType> values = IndexedEnumUtil.toIndexes(AllianceType.values());

		public static AllianceType valueOf(int index)
		{
			return EnumUtil.valueOf(values, index);
		}
	}
	
}
