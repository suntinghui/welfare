package com.welfare.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welfare.client.Constants;
import com.welfare.util.DataUtil;
import com.welfare.util.EncryptUtil;
import com.welfare.util.MessageUtil;

/**
 * @author SunTH
 *
 */

@Controller
public class WechatServerConfigController {

	private static final Logger logger = LoggerFactory.getLogger(WechatServerConfigController.class);

	@RequestMapping(value = "wx")
	public void wechat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();

		logger.info("========================================");

		try {
			// get方式请求的默认为是 后台管理系统 验证配置服务器地址
			if (request.getMethod().equalsIgnoreCase("GET")) {
				logger.info("进行服务器地址配置操作。。。");
				out.print(checkServiceUrl(request));

			} else {
				String msg = processMessage(request);
				out.print(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	private String checkServiceUrl(HttpServletRequest request) {
		String signature = request.getParameter("signature");/// 微信加密签名
		String timestamp = request.getParameter("timestamp");/// 时间戳
		String nonce = request.getParameter("nonce"); /// 随机数
		String echoStr = request.getParameter("echostr"); // 随机字符串

		String tempSignature = EncryptUtil.getSHA1(Constants.TOKEN, timestamp, nonce);
		logger.info("check: {}", tempSignature);

		if (tempSignature.equals(signature)) {
			return echoStr;
		}
		return "";
	}

	private String processMessage(HttpServletRequest request) {
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			logger.info("用户向微信请求报文 {}",map.toString());

			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			// 保存用户的OPENID到Session中
			DataUtil.saveSessionData(Constants.kOPENID, fromUserName);

			String message = null;
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				message = MessageUtil.defaultText(toUserName, fromUserName);
				if (content.equalsIgnoreCase("1")) { // 卡片使用
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_1());
				} else if (content.equalsIgnoreCase("2")) { // 卡片转赠说明
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_2());
				} else if (content.equalsIgnoreCase("3")) { // 退卡规则
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_3());
				} else if (content.equalsIgnoreCase("4")) { // 电子发票
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_4());
				} else if (content.equalsIgnoreCase("5")) { // 退货
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_5());
				} else if (content.equalsIgnoreCase("6")) { // 激活类
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceReplyText_6());
				}  else { // 输入其他内容时统一回复subscribeText
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceText());
				} 

			} else if (MessageUtil.MESSAGE_EVNET.equals(msgType)) {
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.subscribeText());
					
				} else if (MessageUtil.MESSAGE_CLICK.equals(eventType)) {
					if (map.get("EventKey").equals(Constants.MENU_SERVICE)) {
						message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.customerServiceText());
					} 

				} else if (MessageUtil.MESSAGE_VIEW.equals(eventType)) {
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
					
				} else if (MessageUtil.MESSAGE_SCANCODE.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}
			} else if (MessageUtil.MESSAGE_LOCATION.equals(msgType)) {
				String label = map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, label);
			}

			logger.info("微信向用户响应报文 {}",message);
			
			return message;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
