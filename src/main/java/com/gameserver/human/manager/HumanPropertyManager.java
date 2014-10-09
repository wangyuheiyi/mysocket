package com.gameserver.human.manager;

import com.core.util.KeyValuePair;
import com.gameserver.human.Human;
import com.gameserver.human.effector.HumanAPropFromType;
import com.gameserver.role.properties.PetAProperty;
import com.gameserver.role.properties.PropertyType;
import com.gameserver.role.properties.RoleBaseIntProperties;
import com.gameserver.role.properties.RolePropertyManager;


/**
 * 主角属性管理
 * @author Thinker
 *
 */
public class HumanPropertyManager extends RolePropertyManager<Human,Float>
{
	
	private RoleBaseIntProperties[] property;
	public HumanPropertyManager(Human role)
	{
		super(role,5);	
		property = new RoleBaseIntProperties[HumanAPropFromType.values().length];
	}
	
	/**
	 * 获取改变
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public KeyValuePair<Integer, Float>[] getChanged()
	{
		if (propChangeSet.isEmpty())
		{
			return null;
		}
		boolean _aPropChange = propChangeSet.get(RolePropertyManager.CHANGE_INDEX_APROP);
		
		int _length = 0;
		if (_aPropChange)
		{
			_length += RoleBaseIntProperties._SIZE;
		}

		KeyValuePair<Integer, Float>[] valuePairs = new KeyValuePair[_length];
		int i = 0;
		if (_aPropChange)
		{
			for (KeyValuePair<Integer, Float> valuePair : this.battleProperty.getAPropValuePairs())
			{
				valuePairs[i] = valuePair;
				valuePairs[i].setKey(PropertyType.genPropertyKey(valuePairs[i].getKey(), PropertyType.PET_PROP_A));
				i++;
			}
		}
		
		if (_bPropChange)
		{
			for (KeyValuePair<Integer, Float> valuePair : this.battleProperty.getBPropValuePairs())
			{
				valuePairs[i] = valuePair;
				valuePairs[i].setKey(PropertyType.genPropertyKey(valuePairs[i].getKey(), PropertyType.PET_PROP_B));
				i++;
			}
		}
		return valuePairs;
	}
	
	
	@Override
	protected boolean updateAProperty(Human role, int effectMask)
	{
		boolean _changed = false;
		RoleBaseIntProperties property=null;
		for (HumanAPropFromType fromType : HumanAPropFromType.values())
		{
			if ((fromType.mark & effectMask) != 0) 
			{
				property = this.battleProperty.getAPropSegment(fromType.index);
				fromType.effector.effect(property, role);
				if (property.isChanged())
				{
					_changed = true;
					property.resetChanged();
				}
			}
		}
		if (_changed)
		{
			this.battleProperty.updateAProperty();
			role.setModified();
			return true;
		}
		return false;
	}
	

	@Override
	protected boolean updateBProperty(Human role, int effectMask) 
	{
		boolean _changed = false;
		for (PetBPropFromType fromType : PetBPropFromType.values())
		{
			if ((fromType.mark & effectMask) != 0)
			{
				PetBProperty property = this.battleProperty.getBPropSegment(fromType.index);
				//fromType.effector.effect(property, role);
				if (property.isChanged()) 
				{
					_changed = true;
					property.resetChanged();
				}
			}
		}
		if (_changed)
		{
			this.battleProperty.updateBProperty();
			role.setModified();
			return true;
		}
		return false;
	}

	@Override
	public void updateProperty(int effectMask)
	{
		if (this.updateAProperty(owner, effectMask))
		{
			propChangeSet.set(RolePropertyManager.CHANGE_INDEX_APROP);
		}
		
		if (this.updateBProperty(owner, effectMask))
		{
			propChangeSet.set(RolePropertyManager.CHANGE_INDEX_BPROP);
		}
	}
	
	
}
