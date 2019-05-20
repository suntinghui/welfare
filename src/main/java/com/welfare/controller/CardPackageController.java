package com.welfare.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Data;
import com.welfare.client.Constants;
import com.welfare.model.CardDetailRsp;
import com.welfare.model.CardGiftRsp;
import com.welfare.model.CardListResp;
import com.welfare.model.LinkDetailRsp;
import com.welfare.model.PayCodeRsp;
import com.welfare.model.ResponseObject;
import com.welfare.pojo.WXShare;
import com.welfare.service.MemberCardService;
import com.welfare.service.MemberService;
import com.welfare.util.DataUtil;
import com.welfare.util.StringUtil;
import com.welfare.util.WXUtil;

/**
 *  卡包
 * @author SunTH
 *
 */
@Controller
public class CardPackageController {
	
	private static final Logger logger = LoggerFactory.getLogger(CardPackageController.class);
	
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
		WXUtil.saveLocalOpenID(request.getParameter("code"));
		
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
		ResponseObject<String> resp = memberCardServiceImpl.getCardActive(id);
		
		return "";
	}
	
	/**
	 * 进入转赠
	 * @param cardNo
	 * @param model
	 * @return
	 */
	@RequestMapping("startCardGift")
	public String startCardGift(HttpServletRequest request,@RequestParam("id") int id , Model model) {
		logger.info(request.getRequestURL().toString());
		// 注意：携带参数！！！  否则会签名失败！！！
		String url = request.getRequestURL().toString()+"?id="+id;
		logger.info("==============={}", url);
		
		logger.info("_+_+_+{}",request.getParameter("code"));
		
		Map<String, String> map = WXUtil.getConfig(url);
		WXShare share = new WXShare();
		share.setAppId(Constants.APPID);
		share.setNonceStr(map.get("nonceStr"));
		share.setTimestamp(map.get("timestamp"));
		share.setSignature(map.get("signature"));
		
		System.out.println(share.toString());
		
		model.addAttribute("share", share);
		model.addAttribute("id", id);
		
		// 分享的链接，用户点开后会触发selectMemberCardById请求。
		// 加一个发送人的openid，一是知道是谁发送的，二是进入页面时使用该OPENID进行请求数据。
		model.addAttribute("link", Constants.WEIXIN_HOST+"selectMemberCardById?id="+id+"&sendOpenId="+DataUtil.getSessionData(Constants.kOPENID));
		
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
	@RequestMapping("payCode")
	public String getPayCode(@RequestParam("cardNo") String cardNo, Model model) {
		//PayCodeRsp payCode = memberCardServiceImpl.getCardPayCode(cardNo);
		model.addAttribute("payCode", "2336639990501385568");
		model.addAttribute("cardNo", "6226200102917466");
		model.addAttribute("balance", "1000");
		return "payCode";
	}
	
	/**
	 *  分享后，由领取人点开触发的接口，然后打开领取页面
	 */
	@RequestMapping("selectMemberCardById")
	public String selectMemberCardById(@RequestParam("id") String id, @RequestParam("sendOpenId") String sendOpenId , Model model) {
		// 此处首先保存一个OPENID用于调接口。领取时要更换记录的OPENID。
		logger.info("发送人的OpenId - {}", sendOpenId);
		DataUtil.saveSessionData(Constants.kOPENID, sendOpenId);
		
		LinkDetailRsp detail = memberCardServiceImpl.selectMemberCardById(id);
		model.addAttribute("detail", detail);
		
		// 将领取卡做成可以获得微信CODE的链接
		String getCodeUrl = WXUtil.formatURLGetCode(Constants.WEIXIN_HOST+"receiveCard?id="+id);
		model.addAttribute("link", getCodeUrl);
		return "receiveCard";
	}
	
	/**
	 * 领取卡
	 * @return
	 */
	@RequestMapping("receiveCard")
	public String receiveCard(HttpServletRequest request, @RequestParam("id") String id, Model model) {
		String code = request.getParameter("code");
		// 领取人的OPENID
		String receiveOpenId = WXUtil.getOpenID(code);
		logger.info("领取人的OPENID - {}", receiveOpenId);
		DataUtil.saveSessionData(Constants.kOPENID, receiveOpenId);
		
		ResponseObject<String> resp = memberCardServiceImpl.receiveCard(id);
		model.addAttribute("result", resp.getRespCode());
		return "result";
	}
	
	
	
}

