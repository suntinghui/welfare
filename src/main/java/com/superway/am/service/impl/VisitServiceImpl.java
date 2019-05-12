package com.superway.am.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superway.am.mapper.VisitMapper;
import com.superway.am.pojo.Visit;
import com.superway.am.service.VisitService;

@Service
public class VisitServiceImpl implements VisitService {
	
	@Resource
	private VisitMapper mapper = null;

	@Override
	public List<Visit> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public int insertVisit(Visit visit) {
		return mapper.insertVisit(visit);
	}

}
