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

@Service("getJSApiTicketTask")
public class GetJSApiTicketTask {

	private static final Logger logger = LoggerFactory.getLogger(GetJSApiTicketTask.class);

	public void getTicket() {
		String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+Constants.ACCESS_TOKEN+"&type=jsapi";

		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);

		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				logger.info("GetJSApiTicketTask:{}", result);

				jsonObject = JSONObject.parseObject(result);
				String ticket = (String) jsonObject.get("ticket");
				logger.info("获取ticket成功:{}", ticket);
				Constants.JSAPI_TICKET = ticket;

			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("获取ticket失败");
		}
	}

}
