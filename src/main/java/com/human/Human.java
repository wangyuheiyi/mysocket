package com.human;

import java.sql.Timestamp;

import com.common.operation.LifeCycle;
import com.common.operation.LifeCycleImpl;
import com.common.operation.PersistanceObject;
import com.db.model.impl.HumanEntity;

public class Human implements PersistanceObject<Long, HumanEntity>{
	/** 生命期 */
	private LifeCycle lifeCycle;
	
	public Human() {
		this.lifeCycle = new LifeCycleImpl(this);
	}
	/** 是否已经在数据库中 */
	private boolean inDb;
	/** 玩家角色ID 主键 */
	private long id;
	/** 玩家账号ID */
	private long passportId;
	/** 玩家的名字  */
	private String name;
	/** 职业类型 */
	private int vocationType;
	/** 等级 */
	private int level=1;
	/** 阵营 */
	private int allianceTypeId;
	/** 玩家的战功 */
	private int exploit;
	/** 钻石 */
	private int diamond;
	/** 金币 */
	private int gold;
	/** 点券 */
	private int coupon;
	/** 当前经验 */
	private int curExp;
	/** 当前精力  */
	private int curVim;
	/** 最后回复精力的时间  */
	private long vimLastTime;
	/** 所在城镇 ID */
	private int cityId = -1;
	/** 所在场景Id */
	private int sceneId;
	/** 主背包容量 */
	private int primBagCount;
	/** 剧情ID */
	private int storyId;
	/** 角色的AvatarId */
	private int avatar;
	/** 新手引导ID */
	private int guideId;
	/** 新手引导状态 */
	private int guideState;
	/** 角色类型:0正常角色1竞技场角色其它场景角色 */
	private int roleKind;
	/** 上次登陆IP */
	private String lastLoginIp;
	/** 上次登陆时间 */
	private Timestamp lastLoginTime;
	/** 上次登出时间 */
	private Timestamp lastLogoutTime;
	/** 累计在线时长(分钟) */
	private int totalMinute;
	/** 在线状态 */
	private int onlineStatus;
	/** 空闲时间 */
	private int idleTime;
	/** 创建时间 */
	private Timestamp createTime;
	/** 是否已经被删除 */
	private int deleted;
	/** 删除日期 */
	private Timestamp deleteTime;
	
	
	@Override
	public void setDbId(Long id) {
		this.id=id;
	}

	@Override
	public Long getDbId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isInDb() {
		return this.inDb;
	}

	@Override
	public String getGUID() {
		return "human#" + this.id;
	}

	@Override
	public void setInDb(boolean inDb) {
		this.inDb = inDb;
	}

	@Override
	public long getCharId() {
		return this.id;
	}

	@Override
	public HumanEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fromEntity(HumanEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModified() {
		// TODO Auto-generated method stub
		
	}

	public LifeCycle getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}


	public long getPassportId() {
		return passportId;
	}

	public void setPassportId(long passportId) {
		this.passportId = passportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVocationType() {
		return vocationType;
	}

	public void setVocationType(int vocationType) {
		this.vocationType = vocationType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAllianceTypeId() {
		return allianceTypeId;
	}

	public void setAllianceTypeId(int allianceTypeId) {
		this.allianceTypeId = allianceTypeId;
	}

	public int getExploit() {
		return exploit;
	}

	public void setExploit(int exploit) {
		this.exploit = exploit;
	}

	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public int getCurExp() {
		return curExp;
	}

	public void setCurExp(int curExp) {
		this.curExp = curExp;
	}

	public int getCurVim() {
		return curVim;
	}

	public void setCurVim(int curVim) {
		this.curVim = curVim;
	}

	public long getVimLastTime() {
		return vimLastTime;
	}

	public void setVimLastTime(long vimLastTime) {
		this.vimLastTime = vimLastTime;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getPrimBagCount() {
		return primBagCount;
	}

	public void setPrimBagCount(int primBagCount) {
		this.primBagCount = primBagCount;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public int getGuideId() {
		return guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}

	public int getGuideState() {
		return guideState;
	}

	public void setGuideState(int guideState) {
		this.guideState = guideState;
	}

	public int getRoleKind() {
		return roleKind;
	}

	public void setRoleKind(int roleKind) {
		this.roleKind = roleKind;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getLastLogoutTime() {
		return lastLogoutTime;
	}

	public void setLastLogoutTime(Timestamp lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}

	public int getTotalMinute() {
		return totalMinute;
	}

	public void setTotalMinute(int totalMinute) {
		this.totalMinute = totalMinute;
	}

	public int getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public int getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(int idleTime) {
		this.idleTime = idleTime;
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

	
}
