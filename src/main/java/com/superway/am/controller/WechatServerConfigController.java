package com.superway.am.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superway.am.common.Constants;
import com.superway.am.util.EncryptUtil;
import com.superway.am.util.MessageUtil;

/**
 * @author SunTH
 *
 */

@Controller
public class WechatServerConfigController {

	@RequestMapping(value = "wx")
	public void wechat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		try {
			// get方式请求的默认为是验证配置服务器地址
			if (request.getMethod().equalsIgnoreCase("GET")) {
				System.out.println("进行服务器地址配置操作。。。");
				out.print(checkServiceUrl(request));

			} else {
				out.print(processMessage(request));
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
		System.out.println("check: " + tempSignature);

		if (tempSignature.equals(signature)) {
			return echoStr;
		}
		return "";
	}

	private String processMessage(HttpServletRequest request) {
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			String message = null;
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				message = MessageUtil.defaultText(toUserName, fromUserName);
				
			} else if (MessageUtil.MESSAGE_EVNET.equals(msgType)) {
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_CLICK.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
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

			System.out.println("\nmessage: " + message);
			return message;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
