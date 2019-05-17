package com.welfare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.OrderReturn;
import com.welfare.model.ResponseObject;
import com.welfare.service.OrderReturnService;
import com.welfare.util.HttpUtil;
import com.welfare.util.MapUtil;

public class OrderReturnServiceImpl implements OrderReturnService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderReturnServiceImpl.class);

	@Override
	public ResponseObject<String> add(OrderReturn or) {
		String result = HttpUtil.post(Constants.SERVER_HOST+"/orderReturn/add", MapUtil.obj2Map(or));
		logger.debug(result);
		
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

}
