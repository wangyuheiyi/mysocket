package com.gameserver.human;

import java.sql.Timestamp;

import com.db.model.impl.HumanEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.operation.LifeCycle;
import com.gameserver.common.operation.LifeCycleImpl;
import com.gameserver.common.operation.PersistanceObject;
import com.gameserver.player.Player;

public class Human implements PersistanceObject<Long, HumanEntity>{
	/** 生命期 */
	private LifeCycle lifeCycle;
	/** 角色所属玩家 */
	private Player player;
	public Human(Player player) {
		this.player=player;
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
	/** 种族 */
	private int allianceTypeId;
	/** 钻石 */
	private int diamond;
	/** 金币 */
	private int gold;
	/** 点券 */
	private int coupon;
	/** 当前经验 */
	private int curExp;
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

	public Player getPlayer() {
		return player;
	}

	/**
	 * 激活此关系
	 */
	public void active() 
	{
		getLifeCycle().activate();
	}
	
	@Override
	public HumanEntity toEntity() {
		HumanEntity humanEntity=new HumanEntity();
		humanEntity.setId(this.getDbId());
		humanEntity.setPassportId(this.getPassportId());
		humanEntity.setName(this.getName());
		humanEntity.setVocationType(this.getVocationType());
		humanEntity.setLevel(this.getLevel());
		humanEntity.setAllianceTypeId(this.getAllianceTypeId());
		humanEntity.setDiamond(this.getDiamond());
		humanEntity.setGold(this.getGold());
		humanEntity.setCoupon(this.getCoupon());
		humanEntity.setCurExp(this.getCurExp());
		humanEntity.setSceneId(this.getSceneId());
		humanEntity.setPrimBagCount(this.getPrimBagCount());
		humanEntity.setStoryId(this.getStoryId());
		humanEntity.setAvatar(this.getAvatar());
		humanEntity.setGuideId(this.getGuideId());
		humanEntity.setGuideState(this.getGuideState());
		humanEntity.setRoleKind(this.getRoleKind());
		humanEntity.setLastLoginIp(this.getLastLoginIp());
		humanEntity.setLastLoginTime(this.getLastLoginTime());
		humanEntity.setLastLogoutTime(this.getLastLogoutTime());
		humanEntity.setCreateTime(this.getCreateTime());
		humanEntity.setDeleted(this.getDeleted());
		humanEntity.setDeleteTime(this.getDeleteTime());
		return humanEntity;
	}

	@Override
	public void fromEntity(HumanEntity entity) {
		this.setDbId(entity.getId());
		this.setPassportId(entity.getPassportId());
		this.setName(entity.getName());
		this.setVocationType(entity.getVocationType());
		this.setLevel(entity.getLevel());
		this.setAllianceTypeId(entity.getAllianceTypeId());
		this.setDiamond(entity.getDiamond());
		this.setGold(entity.getGold());
		this.setCoupon(entity.getCoupon());
		this.setCurExp(entity.getCurExp());
		this.setSceneId(entity.getSceneId());
		this.setPrimBagCount(entity.getPrimBagCount());
		this.setStoryId(entity.getStoryId());
		this.setAvatar(entity.getAvatar());
		this.setGuideId(entity.getGuideId());
		this.setGuideState(entity.getGuideState());
		this.setRoleKind(entity.getRoleKind());
		this.setLastLoginIp(entity.getLastLoginIp());
		this.setLastLoginTime(entity.getLastLoginTime());
		this.setLastLogoutTime(entity.getLastLogoutTime());
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
				this.getPlayer().getDataUpdater().addUpdate(lifeCycle);
			}
		}
	}

	public LifeCycle getLifeCycle() {
		return lifeCycle;
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
	
	//需要完善的属性
	public int getVipLevel()
	{
		return 0;
	}
	
	//统帅值
	public int getControl(){
		return 0;
	}
	
	public void setControl(int control){
		
	}
	
	//攻击力
	public int getAttack(){
		return 0;
	}
	
	public void setAttack(int attack){
	}
	
	//防御力
	public int getDefence(){
		return 0;
	}
	
	public void setDefence(int defence){
	}
	
	//法力
	public int getMagic(){
		return 0;
	}
	
	public void setMagic(int magic){
	}
	
	//幸运
	public int getLucky(){
		return 0;
	}
	
	public void setLucky(int lucky){
	}
	
	//命中
	public int getHit(){
		return 0;
	}
	
	public void setHit(int hit){
	}
	
	//闪避
	public int getDodge(){
		return 0;
	}
	
	public void setDodge(int dodge){
	}
	
	//免伤
	public int getAvoidDamage(){
		return 0;
	}
	
	public void setAvoidDamage(int avoidDamage){
	}
	
	//暴击
	public int getCrit(){
		return 0;
	}
	
	public void setCrit(int crit){
	}
	
	//速度
	public int getMoveSpeed(){
		return ServerManager.getInstance().getHumanSever().getHumanTemplByAvatar(this.getAvatar()).getMoveSpeed();
	}
		
	//主角技能
	public int getRoleSkillA(){
		return ServerManager.getInstance().getHumanSever().getHumanTemplByAvatar(this.getAvatar()).getRoleSkillA();
	}
	
	//主角技能b
	public int getSpecialBuilding(){
		return ServerManager.getInstance().getHumanSever().getHumanTemplByAvatar(this.getAvatar()).getSpecialBuilding();
	}

		
}