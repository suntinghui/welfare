package com.welfare.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.CardDetailRsp;
import com.welfare.model.CardGiftRsp;
import com.welfare.model.LinkDetailRsp;
import com.welfare.model.PayCodeRsp;
import com.welfare.model.ResponseObject;
import com.welfare.service.MemberCardService;
import com.welfare.util.HttpUtil;

@Service
public class MemberCardServiceImpl implements MemberCardService {

	private static final Logger logger = LoggerFactory.getLogger(MemberCardServiceImpl.class);

	@Override
	public ResponseObject<CardDetailRsp>  getCardDetail(int id) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/card/selectCardDetail/" + id, "");
		 
		ResponseObject<CardDetailRsp> obj =(ResponseObject<CardDetailRsp>)JSON.parseObject(result, new TypeReference<ResponseObject<CardDetailRsp>>() {});
		return obj;
	}

	@Override
	public ResponseObject<String> getCardActive(int id) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/card/active/" + id, "");
		logger.debug(result);
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

	@Override
	public CardGiftRsp cardGift(String cardNo, String message) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cardNo", cardNo);
		map.put("mssage", message);
		String result = HttpUtil.post(Constants.SERVER_HOST + "/card/cardGift/", map);
		logger.debug(result);
		ResponseObject<CardGiftRsp> obj = (ResponseObject<CardGiftRsp>)JSON.parseObject(result, new TypeReference<ResponseObject<CardGiftRsp>>() {});;
		return obj.getData();
	}
	
	@Override
	public String cancelCardGift(String id) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/card/cancelCardGift/" + id, "");
		logger.debug(result);
		String obj = JSON.parseObject(result, String.class);
		return obj;
	}

	@Override
	public PayCodeRsp getCardPayCode(String cardNo) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cardNo", cardNo);
		String result = HttpUtil.post(Constants.SERVER_HOST + "/card/getCardPayCode/", map);
		logger.debug(result);
		//PayCodeRsp obj = JSON.parseObject(result, PayCodeRsp.class);
		//return obj;
		
		ResponseObject<PayCodeRsp> obj = (ResponseObject<PayCodeRsp>)JSON.parseObject(result, new TypeReference<ResponseObject<PayCodeRsp>>() {});;
		return obj.getData();
	}

	@Override
	public LinkDetailRsp selectMemberCardById(String id) {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/card/selectMemberCardById/" + id, "");
		logger.debug(result);
		LinkDetailRsp obj = JSON.parseObject(result, LinkDetailRsp.class);
		return obj;
	}

	@Override
	public ResponseObject<String> receiveCard(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String result = HttpUtil.post(Constants.SERVER_HOST + "/card/receiveCard/", map);
		logger.debug(result);
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

}
