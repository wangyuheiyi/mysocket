package com.common.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一定义系统使用的slf4j的Logger
 * @author Thinker
 * 
 */
public final class Loggers
{
	/**错误级别*/
	public static final int ERROR=0;
	/**警告级别*/
	public static final int WARN=1;
	/**信息级别*/
	public static final int INFO=2;
	/**调试级别*/
	public static final int DEBUG=3;
	/**跟踪级别*/
	public static final int TRACE=4;
	
	////////////////////////////////系统级别输出日志////////////////////////////////////////////////////
	/** Server相关的日志 */
	public static final Logger serverLogger = LoggerFactory.getLogger("zsg.server");
	/** 报表日志*/
	public static final Logger reportLogger = LoggerFactory.getLogger("zsg.report");
	/** Game Server相关的日志 */
	public static final Logger gameLogger = LoggerFactory.getLogger("zsg.game");
	/** 登录相关的日志 */
	public static final Logger loginLogger = LoggerFactory.getLogger("zsg.login");
	/** 异常相关的日志 */
	public static final Logger errorLogger = LoggerFactory.getLogger("zsg.error");
	/** 数据库相关的日志 */
	public static final Logger dbLogger = LoggerFactory.getLogger("zsg.db");
	/** 消息处理相关的日志 */
	public static final Logger msgLogger = LoggerFactory.getLogger("zsg.msg");
	/** 玩家相关的日志 */
	public static final Logger playerLogger = LoggerFactory.getLogger("zsg.player");
	/** 定时器的日志 */
	public static final Logger scheduleLogger = LoggerFactory.getLogger("zsg.schedule");
	/** 充值日志 */
	public static final Logger chargeLogger = LoggerFactory.getLogger("zsg.charge");
	////////////////////////////////单独模块输出日志////////////////////////////////////////////////////
	
	
	/** 竞技场相关的日志 */
	public static final Logger arenaLogger = LoggerFactory.getLogger("zsg.arena");
	/** 副本相关的日志 */
	public static final Logger missionLogger = LoggerFactory.getLogger("zsg.mission");
	
	/** 世界boss相关的日志*/
	public static final Logger worldBossLogger = LoggerFactory.getLogger("zsg.worldBoss");
	
	/** 邮件的日志 */
	public static final Logger mailLogger = LoggerFactory.getLogger("zsg.mail");
	
	/** 排行榜的日志 */
	public static final Logger rankLogger = LoggerFactory.getLogger("zsg.rank");
	
	/** vip的日志 */
	public static final Logger vipLogger = LoggerFactory.getLogger("zsg.vip");
	
	/** 体力的日志 */
	public static final Logger vimLogger = LoggerFactory.getLogger("zsg.vim");
	
	/** 好友的日志 */
	public static final Logger relationLogger = LoggerFactory.getLogger("zsg.relation");
	
	/** 过关斩将的日志 */
	public static final Logger cutPetLogger = LoggerFactory.getLogger("zsg.cutPet");
	/** 任务相关的日志 */
	public static final Logger taskLogger = LoggerFactory.getLogger("zsg.task");
	
	/** 公共信息相关的日志 */
	public static final Logger commonRecordLogger = LoggerFactory.getLogger("zsg.commonRecord");
	/** 商城相关的日志 */
	public static final Logger mallLogger = LoggerFactory.getLogger("zsg.mall");
	/** 聊天的日志 */
	public static final Logger chatLogger = LoggerFactory.getLogger("zsg.chat");

	/** 公告相关的日志 */
	public static final Logger noticeLogger = LoggerFactory.getLogger("zsg.notice");
	/** 全服补偿的日志 */
	public static final Logger compensationLogger = LoggerFactory.getLogger("zsg.compensation");
	/** 武将附身相关的日志*/
	public static final Logger petPossessedLogger = LoggerFactory.getLogger("zsg.petPossessed");

	/** 模板相关的日志 */
	public static final Logger templateLogger = LoggerFactory.getLogger("zsg.template");
	/** GM命令相关的日志 */
	public static final Logger gmcmdLogger = LoggerFactory.getLogger("zsg.gmcmd");
	/** 物品相关的日志 */
	public static final Logger itemLogger = LoggerFactory.getLogger("zsg.item");
	/** 角色相关的日志 */
	public static final Logger humanLogger = LoggerFactory.getLogger("zsg");
	/** 场景相关的日志 */
	public static final Logger sceneLogger = LoggerFactory.getLogger("zsg.scene");
	/** 状态相关的日志 */
	public static final Logger stateLogger = LoggerFactory.getLogger("zsg.state");
	/** 数据更新的日志 */
	public static final Logger updateLogger = LoggerFactory.getLogger("zsg.update");
	/** 武将相关的日志*/
	public static final Logger petLogger = LoggerFactory.getLogger("zsg.pet");
	/** 每周登陆的日志*/
	public static final Logger weekloginLogger = LoggerFactory.getLogger("zsg.weeklogin");
	/** 武将 pvp的日志*/
	public static final Logger petpvpLogger = LoggerFactory.getLogger("zsg.petpvp");
	/** 摇钱树日志 */
	public static final Logger moneyTreeLogger = LoggerFactory.getLogger("zsg.moneyTree");
	/**珍宝阁日志*/
	public static final Logger jumboCourtLogger = LoggerFactory.getLogger("zsg.jumboCourt");
	/**马上有钱*/
	public static final Logger treasurebowlLogger = LoggerFactory.getLogger("zsg.treasurebowl");
	/**活跃度*/
	public static final Logger livenessLogger = LoggerFactory.getLogger("zsg.liveness");
	/** 技能*/
	public static final Logger skillLogger = LoggerFactory.getLogger("zsg.skill");


	public static final Logger asyncLogger = LoggerFactory.getLogger("zsg.asyncLogger");
	
	/** 运营活动相关的日志 */
	public static final Logger activityLogger = LoggerFactory.getLogger("zsg.activity");
	
	/** 运营活动相关的日志 */
	public static final Logger pointoutLogger = LoggerFactory.getLogger("zsg.pointout");

	/** 兑换码的日志*/
	public static final Logger promoLogger = LoggerFactory.getLogger("zsg.promo");
	
	/**天书日志*/
	public static final Logger godBookLogger = LoggerFactory.getLogger("zsg.godBook");

	/**无尽副本日志*/
	public static final Logger endLessMissionLogger = LoggerFactory.getLogger("zsg.endLessMission");
	/**充值返还日志*/
	public static final Logger chargeRefundLogger = LoggerFactory.getLogger("zsg.chargeRefund");

}
