package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welfare.model.Goods;
import com.welfare.service.GoodsService;

@Controller
public class BuyCardController {
	
	@Resource
	private GoodsService goodsServiceImpl;
	
	@RequestMapping(value = "queryAllGoods")
	public String queryAllGoods(Model model) {
		List<Goods> list = goodsServiceImpl.selectList();
		model.addAttribute("list", list);
		return "showAllGoods";
	}
	
	@RequestMapping(value = "querySKU")
	public void querySKU(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
	}

}
