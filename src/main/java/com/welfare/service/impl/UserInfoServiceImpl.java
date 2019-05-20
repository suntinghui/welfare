package com.welfare.service.impl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.welfare.client.Constants;
import com.welfare.pojo.WXUserInfo;
import com.welfare.service.UserInfoService;
import com.welfare.util.DataUtil;
import com.welfare.util.StringUtil;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Override
	public WXUserInfo getUserInfo() {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+Constants.ACCESS_TOKEN+"&openid="+DataUtil.getSessionData(Constants.kOPENID);

		logger.info("-----{}", url);
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);

		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				logger.info("getUserInfo:{}", result);

				jsonObject = JSONObject.parseObject(result);
				if (null == jsonObject.get("errcode")) {
					WXUserInfo userinfo = jsonObject.toJavaObject(WXUserInfo.class);
					return userinfo;
				} else {
					logger.error("获取getUserInfo失败:{}-{}", jsonObject.get("errcode"), jsonObject.get("errmsg"));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("获取access_token失败");
		}
		
		return null;
	}

}
