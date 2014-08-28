package com.common.globals.server.impl;

import java.io.File;

import com.common.constants.FunctionSwitches;
import com.common.constants.SharedConstants;
import com.common.globals.server.IBaseServer;
import com.core.config.ServerConfig;

/**
 * 服务器配置信息
 * 
 * 一些key/value对 获取资源的路径
 * 
 * @author Thinker
 * 
 */
public class GameConfigServer extends ServerConfig implements IBaseServer 
{
	/** 系统配置的数据库版本号 */
	private String dbVersion;
	
	/** 最大允许在线人数 */
	private volatile int maxOnlineUsers;

	/** 记录统计值开关 */
	private boolean logStatistics = true;
	
	/** Telnet服务器名称 */
	private String telnetServerName;
	/** Telnet绑定的ip */
	private String telnetBindIp;
	/** Telnet绑定的端口 */
	private String telnetPort;
	
	/** 定时向Local汇报在线人数的间隔 单位：秒 */
	private int localReportOnlinePeriod = 300;	
	/** 定时向Local汇报游戏服务器状态的间隔 单位：秒 */
	private int localReportStatusPeriod = 60;
	
	/** 认证方式, 默认平台认证 */
	private int authType = SharedConstants.AUTH_TYPE_INTERFACE;	
	/** 登陆墙是否打开，默认关闭 */
	private volatile boolean loginWallEnabled = false;
	
	/** 战报服务的类型,0 file 1 db */
	private int battleReportServiceType = 0;
	
	/** 战报数据库配置文件*/
	private String battleReportDbConfigName;
	/** 战报文件存储目录 */
	private String battleReportRootPath;
	
	/** 运营公司 */
	private String operationCom;
	
	/** 功能开关 */
	private FunctionSwitches funcSwitches = new FunctionSwitches();
	/** 开启新手引导 */
	private boolean openNewerGuide = true;
	/** 最大玩家等级 */
	private int maxHumanLevel = 140;
	/** 世界聊天所需钻石 */
	private int worldChatNeedDiamond = 2;
	/** 是否以异或方式加载模版资源 */
	private boolean templateXorLoad = true;
	/** 时区 */
	protected String timeZone = "";

	/** AppleStoreType */
	private String appleStoreType = "buy";
	/** 翻译错误的处理方式 */
	private String _translateFailAs = "error";
	
	// 登陆是否自动显示活动提示框
	// @waring 在项目启动的时候会从开关库读取数值, 在.cfg.js里和此处配的值实则无效
	private int loginShowActiveDialog = 1;



	/** 区域页面数量, 默认为 512 */
	private int _districtPageCount;
	
	/** 是否开启财务汇报功能 */
	protected boolean platformCollecterEnable = true;
	/** 是否开启财务汇报功能DEBUG版本 */
	protected boolean platformCollecterDebugEnable = false;
	/** 财务汇报地址*/
	protected String platformCollecterURL = "127.0.0.1";
	/** 财务汇报端口*/
	protected int platformCollecterPort = 1463;
	/** 财务汇报间隔 */
	protected int platformCollecterInterval = 10000;
	/** Game Id */
	protected String platformCollecterGameId = "war";
	/** Game Id */
	protected String platformCollecterPlatformId = "renren.com";
	/** 服务器名称 */
	protected String gameServerName = "";
	
	private String gameCode="1";
	
	public GameConfigServer() 
	{
		_districtPageCount = "1".equals(System.getenv("__WAR_DEVELOP_MODE__")) ? 2 : 512;
	}

	/**
	 * 取得资源文件的绝对路径
	 * 
	 * @param pathes
	 *            路径的参数,每个参数将使用路径分隔符连接起来
	 * @return
	 */
	@Override
	public String getResourceFullPath(String... pathes)
	{
		StringBuilder _sb = new StringBuilder();
		_sb.append(this.getBaseResourceDir());
		for (String _path : pathes)
		{
			_sb.append(File.separator);
			_sb.append(_path);
		}
		return _sb.toString();
	}
	

	@Override
	public void validate()
	{
		super.validate();
	}

	/**
	 * 登陆墙是否打开
	 * @return
	 */
	public boolean isLoginWallEnabled() {
		return loginWallEnabled;
	}

