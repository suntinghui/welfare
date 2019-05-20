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
	
	/**
	 * 检查是否设置了卡密码。
	 * @return  65:没有设置 00：已设置
	 */
	public String checkForCardPwd();
	
	/**
	 * 校验卡包密码
	 * @return 65：未设置卡包密码，请设置卡包密码 00：校验通过 64：校验不通过"
	 */
	public String verifyPwdCard(String pwd);

}
