package com.superway.am.service;

import java.util.List;

import com.superway.am.pojo.Actualize;

public interface ActualizeService {
	
	public List<Actualize> queryAll();
	
	public int insertActualize(Actualize actualize);

}
