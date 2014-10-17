package com.gameserver.building.template;


import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelRowBinding;

/**
 * 建筑队列配置模板
 * 
 * @author Thinker
 * 
 */
@ExcelRowBinding
public class BuildQueueTemplate extends BuildQueueTemplateVO
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
