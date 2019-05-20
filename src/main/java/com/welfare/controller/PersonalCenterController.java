package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.welfare.client.Constants;
import com.welfare.model.OrderInfo;
import com.welfare.model.Trans;
import com.welfare.model.UserInfo;
import com.welfare.pojo.WXUserInfo;
import com.welfare.service.MemberService;
import com.welfare.service.OrderService;
import com.welfare.service.TransService;
import com.welfare.service.UserInfoService;
import com.welfare.util.StringUtil;
import com.welfare.util.WXUtil;

@Controller
public class PersonalCenterController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonalCenterController.class);
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	@Resource
	private MemberService memberServiceImpl;
	@Resource
	private TransService transServiceImpl;
	@Resource
	private OrderService orderServiceImpl;
	
	
	@RequestMapping("personalCenter")
	public String personalCenter(HttpServletRequest request,Model model) {
		WXUtil.saveLocalOpenID(request.getParameter("code"));
		
		WXUserInfo wxuserInfo = userInfoServiceImpl.getUserInfo();
		model.addAttribute("wxuser", wxuserInfo);
		
		UserInfo userInfo = memberServiceImpl.selectByOpenId();
		model.addAttribute("user", userInfo);
		
		return "personalCenter";
	}
	
	@RequestMapping("transList")
	public String getTransList(@RequestParam("transType") int transType, Model model) {
		List<Trans> list = transServiceImpl.getList(transType);
		model.addAttribute("list",  list);
		return "transList";
	}
	
	@RequestMapping("intoEditPwd")
	public String intoEditPwd() {
		return "editPassword";
	}
	
	@ResponseBody
	@RequestMapping(value="getVerifyCode",method = RequestMethod.POST)
	public String getVerifyCode(HttpServletRequest request, HttpServletResponse response) {
		String phone = request.getParameter("phoneNumbers");
		logger.info("phone: {}", phone);
		String code = memberServiceImpl.getVerifyCode(phone);
		return JSON.toJSONString(code);
	}
	
	@RequestMapping("queryOrderList")
	public String queryOrderList(Model model) {
		List<OrderInfo> list = orderServiceImpl.selectListOiByIdMember();
		model.addAttribute("list", list);
		return "orderList";
	}
	
	

}
