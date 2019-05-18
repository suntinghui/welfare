package com.welfare.service;

import java.util.List;

import com.welfare.model.CardListResp;
import com.welfare.model.UserInfo;

public interface MemberService {
	
	/**
	 * Openid通过header进行传递
	 * @return
	 */
	public List<CardListResp> getMemberCardListByOpenId();
	
	/**
	 * 查看用户信息
	 * @return
	 */
	public UserInfo selectByOpenId();
	
	/**
	 * 获取验证码
	 */
	public String getVerifyCode(String phone);

}
