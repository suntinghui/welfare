package com.welfare.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.common.Constants;
import com.welfare.model.City;
import com.welfare.model.Goods;
import com.welfare.model.ResponseList;
import com.welfare.service.CityService;
import com.welfare.service.GoodsService;
import com.welfare.util.HttpUtil;

@Service
public class CityServiceImpl implements CityService {
	
	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

	@Override
	public List<City> queryAll() {
		String result = HttpUtil.get(Constants.SERVER_HOST+"/city/selectList", "");
		logger.debug(result);
		
		ResponseList<City> obj = (ResponseList<City>)JSON.parseObject(result, new TypeReference<ResponseList<City>>() {});
		return obj.getData();
	}

}
