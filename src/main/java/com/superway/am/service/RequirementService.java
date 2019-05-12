package com.superway.am.service;

import java.util.List;

import com.superway.am.pojo.Requirement;

public interface RequirementService {
	
	public List<Requirement> queryAll();
	
	public int insertRequirement(Requirement req);

}
