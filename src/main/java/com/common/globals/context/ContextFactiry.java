package com.common.globals.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 所有spring上下文管理器
 * @author Administrator
 *
 */
public class ContextFactiry {
	private static final ApplicationContext springCtx=new ClassPathXmlApplicationContext("com/conf/contextConf.xml");
	/**
	 * 返回工厂服务
	 * 
	 * @return
	 */
	public static IContext getContext(String beanId) 
	{
		// 获取 Spring 上下文
		IContext ctx = (IContext)springCtx.getBean(beanId);
		if (ctx == null)
		{
			// 如果上下文为空, 直接抛出 Exception
			throw new RuntimeException("sprintContext is null");
		}
		return ctx;
	}
}
