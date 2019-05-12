package com.superway.am.mapper;

import java.util.List;

import com.superway.am.pojo.Requirement;

public interface RequirementMapper {
	
	public List<Requirement> queryAll();
	
	public int insertRequirement(Requirement req);

}
