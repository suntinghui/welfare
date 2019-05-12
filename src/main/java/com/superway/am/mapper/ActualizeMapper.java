package com.superway.am.mapper;

import java.util.List;

import com.superway.am.pojo.Actualize;

public interface ActualizeMapper {
	
	public List<Actualize> queryAll();
	
	public int insertActualize(Actualize actualize);

}
