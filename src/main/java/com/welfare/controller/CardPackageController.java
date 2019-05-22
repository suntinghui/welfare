package com.welfare.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
 * 卡包
 * 
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
	 * 
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
		ResponseObject<CardDetailRsp> resp = memberCardServiceImpl.getCardDetail(id);
		if (resp.getRespCode().equals("00")) {
			model.addAttribute("detail", resp.getData());
			return "cardPackageDetail";
		} else {
			model.addAttribute("resp", resp);
			return "result2";
		}

	}

	/**
	 * 激活
	 */
	@ResponseBody
	@RequestMapping("cardActive")
	public String cardActive(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseObject<String> resp = memberCardServiceImpl.getCardActive(id);
		return JSON.toJSONString(resp);
	}
	
	/**
	 * 是否设置密码。该方法用于卡片详情页面的转赠后的小提示。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkPwdTip")
	public String checkForCardPwd(HttpServletRequest request, HttpServletResponse response) {
		ResponseObject<String> resp = memberServiceImpl.checkForCardPwd();
		return JSON.toJSONString(resp);
	}

	/**
	 * 进入转赠。如果没有设置密码会先跳转到设置密码界面
	 * 
	 * @param cardNo
	 * @param model
	 * @return
	 */
	@RequestMapping("startCardGift")
	public String startCardGift(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("cardNo") String cardNo, Model model) {
		// 首先判断用户是否设置了密码
		ResponseObject<String> pwdResp = memberServiceImpl.checkForCardPwd();
		// 65:没有设置 00：已设置
		if (!pwdResp.getRespCode().equals("00")) {
			return "editPassword";
		}
		
		
		logger.info(request.getRequestURL().toString());
		// 注意：携带参数！！！ 否则会签名失败！！！
		String url = request.getRequestURL().toString() + "?id=" + id + "&cardNo=" + cardNo;
		logger.info("==============={}", url);

		Map<String, String> map = WXUtil.getConfig(url);
		WXShare share = new WXShare();
		share.setAppId(Constants.APPID);
		share.setNonceStr(map.get("nonceStr"));
		share.setTimestamp(map.get("timestamp"));
		share.setSignature(map.get("signature"));

		logger.info(share.toString());

		model.addAttribute("share", share);
		model.addAttribute("id", id);
		model.addAttribute("cardNo", cardNo);

		// 分享的链接，用户点开后会触发selectMemberCardById请求。
		// 加一个发送人的openid，一是知道是谁发送的，二是进入页面时使用该OPENID进行请求数据。
		model.addAttribute("link", Constants.WEIXIN_HOST + "selectMemberCardById?id=" + id + "&sendOpenId=" + DataUtil.getSessionData(Constants.kOPENID));

		return "cardGift";
	}

	/**
	 * 分享成功后调用转赠接口
	 * 
	 * @param cardNo
	 * @param mssage
	 * @param model
	 * @return
	 */
	@RequestMapping("cardGift")
	public String cardGift(@RequestParam("cardNo") String cardNo, @RequestParam("mssage") String mssage, Model model) {
		ResponseObject<CardGiftRsp> resp = memberCardServiceImpl.cardGift(cardNo, mssage);
		model.addAttribute("resp", resp);
		return "result2";
	}

	/**
	 * 生成付款码
	 */
	@ResponseBody
	@RequestMapping("payCode")
	public String getPayCode(HttpServletRequest request, HttpServletResponse response) {
		String cardNo = request.getParameter("cardNo");
		ResponseObject<PayCodeRsp> resp = memberCardServiceImpl.getCardPayCode(cardNo);
		return JSON.toJSONString(resp);
	}

	/**
	 * 分享后，由领取人点开触发的接口，然后打开领取页面
	 */
	@RequestMapping("selectMemberCardById")
	public String selectMemberCardById(@RequestParam("id") String id, @RequestParam("sendOpenId") String sendOpenId, Model model) {
		// 此处首先保存一个OPENID用于调接口。领取时要更换记录的OPENID。
		logger.info("发送人的OpenId - {}", sendOpenId);
		DataUtil.saveSessionData(Constants.kOPENID, sendOpenId);

		LinkDetailRsp detail = memberCardServiceImpl.selectMemberCardById(id);
		model.addAttribute("detail", detail);

		// 将领取卡做成可以获得微信CODE的链接
		String getCodeUrl = WXUtil.formatURLGetCode(Constants.WEIXIN_HOST + "receiveCard?id=" + id);
		model.addAttribute("link", getCodeUrl);
		return "receiveCard";
	}

	/**
	 * 领取卡
	 * 
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
		model.addAttribute("resp", resp);
		return "result2";
	}
	
	
	@ResponseBody
	@RequestMapping("verifyPwdCard")
	public String verifyPwdCardPwd(HttpServletRequest request, HttpServletResponse response) {
		String pwd = request.getParameter("pwd");
		ResponseObject<String> resp = memberServiceImpl.verifyPwdCard(pwd);
		return JSON.toJSONString(resp);
	}

}
