package com.gameserver.human;

import java.sql.Timestamp;

import com.db.model.impl.HumanEntity;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.operation.LifeCycle;
import com.gameserver.common.operation.LifeCycleImpl;
import com.gameserver.common.operation.PersistanceObject;
import com.gameserver.player.Player;
import com.gameserver.properties.RoleBaseIntProperties;

public class Human implements PersistanceObject<Long, HumanEntity>{
	/** 基础属性：整型 */
	protected final RoleBaseIntProperties baseIntProperties;
	/** 生命期 */
	private LifeCycle lifeCycle;
	/** 角色所属玩家 */
	private Player player;
	public Human(Player player) {
		baseIntProperties=new RoleBaseIntProperties();
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
	
	/** 种族 */
	private int allianceTypeId;

	/** 主背包容量 */
	private int primBagCount;
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
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.VOCATIONTYPE);
	}

	public void setVocationType(int vocationType) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.VOCATIONTYPE, vocationType);
	}

	public int getLevel() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.LEVEL);
	}

	public void setLevel(int level) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.LEVEL, level);
	}

	public int getAllianceTypeId() {
		return allianceTypeId;
	}

	public void setAllianceTypeId(int allianceTypeId) {
		this.allianceTypeId = allianceTypeId;
	}

	public int getDiamond() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.DIAMOND);
	}

	public void setDiamond(int diamond) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.DIAMOND, diamond);
	}

	public int getGold() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.GOLD);
	}

	public void setGold(int gold) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.GOLD, gold);
	}

	public int getCoupon() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.COUPON);
	}

	public void setCoupon(int coupon) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.COUPON, coupon);
	}

	public int getCurExp() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.CUR_EXP);
	}

	public void setCurExp(int curExp) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.CUR_EXP, curExp);
	}

	public int getSceneId() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.SCENE_ID);
	}

	public void setSceneId(int sceneId) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.SCENE_ID, sceneId);
	}

	public int getPrimBagCount() {
		return primBagCount;
	}

	public void setPrimBagCount(int primBagCount) {
		this.primBagCount = primBagCount;
	}

	public int getStoryId() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.STORY_ID);
	}

	public void setStoryId(int storyId) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.STORY_ID, storyId);
	}

	public int getAvatar() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.AVATAR);
	}

	public void setAvatar(int avatar) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.AVATAR, avatar);
	}
	
	public int getTemplateId() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.TEMPLATE_ID);
	}

	public void setTemplateId(int templateId) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.TEMPLATE_ID, templateId);
	}

	public int getGuideId() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.GUIDEID);
	}

	public void setGuideId(int guideId) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.GUIDEID, guideId);
	}

	public int getGuideState() {
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.GUIDESTATE);
	}

	public void setGuideState(int guideState) {
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.GUIDESTATE, guideState);
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
	
	//需要完善的属性
	public int getVim()
	{
		return 0;
	}
	
	//统帅值
	public int getControl(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.CONTROL);
	}
	
	public void setControl(int control){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.CONTROL, control);
	}
	
	//攻击力
	public int getAttack(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.ATTACK);
	}
	
	public void setAttack(int attack){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.ATTACK, attack);
	}
	
	//防御力
	public int getDefence(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.DEFENCE);
	}
	
	public void setDefence(int defence){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.DEFENCE, defence);
	}
	
	//法力
	public int getMagic(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.MAGIC);
	}
	
	public void setMagic(int magic){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.MAGIC, magic);
	}
	
	//幸运
	public int getLucky(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.LUCKY);
	}
	
	public void setLucky(int lucky){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.LUCKY, lucky);
	}
	
	//命中
	public int getHit(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.HIT);
	}
	
	public void setHit(int hit){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.HIT, hit);
	}
	
	//闪避
	public int getDodge(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.DODGE);
	}
	
	public void setDodge(int dodge){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.DODGE, dodge);
	}
	
	//免伤
	public int getAvoidDamage(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.AVOIDDAMAGE);
	}
	
	public void setAvoidDamage(int avoidDamage){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.AVOIDDAMAGE, avoidDamage);
	}
	
	//暴击
	public int getCrit(){
		return baseIntProperties.getPropertyValue(RoleBaseIntProperties.CRIT);
	}
	
	public void setCrit(int crit){
		baseIntProperties.setPropertyValue(RoleBaseIntProperties.CRIT, crit);
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

	/**
	 * 在数据加载完之后的登陆
	 * 
	 * @param isFirstLogin
	 */
	public void onLogin(boolean isFirstLogin)
	{
		
	}
	
	public void checkAfterRoleLoad()
	{
		
	}
	
	public void onInit(){
		
	}
	
	public void afterLogin()
	{
		
	}
	
	/**
	 * 重置所有属性的修改标识
	 * 
	 * @param reset
	 */
	public void resetChange()
	{
//		this.getPropertyManager().resetChanged();
//		this.finalProps.resetChanged();
		this.baseIntProperties.resetChanged();
//		this.baseStrProperties.resetChanged();
	}
}
