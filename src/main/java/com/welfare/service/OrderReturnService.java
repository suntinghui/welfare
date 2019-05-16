package com.welfare.service;

import com.welfare.model.OrderReturn;
import com.welfare.model.ResponseObject;

public interface OrderReturnService {
	
	public ResponseObject<String> add(OrderReturn or);

}
