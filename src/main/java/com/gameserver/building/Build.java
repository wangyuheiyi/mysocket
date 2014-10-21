package com.gameserver.building;

import java.sql.Timestamp;

import org.springframework.util.Assert;

import com.db.model.impl.BuildEntity;
import com.gameserver.common.operation.LifeCycle;
import com.gameserver.common.operation.LifeCycleImpl;
import com.gameserver.common.operation.PersistanceObject;
import com.gameserver.human.Human;

public class Build implements PersistanceObject<Long, BuildEntity>{
	/** 主人 */
	private Human owner;
	/** 生命期 */
	private final LifeCycle lifeCycle;
	/** 主键 uuid */
	private long id;
	/** 用户id */
	private long charId;
	/** 是否已经在数据库中 */
	private boolean inDb;
	/** 玩家模板id*/
	private int templateId;
	
	/** 是否建筑完成*/
	private int isFinish;
	
	/** 产出的最后时间*/
	private long outPutTime;
	/** 开始建筑时间*/
	private long buildStartTime;
	/** 创建时间 */
	private Timestamp createTime;
	/** 是否已经被删除 */
	private int deleted;
	/** 删除日期 */
	private Timestamp deleteTime;
	
	public Build() {
		this.lifeCycle = new LifeCycleImpl(this);
	}
	
	/**
	 * 设置主人
	 * 
	 * @param owner
	 * @throws IllegalArgumentException
	 *             当owner为空时抛出
	 */
	public void setOwner(Human owner) {
		Assert.notNull(owner);
		this.owner = owner;
	}
	
	public Human getOwner() {
		return this.owner;
	}
	
	@Override
	public void setDbId(Long id) {
		this.id=id;
	}
	
	@Override
	public Long getDbId() {
		return this.id;
	}
	@Override
	public boolean isInDb() {
		return this.inDb;
	}
	@Override
	public String getGUID() {
		return "Build#"+this.id;
	}
	@Override
	public void setInDb(boolean inDb) {
		this.inDb=inDb;
	}
	public void setCharId(long charId){
		this.charId=charId;
	}
	@Override
	public long getCharId() {
		return this.charId;
	}
	
	@Override
	public BuildEntity toEntity() {
		BuildEntity buildEntity=new BuildEntity();
		buildEntity.setId(this.getDbId());
		buildEntity.setCharId(this.getCharId());
		buildEntity.setTemplateId(this.getTemplateId());
		buildEntity.setIsFinish(this.getIsFinish());
		buildEntity.setOutPutTime(this.getOutPutTime());
		buildEntity.setBuildStartTime(this.getBuildStartTime());
		buildEntity.setCreateTime(this.getCreateTime());
		buildEntity.setDeleted(this.getDeleted());
		buildEntity.setDeleteTime(this.getDeleteTime());
		return buildEntity;
	}
	@Override
	public void fromEntity(BuildEntity entity) {
		this.setDbId(entity.getId());
		this.setCharId(entity.getCharId());
		this.setTemplateId(entity.getTemplateId());
		this.setIsFinish(entity.getIsFinish());
		this.setOutPutTime(entity.getOutPutTime());
		this.setBuildStartTime(entity.getBuildStartTime());
		this.setCreateTime(entity.getCreateTime());
		this.setDeleted(entity.getDeleted());
		this.setDeleteTime(entity.getDeleteTime());
		this.active();
		this.setInDb(true);
	}
	
	/**
	 * 激活此关系
	 */
	public void active() 
	{
		getLifeCycle().activate();
	}

	@Override
	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}
	
	@Override
	public void setModified() {
		if (this != null) 
		{
			// TODO 为了防止发生一些错误的使用状况,暂时把此处的检查限制得很严格
			this.lifeCycle.checkModifiable();
			if (this.lifeCycle.isActive())
			{
				// 物品的生命期处于活动状态,并且该宠物不是空的,则执行通知更新机制进行
				owner.getPlayer().getDataUpdater().addUpdate(lifeCycle);
			}
		}
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public int getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}

	public long getOutPutTime() {
		return outPutTime;
	}

	public void setOutPutTime(long outPutTime) {
		this.outPutTime = outPutTime;
	}

	public long getBuildStartTime() {
		return buildStartTime;
	}

	public void setBuildStartTime(long buildStartTime) {
		this.buildStartTime = buildStartTime;
	}

	
	
	
}
