package com.welfare.model;

/**
 * City {
		all (integer, optional): 是否是全国卡 0：否 1：是 ,
		city (string, optional): city ,
		id (integer, optional): id ,
		idMer (string, optional): 商户id ,
		idProduct (string, optional): 商品编号 ,
		jv (string, optional): 城市编号 ,
		limitSize (integer, optional),
		limitStart (integer, optional),
		orderByStr (string, optional),
		orderByString (inline_model, optional),
		page (integer, optional),
		pageCount (integer, optional),
		sort (integer, optional): 排序序号 ,
		status (integer, optional): 是否启用：0：否 1：是
 * @author SunTH
 *
 */

public class City {
	private int all;
	private String city;
	private int id;
	private String idMer;
	private String idProduct;
	private String jv;
	private int limitSize;
	private int limitStart;
	private String orderByStr;
	private int page;
	private int sort;
	private int status;
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdMer() {
		return idMer;
	}
	public void setIdMer(String idMer) {
		this.idMer = idMer;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getJv() {
		return jv;
	}
	public void setJv(String jv) {
		this.jv = jv;
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
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "City [all=" + all + ", city=" + city + ", id=" + id + ", idMer=" + idMer + ", idProduct=" + idProduct
				+ ", jv=" + jv + ", limitSize=" + limitSize + ", limitStart=" + limitStart + ", orderByStr="
				+ orderByStr + ", page=" + page + ", sort=" + sort + ", status=" + status + "]";
	}
	
	

}
