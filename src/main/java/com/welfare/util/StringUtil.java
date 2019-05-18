package com.welfare.util;

public class StringUtil {

	public static boolean isNotEmpty(String str) {
		return str != null && !str.trim().isEmpty();
	}

	public static boolean isEmpty(String str) {
		return null == str || str.trim().equals("");
	}

}
