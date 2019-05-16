package com.welfare.model;


/**
 * activeTime (string, optional): 激活时间 ,
backgroundPicUrl (string, optional): 卡面网络链接 ,
cardId (string, optional): 微信cardId ,
cardNo (string, optional): C4卡号(供应商卡号) ,
cardNoIntr (string, optional): 内部卡号 ,
code (string, optional): 微信code ,
codeC (string, optional): 渠道编号 ,
freezeCause (integer, optional),
fv (number, optional): 面值 ,
id (integer, optional): id ,
idMember (integer, optional): 用户id ,
idShop (string, optional): 卡片地区 ,
limitSize (integer, optional),
limitStart (integer, optional),
localImgUrl (string, optional): 卡面本地连接 ,
mssage (string, optional): 赠送留言 ,
oidActive (string, optional): 激活订单号（供应商） ,
orderByStr (string, optional),
orderByString (inline_model_2, optional),
page (integer, optional),
pageCount (integer, optional),
phoneFrom (string, optional): 发送人手机号 ,
phoneRcv (string, optional): 接受人手机号 ,
status (integer, optional): 卡状态 ,
statusActive (integer, optional): 家乐福卡是否已激活1：是 2：否 ,
timeActive (string, optional): 激活时间 ,
timeAdd (string, optional): 添加时间 ,
timeCreate (string, optional): 创建时间 ,
timeSend (string, optional): 转赠时间
 * @author SunTH
 *
 */
public class MemberCard {
	private String activeTime;
	private String backgroundPicUrl;
	private String cardId;
	private String cardNo;
	private String cardNoIntr;
	private String code;
	private String codeC;
	private int freezeCause;
	private double fv;
	private int id;
	private int idMember;
	private String idShop;
	private int limitSize;
	private int limitStart;
	private String localImgUrl;
	private String mssage;
	private String oidActive;
	private String orderByStr;
	private String orderByString;
	private int page;
	private int pageCount;
	private String phoneFrom;
	private String phoneRcv;
	private int status;
	private int statusActive;
	private String timeActive;
	private String timeAdd;
	private String timeCreate;
	private String timeSend;
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getBackgroundPicUrl() {
		return backgroundPicUrl;
	}
	public void setBackgroundPicUrl(String backgroundPicUrl) {
		this.backgroundPicUrl = backgroundPicUrl;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeC() {
		return codeC;
	}
	public void setCodeC(String codeC) {
		this.codeC = codeC;
	}
	public int getFreezeCause() {
		return freezeCause;
	}
	public void setFreezeCause(int freezeCause) {
		this.freezeCause = freezeCause;
	}
	public double getFv() {
		return fv;
	}
	public void setFv(double fv) {
		this.fv = fv;
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
	public String getIdShop() {
		return idShop;
	}
	public void setIdShop(String idShop) {
		this.idShop = idShop;
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
	public String getLocalImgUrl() {
		return localImgUrl;
	}
	public void setLocalImgUrl(String localImgUrl) {
		this.localImgUrl = localImgUrl;
	}
	public String getMssage() {
		return mssage;
	}
	public void setMssage(String mssage) {
		this.mssage = mssage;
	}
	public String getOidActive() {
		return oidActive;
	}
	public void setOidActive(String oidActive) {
		this.oidActive = oidActive;
	}
	public String getOrderByStr() {
		return orderByStr;
	}
	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}
	public String getOrderByString() {
		return orderByString;
	}
	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
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
	public String getPhoneFrom() {
		return phoneFrom;
	}
	public void setPhoneFrom(String phoneFrom) {
		this.phoneFrom = phoneFrom;
	}
	public String getPhoneRcv() {
		return phoneRcv;
	}
	public void setPhoneRcv(String phoneRcv) {
		this.phoneRcv = phoneRcv;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatusActive() {
		return statusActive;
	}
	public void setStatusActive(int statusActive) {
		this.statusActive = statusActive;
	}
	public String getTimeActive() {
		return timeActive;
	}
	public void setTimeActive(String timeActive) {
		this.timeActive = timeActive;
	}
	public String getTimeAdd() {
		return timeAdd;
	}
	public void setTimeAdd(String timeAdd) {
		this.timeAdd = timeAdd;
	}
	public String getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(String timeCreate) {
		this.timeCreate = timeCreate;
	}
	public String getTimeSend() {
		return timeSend;
	}
	public void setTimeSend(String timeSend) {
		this.timeSend = timeSend;
	}
	
}
