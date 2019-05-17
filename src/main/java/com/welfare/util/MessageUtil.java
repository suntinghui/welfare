package com.welfare.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.welfare.pojo.Image;
import com.welfare.pojo.ImageMessage;
import com.welfare.pojo.News;
import com.welfare.pojo.NewsMessage;
import com.welfare.pojo.TextMessage;
/**
 * 消息封装类
 *
 */
public class MessageUtil {	
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}
	
	/**
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	/**
	 * 为防止出现“该公众号提供的服务出现故障，请稍候重试”
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String defaultText(String toUserName,String fromUserName) {
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent("默认提示");
		return textMessageToXml(text);
	}
	
	/**
	 * 关注事件 SUBSCRIBE
	 * @return
	 */
	public static String subscribeText(){
		StringBuffer sb = new StringBuffer();
		sb.append("终于等到你。。。\n\n");
		sb.append("欢迎您关注预付卡福利社。");
		return sb.toString();
	}
	
	// 点击客服服务菜单后的回复
	public static String customerServiceText() {
		StringBuffer sb = new StringBuffer();
		sb.append("请输入以下数字序号，选择您需要的客服服务的业务类型：\n");
		sb.append("[1]卡片使用\n");
		sb.append("[2]卡片转赠说明\n");
		sb.append("[3]退卡规则\n");
		sb.append("[4]电子发票\n");
		sb.append("[5]退货\n");
		sb.append("[6]激活类\n");
		return sb.toString();
	}
	
	/**
	 * 卡片使用
	 * @return
	 */
	public static String customerServiceReplyText_1() {
		StringBuffer sb = new StringBuffer();
		sb.append("（1） 关注“Carrefour福利社”—家乐福卡—卡包中使用；或在微信卡包中使用；\n");
		sb.append("（2） 卡片有效期为三年；\n");
		sb.append("（3） 2018年12月28日之后购买的卡片，没有红包和充值功能；\n");
		sb.append("（4） 个人购卡量：每单限额 / 活动期间限额；\n");
		sb.append("（5） 如发现卡片添加不了微信卡包，可能是您微信卡包里卡片过多， 请在福利社的卡包里使用；\n");
		sb.append("（6） 如卡片已添加到微信卡包，但卡片没有显示卡号，请尝试先删除微信卡包里的卡片，重新添加一次 ，或致电客服为您查看；\n");
		sb.append("（7） 如您还有其他问题，请拨打客服电话：400-8086-217。\n");
		return sb.toString();
	}
	
	/**
	 * 卡片转赠说明
	 * @return
	 */
	public static String customerServiceReplyText_2() {
		StringBuffer sb = new StringBuffer();
		sb.append("（1） 在卡片管理功能中，将可使用的卡片加入微信卡包，可转赠给微信好友。关注“Carrefour福利社”—卡包—点击卡片—转赠（红包）—转赠—设置密码—点击好友；\n");
		sb.append("（2） 进行转赠前需先设置转赠密码；\n");
		sb.append("（3） 12月28日之后购买的卡片，前两次转赠基于微信号转赠，以后则通过受赠人手机号转赠，受赠人会收到一条转赠短信，依照短信内的指引领取；\n");
		sb.append("（4） “零”元卡不能以任何方式转赠；\n");
		sb.append("（5） 转赠的卡片可在卡片右下角点击取消转赠；\n");
		sb.append("（6） 转赠的卡片好友未领取，或未点击好友返回的，卡片会显示“转赠中”，如对方未领取，卡片将在24小时后原路退回您的卡包；\n");

		return sb.toString();
	}
	
	/**
	 * 退卡规则
	 * @return
	 */
	public static String customerServiceReplyText_3() {
		StringBuffer sb = new StringBuffer();
		sb.append("（1）在“家乐福卡”内选择“个人中心”-“退卡”；\n");
		sb.append("（2）退卡时间：5个工作日；退卡申请提交后不能取消，如有需要，请重新购买；\n");
		sb.append("（3）退卡条件：卡片属于原购买人，并且购买的电子卡未发生消费/转赠操作，可在线上办理退卡；若购买的电子卡已发生上述操作，则无法退卡；\n");
		sb.append("（4）退卡金额：按照购卡的实际金额退现，现金退回到购买人的微信钱包；\n");
		sb.append("（5）如已开票，则无法退卡；\n");
		sb.append("（6）退卡需要提供：手机号、卡号（退卡时自动上传），上传身份证正反面及微信订单号的截图；\n");
		sb.append("（7）如您还有其他问题，请拨打客服电话：400-8086-217。\n");
		return sb.toString();
	}
	
	/**
	 * 电子发票
	 * @return
	 */
	public static String customerServiceReplyText_4() {
		StringBuffer sb = new StringBuffer();
		sb.append("（1）开票时间：7个自然日内通过邮件发送；\n");
		sb.append("（2）开票条件：只能原购买人申请，并且无退卡，发票开出后，无法退卡；\n");
		sb.append("（3）开票单位：途皓（北京）商务服务有限公司；\n");
		sb.append("（4）发票内容：单用途预付费卡；\n");
		sb.append("（5）发票形式：我方只提供电子发票，请注意查看您的邮箱；\n");
		sb.append("（6）如您还有其他问题，请拨打客服电话：400-8086-217。\n");
		return sb.toString();
	}
	
	/**
	 * 退货
	 * @return
	 */
	public static String customerServiceReplyText_5() {
		StringBuffer sb = new StringBuffer();
		sb.append("（1） 请到家乐福原购买门店服务台遵从服务员的指引办理退货；\n");
		sb.append("（2） 请关注“Carrefour福利社”—个人中心—退货—点击交易订单，出示条码给店员操作；\n");
		sb.append("（3） 对于客户反应不能退货的，请及时联系客服处理，并提供客户电话/城市/门店信息；（4） 如您还有其他问题，请拨打客服电话：400-8086-217。\n");
		return sb.toString();
	}
	
	/**
	 * 激活类
	 * @return
	 */
	public static String customerServiceReplyText_6() {
		StringBuffer sb = new StringBuffer();
		sb.append("由于系统和网络原因，卡片激活在3小时以内均属正常，请在网络环境良好的情况下使用卡片，并自行通过刷新解决问题。如您还有其他问题，请拨打客服电话：400-8086-217。\n");
		return sb.toString();
	}
	
	
	
	/**
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("慕课网介绍");
		news.setDescription("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。");
		news.setPicUrl("http://zapper.tunnel.mobi/Weixin/image/imooc.jpg");
		news.setUrl("www.imooc.com");
		
		newsList.add(news);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = newsMessageToXml(newsMessage);
		return message;
	}
	
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message = null;
		Image image = new Image();
		image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}
	
}
