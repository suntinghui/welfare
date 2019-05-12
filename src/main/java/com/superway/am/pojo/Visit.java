package com.superway.am.pojo;

import java.util.Date;

public class Visit {
	
	private int id;
	private String company_name;
	private String customer_name;
	private String customer_phone;
	private int total_score; // 系统使用综合评分
	private int sysImpl_score; // 实施过程综合评分
	private int service_score; // 客户服务综合评分
	private String opinion;
	private String create_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public int getSysImpl_score() {
		return sysImpl_score;
	}
	public void setSysImpl_score(int sysImpl_score) {
		this.sysImpl_score = sysImpl_score;
	}
	public int getService_score() {
		return service_score;
	}
	public void setService_score(int service_score) {
		this.service_score = service_score;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

}
