package com.welfare.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welfare.client.Constants;
import com.welfare.model.CardDetailRsp;
import com.welfare.model.CardGiftRsp;
import com.welfare.model.CardListResp;
import com.welfare.model.PayCodeRsp;
import com.welfare.pojo.WXShare;
import com.welfare.service.MemberCardService;
import com.welfare.service.MemberService;
import com.welfare.util.StringUtil;
import com.welfare.util.WXUtil;

/**
 *  卡包
 * @author SunTH
 *
 */
@Controller
public class CardPackageController {
	
	@Resource
	private MemberService memberServiceImpl;
	@Resource
	private MemberCardService memberCardServiceImpl;
	
	/**
	 * 查询卡包列表
	 * @param model
	 * @return
	 */
	@RequestMapping("cardPackageList")
	public String cardPackageList(HttpServletRequest request, Model model) {
		if (StringUtil.isEmpty(Constants.OPENID)) {
			WXUtil.getOpenID(request.getParameter("code"));
		}
		
		List<CardListResp> list = memberServiceImpl.getMemberCardListByOpenId();
		model.addAttribute("list", list);
		return "cardPackageList";
	}

	/**
	 * 选择某一卡，进入卡信息界面
	 */
	@RequestMapping("cardPackageDetail")
	public String cardPackageDetail(@RequestParam("id") int id, Model model) {
		CardDetailRsp detail = memberCardServiceImpl.getCardDetail(id);
		model.addAttribute("detail", detail);
		return "cardPackageDetail";
	}
	
	/**
	 * 激活
	 */
	@RequestMapping("cardActive")
	public String cardActive(@RequestParam("id") int id) {
		String str = memberCardServiceImpl.getCardActive(id);
		return "";
	}
	
	/**
	 * 进入转赠
	 * @param cardNo
	 * @param model
	 * @return
	 */
	@RequestMapping("startCardGift")
	public String startCardGift(HttpServletRequest request, Model model) {
		System.out.println(request.getRequestURL().toString());
		Map<String, String> map = WXUtil.getConfig(request.getRequestURL().toString());
		WXShare share = new WXShare();
		share.setAppId(Constants.APPID);
		share.setNonceStr(map.get("nonceStr"));
		share.setTimestamp(map.get("timestamp"));
		share.setSignature(map.get("signature"));
		
		System.out.println(share.toString());
		
		model.addAttribute("share", share);
		
		return "cardGift";
	}
	
	
	/**
	 * 转赠
	 * @param cardNo
	 * @param mssage
	 * @param model
	 * @return
	 */
	@RequestMapping("cardGift")
	public String cardGift(@RequestParam("cardNo ") String cardNo, @RequestParam("mssage") String mssage, Model model) {
		CardGiftRsp gift = memberCardServiceImpl.cardGift(cardNo, mssage);
		model.addAttribute("gift", gift);
		return "cardGift";
	}
	
	/**
	 * 生成付款码
	 */
	@RequestMapping("useCardQR")
	public String getPayCodeBar(@RequestParam("cardNo") String cardNo, Model model) {
		PayCodeRsp payCode = memberCardServiceImpl.getCardPayCode(cardNo);
		model.addAttribute("code", "2336639990501385568");
		return "useCardQR";
	}
	
	
	
	
}
