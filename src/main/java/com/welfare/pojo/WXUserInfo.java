package com.welfare.pojo;

/**
 * https://www.cnblogs.com/mracale/p/5914575.html
 *   微信 用户信息
 * @author SunTH
 *
 */
public class WXUserInfo {
	private int subscribe;
	private String openid;
	private String nickname;
	private String sex; // 1时是男性，值为2时是女性，值为0时是未知
	private String headimgurl;
	private String unionid;
	
	
	
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	

}
