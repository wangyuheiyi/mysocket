package com.gameserver.building;

import com.common.msg.BuildBean.BuildClientData;
import com.common.msg.BuildBean.BuildClientIngData;
import com.core.util.TimeUtils;
import com.gameserver.building.template.BuildTemplate;
import com.gameserver.common.globals.server.impl.ServerManager;

/**
 * 建筑逻辑类
 * @author Administrator
 *
 */
public class BuildListLogic {
	private static BuildListLogic instance = new BuildListLogic();
	public static BuildListLogic getInstance() 
	{
	     return instance;
	}
	
	/**
	 * 获取某一个建筑对象
	 * @param build
	 * @param buildTemplate
	 * @return
	 */
	public BuildClientData getBuildClientData(Build build){
		long now =ServerManager.getInstance().getSystemTimeService().now();
		//获取建筑的模板数据
		BuildTemplate buildTemplate=ServerManager.getInstance().getBuildSever().getHumanTemplById(build.getTemplateId());
		BuildClientData.Builder buildClientData=BuildClientData.newBuilder();
		//获取建筑的模板数据
		buildClientData.setBuildId(build.getDbId());
		buildClientData.setTemplateId(build.getTemplateId());
		//计算产出倒计时
		long cdtime=TimeUtils.getLongCdtime(build.getOutPutTime()+(buildTemplate.getOutputInterval()*TimeUtils.SECOND),now);
		buildClientData.setOutPutCdTime(cdtime);
		return buildClientData.build();
	}
	
	
	/**
	 * 获取某一个正在建筑的建筑对象
	 * @param build
	 * @param buildTemplate
	 * @return
	 */
	public BuildClientIngData getBuildClientIngData(Build build){
		long now =ServerManager.getInstance().getSystemTimeService().now();
		//获取建筑的模板数据
		BuildTemplate buildTemplate=ServerManager.getInstance().getBuildSever().getHumanTemplById(build.getTemplateId());
		BuildClientIngData.Builder buildClientIngData=BuildClientIngData.newBuilder();
		//获取建筑的模板数据
		buildClientIngData.setBuildId(build.getDbId());
		buildClientIngData.setTemplateId(build.getTemplateId());
		//计算产出倒计时
		long cdtime=TimeUtils.getLongCdtime(build.getBuildStartTime()+(buildTemplate.getBuildTime()*TimeUtils.SECOND),now);
		buildClientIngData.setBuildFinishCdTime(cdtime);
		return buildClientIngData.build();
	}
	
}
