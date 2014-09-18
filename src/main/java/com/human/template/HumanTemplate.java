package com.human.template;


import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelRowBinding;

/**
 * 玩家角色初始化配置模板
 * 
 * @author Thinker
 * 
 */
@ExcelRowBinding
public class HumanTemplate extends HumanTemplateVO
{
	@Override
	public void check() throws TemplateConfigException
	{
		
	}
	@Override
	public void patchUp()
	{
	
	}
}
