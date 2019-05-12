package com.superway.am.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superway.am.mapper.RequirementMapper;
import com.superway.am.pojo.Requirement;
import com.superway.am.service.RequirementService;

@Service
public class RequirementServiceImpl implements RequirementService {
	
	@Resource
	private RequirementMapper mapper = null;

	@Override
	public List<Requirement> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public int insertRequirement(Requirement req) {
		return mapper.insertRequirement(req);
	}

}
