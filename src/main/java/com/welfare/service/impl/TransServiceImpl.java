package com.welfare.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.common.Constants;
import com.welfare.model.ResponseList;
import com.welfare.model.Trans;
import com.welfare.service.TransService;
import com.welfare.util.HttpUtil;

public class TransServiceImpl implements TransService {
	
	private static final Logger logger = LoggerFactory.getLogger(TransServiceImpl.class);

	@Override
	public List<Trans> getList(int idMember, int typeTrans) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("idMember", String.valueOf(idMember));
		map.put("typeTrans", String.valueOf(typeTrans));
		
		String result = HttpUtil.get(Constants.SERVER_HOST + "/trans/selectByCardTrans", map);
		logger.debug(result);

		ResponseList<Trans> obj = (ResponseList<Trans>) JSON.parseObject(result,
				new TypeReference<ResponseList<Trans>>() {});
		return obj.getData();
	}

}
