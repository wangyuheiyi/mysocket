package com.common.globals.server.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.common.Thread.HeartbeatThread;
import com.common.constants.Loggers;
import com.common.globals.config.GameConfigServer;
import com.common.globals.server.IBaseServer;
import com.scene.Scene;
import com.scene.SceneListener;
import com.scene.SceneRunner;
import com.scene.template.SceneTemplate;

/**
 * 场景服务
 * @author Thinker
 */
@Component
public class SceneService implements IBaseServer{
	/** 场景心跳 */
	private HeartbeatThread sceneTaskScheduler;
	
	private OnLinePlayerServer onLinePlayerServer;
	private Map<Integer, Scene> sceneMap;
	private Map<Integer, SceneRunner> sceneRunners;
	
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
	public void init(GameConfigServer config) {
		sceneMap = new ConcurrentHashMap<Integer, Scene>();
		sceneRunners = new ConcurrentHashMap<Integer, SceneRunner>();
		sceneTaskScheduler = new HeartbeatThread();
		ServerManager.getInstance();
		// 获取场景模版字典
		Map<Integer,SceneTemplate> sceneTmplMap = ServerManager.getInstance().getTemplateService().getAll(SceneTemplate.class);
		onLinePlayerServer=ServerManager.getInstance().getOnLinePlayerServer();
		// 场景事件监听
		List<SceneListener> listeners = Arrays.asList(new SceneListener[] {});
		for(SceneTemplate sceneTmpl:sceneTmplMap.values())
		{
			// 初始化场景
			this.initScene(sceneTmpl,listeners);
		}
	}
	
	private void initScene(SceneTemplate sceneTmpl,List<SceneListener> listeners)
	{
		if(sceneTmpl==null) return;
		// 创建场景对象
		Scene scene=new Scene(onLinePlayerServer,sceneTmpl);
		
		// 注册事件监听
		for(SceneListener listener : listeners) scene.registerListener(listener);
		this.addScene(scene);
	}
	
	
	/**
	 * 获取指定场景对象
	 * 
	 * @param sceneId
	 *            场景ID
	 * @return 如果不存在该ID的场景,则返回null
	 * @exception ConcurrentModificationException
	 *                如果不是该场景的线程调用该方法
	 */
	public Scene getScene(Integer sceneId)
	{
		return sceneMap.get(sceneId);
	}
	/**
	 * @warning 如果有地方同时使用了scenes和sceneRunners，需要先获得锁，
	 *          再进行操作，因为存在只更新了scenes，而没更新sceneRunners的糟糕情况，
	 *          需要保证它们更新的原子性。目前绝大多数对scenes和sceneRunners的引用
	 *          都没有考虑该问题,这是因为他们没有同时使用这两个集合。
	 * 
	 * @param scene
	 */
	private void addScene(Scene scene) 
	{
		synchronized (sceneMap)
		{
			sceneMap.put(scene.getId(), scene);
			sceneRunners.put(scene.getId(), new SceneRunner(scene));
		}
	}
	
	/**
	 * @warning 与{@link SceneService#addScene(Scene)}类似，需要确保
	 *          在同时修改scenes和sceneRunners时加锁。
	 * 
	 * @param sceneId
	 */
	public void removeScene(Integer sceneId)
	{
		synchronized (sceneMap)
		{
			sceneMap.remove(sceneId);
			sceneRunners.remove(sceneId);
		}
	}
	
	/**
	 * 线程安全的
	 * 
	 * @return
	 */
	public List<SceneRunner> getAllSceneRunners()
	{
		List<SceneRunner> runnerList = new ArrayList<SceneRunner>();
		for (SceneRunner runner : sceneRunners.values())
		{
			runnerList.add(runner);
		}
		return runnerList;
	}
}
