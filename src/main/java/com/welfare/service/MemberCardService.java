package com.welfare.service;

import com.welfare.model.CardDetailRsp;
import com.welfare.model.CardGiftRsp;
import com.welfare.model.PayCodeRsp;

public interface MemberCardService {
	
	/**
	 * 激活卡
	 */
	public String getCardActive(int id) ;
	
	/**
	 * 查询卡详情接口
	 * @return
	 */
	public CardDetailRsp getCardDetail(int id);
	
	/**
	 * 转赠
	 * @param card
	 * @param message
	 * @return
	 */
	public CardGiftRsp cardGift(String card, String message);
	
	/**
	 * 生成付款码
	 * @param cardNo
	 * @return
	 */
	public PayCodeRsp getCardPayCode(String cardNo);
	

}
