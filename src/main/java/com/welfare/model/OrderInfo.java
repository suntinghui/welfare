package com.welfare.model;

import com.welfare.util.DataUtil;

public class OrderInfo {
	public int bonus;
	public int count;
	public double fvTotal;
	public int id;
	public String idMember;
	public String invoice;
	public int isInvoice;
	public String jv;
	public int limitSize;
	public int limitStart;
	public int memberBonus;
	public String noDv;
	public String oid;
	public int page;
	public int pageCount;
	public double priceReal;
	public int status;
	public String timeAdd;
	public String timePay;
	public String timeUpdate;
	public String transactionId;
	public int type;

	public String invoiceDesc;
	public String statusDesc;
	public String typeDesc;

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getFvTotal() {
		return fvTotal;
	}

	public void setFvTotal(double fvTotal) {
		this.fvTotal = fvTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public int getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(int isInvoice) {
		this.isInvoice = isInvoice;
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

	public int getMemberBonus() {
		return memberBonus;
	}

	public void setMemberBonus(int memberBonus) {
		this.memberBonus = memberBonus;
	}

	public String getNoDv() {
		return noDv;
	}

	public void setNoDv(String noDv) {
		this.noDv = noDv;
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

	public double getPriceReal() {
		return priceReal;
	}

	public void setPriceReal(double priceReal) {
		this.priceReal = priceReal;
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

	public String getTimePay() {
		return timePay;
	}

	public void setTimePay(String timePay) {
		this.timePay = timePay;
	}

	public String getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(String timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getInvoiceDesc() {
		return DataUtil.invoiceMap().get(this.isInvoice+"");
	}

	public String getStatusDesc() {
		return DataUtil.orderStatusMap().get(this.status + "");
	}

	public String getTypeDesc() {
		return DataUtil.orderTypeMap().get(this.type + "");
	}

}
