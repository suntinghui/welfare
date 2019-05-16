package com.welfare.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welfare.model.City;
import com.welfare.model.Goods;
import com.welfare.model.GoodsSKU;
import com.welfare.service.CityService;
import com.welfare.service.GoodsService;

@Controller
public class BuyCardController {
	
	@Resource
	private GoodsService goodsServiceImpl;
	@Resource
	private CityService cityServiceImpl;
	
	@RequestMapping(value = "queryAllGoods")
	public String queryAllGoods(Model model) {
		List<Goods> list = goodsServiceImpl.selectList();
		model.addAttribute("list", list);
		return "showAllGoods";
	}
	
	@RequestMapping(value = "querySKU")
	public String querySKU(@RequestParam("idGoods") String idGoods, Model model) throws Exception {
		List<GoodsSKU> skuList = goodsServiceImpl.selectSKUById(Integer.parseInt(idGoods));
		model.addAttribute("skuList", skuList);
		
		List<City> cityList = cityServiceImpl.queryAll();
		model.addAttribute("cityList", cityList);
		
		return "buyCard";
	}

}
