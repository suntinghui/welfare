package com.welfare.model;

public class Invoice {
	
	private String oid;
	private int memberId;
	private String title;
	private String code;
	private String name;
	private String phone;
	private String address;
	private String bz;
	private String email;
	private double priceInvoice;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPriceInvoice() {
		return priceInvoice;
	}
	public void setPriceInvoice(double priceInvoice) {
		this.priceInvoice = priceInvoice;
	}
	@Override
	public String toString() {
		return "Invoice [oid=" + oid + ", memberId=" + memberId + ", title=" + title + ", code=" + code + ", name="
				+ name + ", phone=" + phone + ", address=" + address + ", bz=" + bz + ", email=" + email
				+ ", priceInvoice=" + priceInvoice + "]";
	}
	
}
