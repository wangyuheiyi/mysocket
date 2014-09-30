package com.gameserver.human.template;

import com.common.constants.RoleConstants;
import com.common.exception.TemplateConfigException;
import com.core.annotation.ExcelRowBinding;
import com.gameserver.common.globals.server.impl.ServerManager;

@ExcelRowBinding
public class ExperienceTemplate extends ExperienceTemplateVO
{
	@Override
	public void check() throws TemplateConfigException
	{
		if (humanExperience<=0) 
		{
			throw new TemplateConfigException(getSheetName(),getId(),"经验配置不能小于0");
		}
	}
	
	@Override
	public void patchUp()
	{
		//校验每个等级是否填写
		for(int i=0;i<RoleConstants.HUMAN_MAX_LEVEL_NUM;i++)
			checkLevelExperience(i+1);
	}
	
	/**
	 * 校验等级经验是否填写
	 * @param templateId
	 * @param pos
	 */
	private void checkLevelExperience(int level)
	{
		ExperienceTemplate expTempl=ServerManager.getInstance().getTemplateService().get(level,ExperienceTemplate.class);
		if(expTempl==null)
		{
			throw new TemplateConfigException(this.getSheetName(),getId(),String.format("经验配置表对应等级数据不存在!!!",level));
		}
	}

}
