package com.gameserver.role.properties;

import java.util.BitSet;

import com.core.annotation.Comment;
import com.core.annotation.Type;

/**
 * 角色战斗属性:符号值定义
 * 
 * @author Thinker
 * 
 */
public class RoleBattleIntProperties extends GenericPropertyObject
{
	/** 基础整型属性索引开始值 */
	public static int _BEGIN = 0;
	
	/** 基础整型属性索引结束值 */
	public static int _END = _BEGIN;
	
	/** 血量 */
	@Comment(content = "血量")
	@Type(Integer.class)
	public static final int HP = ++_END;

	/** 统帅力 */
	@Comment(content = "统帅力")
	@Type(Integer.class)
	public static final int DOMINANCE = ++_END;
	
	/** 攻击力 */
	@Comment(content = "攻击力")
	@Type(Integer.class)
	public static final int ATTACK = ++_END;

	/** 防御力 */
	@Comment(content = "防御力")
	@Type(Integer.class)
	public static final int DEFENCE = ++_END;
	
	/** 法力 */
	@Comment(content = "法力")
	@Type(Integer.class)
	public static final int MAGIC = ++_END;
	
	/**幸运 */
	@Comment(content = "幸运")
	@Type(Integer.class)
	public static final int LUCK = ++_END;
	
	/** 命中 */
	@Comment(content = "命中")
	@Type(Integer.class)
	public static final int HIT = ++_END;
	
	/** 闪避 */
	@Comment(content = "闪避")
	@Type(Integer.class)
	public static final int DODGE = ++_END;
	
	/** 免伤 */
	@Comment(content = "免伤")
	@Type(Integer.class)
	public static final int AVOIDDAMAGE = ++_END;
	
	/** 暴击 */
	@Comment(content = "暴击")
	@Type(Integer.class)
	public static final int CRIT = ++_END;
	
	/** 移动速度 */
	@Comment(content = "移动速度")
	@Type(Integer.class)
	public static final int MOVESPEED = ++_END;
	

	/** 基础整型属性的个数 */
	public static final int _SIZE = _END - _BEGIN + 1;

	public static final int TYPE = PropertyType.BASE_ROLE_PROPS_INT;

	/** 数值是否修改的副本标识 */
	private final BitSet shadowBitSet;

	public RoleBattleIntProperties() 
	{
		super(_SIZE, TYPE);
		this.shadowBitSet = new BitSet(this.size());
	}

	/**
	 * 重载{@link #resetChanged()},在重置前将props的修改记录下来
	 */
	@Override
	public void resetChanged()
	{
		this.props.fillChangedBit(this.shadowBitSet);
		super.resetChanged();
	}

	/**
	 * 是否有副本属性的修改
	 * 
	 * @return ture,有修改
	 */
	public boolean isShadowChanged()
	{
		return this.props.isChanged() || (!this.shadowBitSet.isEmpty());
	}

	/**
	 * 检查指定的副本属性索引是否有修改
	 * 
	 * @param index
	 * @return true,有修改;false,无修改
	 */
	public boolean isShadowChanged(final int index)
	{
		return this.props.isChanged(index) || this.shadowBitSet.get(index);
	}

	public void resetShadowChanged() 
	{
		this.shadowBitSet.clear();
	}

	/**
	 * 判定指定的属性索引是否有修改
	 * 
	 * @param index
	 * @return
	 */
	public boolean isChanged(int index) 
	{
		return this.props.isChanged(index);
	}

	/**
	 * 获取属性值
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public int getPropertyValue(int index)
	{
		Integer value = props.get(index);
		if (value != null)
		{
			return value;
		} else
		{
			return 0;
		}
	}
	
	/**
	 * 将指定参数中的数据加到本身对应索引中
	 * 
	 * @param src
	 * @exception IllegalArgumentException
	 *                如果src的对象类型与该类型不一致
	 * @exception IllegalStateException
	 *                如果该对象处于只读状态
	 */
	public void add(RoleBattleIntProperties src)
	{
		addBySign(src, 1);
	}
	
	/**
	 * 从本身减去将指定参数中的数据
	 * 
	 * @param src
	 * @exception IllegalArgumentException
	 *                如果src的对象类型与该类型不一致
	 * @exception IllegalStateException
	 *                如果该对象处于只读状态
	 */
	public void dec(RoleBattleIntProperties src) 
	{
		addBySign(src, -1);
	}
	
	/**
	 * 将指定索引<tt>index</tt>的属性值加<tt>value</tt>
	 * 
	 * @param index
	 * @param value
	 * @return 返回相加后的结果
	 */
	public final float add(int index, int value) 
	{
		if (!isReadOnly)
		{
			return props.add(index, value);
		} else
		{
			throw new IllegalStateException("Read only");
		}
	}
	
	/**
	 * 取得指定索引的float值
	 * 
	 * @param index
	 *            属性索引
	 * @return
	 */
	public final int get(int index) 
	{
		return props.get(index);
	}
	
	/**
	 * 为本身加上或减去将指定参数中的数据
	 * 
	 * @param src
	 * @param sign
	 *            1 or -1 (加/减)
	 * @exception IllegalArgumentException
	 *                如果src的对象类型与该类型不一致
	 * @exception IllegalStateException
	 *                如果该对象处于只读状态
	 */
	private void addBySign(RoleBattleIntProperties src, int sign)
	{
		if (src.propertyType != this.propertyType)
		{
			throw new IllegalArgumentException("Not the same property type.");
		}
		if (!isReadOnly) 
		{
			for (int i = 0; i < size(); i++)
			{
				add(i, sign * src.get(i));
			}
		} else 
		{
			throw new IllegalStateException("Read only");
		}
	}
}
