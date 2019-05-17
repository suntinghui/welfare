package com.welfare.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.welfare.client.Constants;
import com.welfare.model.MemberCard;
import com.welfare.model.ResponseList;
import com.welfare.service.MemberService;
import com.welfare.util.HttpUtil;

public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public List<MemberCard> getMemberCardListById(int idMember) {
		String result = HttpUtil.get(Constants.SERVER_HOST+"/member/selectListByIdMember/"+idMember, "");
		logger.debug(result);
		ResponseList<MemberCard> obj = (ResponseList<MemberCard>) JSON.parseObject(result,
				new TypeReference<ResponseList<MemberCard>>() {});
		return obj.getData();
	}

}
