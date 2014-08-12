package com.common.globals.server.impl;

import org.springframework.stereotype.Component;

import com.common.Thread.HeartbeatThread;
import com.common.constants.Loggers;
import com.common.globals.server.IBaseServer;

/**
 * 场景服务
 * @author Thinker
 */
@Component
public class SceneService implements IBaseServer{
	/** 场景心跳 */
	private HeartbeatThread sceneTaskScheduler;
	
	
	public void start()
	{
		Loggers.gameLogger.info("begin start heartBeatThread");
		sceneTaskScheduler.start();
		Loggers.gameLogger.info("end start heartBeatThread");
	}

	public void stop()
	{
		Loggers.gameLogger.info("begin stop heartBeatThread");
		sceneTaskScheduler.shutdown();
		Loggers.gameLogger.info("end stop heartBeatThread");

	}

	@Override
	public void init() {
		sceneTaskScheduler = new HeartbeatThread();
	}
}
