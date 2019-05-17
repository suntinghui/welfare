package com.welfare.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.Invoice;
import com.welfare.model.ResponseObject;
import com.welfare.service.InvoiceService;
import com.welfare.util.HttpUtil;
import com.welfare.util.MapUtil;

public class InvoiceServiceImpl implements InvoiceService {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Override
	public ResponseObject<String> add(Invoice invoice) {
		String result = HttpUtil.post(Constants.SERVER_HOST+"/invoice/add", MapUtil.obj2Map(invoice));
		logger.debug(result);
		
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

}
