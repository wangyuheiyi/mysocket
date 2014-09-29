package com;

import java.net.URL;

import com.core.helper.ConfigHelper;
import com.gameserver.common.globals.config.GameConfigServer;
import com.gameserver.common.globals.server.impl.ServerManager;

public class GameServer {
	
	/** 服务器配置信息 */
	private GameConfigServer config;
	
	public void init(){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("my_game.cfg.js");
		config = ConfigHelper.buildConfig(GameConfigServer.class, url);
		ServerManager.getInstance().init(config);
		
	}
	
	/**
	 * 启动服务
	 */
	public void start(){
		ServerManager.getInstance().start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameServer gameServer=new GameServer();
		gameServer.init();
		gameServer.start();
		System.out.println("game server start finished");
	}

}
