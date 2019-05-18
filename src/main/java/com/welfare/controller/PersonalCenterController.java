package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welfare.model.Trans;
import com.welfare.model.UserInfo;
import com.welfare.pojo.WXUserInfo;
import com.welfare.service.MemberService;
import com.welfare.service.TransService;
import com.welfare.service.UserInfoService;

@Controller
public class PersonalCenterController {
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	@Resource
	private MemberService memberServiceImpl;
	@Resource
	private TransService transServiceImpl;
	
	
	@RequestMapping("personalCenter")
	public String personalCenter(Model model) {
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
	

}
