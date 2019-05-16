package com.welfare.util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MapUtil {

	public static HashMap<String, String> obj2Map(Object obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		// 得到类对象
		Class userCla = (Class) obj.getClass();
		/* 得到类中的所有属性集合 */
		Field[] fs = userCla.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			String val = new String();
			try {
				Object temp = f.get(obj);
				if (temp == null) {
					val = "";
				} else {
					val = temp.toString();
				}

				map.put(f.getName(), val);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return map;
	}

}
