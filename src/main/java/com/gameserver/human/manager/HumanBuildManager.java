package com.gameserver.human.manager;
import com.gameserver.building.Build;
import com.gameserver.human.Human;

public class HumanBuildManager {
	private Build build;
	/** 主人 */
	private Human owner;
	
	public HumanBuildManager(Human human){
		this.owner=human;
	}

	public Build getBuild() {
		return build;
	}
	
	
}
