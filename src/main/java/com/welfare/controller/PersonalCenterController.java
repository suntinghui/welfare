package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		if (StringUtil.isEmpty(Constants.OPENID)) {
			WXUtil.getOpenID(request.getParameter("code"));
		}
		
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
	
	@RequestMapping("editPwd")
	public String getVerifyCode(@RequestParam("phone") String phone) {
		String code = memberServiceImpl.getVerifyCode(phone);
		return "editPassword?code="+code;
	}
	
	@RequestMapping("queryOrderList")
	public String queryOrderList(Model model) {
		List<OrderInfo> list = orderServiceImpl.selectListOiByIdMember();
		model.addAttribute("list", list);
		return "orderList";
	}
	
	

}
