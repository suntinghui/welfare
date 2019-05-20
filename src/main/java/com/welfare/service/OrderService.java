package com.welfare.service;

import java.util.HashMap;
import java.util.List;

import com.welfare.model.OrderInfo;
import com.welfare.model.PayResp;
import com.welfare.model.ResponseObject;

public interface OrderService {
	
	/**
	 * 下单
	 * @param param
	 * @return
	 */
	public ResponseObject<PayResp> add(HashMap<String, String> param);
	
	/**
	 * 主订单列表
	 */
	public List<OrderInfo> selectListOiByIdMember();
	
	

}
