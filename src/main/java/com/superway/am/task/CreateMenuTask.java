package com.superway.am.task;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.superway.am.common.Constants;
import com.superway.am.util.StringUtil;
import com.superway.am.util.WeixinUtil;

@Service("createMenuTask")
public class CreateMenuTask {

	public void createMenu() {
		System.out.println("开始创建菜单。。。");
		
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+Constants.ACCESS_TOKEN;
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(JSONObject.toJSONString(WeixinUtil.initMenu()),"UTF-8"));

		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSONObject.parseObject(result);
				if(jsonObject != null){
					int code = jsonObject.getInteger("errcode");
					System.out.println("code: "+code);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("创建菜单错误。。。");
		}
	}

}
