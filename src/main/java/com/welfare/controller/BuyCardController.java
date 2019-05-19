package com.welfare.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welfare.client.Constants;
import com.welfare.model.City;
import com.welfare.model.Goods;
import com.welfare.model.GoodsSKU;
import com.welfare.service.CityService;
import com.welfare.service.GoodsService;
import com.welfare.service.OrderService;
import com.welfare.util.StringUtil;
import com.welfare.util.WXUtil;

@Controller
public class BuyCardController {

	@Resource
	private GoodsService goodsServiceImpl;
	@Resource
	private CityService cityServiceImpl;
	@Resource
	private OrderService orderServiceImpl;

	@RequestMapping(value = "queryAllGoods")
	public String queryAllGoods(HttpServletRequest request, Model model) {
		WXUtil.getOpenID(request.getParameter("code"));
		
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
		model.addAttribute("idGoods", idGoods);

		return "buyCard";
	}

	@RequestMapping(value = "orderAdd")
	public String orderAdd(@RequestParam("count") String count, @RequestParam("type") String type, @RequestParam("jv") String jv, @RequestParam("idSku") String idSku, @RequestParam("typeBuy") String typeBuy, @RequestParam("priceSale") String priceSale, @RequestParam("idGoods") String idGoods, Model model) {
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("count", count);
		paramMap.put("type", type);
		paramMap.put("jv", jv);
		paramMap.put("idSku", idSku);
		paramMap.put("typeBuy", typeBuy);
		paramMap.put("priceSale", priceSale);
		paramMap.put("idGoods", idGoods);
		orderServiceImpl.add(paramMap);
		return "result";
	}
	
	@RequestMapping(value = "showQRCode")
	public String showQRCode(Model model) throws Exception {

		return "useCardQR";
	}

}
