package com.nepo.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nepo.weixin.message.resp.Article;
import com.nepo.weixin.message.resp.NewsMessage;
import com.nepo.weixin.message.resp.TextMessage;
import com.nepo.weixin.util.MessageUtil;

/**
 * 微信核心服务类
 * 
 * @author xpeng
 */
public class SmartCampusCoreService {
	private static Logger logger = LoggerFactory
			.getLogger(SmartCampusCoreService.class);

	/**
	 * 处理微信发来的请求(文本消息)
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		// 默认返回的文本消息内容
		String respMessage = "请求处理异常，请稍候尝试！";
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 循环遍历微信消息内容
			Set<Map.Entry<String, String>> set = requestMap.entrySet();
			System.out.println("=======:微信-->服务器的信息:\n");
			for (Iterator<Map.Entry<String, String>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) it
						.next();
				logger.info(entry.getKey() + "--->" + entry.getValue());
			}
			// 默认回复此文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义
			textMessage.setContent(getMainMenu());
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respMessage = "您发送的是文本消息！";
				respMessage = getRespMessage(requestMap);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");
				// 订阅-关注
				if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
					textMessage.setContent(textMessage.getContent());
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// 取消订阅-取消关注
				else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 微信上传地理位置
				else if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(eventType
						.toLowerCase())) {
					return "";
				} else if (MessageUtil.EVENT_TYPE_CLICK.equals(eventType)) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}


	private static String getRespMessage(Map<String, String> requestMap) {
		String respMessage = "请求处理异常，请稍候尝试！";
		List<Article> articleList = new ArrayList<Article>();
		// 接收用户发送的文本消息内容
		String content = requestMap.get("Content");
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 创建图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		if ("?".equals(content) || "？".equals(content)) {
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			textMessage.setContent(getMainMenu());
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}
		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}

	/**
	 * robot的主菜单
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("欢迎关注我要金蛋网").append("");
		return buffer.toString();
	}


}
