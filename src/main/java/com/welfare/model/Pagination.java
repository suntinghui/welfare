package com.welfare.model;

public class Pagination<List> {
	
	private List dl;
	private int totalSize;
	private int totalPage;
	
	public List getDl() {
		return dl;
	}
	public void setDl(List dl) {
		this.dl = dl;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	

}
