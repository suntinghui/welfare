package com.welfare.model;

public class ResponsePagination<T> {
	
	private String respCode;
	private String respMsg;
	private Pagination<T> data;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public Pagination<T> getData() {
		return data;
	}
	public void setData(Pagination<T> data) {
		this.data = data;
	}
	
}
