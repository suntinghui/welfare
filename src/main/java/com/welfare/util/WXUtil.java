package com.welfare.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.welfare.client.Constants;

public class WXUtil {

	private static final Logger logger = LoggerFactory.getLogger(WXUtil.class);

	public static String formatURLGetCode(String srcUrl) {
		try {
			return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constants.APPID + "&redirect_uri=" + URLEncoder.encode(srcUrl, "utf-8") + "&response_type=code&scope=snsapi_base&state=210#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String getOpenID(String code) {
		if (StringUtil.isEmpty(code))
			return "";

		try {
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constants.APPID + "&secret=" + Constants.APP_SECRET + "&code=" + code + "&grant_type=authorization_code";
			JSONObject jsonObject = WXHttpUtil.doGetStr(url);
			String openId = (String) jsonObject.get("openid");

			logger.info("通过授权的方式成功得到openID：{}", openId);

			return openId;

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 存储本人的OPENID
	 * 
	 * @param code
	 */
	public static void saveLocalOpenID(String code) {
		String openId = getOpenID(code);
		// 保存用户的OPENID到Session中
		DataUtil.saveSessionData(Constants.kOPENID, openId);
	}

	public static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	public static Map<String, String> getConfig(String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String jsapi_ticket = Constants.JSAPI_TICKET;
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		logger.info(ret.toString());

		return ret;
	}

}
