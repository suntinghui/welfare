package com.welfare.service;

import com.welfare.model.Invoice;
import com.welfare.model.ResponseObject;

public interface InvoiceService {
	
	/**
	 * 开具发票
	 * @return
	 */
	public ResponseObject<String> add(Invoice invoice);

}
