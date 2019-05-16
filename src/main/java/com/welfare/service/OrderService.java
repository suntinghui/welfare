package com.welfare.service;

import java.util.HashMap;

import com.welfare.model.ResponseObject;

public interface OrderService {
	
	/**
	 * 下单
	 * @param param
	 * @return
	 */
	public ResponseObject<String> add(HashMap<String, String> param);
	
	
	

}
