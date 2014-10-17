package com.gameserver.human.manager;

import org.springframework.stereotype.Component;

import com.gameserver.building.Build;
import com.gameserver.human.Human;

@Component
public class HumanBuildManager {
	private Build build;
	/** 主人 */
	private Human owner;
	
	public HumanBuildManager(){
//		this.owner=owner;
	}

	public Build getBuild() {
		return build;
	}
	
	
}
