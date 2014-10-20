package com.gameserver.building;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

import com.common.msg.BuildBean.BuildData;
import com.common.msg.BuildBean.BuildIngData;
import com.core.helper.LLJsonHelper;
import com.core.util.StringUtils;
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
	/** 木材资源*/
	private int wood;
	/** 石头资源*/
	private int stone;
	/** 水晶资源*/
	private int crystal;
	/** 特殊资源*/
	private int special;
	/** 建筑列表*/
	private List<BuildData> buildDataList=new ArrayList<BuildData>();
	/** 正在建筑的列表*/
	private List<BuildIngData> buildIngDataList=new ArrayList<BuildIngData>();
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
		buildEntity.setWood(this.getWood());
		buildEntity.setStone(this.getStone());
		buildEntity.setCrystal(this.getCrystal());
		buildEntity.setSpecial(this.getSpecial());
		buildEntity.setBuildPack(toJsonPropBuildData());
		buildEntity.setBuildIngPack(toJsonPropBuildIngData());
		buildEntity.setCreateTime(this.getCreateTime());
		buildEntity.setDeleted(this.getDeleted());
		buildEntity.setDeleteTime(this.getDeleteTime());
		return buildEntity;
	}
	@Override
	public void fromEntity(BuildEntity entity) {
		this.setDbId(entity.getId());
		this.setCharId(entity.getCharId());
		this.setWood(entity.getWood());
		this.setStone(entity.getStone());
		this.setCrystal(entity.getCrystal());
		this.setSpecial(entity.getSpecial());
		loadJsonPropBuildData(entity.getBuildPack());
		loadJsonPropBuildIngData(entity.getBuildIngPack());
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

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getCrystal() {
		return crystal;
	}

	public void setCrystal(int crystal) {
		this.crystal = crystal;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
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

	public List<BuildData> getBuildDataList() {
		return buildDataList;
	}

	public List<BuildIngData> getBuildIngDataList() {
		return buildIngDataList;
	}
	
	
	public String toJsonPropBuildData() {
		return LLJsonHelper.getJsonStringFromCollection(this.buildDataList);
	}
	
	public String toJsonPropBuildIngData() {
		return LLJsonHelper.getJsonStringFromCollection(this.buildIngDataList);
	}

	
	public void loadJsonPropBuildData(String value) {
		if(StringUtils.isEmpty(value)) return;
		BuildData[] tempList = LLJsonHelper.getObjectArrayFromJson(value,BuildData.class);
		this.buildDataList.clear();
		for (int i = 0; i < tempList.length; i++)
		{
			this.buildDataList.add(tempList[i]);
		}
	}
	
	public void loadJsonPropBuildIngData(String value) {
		if(StringUtils.isEmpty(value)) return;
		BuildIngData[] tempList = LLJsonHelper.getObjectArrayFromJson(value,BuildIngData.class);
		this.buildIngDataList.clear();
		for (int i = 0; i < tempList.length; i++)
		{
			this.buildIngDataList.add(tempList[i]);
		}
	}
}
