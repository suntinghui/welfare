package com.welfare.service;

import java.util.List;

import com.welfare.model.CardListResp;
import com.welfare.model.ResponseObject;
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
	public ResponseObject<String> getVerifyCode(String phone);
	
	/**
	 * 修改卡包密码
	 * @param code
	 * @param phoneNumber
	 * @param pwd
	 * @return
	 */
	public ResponseObject<String> editPackagePwd(String code, String phoneNumber, String pwd);

}
