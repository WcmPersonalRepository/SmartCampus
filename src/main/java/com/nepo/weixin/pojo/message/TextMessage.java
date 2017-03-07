package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class TextMessage extends BaseMessage {
	private SubTextMessage text;
	public SubTextMessage getText() {
		return text;
	}
	public void setText(SubTextMessage text) {
		this.text = text;
	}
}
