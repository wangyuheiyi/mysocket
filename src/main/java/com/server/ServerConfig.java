package com.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
