package com.gameserver.human.effector;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gameserver.human.Human;
import com.gameserver.human.template.HumanTemplate;
import com.gameserver.role.properties.PropertyType;
import com.gameserver.role.properties.RoleBaseIntProperties;

/**
 * 主角一级属性效果器
 * @author Thinker
 *
 */
public class HumanAPropEffectorFactory
{
	/** 
	 * 初始化影响
	 */
	public static final HumanPropertyEffector<RoleBaseIntProperties, Human> INIT_EFFECTOR = new HumanPropertyEffector<RoleBaseIntProperties, Human>() 
	{
		@Override
		public void effect(RoleBaseIntProperties prop, Human human)
		{
			prop.clear();
		}
	};
	
	
	/** 
	 * 等级影响
	 */
	public static final HumanPropertyEffector<RoleBaseIntProperties, Human> LEVEL_EFFECTOR = new HumanPropertyEffector<RoleBaseIntProperties, Human>()
	{
		@Override
		public void effect(RoleBaseIntProperties prop, Human human)
		{
			prop.clear();	
//			HumanTemplate humanTempl=human.getVocationTmpl();			
//			//血量
//			float hp=humanTempl.getBaseHp()+(human.getLevel()-1)*humanTempl.getGrowthHp();
//			//攻击力
//			float attack=humanTempl.getBaseAttack()+(human.getLevel()-1)*humanTempl.getGrowthAttack();
//			//防御力
//			float defence=humanTempl.getBaseDefence()+(human.getLevel()-1)*humanTempl.getGrowthDefence();
//			
//			prop.set(PetAProperty.MAX_HP, hp);
//			prop.set(PetAProperty.ATTACK, attack);
//			prop.set(PetAProperty.DEFENCE, defence);
//			prop.set(PetAProperty.CRIT, humanTempl.getCrit());
//			prop.set(PetAProperty.CRIT_RESIST, humanTempl.getCritResist());
//			prop.set(PetAProperty.DODGE, humanTempl.getDodge());
//			prop.set(PetAProperty.HIT, humanTempl.getHit());
//			prop.set(PetAProperty.AVOID_DAMAGE, humanTempl.getAvoidDamage());
//			prop.set(PetAProperty.CRIT_DAMAGE, humanTempl.getCritDamage());
//			prop.set(PetAProperty.WRECK_ARMOR_DAMAGE, humanTempl.getWreckArmorDamage());
		}
	};

	
}
