package com.superway.am.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superway.am.mapper.ActualizeMapper;
import com.superway.am.mapper.VisitMapper;
import com.superway.am.pojo.Actualize;
import com.superway.am.pojo.Visit;
import com.superway.am.service.ActualizeService;
import com.superway.am.service.VisitService;

@Service
public class ActualizeServiceImpl implements ActualizeService {
	
	@Resource
	private ActualizeMapper mapper = null;

	@Override
	public List<Actualize> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public int insertActualize(Actualize actualize) {
		return mapper.insertActualize(actualize);
	}


}
