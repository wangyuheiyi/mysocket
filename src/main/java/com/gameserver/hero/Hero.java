package com.gameserver.hero;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.util.Assert;

import com.core.util.KeyValuePair;
import com.db.model.impl.HeroEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.operation.LifeCycle;
import com.gameserver.common.operation.LifeCycleImpl;
import com.gameserver.common.operation.PersistanceObject;
import com.gameserver.hero.manager.HeroPropertyManager;
import com.gameserver.human.Human;
import com.gameserver.role.Role;
import com.gameserver.role.RoleType;
import com.gameserver.role.properties.RoleBaseIntProperties;
import com.gameserver.role.properties.RolePropertyManager;

public class Hero extends Role implements PersistanceObject<Long, HeroEntity>{
	/** 属性管理器 */
	private HeroPropertyManager propertyManager;
	/** 主人 */
	private Human owner;
	/** 生命期 */
	private LifeCycle lifeCycle;
	
	public Hero() {
		super(RoleType.HUMAN);
		propertyManager = new HeroPropertyManager(this);
		this.lifeCycle = new LifeCycleImpl(this);
	}
	
	/** 是否已经在数据库中 */
	private boolean inDb;
	/** 玩家角色ID 主键 */
	private long id;
	/** 玩家角色ID */
	private long charId;

	/** 英雄装备列表*/
	private String equipPack;
	/** 英雄魔法列表*/
	private String magicPack;
	/** 英雄率领的部队列表*/
	private String monsterPack;
	/** 创建时间 */
	private Timestamp createTime;
	/** 是否已经被删除 */
	private int deleted;
	/** 删除日期 */
	private Timestamp deleteTime;
	
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
		return id;
	}
	
	public void setCharId(long charId){
		this.charId=charId;
	}
	@Override
	public long getCharId() {
		return this.charId;
	}
	

	@Override
	public boolean isInDb() {
		return this.inDb;
	}

	@Override
	public String getGUID() {
		return "hero#" + this.id;
	}

	@Override
	public void setInDb(boolean inDb) {
		this.inDb = inDb;
	}


	public String getEquipPack() {
		return equipPack;
	}

	public void setEquipPack(String equipPack) {
		this.equipPack = equipPack;
	}

	public String getMagicPack() {
		return magicPack;
	}

	public void setMagicPack(String magicPack) {
		this.magicPack = magicPack;
	}

	public String getMonsterPack() {
		return monsterPack;
	}

	public void setMonsterPack(String monsterPack) {
		this.monsterPack = monsterPack;
	}

	
	
	/**
	 * 激活此关系
	 */
	public void active() 
	{
		getLifeCycle().activate();
	}
	
	@Override
	public HeroEntity toEntity() {
		HeroEntity heroEntity=new HeroEntity();
		heroEntity.setId(this.getDbId());
		heroEntity.setCharId(this.getCharId());
		heroEntity.setTemplateId(this.getTemplateId());
		heroEntity.setLevel(this.getLevel());
		heroEntity.setCurExp(this.getCurExp());
		heroEntity.setCreateTime(this.getCreateTime());
		heroEntity.setDeleted(this.getDeleted());
		heroEntity.setDeleteTime(this.getDeleteTime());
		return heroEntity;
	}

	@Override
	public void fromEntity(HeroEntity entity) {
		this.setDbId(entity.getId());
		this.setCharId(entity.getCharId());
		this.setTemplateId(entity.getTemplateId());
		this.setLevel(entity.getLevel());
		this.setCurExp(entity.getCurExp());
		this.setCreateTime(entity.getCreateTime());
		this.setDeleted(entity.getDeleted());
		this.setDeleteTime(entity.getDeleteTime());
		this.active();
		this.setInDb(true);
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
	
	@Override
	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	
	public int getLevel() 
	{
		return this.baseIntProperties.getPropertyValue(RoleBaseIntProperties.LEVEL);
	}

	public void setLevel(int level)
	{
		this.baseIntProperties.setPropertyValue(RoleBaseIntProperties.LEVEL,level);
		this.onModified();
	}
	
	
	/**
	 * 获取当前经验值
	 * 
	 * @return
	 */
	public int getCurExp()
	{
		return this.baseIntProperties.getPropertyValue(RoleBaseIntProperties.CUR_EXP);
	}

	/**
	 * 获取当前经验值
	 * 
	 * @param currExp
	 *            当前经验值
	 * @return
	 */
	public void setCurExp(int curExp)
	{
		this.baseIntProperties.setPropertyValue(RoleBaseIntProperties.CUR_EXP,curExp);
		this.onModified();
	}
	
	
	
	public int getTemplateId() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.TEMPLATE_ID);
	}

	public void setTemplateId(int templateId) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.TEMPLATE_ID, templateId);
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

	public int getMaxExp()
	{
		return ServerManager.getInstance().getHumanSever().getMaxExpByTempl(this.getLevel());
	}
	
	

	@Override
	public RolePropertyManager<?> getPropertyManager() {
		return propertyManager;
	}

	@Override
	protected void onModified() {
		setModified();
	}


	@Override
	public long getUUID() {
		return this.getDbId();
	}


	@Override
	public void heartBeat() 
	{
		
	}

	@Override
	protected List<KeyValuePair<Integer, Integer>> changedNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
