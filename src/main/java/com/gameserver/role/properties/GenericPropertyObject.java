package com.gameserver.role.properties;

import java.util.BitSet;

import com.core.util.GenericPropertyArray;
import com.core.util.KeyValuePair;


/**
 * 泛型的属性对象
 * @author Thinker
 */
public class GenericPropertyObject 
{
	protected final GenericPropertyArray props;
	protected final int propertyType;
	/** 是否可以修改 */
	protected boolean isReadOnly = false;

	public GenericPropertyObject( int size, int properType) 
	{
		this.props = new GenericPropertyArray(size);
		this.propertyType = properType;
	}

	public boolean isChanged() 
	{
		return props.isChanged();
	}

	public void resetChanged()
	{
		props.resetChanged();
	}

	
	public int size()
	{
		return props.size();
	}
	/**
	 * @see {@link GenericPropertyArray#fillChangedBit(BitSet)}
	 * @param toBitSet
	 * @return
	 */
	public boolean fillChangedBit(final BitSet toBitSet)
	{
		return props.fillChangedBit(toBitSet);
	}

	/**
	 * 设置属性值
	 * 
	 * @param index
	 * @param value
	 */
	public void setPropertyValue(int index, int value)
	{
		props.set(index, value);
	}

	/**
	 * 获取属性值
	 * 
	 * @param index
	 * @return
	 */
	public int getPropertyValue(int index) 
	{
		return props.get(index);
	}

	/**
	 * 取得被修改过的的属性索引,修正后的索引，及其对应的值
	 * 
	 * @return
	 */
	public KeyValuePair<Integer, Integer>[] getChanged()
	{
		KeyValuePair<Integer, Integer>[] changes= props.getChanged();
		for(int i=0;i<changes.length;i++)
		{
			changes[i].setKey(PropertyType.genPropertyKey(changes[i].getKey(), propertyType));
		}
		return changes;
	}
	
	public void clear()
	{
		if (!isReadOnly) 
		{
			this.props.clear();
		} else
		{
			throw new IllegalStateException("Read only");
		}
	}
	
	public KeyValuePair<Integer,Float>[] getIndexValuePairs()
	{
		return props.getIndexValuePairs();
	}
	
	/**
	 * 设定指定索引的float值
	 * 
	 * @param index
	 *            属性索引
	 * @param value
	 *            新值
	 * @return true,值被修改;false,值未修改
	 * @exception IllegalStateException
	 *                如果该对象处于只读状态
	 */
	public final void set(int index, int value)
	{
		if (!isReadOnly)
		{
			props.set(index, value);
		} else
		{
			throw new IllegalStateException("Read only");
		}
	}
}
