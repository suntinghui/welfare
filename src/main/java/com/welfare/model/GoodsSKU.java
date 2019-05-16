package com.welfare.model;

/**
 * GoodsSku {
cardId (string, optional): 微信cardId ,
codesC (string, optional): codesC ,
fv (number, optional): 面值 ,
id (integer, optional): id ,
idGoods (integer, optional): 商品id ,
isAlive (integer, optional): isAlive ,
isEnable (integer, optional): 是否关闭 0启用 1关闭 ,
limitSize (integer, optional),
limitStart (integer, optional),
orderByStr (string, optional),
orderByString (inline_model_1, optional),
page (integer, optional),
pageCount (integer, optional),
priceSale (number, optional): 销售金额
}
 * @author SunTH
 *
 */
public class GoodsSKU {
	private String cardId;
	private String codesC;
	private double fv;
	private int id;
	private int idGoods;
	private int isAlive;
	private int isEnable;
	private int limitSize;
	private int limitStart;
	private String orderByStr;
	private int page;
	private int pageCount;
	private double priceSale;
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCodesC() {
		return codesC;
	}
	public void setCodesC(String codesC) {
		this.codesC = codesC;
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
	public int getIdGoods() {
		return idGoods;
	}
	public void setIdGoods(int idGoods) {
		this.idGoods = idGoods;
	}
	public int getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(int isAlive) {
		this.isAlive = isAlive;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
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
	public double getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}
	
	@Override
	public String toString() {
		return "GoodsSKu [cardId=" + cardId + ", codesC=" + codesC + ", fv=" + fv + ", id=" + id + ", idGoods="
				+ idGoods + ", isAlive=" + isAlive + ", isEnable=" + isEnable + ", limitSize=" + limitSize
				+ ", limitStart=" + limitStart + ", orderByStr=" + orderByStr + ", page=" + page + ", pageCount="
				+ pageCount + ", priceSale=" + priceSale + "]";
	}
	
}
