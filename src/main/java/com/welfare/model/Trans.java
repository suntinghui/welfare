package com.welfare.model;

/**
 * Trans {
balance (number, optional): 余额 ,
cardId (string, optional): 微信cardId ,
cardNoIntr (string, optional): 内部卡号 ,
cardno (string, optional): C4卡号 ,
channel (string, optional): id ,
code (string, optional): 微信code ,
coid (string, optional): 微信订单号 ,
id (integer, optional): id ,
idMember (integer, optional): 用户id ,
jv (string, optional): 城市编号 ,
limitStart (integer, optional),
orderByStr (string, optional),
priceSale (number, optional): 消费金额 ,
recordBalance (string, optional): recordBalance ,
timeAdd (string, optional): 添加时间 ,
typeTrans (integer, optional): 流水类型
}

 * @author SunTH
 *
 */

public class Trans {
	private double balance;
	private String cardId;
	private String cardNoIntr;
	private String cardno;
	private String channel;
	private String code;
	private String coid;
	private int id;
	private int idMember;
	private String jv;
	private int limitStart;
	private String orderByStr;
	private double priceSale;
	private String recordBalance;
	private String timeAdd;
	private int typeTrans;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCardNoIntr() {
		return cardNoIntr;
	}
	public void setCardNoIntr(String cardNoIntr) {
		this.cardNoIntr = cardNoIntr;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
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
	public String getJv() {
		return jv;
	}
	public void setJv(String jv) {
		this.jv = jv;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public String getOrderByStr() {
		return orderByStr;
	}
	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}
	public double getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}
	public String getRecordBalance() {
		return recordBalance;
	}
	public void setRecordBalance(String recordBalance) {
		this.recordBalance = recordBalance;
	}
	public String getTimeAdd() {
		return timeAdd;
	}
	public void setTimeAdd(String timeAdd) {
		this.timeAdd = timeAdd;
	}
	public int getTypeTrans() {
		return typeTrans;
	}
	public void setTypeTrans(int typeTrans) {
		this.typeTrans = typeTrans;
	}
	
	@Override
	public String toString() {
		return "Trans [balance=" + balance + ", cardId=" + cardId + ", cardNoIntr=" + cardNoIntr + ", cardno=" + cardno
				+ ", channel=" + channel + ", code=" + code + ", coid=" + coid + ", id=" + id + ", idMember=" + idMember
				+ ", jv=" + jv + ", limitStart=" + limitStart + ", orderByStr=" + orderByStr + ", priceSale="
				+ priceSale + ", recordBalance=" + recordBalance + ", timeAdd=" + timeAdd + ", typeTrans=" + typeTrans
				+ ", getBalance()=" + getBalance() + ", getCardId()=" + getCardId() + ", getCardNoIntr()="
				+ getCardNoIntr() + ", getCardno()=" + getCardno() + ", getChannel()=" + getChannel() + ", getCode()="
				+ getCode() + ", getCoid()=" + getCoid() + ", getId()=" + getId() + ", getIdMember()=" + getIdMember()
				+ ", getJv()=" + getJv() + ", getLimitStart()=" + getLimitStart() + ", getOrderByStr()="
				+ getOrderByStr() + ", getPriceSale()=" + getPriceSale() + ", getRecordBalance()=" + getRecordBalance()
				+ ", getTimeAdd()=" + getTimeAdd() + ", getTypeTrans()=" + getTypeTrans() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
