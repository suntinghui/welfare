package com.welfare.service;

import java.util.HashMap;

import com.welfare.model.CardDetailRsp;
import com.welfare.model.CardGiftRsp;
import com.welfare.model.LinkDetailRsp;
import com.welfare.model.PayCodeRsp;
import com.welfare.model.ResponseObject;

public interface MemberCardService {

	/**
	 * 激活卡
	 */
	public String getCardActive(int id);

	/**
	 * 查询卡详情接口
	 * 
	 * @return
	 */
	public CardDetailRsp getCardDetail(int id);

	/**
	 * 转赠
	 * 
	 * @param card
	 * @param message
	 * @return
	 */
	public CardGiftRsp cardGift(String card, String message);

	/**
	 *  取消转赠接口
	 * @param id
	 * @return
	 */
	public String cancelCardGift(String id);

	/**
	 * 生成付款码
	 * 
	 * @param cardNo
	 * @return
	 */
	public PayCodeRsp getCardPayCode(String cardNo);
	
	/**
	 * 查看连接接口
	 * @param id
	 * @return
	 */
	public LinkDetailRsp selectMemberCardById(String id);
	
	/**
	 * 领取卡
	 */
	public ResponseObject<String> receiveCard(String id);
	
}
