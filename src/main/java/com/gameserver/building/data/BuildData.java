package com.gameserver.building.data;
/**
 * 建筑详细数据
 * @author Administrator
 *
 */
public class BuildData {
	private int templateId;
	/** 产出的最后时间*/
	private long outPutTime;
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public long getOutPutTime() {
		return outPutTime;
	}
	public void setOutPutTime(long outPutTime) {
		this.outPutTime = outPutTime;
	}

	
	
}
