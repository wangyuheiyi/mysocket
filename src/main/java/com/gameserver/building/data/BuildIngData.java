package com.gameserver.building.data;
/**
 * 正在建筑的建筑列表
 * @author Administrator
 *
 */
public class BuildIngData {
	private int templateId;
	/** 开始建筑时间*/
	private long buildStartTime;
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public long getBuildStartTime() {
		return buildStartTime;
	}
	public void setBuildStartTime(long buildStartTime) {
		this.buildStartTime = buildStartTime;
	}
	
}
