package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="getVerifyCode", produces = "application/json; charset=utf-8")
	public String getVerifyCode(@RequestParam("phoneNumbers") String phone) {
		String code = memberServiceImpl.getVerifyCode(phone);
		return code;
	}
	/*
	 * 修改密码
	 */
	@ResponseBody
	@RequestMapping(value="editPackagePwd", produces = "application/json; charset=utf-8")
	public String editPackagePwd(HttpServletRequest req)
	{
		String result=memberServiceImpl.editPackagePwd(req.getParameter("code"), req.getParameter("phoneNumber"), req.getParameter("pwd"));
		return result;
	}
	@RequestMapping("queryOrderList")
	public String queryOrderList(Model model) {
		List<OrderInfo> list = orderServiceImpl.selectListOiByIdMember();
		model.addAttribute("list", list);
		return "orderList";
	}
	
	

}
