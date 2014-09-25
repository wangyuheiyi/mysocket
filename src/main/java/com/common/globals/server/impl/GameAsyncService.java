package com.common.globals.server.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.common.async.AsyncOperation;
import com.common.async.AsyncService;
import com.common.async.IIoOperation;
import com.common.async.SyncOperation;
import com.common.globals.config.GameConfigServer;
import com.common.globals.server.IBaseServer;
/**
 * 游戏中的异步操作服务
 * @author Administrator
 *
 */
@Component("gameAsyncService")
public class GameAsyncService implements IBaseServer,AsyncService{

	@Override
	public void init(GameConfigServer config) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public SyncOperation createSyncOperationAndExecuteAtOnce(
			IIoOperation operation) {
		SyncOperation _operation = new SyncOperation(operation);
		_operation.execute();
		return _operation;
	}


	
	@Override
	@Async
	public AsyncOperation createOperationAndExecuteAtOnce(IIoOperation operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
