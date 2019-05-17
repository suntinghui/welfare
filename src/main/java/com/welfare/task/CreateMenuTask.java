package com.welfare.task;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.welfare.client.Constants;
import com.welfare.pojo.Button;
import com.welfare.pojo.ClickButton;
import com.welfare.pojo.Menu;
import com.welfare.pojo.ViewButton;

@Service("createMenuTask")
public class CreateMenuTask {

	private static final Logger logger = LoggerFactory.getLogger(CreateMenuTask.class);

	public void genMenuAction() {
		logger.info("开始创建菜单-----------------------");

		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + Constants.ACCESS_TOKEN;

		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(JSONObject.toJSONString(createMenu()), "UTF-8"));

		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.parseObject(result);
				if (jsonObject != null) {
					int code = jsonObject.getInteger("errcode");
					logger.error("code:{} ", code);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("创建菜单错误--------------------------------");
		}
	}

	private Menu createMenu() {
		// 第一系列菜单
		ViewButton button11 = new ViewButton("购卡", "view", Constants.WEIXIN_HOST + "queryAllGoods");
		ViewButton button12 = new ViewButton("卡包", "view", Constants.WEIXIN_HOST + "");
		ViewButton button13 = new ViewButton("个人中心", "view", Constants.WEIXIN_HOST + "");
		ClickButton button14 = new ClickButton("客服服务", "click", Constants.MENU_SERVICE);
		Button button1 = new Button();
		button1.setName("家乐福卡");
		button1.setSub_button(new Button[] { button11, button12, button13, button14 });

		// 第二系列菜单
		ViewButton button21 = new ViewButton("采购电子码", "view", Constants.WEIXIN_HOST + "undo");
		ViewButton button22 = new ViewButton("电子码领取", "view", Constants.WEIXIN_HOST + "undo");
		ViewButton button23 = new ViewButton("企业中心", "view", Constants.WEIXIN_HOST + "undo");
		ViewButton button24 = new ViewButton("企业卡包", "view", Constants.WEIXIN_HOST + "undo");
		Button button2 = new Button();
		button2.setName("对公业务");
		button2.setSub_button(new Button[] { button21, button22, button23, button24 });

		// 第三系列菜单
		ViewButton button31 = new ViewButton("ID包", "view", Constants.WEIXIN_HOST + "undo");
		ViewButton button32 = new ViewButton("凭ID领取", "view", Constants.WEIXIN_HOST + "undo");
		ViewButton button33 = new ViewButton("ID中心", "view", Constants.WEIXIN_HOST + "undo");
		Button button3= new Button();
		button3.setName("我的");
		button3.setSub_button(new Button[] { button31, button32, button33 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { button1, button2, button3 });
		return menu;
	}

}
