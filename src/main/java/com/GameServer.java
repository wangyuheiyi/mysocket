package com;

import java.net.URL;

import org.springframework.beans.BeansException;

import com.common.context.ContextFactiry;
import com.common.globals.config.GameConfigServer;
import com.common.globals.server.impl.DiscardServer;
import com.common.globals.server.impl.GlobalLogicRunner;
import com.common.globals.server.impl.OnLinePlayerServer;
import com.common.globals.server.impl.SceneService;
import com.common.globals.server.impl.ServerManager;
import com.common.globals.server.impl.SystemTimeService;
import com.core.config.ConfigUtil;
import com.core.helper.ConfigHelper;
import com.core.template.TemplateService;

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
