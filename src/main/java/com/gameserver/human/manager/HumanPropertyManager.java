package com.gameserver.human.manager;

import com.core.util.KeyValuePair;
import com.gameserver.human.Human;
import com.gameserver.human.effector.HumanAPropFromType;
import com.gameserver.human.effector.HumanProperty;
import com.gameserver.role.properties.PropertyType;
import com.gameserver.role.properties.RoleBaseIntProperties;
import com.gameserver.role.properties.RolePropertyManager;


/**
 * 主角属性管理
 * @author Thinker
 *
 */
public class HumanPropertyManager extends RolePropertyManager<Human>
{
	
	private HumanProperty property;
	public HumanPropertyManager(Human role)
	{
		super(role,5);	
		property = new HumanProperty(HumanAPropFromType.values().length);
	}
	
	/**
	 * 获取改变
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public KeyValuePair<Integer, Integer>[] getChanged()
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

		KeyValuePair<Integer, Integer>[] valuePairs = new KeyValuePair[_length];
		int i = 0;
		if (_aPropChange)
		{
			for (KeyValuePair<Integer, Integer> valuePair : this.property.getAPropValuePairs())
			{
				valuePairs[i] = valuePair;
				valuePairs[i].setKey(PropertyType.genPropertyKey(valuePairs[i].getKey(), PropertyType.PET_PROP_A));
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
				property = this.property.getAPropSegment(fromType.index);
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
			this.property.updateAProperty();
			role.setModified();
			return true;
		}
		return false;
	}
	

	@Override
	protected boolean updateBProperty(Human role, int effectMask) 
	{
//		boolean _changed = false;
//		for (PetBPropFromType fromType : PetBPropFromType.values())
//		{
//			if ((fromType.mark & effectMask) != 0)
//			{
//				PetBProperty property = this.battleProperty.getBPropSegment(fromType.index);
//				//fromType.effector.effect(property, role);
//				if (property.isChanged()) 
//				{
//					_changed = true;
//					property.resetChanged();
//				}
//			}
//		}
//		if (_changed)
//		{
//			this.battleProperty.updateBProperty();
//			role.setModified();
//			return true;
//		}
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
