// Server 基本信息 
config.serverType = 1;
config.debug = 1;
config.charset = "UTF-8";
config.version = "1.0.0.1";
config.resourceVersion = "1.0.0.0";
config.dbVersion = "0.2.0.0";
config.regionId = "1";
config.localHostId = "1002";
config.serverGroupId = "2";
config.serverIndex = 1;

config.serverId = "100003";


// 如果需要让其他人连接自己的机器, 可以修改这个 IP 地址
config.bindIp = "192.168.5.156";

config.ports = "8084";
config.serverName = "zsg";
config.serverHost = "192.168.5.156";
config.serverDomain = "zsg";
config.ioProcessor = 1;
config.language = "zh_CN";
config.i18nDir = "i18n";

// Excel 资源目录
config.baseResourceDir = "../resources";
config.scriptDir = "scripts";

// 战报文件存放目录
config.battleReportRootPath = "/D:/Temp_Test/";
config.battleReportServiceType = 0;

config.dbInitType = 0;
config.dbConfigName = "game_server_hibernate.cfg.xml,game_server_hibernate_query.xml";
config.battleReportDbConfigName = "battle_report_ibatis_config.xml";

config.flashSocketPolicy = "<cross-domain-policy>\r\n<allow-access-from domain=\"*\" to-ports=\"80-65535\" />\r\n </cross-domain-policy>\r\n\0";
config.gameServerCount = 1;
config.authType = 0;

config.maxOnlineUsers = 1500;
config.openNewerGuide = true;
config.loginWallEnabled = false;

// 
// 配置 LogServer
// 
config.logConfig.logServerIp = "192.168.5.156";
config.logConfig.logServerPort = 9890;

/*
 *配置Telnet 
 */
config.telnetServerName="GameServer_telnet";
config.telnetBindIp="192.168.5.156";
config.telnetPort=7000;

// 
// 配置 Local 接口相关参数
// 
config.localReportOnlinePeriod = 300;
config.localReportStatusPeriod = 60;
config.turnOnLocalInterface = true;
config.requestDomain = "http://shanggame.com/";
config.reportDomain = "http://shanggame.com/";

config.operationCom = "shanggame";

config.chargeEnabled = true;
config.templateXorLoad = false;

config.districtPageCount = 1;
config.lastNetOnOff = true;

config.apnOpen=0;
config.apnIp="127.0.0.1";
config.apnPort=9999;

config.startServerTime="2014-07-30 01:01:01";