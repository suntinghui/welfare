package com.welfare.task;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.welfare.client.Constants;
import com.welfare.util.StringUtil;

@Service("getAccessTokenTask")
public class GetAccessTokenTask {

	private static final Logger logger = LoggerFactory.getLogger(GetAccessTokenTask.class);

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
				logger.info("GetAccessTokenTask:{}", result);

				jsonObject = JSONObject.parseObject(result);
				if (null == jsonObject.get("errcode")) {
					String access_token = (String) jsonObject.get("access_token");

					if (StringUtil.isNotEmpty(access_token)) {
						logger.info("获取access_token成功:{}", access_token);
						Constants.ACCESS_TOKEN = access_token;
					} else {
						logger.info("获取access_token失败");
					}
				} else {
					logger.error("获取access_token失败:{}-{}", jsonObject.get("errcode"), jsonObject.get("errmsg"));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("获取access_token失败");
		}
	}

}