	/**
	 * 设置登陆墙是否打开
	 * @param loginWallEnabled
	 */
	public void setLoginWallEnabled(boolean loginWallEnabled) {
		this.loginWallEnabled = loginWallEnabled;
	}
	
	/**
	 * 获得脚本文件路径
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public String getResourceFilePath(String fileName) {
		return this.getResourceFullPath(this.getScriptDir(), fileName);
	}

	/**
	 * @return the maxOnlineUsers
	 */
	public int getMaxOnlineUsers() {
		return maxOnlineUsers;
	}

	/**
	 * @param maxOnlineUsers
	 *            the maxOnlineUsers to set
	 */
	public void setMaxOnlineUsers(int maxOnlineUsers) {
		this.maxOnlineUsers = maxOnlineUsers;
	}


	public boolean isLogStatistics() {
		return logStatistics;
	}

	public void setLogStatistics(boolean logStatistics) {
		this.logStatistics = logStatistics;
	}


	public int getLoginShowActiveDialog() {
		return loginShowActiveDialog;
	}

	public void setLoginShowActiveDialog(int loginShowActiveDialog) {
		this.loginShowActiveDialog = loginShowActiveDialog;
	}


	public String getTelnetServerName() {
		return telnetServerName;
	}

	public void setTelnetServerName(String telnetServerName) {
		this.telnetServerName = telnetServerName;
	}

	public String getTelnetBindIp() {
		return telnetBindIp;
	}

	public void setTelnetBindIp(String telnetBindIp) {
		this.telnetBindIp = telnetBindIp;
	}

	public String getTelnetPort() {
		return telnetPort;
	}

	public void setTelnetPort(String telnetPort) {
		this.telnetPort = telnetPort;
	}

	public int getLocalReportOnlinePeriod() {
		return localReportOnlinePeriod;
	}


	public void setLocalReportOnlinePeriod(int localReportOnlinePeriod) {
		this.localReportOnlinePeriod = localReportOnlinePeriod;
	}


	public int getLocalReportStatusPeriod() {
		return localReportStatusPeriod;
	}


	public void setLocalReportStatusPeriod(int localReportStatusPeriod) {
		this.localReportStatusPeriod = localReportStatusPeriod;
	}
	
