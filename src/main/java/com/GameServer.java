package com;

import org.springframework.beans.BeansException;

import com.common.globals.context.ContextFactiry;
import com.common.globals.server.impl.*;

public class GameServer {
	
	
	public void init(){
		ContextFactiry.getContext("serverContext").getBean(OnLinePlayerServer.class).init();
		ContextFactiry.getContext("serverContext").getBean(DiscardServer.class).init();
		ContextFactiry.getContext("serverContext").getBean(GlobalLogicRunner.class).init();
		ContextFactiry.getContext("serverContext").getBean(SystemTimeService.class).init();
		ContextFactiry.getContext("serverContext").getBean(SceneService.class).init();
	}
	
	/**
	 * 启动服务
	 */
	public void start(){
		try {
			ContextFactiry.getContext("serverContext").getBean(SceneService.class).start();
			ContextFactiry.getContext("serverContext").getBean(DiscardServer.class).run();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameServer gameServer=new GameServer();
		gameServer.init();
		gameServer.start();
	}

}
