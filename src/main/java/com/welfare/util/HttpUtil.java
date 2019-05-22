package com.welfare.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
		
		logger.info("URL: - {}", url);

		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("token", "oaPc35_YfvsDhYpWSUOL6C61lY3k");
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
		logger.info(url);
		logger.info("HTTP Get: {}", result);
		return result;
	}
	
	public static String post(String url, HashMap<String, String> map) {
		/*
		 * StringBuffer sb = new StringBuffer(); for (Map.Entry<String, String> entry :
		 * map.entrySet()) {
		 * sb.append(entry.getKey()).append("=").append(entry.getValue());
		 * sb.append("&"); }
		 * 
		 * if (sb.toString().endsWith("&")) { sb.deleteCharAt(sb.length() - 1); }
		 * logger.info(url); return post(url, sb.toString());
		 */
		return post2(url,map);
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
		logger.info("HTTP Post URL: - {}", url);
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
			conn.setRequestProperty("token", DataUtil.getSessionData(Constants.kOPENID));

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
  
	
	public static String post1(String url, String param, Charset charset) {
		logger.info("HTTP Post1 URL: - {}", url);
		
		logger.info("HTTP Post1 param: {}", param);

		BufferedReader out = null;
		InputStream in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection httpConn=(HttpURLConnection)realUrl.openConnection();
	         
	        //设置参数
	        httpConn.setDoOutput(true);     //需要输出
	        httpConn.setDoInput(true);      //需要输入
	        httpConn.setUseCaches(false);   //不允许缓存
	        httpConn.setRequestMethod("POST");      //设置POST方式连接
	         
	        //设置请求属性
	        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
	        httpConn.setRequestProperty("Charset", "UTF-8");
	        String token=DataUtil.getSessionData(Constants.kOPENID);
			logger.info("HTTP Post Token-{}", token);
			httpConn.setRequestProperty("token", token);
			
	        //连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
	        httpConn.connect();
	             
	        //建立输入流，向指向的URL传入参数
	        DataOutputStream dos=new DataOutputStream(httpConn.getOutputStream());
	        dos.writeBytes(param);
	        dos.flush();
	        dos.close();
            
	        //获得响应状态
	        int resultCode=httpConn.getResponseCode();
	        if(HttpURLConnection.HTTP_OK==resultCode){
	        	in=httpConn.getInputStream();
	            StringBuffer sb=new StringBuffer();
	            String readLine=new String();
	            out=new BufferedReader(new InputStreamReader(in,"UTF-8"));
	            while((readLine=out.readLine())!=null){
	                sb.append(readLine).append("\n");
	            }
	            //responseReader.close();
	             
	        }  


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

	public static String post2(String url, HashMap<String, String> map) {
	   logger.info("HTTP Post2 URL: - {}", url);
			
	   
	   String result = null;
	 //获取请求参数
        List<NameValuePair> parame = new ArrayList<NameValuePair>();
        StringBuffer sb = new StringBuffer();
        if(map!=null)
	   	for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
			parame.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
	    logger.info("HTTP Post2 param: {}", sb);
		   

	   CloseableHttpClient httpclient = HttpClients.createDefault();
       CloseableHttpResponse response = null;
       try {
           //创建post请求
           HttpPost httpPost = new HttpPost(url);
            // 设置请求和传输超时时间  
           RequestConfig requestConfig = RequestConfig.custom()  
                   .setSocketTimeout(2000).setConnectTimeout(2000).build();  
           httpPost.setConfig(requestConfig); 
           String token=DataUtil.getSessionData(Constants.kOPENID);
           httpPost.addHeader("token", token);
           
           // 提交参数发送请求
           UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parame);
           httpPost.setEntity(urlEncodedFormEntity);
           response = httpclient.execute(httpPost);
           // 得到响应信息
           int statusCode = response.getStatusLine().getStatusCode();
           // 判断响应信息是否正确
           if (statusCode != HttpStatus.SC_OK) {
               // 终止并抛出异常
               httpPost.abort();
               throw new RuntimeException("HttpClient,error status code :" + statusCode);
           }
           HttpEntity entity = response.getEntity();
           if (entity != null) {
               //result = EntityUtils.toString(entity);//不进行编码设置
               result = EntityUtils.toString(entity, "UTF-8");
           }
           EntityUtils.consume(entity);

       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       } catch (ClientProtocolException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           //关闭所有资源连接
           if (response != null) {
               try {
                   response.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (httpclient != null) {
               try {
                   httpclient.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       logger.info("HTTP Post2: {}", result);
       return result;
 
	}
}