	public FunctionSwitches getFuncSwitches() {
		return funcSwitches;
	}
	
	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}
	
	public int getBattleReportServiceType() {
		return battleReportServiceType;
	}
	
	public void setBattleReportServiceType(int battleReportServiceType) {
		this.battleReportServiceType = battleReportServiceType;
	}

	public String getBattleReportDbConfigName() {
		return battleReportDbConfigName;
	}
	
	public void setBattleReportDbConfigName(String battleReportDbConfigName) {
		this.battleReportDbConfigName = battleReportDbConfigName;
	}
	
	public String getBattleReportRootPath() {
		return battleReportRootPath;
	}
	
	public void setBattleReportRootPath(String battleReportRootPath) {
		this.battleReportRootPath = battleReportRootPath;
	}
	
	public boolean isBattleReportFileOutputOn()
	{
		return funcSwitches.isBattleReportFileOutput();
	}
	
	public void setBattleReportFileOutputOn(boolean value) {
		funcSwitches.setBattleReportFileOutput(value);
	}
	
	public boolean isChargeEnabled() {
		return funcSwitches.isChargeEnabled();
	}
	
	public void setChargeEnabled(boolean value) {
		funcSwitches.setChargeEnabled(value);
	}
	
	public boolean isSort() {
		return funcSwitches.isSort();
	}
	
	public void setSort(boolean sort) {
		funcSwitches.setSort(sort);
	}
	
	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}

	public String getDbVersion() {
		return dbVersion;
	}

	public boolean getOpenNewerGuide() {
		return this.openNewerGuide;
	}

	public void setOpenNewerGuide(boolean value) {
		this.openNewerGuide = value;
	}

	public int getMaxHumanLevel() {
		return this.maxHumanLevel;
	}

	public void setMaxHumanLevel(int value) {
		this.maxHumanLevel = value;
	}

	public int getWorldChatNeedDiamond() {
		return this.worldChatNeedDiamond;
	}

	public void setWorldChatNeedDiamond(int value) {
		this.worldChatNeedDiamond = value;
	}

	public String getOperationCom() {
		return operationCom;
	}

	public void setOperationCom(String operationCom) {
		this.operationCom = operationCom;
	}

	/**
	 * 使用异或方式加载模版资源 ?
	 * 
	 * @return
	 */
	public boolean isTemplateXorLoad() {
		return this.templateXorLoad;
	}

	/**
	 * 使用异或方式加载模版资源 ?
	 * 
	 * @param value
	 */
	public void setTemplateXorLoad(boolean value) {
		this.templateXorLoad = value;
	}

	/**
	 * 获取时区
	 * 
	 * @return
	 */
	public String getTimeZone() {
		return this.timeZone;
	}

	/**
	 * 设置时区
	 * 
	 * @param value
	 */
	public void setTimeZone(String value) {
		this.timeZone = value;
	}
	public String getAppleStoreType() {
		return appleStoreType;
	}

	public void setAppleStoreType(String appleStoreType) {
		this.appleStoreType = appleStoreType;
	}

	/**
	 * 获取翻译失败的处理办法
	 * 
	 * <ul>
	 * <li>ignore, 忽略翻译失败</li>
	 * <li>warning, 输出警告信息继续启动服务器</li>
	 * <li>error, 翻译错误时停止服务器启动过程</li>
	 * </ul>
	 * 
	 * @return
	 * 
	 */
	public String getTranslateFailAs() {
		return this._translateFailAs;
	}

	/**
	 * 设置翻译失败的处理办法
	 * 
	 * @param value
	 * 
	 */
	public void setTranslateFailAs(String value) {
		this._translateFailAs = value;
	}

	/**
	 * <p>获取区域页面数量, 默认为 512 页. 
	 * 如果需要手动修改默认值, 则可以在 game_server_1.cfg.js 文件中增加: </p>
	 * 
	 * <p>config.districtPageCount = N;</p>
	 * 
	 * <p><font color='#990000'>注意:</font> 
	 * game_server_1.cfg.js 文件是由 deploy_tools 部署工具生成的, 
	 * 部署工具不会生成: </p>
	 * 
	 * <p>config.districtPageCount = N;</p> 
	 * 
	 * <p>这条配置语句! 
	 * 这样做的目的是确保线上正式服务器区域页数永远为 512 页!</p>
	 * 
	 * @return
	 */
	public int getDistrictPageCount() {
		return this._districtPageCount;
	}

	/**
	 * 设置区域页面数量
	 * 
	 * @param value
	 */
	public void setDistrictPageCount(int value) {
		this._districtPageCount = value;
	}

	public boolean isPlatformCollecterEnable() {
		return platformCollecterEnable;
	}

	public void setPlatformCollecterEnable(boolean platformCollecterEnable) {
		this.platformCollecterEnable = platformCollecterEnable;
	}

	public boolean isPlatformCollecterDebugEnable() {
		return platformCollecterDebugEnable;
	}

	public void setPlatformCollecterDebugEnable(boolean platformCollecterDebugEnable) {
		this.platformCollecterDebugEnable = platformCollecterDebugEnable;
	}

	public String getPlatformCollecterURL() {
		return platformCollecterURL;
	}

	public void setPlatformCollecterURL(String platformCollecterURL) {
		this.platformCollecterURL = platformCollecterURL;
	}

	public int getPlatformCollecterPort() {
		return platformCollecterPort;
	}

	public void setPlatformCollecterPort(int platformCollecterPort) {
		this.platformCollecterPort = platformCollecterPort;
	}

	public int getPlatformCollecterInterval() {
		return platformCollecterInterval;
	}

	public void setPlatformCollecterInterval(int platformCollecterInterval) {
		this.platformCollecterInterval = platformCollecterInterval;
	}

	public String getPlatformCollecterGameId() {
		return platformCollecterGameId;
	}

	public void setPlatformCollecterGameId(String platformCollecterGameId) {
		this.platformCollecterGameId = platformCollecterGameId;
	}

	public String getPlatformCollecterPlatformId() {
		return platformCollecterPlatformId;
	}

	public void setPlatformCollecterPlatformId(String platformCollecterPlatformId) {
		this.platformCollecterPlatformId = platformCollecterPlatformId;
	}

	public String getGameServerName() {
		return gameServerName;
	}

	public void setGameServerName(String gameServerName) {
		this.gameServerName = gameServerName;
	}

	public String getGameCode() {
		return gameCode;
	}

	@Override
	public void init() {
		
	}


}
