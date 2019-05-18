package com.welfare.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.OrderInfo;
import com.welfare.model.ResponseList;
import com.welfare.model.ResponseObject;
import com.welfare.service.OrderService;
import com.welfare.util.HttpUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public ResponseObject<String> add(HashMap<String, String> param) {
		
		String result = HttpUtil.post(Constants.SERVER_HOST+"/order/add", param);
		logger.debug(result);
		
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

	@Override
	public List<OrderInfo> selectListOiByIdMember() {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/order/selectListOiByIdMember/", "");
		logger.debug(result);
		ResponseList<OrderInfo> obj = (ResponseList<OrderInfo>) JSON.parseObject(result, new TypeReference<ResponseList<OrderInfo>>() {
		});
		return obj.getData();
	}

}
