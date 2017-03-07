package com.nepo.weixin.message.req;
/**
 * 请求消息——图片消息
 * @author xpeng
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
