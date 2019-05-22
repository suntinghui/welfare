package com.welfare.client;

import com.welfare.util.DataUtil;
import com.welfare.util.HttpUtil;

public class Test {
	
	public static void main(String args[]) {
		String result = HttpUtil.get("http://39.106.8.241:9527/tcard-service-user/card/active/255366", "");
		System.out.println(result);
	}

}
