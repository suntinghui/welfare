package com.superway.am.mapper;

import java.util.List;

import com.superway.am.pojo.Visit;

public interface VisitMapper {
	
	public List<Visit> queryAll();
	
	public int insertVisit(Visit visit);

}
