package com.gameserver.role;

import java.util.List;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.HumanBean.GCRoleSymbolChangedInt;
import com.common.msg.HumanBean.KeyValueData;
import com.core.util.KeyValuePair;
import com.gameserver.human.Human;
import com.gameserver.role.properties.RoleBaseIntProperties;
import com.gameserver.role.properties.RolePropertyManager;

/**
 * 抽象角色类
 * @author Thinker
 *
 */
public abstract class Role 
{
	/** 角色类型 */
	protected short roleType;
	/** 基础属性：整型 */
	protected final RoleBaseIntProperties baseIntProperties;

	public Role(short roleType)
	{
		this.roleType = roleType;
		baseIntProperties = new RoleBaseIntProperties();
	}
	
	public void setRoleType(short roleType)
	{
		this.roleType = roleType;
	}

	public short getRoleType() 
	{
		return roleType;
	}
	
	/**
	 * 重置所有属性的修改标识
	 * 
	 * @param reset
	 */
	public void resetChange()
	{
		this.getPropertyManager().resetChanged();
//		this.finalProps.resetChanged();
		this.baseIntProperties.resetChanged();
//		this.baseStrProperties.resetChanged();
	}

	public int getLevel() 
	{
		return this.baseIntProperties.getPropertyValue(RoleBaseIntProperties.LEVEL);
	}

	public void setLevel(int level)
	{
		this.baseIntProperties.setPropertyValue(RoleBaseIntProperties.LEVEL,level);
		this.onModified();
	}

	/**
	 * 获取当前经验值
	 * 
	 * @return
	 */
	public int getCurExp()
	{
		return this.baseIntProperties.getPropertyValue(RoleBaseIntProperties.CUR_EXP);
	}

	/**
	 * 获取当前经验值
	 * 
	 * @param currExp
	 *            当前经验值
	 * @return
	 */
	public void setCurExp(int curExp)
	{
		this.baseIntProperties.setPropertyValue(RoleBaseIntProperties.CUR_EXP,curExp);
		this.onModified();
	}
	
	
	
	public RoleBaseIntProperties getBaseIntProperties()
	{
		return baseIntProperties;
	}
	
	/**
	 * 将有改动的数值数据发送到客户端
	 * 
	 * @param reset
	 *            如果reset标识为true,则会在快照完成后重置更新状态
	 */
	
	public void snapChangedProperty(boolean reset)
	{
		// 如果 LevelA,LevelB,DynamicNumProp,DynamicOtherProp 均无变化，则返回NULL
		if (!this.getPropertyManager().isChanged()
				&& !this.baseIntProperties.isChanged())
		{
			return;
		}
		// 保存数值类属性变化
		List<KeyValuePair<Integer, Integer>> _numChanged = changedNum();
		// 保存字符串类属性变化
		KeyValuePair<Integer, String>[] _strChanged = changedStr();
		
		if (_numChanged != null && !_numChanged.isEmpty())
		{
			BaseMessage.Builder myMessage=BaseMessage.newBuilder();
			GCRoleSymbolChangedInt.Builder gcRoleSymbolChangedInt=GCRoleSymbolChangedInt.newBuilder();
			gcRoleSymbolChangedInt.setType(roleType);
			gcRoleSymbolChangedInt.setRoleId(this.getUUID());
			//发送底层同步消息
			KeyValueData.Builder keyValueData =null;
			for(KeyValuePair<Integer, Integer> keyValuePair:_numChanged){
				keyValueData=KeyValueData.newBuilder();
				keyValueData.setKey(keyValuePair.getKey());
				keyValueData.setValue(keyValuePair.getValue());
				gcRoleSymbolChangedInt.addKeyValueData(keyValueData.build());
			}
			myMessage.setType(BaseMessage.Type.PLAYERMESSAGE);
			myMessage.setMessageCode(BaseMessage.MessageCode.GCROLESYMBOLCHANGEDINT);
			myMessage.setExtension(BaseBean.gcRoleSymbolChangedInt, gcRoleSymbolChangedInt.build());
			sendMessage(myMessage.build());
			
		}

		if (_strChanged != null && _strChanged.length > 0)
		{
			//sendMessage(new GCRoleSymbolChangedLong(getRoleType(), this.getUUID(), _strChanged));
		}

		if (reset)
		{
			resetChange();
		}
	}

	protected KeyValuePair<Integer, String>[] changedStr() 
	{
		// 保存字符串类属性变化
		KeyValuePair<Integer, String>[] _strChanged = null;
//		// 处理 baseStrProps
//		if (this.baseStrProperties.isChanged())
//		{
//
//			Object[] _dOtherPropsChangedValues = this.baseStrProperties
//					.getChanged(); // Object
//			int[] _indexs = (int[]) _dOtherPropsChangedValues[0];
//			Object[] _values = (Object[]) _dOtherPropsChangedValues[1];
//			_strChanged = KeyValuePair.newKeyValuePairArray(_indexs.length);
//			for (int i = 0; i < _indexs.length; i++) {
//				_strChanged[i] = new KeyValuePair<Integer, String>(PropertyType.genPropertyKey(
//						_indexs[i],PropertyType.BASE_ROLE_PROPS_STR),
//						_values[i].toString());
//			}
//		}
		return _strChanged;
	}
	
	public void heartBeat() 
	{
		
	}
	
	/**
	 * 角色的属性管理器
	 * @return
	 */
	abstract public RolePropertyManager<?> getPropertyManager();
	
	abstract public long getUUID();
	/**
	 * 当属性被修改时调用
	 */
	abstract protected void onModified();
	
	abstract protected List<KeyValuePair<Integer, Integer>> changedNum();
	
	/**
	 * 向前端发送消息
	 * 
	 * @see Human#sendMessage(GCMessage)
	 */
	protected void sendMessage(Object msg){
		
	}
}
