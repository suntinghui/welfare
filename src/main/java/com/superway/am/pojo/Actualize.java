package com.superway.am.pojo;

public class Actualize {
	private int id;
	private String company_name;
	private String customer_name;
	private String customer_phone;
	private int total_score; // 实施过程综合评分
	private int manner_score; // 实施人员态度
	private int time_score; // 用户配合用时满意度
	private int delay_score; // 过程问题处理及时度
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
	public int getManner_score() {
		return manner_score;
	}
	public void setManner_score(int manner_score) {
		this.manner_score = manner_score;
	}
	public int getTime_score() {
		return time_score;
	}
	public void setTime_score(int time_score) {
		this.time_score = time_score;
	}
	public int getDelay_score() {
		return delay_score;
	}
	public void setDelay_score(int delay_score) {
		this.delay_score = delay_score;
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