package com.nepo.weixin.message.req;
/**
 * 请求消息——文本消息
 * @author xpeng
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
