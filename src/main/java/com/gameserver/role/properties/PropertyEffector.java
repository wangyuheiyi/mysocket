package com.gameserver.role.properties;

import com.gameserver.role.Role;
import com.gameserver.role.properties.GenericPropertyObject;

/**
 * 主角属性效果器
 * @author Thinker
 *
 * @param <P>
 * @param <R>
 */
public interface PropertyEffector<P extends GenericPropertyObject, R extends Role>
{
	/**
	 * 计算该效应提供的属性值
	 * 
	 * @param 角色
	 * @return 返回计算后的属性值
	 */
	void effect(P property,R role);
}
