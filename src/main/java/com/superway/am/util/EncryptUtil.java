package com.superway.am.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class EncryptUtil {

	public static String getSHA1(String token, String timestamp, String nonce) {
		try {
			String[] array = new String[] { token, timestamp, nonce };
			StringBuffer sb = new StringBuffer();
			Arrays.sort(array);
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
