package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class VideoMessage extends BaseMessage {
	private SubVideoMessage video;
	public SubVideoMessage getVideo() {
		return video;
	}
	public void setVideo(SubVideoMessage video) {
		this.video = video;
	}
}
