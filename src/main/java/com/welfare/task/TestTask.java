package com.welfare.task;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.welfare.model.Invoice;
import com.welfare.model.OrderReturn;
import com.welfare.service.impl.CityServiceImpl;
import com.welfare.service.impl.GoodsServiceImpl;
import com.welfare.service.impl.InvoiceServiceImpl;
import com.welfare.service.impl.MemberServiceImpl;
import com.welfare.service.impl.OrderReturnServiceImpl;
import com.welfare.service.impl.OrderServiceImpl;
import com.welfare.service.impl.TransServiceImpl;

@Service("testTask")
public class TestTask {

	private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

	public void test() {
		
		OrderReturn orderReturn = new OrderReturn();
		orderReturn.setIdMember(96529);
		orderReturn.setCardidUrl("");
		orderReturn.setCardidUrlB("");
		orderReturn.setContentR("");
		orderReturn.setOid("");
		orderReturn.setPhone("");
		orderReturn.setWxOidUrl("");
		
		OrderReturnServiceImpl ser = new OrderReturnServiceImpl();
		ser.add(orderReturn);
		
	}

}
