package com.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.server.globals.DiscardServer;
import com.server.globals.GlobalLogicRunner;
import com.server.globals.OnLinePlayerServer;

public class GameServer {
	public static final ApplicationContext springctx = new ClassPathXmlApplicationContext("com/conf/serverConf.xml"); 
	
	
	public void init(){
		springctx.getBean(OnLinePlayerServer.class).init();
//		springctx.getBean(DiscardServer.class).init();
//		springctx.getBean(GlobalLogicRunner.class).init();
	}
	
	public void start(){
		try {
//			springctx.getBean(DiscardServer.class).run();
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
