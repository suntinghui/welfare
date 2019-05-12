package com.superway.am.service;

import java.util.List;

import com.superway.am.pojo.Visit;

public interface VisitService {
	
	public List<Visit> queryAll();
	
	public int insertVisit(Visit visit);

}
