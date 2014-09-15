package com.common.Thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.common.constants.Loggers;
import com.common.constants.SharedConstants;
import com.common.globals.server.impl.ServerManager;
import com.common.globals.server.impl.SystemTimeService;
import com.core.util.ExecutorUtil;
import com.scene.SceneRunner;

/**
 * 自定义心跳线程
 * @author Thinker
 * 
 */
public final class HeartbeatThread extends Thread 
{
	
	/** 线程池 */
	private final ExecutorService pool;
	
	/** 是否繁忙 */
	private volatile boolean isBusy;
	
	/** 地图id */
	private List<Future<Integer>> futures;
	
	/** 还在执行中没有完成的任务对应场景id的集合 */
	private Set<Integer> undoneTasks;
	
	/** 是否处于活动状态,默认为true，shutdown后变为false */
	private volatile boolean isLive = true;
	
	/**
	 * 构建心跳线程
	 * 
	 */
	public HeartbeatThread()
	{
		pool = Executors.newSingleThreadExecutor();
		futures = new ArrayList<Future<Integer>>(20);
		undoneTasks = new HashSet<Integer>();
	}
	
	@Override
	public void run()
	{
		try
		{
			long beginTime=0;
			while (isLive)
			{
				ServerManager.getInstance().getSystemTimeService().heartBeat();// 更新缓存的时间为当前系统时间
				SystemTimeService systemTimeService=ServerManager.getInstance().getSystemTimeService();
				beginTime=systemTimeService.now();
				futures.clear();
				futures.add(pool.submit(ServerManager.getInstance().getGlobalLogicRunner()));
				List<SceneRunner> sceneRunners = ServerManager.getInstance().getSceneService().getAllSceneRunners();
				for (int i = 0; i < sceneRunners.size(); i++)
				{
					SceneRunner runner = sceneRunners.get(i);
					if (!undoneTasks.contains(runner.getSceneId()))
					{
						futures.add(pool.submit(runner));
					}
				}	
				if(systemTimeService.now()-beginTime>50)
					Loggers.gameLogger.info("HeartbeatThread Run Time:"+(systemTimeService.now()-beginTime));
				
				sleep(SharedConstants.GS_HEART_BEAT_INTERVAL);
				checkUndoneTasks();
				if (undoneTasks.isEmpty())
				{
					isBusy = false;					
				} else 
				{
					isBusy = true;
					if (undoneTasks != null) 
					{
						for (int runnerId : undoneTasks)
						{
							Loggers.gameLogger.error("runnerId:" + runnerId + " is busy");
						}
					}
				}				
			}
		} catch (Exception e)
		{
			Loggers.gameLogger.error("", e);
			shutdown();
		}
	}

	/**
	 * 检查每个场景任务的状态，重新构造未完成的任务列表
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private void checkUndoneTasks() throws InterruptedException,ExecutionException
	{
		undoneTasks.clear();
		for (int i = 0; i < futures.size(); i++)
		{
			Future<Integer> future = futures.get(i);
			if (!future.isDone())
			{
				undoneTasks.add(future.get());
			}
		}
	}

	/**
	 * 调度器是否繁忙
	 * 
	 * @return
	 */
	public boolean isBusy()
	{
		return isBusy;
	}
	
	/**
	 * 关闭SceneTaskScheduler
	 */
	public void shutdown()
	{
		//关闭SceneTaskScheduler，不再向线程池中提交新的任务
		this.isLive = false;
		//等待5分钟，尽量保证已提交的任务都tick完，再关闭线程池
		ExecutorUtil.shutdownAndAwaitTermination(this.pool);
	}
}
