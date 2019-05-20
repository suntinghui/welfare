package com.welfare.controller;

import java.util.HashMap;
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
import com.welfare.model.City;
import com.welfare.model.OrderInfo;
import com.welfare.model.ResponseObject;
import com.welfare.model.Trans;
import com.welfare.model.UserInfo;
import com.welfare.pojo.WXUserInfo;
import com.welfare.service.CityService;
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

	@Resource
	private CityService cityServiceImpl;

	@RequestMapping("personalCenter")
	public String personalCenter(HttpServletRequest request, Model model) {
		WXUtil.saveLocalOpenID(request.getParameter("code"));

		WXUserInfo wxuserInfo = userInfoServiceImpl.getUserInfo();
		model.addAttribute("wxuser", wxuserInfo);

		UserInfo userInfo = memberServiceImpl.selectByOpenId();
		model.addAttribute("user", userInfo);

		return "personalCenter";
	}

	@RequestMapping("transList")
	public String transList(HttpServletRequest request, Model model) {

		return "transList";
	}

	@ResponseBody
	@RequestMapping(value = "getTransList", produces = "application/json; charset=utf-8")
	public String getTransList(HttpServletRequest req, Model model) {
		String transTypeStr = req.getParameter("transType");
		int transType = 0;
		if (!transTypeStr.isEmpty()) {

			try {
				transType = Integer.parseInt(transTypeStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HashMap<String, String> pars = new HashMap<>();
		pars.put("typeTrans", transType + "");
		pars.put("startDate", req.getParameter("startDate"));
		pars.put("endDate", req.getParameter("endDate"));
		List<Trans> list = transServiceImpl.getList(transType);
		model.addAttribute("list", list);
		/*
		 * List<City> cityList = cityServiceImpl.queryAll();
		 * model.addAttribute("cityList", cityList);
		 */
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
		ResponseObject<String> resp = memberServiceImpl.getVerifyCode(phone);
		return resp.getRespCode();
	}
	/*
	 * 修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "editPackagePwd", produces = "application/json; charset=utf-8")
	public String editPackagePwd(HttpServletRequest req) {
		ResponseObject<String> resp = memberServiceImpl.editPackagePwd(req.getParameter("code"), req.getParameter("phoneNumber"), req.getParameter("pwd"));
		return resp.getRespCode();
	}

	@RequestMapping("queryOrderList")
	public String queryOrderList(Model model) {
		List<OrderInfo> list = orderServiceImpl.selectListOiByIdMember();
		model.addAttribute("list", list);
		return "orderList";
	}

}
