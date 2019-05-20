package com.welfare.service;

import java.util.HashMap;
import java.util.List;

import com.welfare.model.ResponseList;
import com.welfare.model.Trans;

public interface TransService {
	
	public List<Trans> getList(int tranType);
	
	public List<Trans> getList(HashMap<String, String> param);
	
	public Trans getDetail(int id);

}
