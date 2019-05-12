package com.superway.am.task;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.superway.am.common.Constants;
import com.superway.am.util.StringUtil;

@Service("getAccessTokenTask")
public class GetAccessTokenTask {

	public void getToken() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Constants.APPID
				+ "&secret=" + Constants.APP_SECRET;

		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);

		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				jsonObject = JSONObject.parseObject(result);
				String access_token = (String) jsonObject.get("access_token");
				System.out.println(access_token);
				if (StringUtil.isNotEmpty(access_token)) {
					System.out.println("获取access_token成功");
					Constants.ACCESS_TOKEN = access_token;
				} else {
					System.out.println("获取access_token失败");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("获取access_token失败");
		}
	}

}
