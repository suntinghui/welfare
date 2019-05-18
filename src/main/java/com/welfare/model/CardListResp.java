package com.welfare.model;

public class CardListResp {
	
	private String backgroundPicUrl;
	private String cardNo;
	private String cardNoIntr;
	private String cityName;
	private int id;
	private int idMember;
	private int isWxbag;
	private String jv;
	private int status;
	
	public String getBackgroundPicUrl() {
		return backgroundPicUrl;
	}
	public void setBackgroundPicUrl(String backgroundPicUrl) {
		this.backgroundPicUrl = backgroundPicUrl;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardNoIntr() {
		return cardNoIntr;
	}
	public void setCardNoIntr(String cardNoIntr) {
		this.cardNoIntr = cardNoIntr;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public int getIsWxbag() {
		return isWxbag;
	}
	public void setIsWxbag(int isWxbag) {
		this.isWxbag = isWxbag;
	}
	public String getJv() {
		return jv;
	}
	public void setJv(String jv) {
		this.jv = jv;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getStatusDesp() {
		// 状态： 3：此卡赠送中 4：此卡已赠送 5：此卡退款中 6：此卡已退卡 7：此卡冻结 8：正常
		switch(this.getStatus()) {
		case 3:
			return "此卡赠送中";
			
		case 4:
			return "此卡已赠送";
			
		case 5:
			return "此卡退款中";
			
		case 6:
			return "此卡已退卡";
			
		case 7:
			return "此卡冻结";
			
		case 8:
			return "正常";
			
			default:
				return "未知";
		}
	}	
	
	

}
