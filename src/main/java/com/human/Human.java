package com.human;

import com.common.operation.LifeCycle;
import com.common.operation.LifeCycleImpl;
import com.common.operation.PersistanceObject;
import com.db.model.impl.HumanEntity;

public class Human implements PersistanceObject<Long, HumanEntity>{
	/** 生命期 */
	private LifeCycle lifeCycle;
	
	public Human() {
		this.lifeCycle = new LifeCycleImpl(this);
	}
	
	
	@Override
	public void setDbId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getDbId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInDb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getGUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInDb(boolean inDb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getCharId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HumanEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fromEntity(HumanEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModified() {
		// TODO Auto-generated method stub
		
	}

}
