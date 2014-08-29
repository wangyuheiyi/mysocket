package com.common.globals.server.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.context.ContextFactiry;
import com.common.globals.config.GameConfigServer;
import com.common.globals.server.IBaseServer;
@Component
public class ServerManager implements IBaseServer{
	public static ServerManager getInstance() 
	 {
	     return ContextFactiry.getContext("serverContext").getBean(ServerManager.class);
	 }
	
	@Autowired
	private DiscardServer discardServer;
	@Autowired
	private GlobalLogicRunner globalLogicRunner;
	@Autowired
	private OnLinePlayerServer onLinePlayerServer;
	@Autowired
	private SceneService sceneService;
	@Autowired
	private SystemTimeService systemTimeService;
	@Autowired
	private UuidService uUIDService;
	
	@Override
	public void init(GameConfigServer config) {
		discardServer.init(config);
		globalLogicRunner.init(config);
		onLinePlayerServer.init(config);
		sceneService.init(config);
		systemTimeService.init(config);
		uUIDService.init(config);
	}
	
	public void start(){
		try {
			sceneService.start();
			discardServer.run();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
