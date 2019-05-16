package com.welfare.service;

import java.util.List;

import com.welfare.model.ResponseList;
import com.welfare.model.Trans;

public interface TransService {
	
	public List<Trans> getList(int idMember, int tranType);

}
