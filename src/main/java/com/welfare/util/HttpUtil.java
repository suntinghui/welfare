package com.welfare.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.welfare.client.Constants;

/**
 * Http 访问工具类
 * 
 */
public class HttpUtil {

	private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	/**
	 * 证书信任管理器（用于https请求）
	 * 
	 */
	public static class MyX509TrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	public static String get(String url, HashMap<String, String> map) {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}

		if (sb.toString().endsWith("&")) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return get(url, sb.toString());
	}

	/**
	 * GET请求 默认是 utf-8 编码
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String get(String url, String params) {
		return get(url, params, Charset.forName("utf-8"));
	}

	/**
	 * GET请求
	 * 
	 * @param url 请求URL
	 * @return
	 */
	public static String get(String url, String params, Charset charset) {
		String result = "";
		InputStream in = null;
		if (null != params && !params.equals("")) {
			if (url.contains("?")) {// 包含?,后面加&直接填加
				url += "&" + params;
			} else {
				url += "?" + params;
			}
		}

		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("token", Constants.OPENID);
			conn.connect();
			in = conn.getInputStream();
			result = IOUtils.toString(in, charset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		logger.info("HTTP Get: {}", result);
		return result;
	}

	public static String post(String url, HashMap<String, String> map) {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}

		if (sb.toString().endsWith("&")) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return post(url, sb.toString());
	}

	/**
	 * POST请求 默认是 utf-8 编码
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(String url, String params) {
		return post(url, params, Charset.forName("utf-8"));
	}

	/**
	 * POST请求
	 * 
	 * @param url   请求URL
	 * @param param 请求参数，请求参数格式 name1=value1&name2=value2
	 * @return
	 */
	public static String post(String url, String param, Charset charset) {
		logger.info("HTTP Post param: {}", param);

		PrintWriter out = null;
		InputStream in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("token", Constants.OPENID);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();

			in = conn.getInputStream();
			result = IOUtils.toString(in, charset);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				try {
					if (out != null) {
						out.close();
					}
				} finally {
					if (in != null) {
						in.close();
					}
				}
			} catch (Exception ex) {
			}

		}

		logger.info("HTTP Post: {}", result);
		return result;

	}

}
