package com.welfare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mysql.fabric.xmlrpc.base.Array;
import com.welfare.client.Constants;
import com.welfare.model.Goods;
import com.welfare.model.GoodsSKU;
import com.welfare.model.ResponseList;
import com.welfare.service.GoodsService;
import com.welfare.util.HttpUtil;

@Service
public class GoodsServiceImpl implements GoodsService {

	private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

	@Override
	public List<Goods> selectList() {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/goods/selectList", "");
		logger.debug(result);

		ResponseList<Goods> obj = (ResponseList<Goods>) JSON.parseObject(result, new TypeReference<ResponseList<Goods>>() {
		});
		if (obj.getRespCode().equals("00")) {
			return obj.getData();
		} else {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<GoodsSKU> selectSKUById(int idGoods) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/goods/selectListByIdGoods/" + idGoods, "");
		logger.debug(result);
		ResponseList<GoodsSKU> obj = (ResponseList<GoodsSKU>) JSON.parseObject(result, new TypeReference<ResponseList<GoodsSKU>>() {
		});
		if (obj.getRespCode().equals("00")) {
			return obj.getData();
		} else {
			return new ArrayList<>();
		}
	}
}
