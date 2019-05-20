package com.welfare.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.CardListResp;
import com.welfare.model.ResponseList;
import com.welfare.model.ResponseObject;
import com.welfare.model.UserInfo;
import com.welfare.service.MemberService;
import com.welfare.util.HttpUtil;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public List<CardListResp> getMemberCardListByOpenId() {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/member/selectListByOpenId/", "");
		logger.debug(result);
		ResponseList<CardListResp> obj = (ResponseList<CardListResp>) JSON.parseObject(result, new TypeReference<ResponseList<CardListResp>>() {
		});
		return obj.getData();
	}

	@Override
	public UserInfo selectByOpenId() {
		String result = HttpUtil.get(Constants.SERVER_HOST + "/member/selectByOpenId/", "");
		logger.debug(result);
		ResponseObject<UserInfo> obj = (ResponseObject<UserInfo>)JSON.parseObject(result, new TypeReference<ResponseObject<UserInfo>>() {});
		return obj.getData();
	}

	@Override
	public ResponseObject<String> getVerifyCode(String phoneNumbers) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("phoneNumbers", phoneNumbers);
		String result = HttpUtil.post(Constants.SERVER_HOST + "/member/getVerifyCode/", map);
		logger.debug(result);
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

	@Override
	public ResponseObject<String> editPackagePwd(String code, String phoneNumber, String pwd) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		map.put("phoneNumbers", phoneNumber);
		map.put("pwd", pwd );
		String result = HttpUtil.post(Constants.SERVER_HOST + "/member/editPackagePwd/", map);
		logger.debug(result);
		ResponseObject<String> obj = (ResponseObject<String>)JSON.parseObject(result, new TypeReference<ResponseObject<String>>() {});
		return obj;
	}

}
