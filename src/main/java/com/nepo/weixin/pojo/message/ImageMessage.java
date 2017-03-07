package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class ImageMessage extends BaseMessage {
	private SubImageMessage image;
	public SubImageMessage getImage() {
		return image;
	}
	public void setImage(SubImageMessage image) {
		this.image = image;
	}
}
