package com.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.context.ContextFactiry;
import com.templates.human.HumanTemplateSever;
@Component
public class TemplatesManager{
	public static TemplatesManager getInstance() 
	 {
	     return ContextFactiry.getContext("tempLatesContext").getBean(TemplatesManager.class);
	 }
	
	@Autowired
	private HumanTemplateSever humanTemplateServer;
	

	public HumanTemplateSever getHumanTemplateServer() {
		return humanTemplateServer;
	}
	
	
}
