package com.gameserver.building;

import java.util.List;

import com.core.enums.IndexedEnum;
import com.core.util.EnumUtil;


/**
 * 建筑相关定义
 * @author Thinker
 *
 */
public interface BuildDef
{
	
	/**
	 * 建筑完成情况
	 * 
	 */
	public static enum BuildFinishType implements IndexedEnum 
	{
		/** 未完成 */
		UNFINISH(0),
		/** 完成*/
		FINISH(1),
		
		;
		
		private BuildFinishType(int index)
		{
			this.index = index;
		}

		public final int index;

		@Override
		public int getIndex()
		{
			return index;
		}

		private static final List<BuildFinishType> values = IndexedEnumUtil.toIndexes(BuildFinishType.values());

		public static BuildFinishType valueOf(int index)
		{
			return EnumUtil.valueOf(values, index);
		}
	}
	
	
	/**
	 * 建筑更新情况
	 * 
	 */
	public static enum BuildUpdateState implements IndexedEnum 
	{
		/** 除去 */
		SUB(0),
		/** 添加*/
		ADD(1),
		/** 完成*/
		FINISH(2),
		;
		
		private BuildUpdateState(int index)
		{
			this.index = index;
		}

		public final int index;

		@Override
		public int getIndex()
		{
			return index;
		}

		private static final List<BuildUpdateState> values = IndexedEnumUtil.toIndexes(BuildUpdateState.values());

		public static BuildUpdateState valueOf(int index)
		{
			return EnumUtil.valueOf(values, index);
		}
	}
}
