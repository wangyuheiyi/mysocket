package com.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.server.globals.DiscardServer;
import com.server.globals.GlobalLogicRunner;
import com.server.globals.OnLinePlayerServer;
/**
 * server的配置类
 * @author renzhong
 *
 */
@Configuration
public class ServerConfig {
	
	/**
	 * 注册在线用户数
	 * @return
	 */
	@Bean
	public OnLinePlayerServer onLinePlayerServer(){
		return new OnLinePlayerServer(2000);
	}
	
	/**
	 * 网络传出服务
	 * @return
	 */
	@Bean
	public DiscardServer discardServer(){
		return new DiscardServer(8090);
	}
	
	
	/**
	 * 处理全局数据
	 * @return
	 */
	@Bean
	public GlobalLogicRunner globalLogicRunner(){
		return new GlobalLogicRunner();
	}
}
