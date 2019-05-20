package com.welfare.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.welfare.model.City;
import com.welfare.service.CityService;
import com.welfare.util.DataUtil;

@Controller
public class DicDataController {
	@Resource
	private CityService cityServiceImpl;
	
	/*
	 * 获取城市集合
	 */
	@ResponseBody
	@RequestMapping(value="getCitys", produces = "application/json; charset=utf-8")
	public String getVerifyCode(Model model) {
		 List<City> list = cityServiceImpl.queryAll();
		 return JSON.toJSONString(list);
	}
	/*
	 * 获取消费类型枚举
	 */
	@ResponseBody
	@RequestMapping(value="getTypeTrans", produces = "application/json; charset=utf-8")
	public String getTypeTrans(Model model) {
		/*
		 * HashMap<String, String> list=DataUtil.transType(); return
		 * JSON.toJSONString(list);
		 */
		 List<City> list = cityServiceImpl.queryAll();
		 return JSON.toJSONString(list);
	}
}
