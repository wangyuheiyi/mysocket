package com.gameserver.hero.effector;

import com.gameserver.human.Human;
import com.gameserver.role.properties.PropertyEffector;
import com.gameserver.role.properties.RoleBattleIntProperties;
import com.gameserver.role.properties.RolePropertyManager;

/**
 * 主角一级属性效果来源类型
 * @author Thinker
 *
 */
public enum HeroAPropFromType 
{
	/** 初始化影响 */
	FROM_HUMAN_INIT(0, RolePropertyManager.PROP_FROM_MARK_INIT,HeroAPropEffectorFactory.INIT_EFFECTOR),
	/** 英雄等级影响 */
	FROM_HUMAN_LEVEL(1, RolePropertyManager.PROP_FROM_MARK_LEVEL,HeroAPropEffectorFactory.LEVEL_EFFECTOR),	
	;
	
	public final int index;
	public final int mark;
	public final PropertyEffector<RoleBattleIntProperties, Human> effector;
	
	private HeroAPropFromType(int index, int mark,PropertyEffector<RoleBattleIntProperties, Human> effector) 
	{
		this.index = index;
		this.mark = mark;
		this.effector = effector;
	}
}
