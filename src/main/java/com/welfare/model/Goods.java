package com.welfare.model;

/**
 * Goods {
brandName (string, optional): 商户名称 ,
cardId (string, optional): 微信cardId ,
cat (integer, optional): 商品类型 ,
code (string, optional): 商品编号 ,
codesC (string, optional): 渠道编号 ,
description (string, optional): 预付费卡使用说明 ,
id (integer, optional): id ,
isAlive (integer, optional): 是否上架 0： 否 1：是 ,
keywords (string, optional): 关键字 ,
limitSize (integer, optional),
limitStart (integer, optional),
name (string, optional): 卡名称 ,
notice (string, optional): 预付费卡使用提醒 ,
orderByStr (string, optional),
orderByString (inline_model_0, optional),
page (integer, optional),
pageCount (integer, optional),
phone (string, optional): 客服电话 ,
prerogative (string, optional): 预付费卡特权说明 ,
status (integer, optional): 状态 1：启用 ,
timeAdd (string, optional): 添加时间 ,
title (string, optional): 预付费卡标题 ,
urlPic (string, optional): 商品图片地址
}
 * @author SunTH
 *
 */

public class Goods {
	private String brandName;
	private String cardId;
	private int cat;
	private String code;
	private String codesC;
	private String description;
	private int id;
	private int isAlive;
	private String keywords;
	private int limitSize;
	private int limitStart;
	private String name;
	private String notice;
	private String orderByStr;
	private int page;
	private int pageCount;
	private String phone;
	private String prerogative;
	private int status;
	private String timeAdd;
	private String title;
	private String urlPic;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodesC() {
		return codesC;
	}
	public void setCodesC(String codesC) {
		this.codesC = codesC;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(int isAlive) {
		this.isAlive = isAlive;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getLimitSize() {
		return limitSize;
	}
	public void setLimitSize(int limitSize) {
		this.limitSize = limitSize;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getOrderByStr() {
		return orderByStr;
	}
	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrerogative() {
		return prerogative;
	}
	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTimeAdd() {
		return timeAdd;
	}
	public void setTimeAdd(String timeAdd) {
		this.timeAdd = timeAdd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrlPic() {
		return urlPic;
	}
	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}
	
	@Override
	public String toString() {
		return "Goods [brandName=" + brandName + ", cardId=" + cardId + ", cat=" + cat + ", code=" + code + ", codesC="
				+ codesC + ", description=" + description + ", id=" + id + ", isAlive=" + isAlive + ", keywords="
				+ keywords + ", limitSize=" + limitSize + ", limitStart=" + limitStart + ", name=" + name + ", notice="
				+ notice + ", orderByStr=" + orderByStr + ", page=" + page + ", pageCount=" + pageCount + ", phone="
				+ phone + ", prerogative=" + prerogative + ", status=" + status + ", timeAdd=" + timeAdd + ", title="
				+ title + ", urlPic=" + urlPic + "]";
	}
	
}
