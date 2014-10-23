package com.gameserver.human.effector;

import org.springframework.util.Assert;

import com.core.util.KeyValuePair;
import com.gameserver.role.properties.RoleResourceIntProperties;


public class HumanProperty
{
	/** 一级属性的组成部分 */
	private final RoleResourceIntProperties[] aProperties;
	
	
	/** 经过修正后的最终一级属性 */
	private final RoleResourceIntProperties aProperty;

	
	
	public HumanProperty(int aFromTypeLength)
	{
		aProperties = new RoleResourceIntProperties[aFromTypeLength];
		aProperty = new RoleResourceIntProperties();

		for (int i = 0; i < aProperties.length; i++) {
			aProperties[i] = new RoleResourceIntProperties();
		}
	}
	
	/**
	 * 增加一级属性的修正
	 * 
	 * @param property
	 *            一级属性的修正值
	 * @param typeIndex
	 *            该修正的类型索引
	 */
	public void addAProperty(final RoleResourceIntProperties property, int typeIndex) {
		Assert.isTrue(typeIndex >= 0 && typeIndex < this.aProperties.length);
		this.aProperties[typeIndex].add(property);
		this.aProperty.add(property);
	}
	
	/**
	 * 减去一级属性的修正
	 * 
	 * @param property
	 * @param typeIndex
	 */
	public void minusAProperty(final RoleResourceIntProperties property, int typeIndex) {
		Assert.isTrue(typeIndex >= 0 && typeIndex < this.aProperties.length);
		this.aProperties[typeIndex].dec(property);
		this.aProperty.dec(property);
	}
	
	
	/**
	 * 减去指定类型的一级属性修正
	 * 
	 * @param typeIndex
	 */
	public void clearAProperty(int typeIndex) {
		Assert.isTrue(typeIndex >= 0 && typeIndex < this.aProperties.length);
		final RoleResourceIntProperties _aPre = this.aProperties[typeIndex];
		this.aProperty.dec(_aPre);
		_aPre.clear();
	}
	
	/**
	 * 更新一级属性
	 */
	public void updateAProperty() {
		this.aProperty.clear();
		for (RoleResourceIntProperties _aPre : this.aProperties) {
			this.aProperty.add(_aPre);
		}
		this.normalizeProperty(this.aProperty);
	}

	
	/**
	 * 取得指定的一级属性值
	 * 
	 * @param index
	 * @return
	 */
	public float getAProperty(final int index) {
		return this.aProperty.get(index);
	}

	/**
	 * 判定指定索引的一级属性是否改变
	 * 
	 * @param index
	 * @return
	 */
	public boolean isAPropertyChanged(int index) {
		return this.aProperty.isChanged(index);
	}
	
	/**
	 * 返回指定影响类型的一级属性的组成
	 * 
	 * @param fromTypeIndex
	 * @return
	 */
	public RoleResourceIntProperties getAPropSegment(int fromTypeIndex)
	{
		Assert.isTrue(fromTypeIndex >= 0 && fromTypeIndex < this.aProperties.length);
		return this.aProperties[fromTypeIndex];
	}

	/**
	 * 获得所有的数据对
	 * @return
	 */
	public KeyValuePair<Integer, Integer>[] getAPropValuePairs()
	{
		return this.aProperty.getIndexValuePairs();
	}
	
	

	
	/**
	 * 规范化,清除掉小于0的数
	 * 
	 * @param properties
	 */
	private void normalizeProperty(RoleResourceIntProperties properties) {
		for (int _index = properties.size() - 1; _index >= 0; _index--) {
			if (properties.get(_index) < 0) {
				properties.set(_index, 0);
			}
		}
	}
	

}
