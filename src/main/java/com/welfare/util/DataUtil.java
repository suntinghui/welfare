package com.welfare.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DataUtil {
	
	public static void saveSessionData(String key, String value) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
	public static String getSessionData(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return "oaPc35wLEs7uj_NtmbDf0gLn8UpY";
//		return (String)session.getAttribute(key);
	}
	
	public static List<String> transTypeValue() {
		ArrayList<String> list = new ArrayList<>();
		for (int i=0; i<14;i++) {
			list.add(i+"");
		}
		return list;
	}
	
	public static List<String> transTypeDisplay() {
		ArrayList<String> list = new ArrayList<>();
		list.add("流水类型");
		list.add("购卡");
		list.add("充值");
		list.add("兑换码领卡");
		list.add("领取礼品卡");
		list.add("转赠礼品卡");
		list.add("回收礼品卡-取消");
		list.add("回收礼品卡-拒绝");
		list.add("发红包");
		list.add("红包退回");
		list.add("领红包");
		list.add("退卡");
		list.add("发票流水");
		list.add("激活卡");
		return list;
	}
	public static HashMap<String, String> transType() {
		HashMap<String, String>  map = new HashMap<>();
		map.put("0", "全部");
		map.put("1", "购卡");
		map.put("4", "领取");
		map.put("5", "转赠");
		map.put("11", "退货");
		return map;
	}
	// 开票状态
	public static HashMap<String, String> invoiceMap() {
		HashMap<String, String>  map = new HashMap<>();
		map.put("0", "未开票");
		map.put("1", "审核中");
		map.put("2", "已开票");
		return map;
	}
	
	public static HashMap<String, String> orderStatusMap() {
		HashMap<String, String>  map = new HashMap<>();
		map.put("1", "待支付");
		map.put("2", "已完成");
		map.put("3", "支付超时");
		return map;
	}
	
	public static HashMap<String, String> orderTypeMap() {
		HashMap<String, String>  map = new HashMap<>();
		map.put("1", "购卡");
		map.put("2", "充值");
		map.put("3", "转赠");
		return map;
	}

}
