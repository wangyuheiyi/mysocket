package com.gameserver.hero.server;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.core.templates.TemplateService;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.IBaseServer;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.hero.template.HeroRecruitPoolTemplate;
import com.gameserver.hero.template.HeroRecruitTemplate;
import com.gameserver.hero.template.HeroTemplate;
/**
 * 英雄服务类
 * @author Administrator
 *
 */
@Component
public class HeroSever implements IBaseServer{

	/** 模板数据管理器 */
	private TemplateService templateService;
	private ConvertHelper convertHelper;
	@Override
	public void init(GameConfigServer config) {
		this.templateService=ServerManager.getInstance().getTemplateService();
		convertHelper=new ConvertHelper();
	}

	/**
	 * 根据Id获取英雄模板
	 * @return
	 */
	public HeroTemplate getHeroTemplById(int heroTemplId)
	{
		return this.templateService.get(heroTemplId,HeroTemplate.class);
	}
	
	/**
	 * 获取全部英雄模板
	 * @return
	 */
	public Map<Integer,HeroTemplate> getAllHeroTemplate()
	{
		return this.templateService.getAll(HeroTemplate.class);
	}
	
	/**
	 * 根据Id获取英雄招募模板
	 * @return
	 */
	public HeroRecruitTemplate getHeroRecruitTemplById(int heroRecruitTemplId)
	{
		return this.templateService.get(heroRecruitTemplId,HeroRecruitTemplate.class);
	}
	
	/**
	 * 获取全部英雄招募模板
	 * @return
	 */
	public Map<Integer,HeroRecruitTemplate> getAllHeroRecruitTemplate()
	{
		return this.templateService.getAll(HeroRecruitTemplate.class);
	}
	
	/**
	 * 根据Id获取英雄招募池模板
	 * @return
	 */
	public HeroRecruitPoolTemplate getHeroRecruitPoolTemplById(int heroRecruitPoolTemplId)
	{
		return this.templateService.get(heroRecruitPoolTemplId,HeroRecruitPoolTemplate.class);
	}
	
