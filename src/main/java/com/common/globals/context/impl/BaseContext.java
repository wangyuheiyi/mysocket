package com.common.globals.context.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.globals.context.IContext;

public class BaseContext implements IContext{
//	private static BaseContext m_instance;
	private ApplicationContext ctx;
//	private String contextFiles;
	
	
//	public String getContextFiles() {
//		return contextFiles;
//	}
//	public void setContextFiles(String contextFiles) {
//		this.contextFiles = contextFiles;
//	}
//	public BaseContext(){
//		ctx=new ClassPathXmlApplicationContext(contextFiles);
//	}
	public BaseContext(String contextFiles){
		ctx=new ClassPathXmlApplicationContext(contextFiles);
	}
	
	
//	public static IContext getInstance() {
//		if (m_instance == null) {
//			m_instance = new BaseContext();
//		}
//		return m_instance;
//	}

	@Override
	public <T> T getBean(Class<T> classType) {
		T clazz = ctx.getBean(classType);
		return clazz;
	}
	
}
