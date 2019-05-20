package com.welfare.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.ResponseList;
import com.welfare.model.Trans;
import com.welfare.service.TransService;
import com.welfare.util.HttpUtil;

@Service
public class TransServiceImpl implements TransService {

	private static final Logger logger = LoggerFactory.getLogger(TransServiceImpl.class);

	@Override
	public List<Trans> getList(int typeTrans) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/trans/selectByCardTrans/"+typeTrans,"");
		logger.debug(result);

		ResponseList<Trans> obj = (ResponseList<Trans>) JSON.parseObject(result, new TypeReference<ResponseList<Trans>>() {
		});
		if (obj.getRespCode().equals("00")) {
			return obj.getData();
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Trans> getList(HashMap<String, String> param) {
		String result = HttpUtil.post(Constants.SERVER_HOST+"/trans/selectByCardTrans", param);
		logger.debug(result);

		ResponseList<Trans> obj = (ResponseList<Trans>) JSON.parseObject(result, new TypeReference<ResponseList<Trans>>() {
		});
		if (obj.getRespCode().equals("00"))  {
			return obj.getData();
		} else {
			return new ArrayList<>();
		}
	}

}