	/**
	 * 获取全部英雄招募池模板
	 * @return
	 */
	public Map<Integer,HeroRecruitPoolTemplate> getAllHeroRecruitPoolTemplate()
	{
		return this.templateService.getAll(HeroRecruitPoolTemplate.class);
	}
	
	
	///////////////////////////////////////数据转换辅助类///////////////////////////////////////////////
//	public HumanInfo getHumanInfo(Human human)
//	{
//		return convertHelper.HUMAN_INFO_WITH_HUMAN.convert(human);
//	}
	/**
	 * 数据转换辅助类
	 * @author Thinker
	 *
	 */
	private static final class ConvertHelper
	{
//		private final Converter<Human,HumanInfo> HUMAN_INFO_WITH_HUMAN = new AbstractConverter<Human,HumanInfo>()
//		{		
//			@Override
//			public HumanInfo convert(Human human)
//			{
//				if (human == null) return null;
//				HumanInfo.Builder humanInfo= HumanInfo.newBuilder();
//				humanInfo.setRoleId(human.getCharId());
//				humanInfo.setRoleName(human.getName());
//				humanInfo.setLevel(human.getLevel());
//				humanInfo.setAllianceTypeId(human.getAllianceTypeId());
//				humanInfo.setDiamond(human.getDiamond());
//				humanInfo.setGold(human.getGold());
//				humanInfo.setCoupon(human.getCoupon());
//				humanInfo.setCurExp(human.getCurExp());
//				humanInfo.setMaxExp(human.getMaxExp());
//				humanInfo.setStoryId(human.getStoryId());
//				humanInfo.setSceneId(human.getSceneId());
//				humanInfo.setPrimBagCount(human.getPrimBagCount());
//				humanInfo.setGuideId(human.getGuideId());
//				humanInfo.setGuideState(human.getGuideState());
//				humanInfo.setRoleKind(human.getRoleKind());
//				humanInfo.setVipLevel(human.getVipLevel());
//				return humanInfo.build();
//			}
//		};
		
		
//		private final Converter<Human,HumanInfoCacheEntity> HUMAN_WITH_CACHE =  new AbstractConverter<Human,HumanInfoCacheEntity>()
//		{
//			@Override
//			public HumanInfoCacheEntity convert(Human human)
//			{
//				if (human == null) return null;
//				HumanInfoCacheEntity cacheEntity = new HumanInfoCacheEntity();
//				cacheEntity.setId(human.getDbId());
//				cacheEntity.setPassportId(human.getPassportId());
//				cacheEntity.setName(human.getName());
//				cacheEntity.setVocationType(human.getVocationType().intVal());
//				cacheEntity.setGirlFlag(0);
//				cacheEntity.setLevel(human.getLevel());
//				cacheEntity.setCityId(human.getSceneId());
//				cacheEntity.setAvatar(human.getAvatar());
//				cacheEntity.setFihterPower(human.getFihterPower());
//				//获得上阵武将战斗力
//				Pet fromArrayPet=human.getPetManager().getPetBySlotId(1);
//				if(fromArrayPet!=null)
//				{
//					cacheEntity.setPetFihterPower(fromArrayPet.getFihterPower());
//				}
//				cacheEntity.setSkillPack(human.getSkillManager().toJsonProp());	
//				cacheEntity.setCurExp(human.getCurExp());
//				cacheEntity.setMaxHp(human.getPropertyManager().getMaxHp());
//				cacheEntity.setAttack(human.getPropertyManager().getAttack());
//				cacheEntity.setDefence(human.getPropertyManager().getDefence());
//				cacheEntity.setCrit(human.getPropertyManager().getCrit());
//				cacheEntity.setCritResist(human.getPropertyManager().getCritResist());
//				cacheEntity.setDodge(human.getPropertyManager().getDodge());
//				cacheEntity.setHit(human.getPropertyManager().getHit());
//				cacheEntity.setAvoidDamge(human.getPropertyManager().getAvoidDamage());
//				cacheEntity.setCritDamage(human.getPropertyManager().getCritDamage());
//				cacheEntity.setWreckArmorDamage(human.getPropertyManager().getWreckArmorDamage());
//				cacheEntity.setGodEquipTemplId(human.getGodEquipManager().getDefaultGodEquipId());
//				if(fromArrayPet == null)
//					cacheEntity.setFromArrayPetId(0);
//				else
//					cacheEntity.setFromArrayPetId(fromArrayPet.getUUID());
//				cacheEntity.setVipLevel(human.getVipLevel());
//				cacheEntity.setQuality(human.getQuality());
//				cacheEntity.setQualityStep(human.getQualityStep());
//				return cacheEntity;
//			}
//		};
		
		
//		private final Converter<HumanInfoData,HumanInfoCacheEntity> HUMAN_INFO_WITH_CACHE = new AbstractConverter<HumanInfoData,HumanInfoCacheEntity>()
//		{
//			@Override
//			public HumanInfoCacheEntity convert(HumanInfoData entity) 
//			{
//				if (entity == null) return null;			
//				HumanInfoCacheEntity cacheEntity = new HumanInfoCacheEntity();
//				cacheEntity.setId(entity.getRoleId());
//				cacheEntity.setName(entity.getName());
//				cacheEntity.setVocationType(entity.getVocation());
//				cacheEntity.setLevel(entity.getLevel());
//				cacheEntity.setCityId(entity.getCityId());
//				cacheEntity.setAvatar(entity.getAvatar());
//				cacheEntity.setFihterPower(entity.getFihterPower());
//				cacheEntity.setPetFihterPower(entity.getPetFihterPower());
//				cacheEntity.setSkillPack(entity.getSkillPack());
//				cacheEntity.setCurExp(entity.getCurExp());
//				cacheEntity.setMaxHp(entity.getMaxHp());
//				cacheEntity.setAttack(entity.getAttack());
//				cacheEntity.setDefence(entity.getDefence());
//				cacheEntity.setCrit(entity.getCrit());
//				cacheEntity.setCritResist(entity.getCritResist());
//				cacheEntity.setDodge(entity.getDodge());
//				cacheEntity.setHit(entity.getHit());
//				cacheEntity.setAvoidDamge(entity.getAvoidDamge());
//				cacheEntity.setCritDamage(entity.getCritDamage());
//				cacheEntity.setWreckArmorDamage(entity.getWreckArmorDamage());
//				cacheEntity.setVipLevel(entity.getVipLevel());
//				cacheEntity.setGodEquipTemplId(entity.getGodEquipTemplId());
//				cacheEntity.setQuality(entity.getQuality());
//				cacheEntity.setQualityStep(entity.getQualityStep());
//				return cacheEntity;
//			}
//			
//			@Override
//			public HumanInfoData reverseConvert(HumanInfoCacheEntity cacheEntity)
//			{
//				if (cacheEntity == null) return null;
//				HumanInfoData humanInfo = new HumanInfoData();
//				humanInfo.setRoleId(cacheEntity.getId());
//				humanInfo.setName(cacheEntity.getName());
//				humanInfo.setVocation(cacheEntity.getVocationType());
//				humanInfo.setLevel(cacheEntity.getLevel());
//				humanInfo.setCityId(cacheEntity.getCityId());
//				humanInfo.setAvatar(cacheEntity.getAvatar());
//				humanInfo.setFihterPower(cacheEntity.getFihterPower());
//				humanInfo.setPetFihterPower(cacheEntity.getPetFihterPower());
//				humanInfo.setSkillPack(cacheEntity.getSkillPack());	
//				humanInfo.setCurExp(cacheEntity.getCurExp());
//				humanInfo.setMaxExp(Globals.getTemplateService().get(cacheEntity.getLevel(),ExperienceTemplate.class).getHumanExperience());
//				humanInfo.setMaxHp(cacheEntity.getMaxHp());
//				humanInfo.setAttack(cacheEntity.getAttack());
//				humanInfo.setDefence(cacheEntity.getDefence());
//				humanInfo.setCrit(cacheEntity.getCrit());
//				humanInfo.setCritResist(cacheEntity.getCritResist());
//				humanInfo.setDodge(cacheEntity.getDodge());
//				humanInfo.setHit(cacheEntity.getHit());
//				humanInfo.setAvoidDamge(cacheEntity.getAvoidDamge());
//				humanInfo.setCritDamage(cacheEntity.getCritDamage());
//				humanInfo.setWreckArmorDamage(cacheEntity.getWreckArmorDamage());
//				humanInfo.setVipLevel(cacheEntity.getVipLevel());
//				humanInfo.setGodEquipTemplId(cacheEntity.getGodEquipTemplId());
//				humanInfo.setQuality(cacheEntity.getQuality());
//				humanInfo.setQualityStep(cacheEntity.getQualityStep());
//				return humanInfo;
//			}
//		};
		
//		/**
//		 * 离线获取human对象-供离线日志调用
//		 */
//		private final Converter<HumanEntity,Human> HUMAN_WITH_ENTITY = new AbstractConverter<HumanEntity,Human>()
//		{		
//			@Override
//			public Human convert(HumanEntity humanEntity)
//			{
//				if (humanEntity == null) return null;
//				
//				Player player=Player.newTestPlayer();
//				
//				player.setPassportId(humanEntity.getPassportId());
//				player.setPassportName(humanEntity.getName());
//				Human  human=new Human(player);
//				human.fromEntity(humanEntity);
//				player.setHuman(human);
//				
//				return human;
//			}
//		};
		
	}
}
