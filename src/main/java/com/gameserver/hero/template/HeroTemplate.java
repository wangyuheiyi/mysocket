package com.gameserver.hero.template;


import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelRowBinding;

/**
 * 玩家角色初始化配置模板
 * 
 * @author Thinker
 * 
 */
@ExcelRowBinding
public class HeroTemplate extends HeroTemplateVO
{
	@Override
	public void check() throws TemplateConfigException
	{
//		System.out.println("human 加载后检测");
	}
	@Override
	public void patchUp()
	{
//		System.out.println("human 加载检测");
	}
}
