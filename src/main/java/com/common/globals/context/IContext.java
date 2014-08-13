package com.common.globals.context;


public interface IContext {
	public <T> T getBean(Class<T> classType);
}
