package com.gameserver.human.effector;

import com.gameserver.human.Human;
import com.gameserver.role.properties.RolePropertyManager;
import com.gameserver.role.properties.RoleResourceIntProperties;

/**
 * 主角一级属性效果来源类型
 * @author Thinker
 *
 */
public enum HumanAPropFromType 
{
	/** 初始化影响 */
	FROM_HUMAN_INIT(0, RolePropertyManager.PROP_FROM_MARK_INIT,HumanAPropEffectorFactory.INIT_EFFECTOR),
	/** 主角等级影响 */
	FROM_HUMAN_LEVEL(1, RolePropertyManager.PROP_FROM_MARK_LEVEL,HumanAPropEffectorFactory.LEVEL_EFFECTOR),	
	;
	
	public final int index;
	public final int mark;
	public final HumanPropertyEffector<RoleResourceIntProperties, Human> effector;
	
	private HumanAPropFromType(int index, int mark,HumanPropertyEffector<RoleResourceIntProperties, Human> effector) 
	{
		this.index = index;
		this.mark = mark;
		this.effector = effector;
	}
}
