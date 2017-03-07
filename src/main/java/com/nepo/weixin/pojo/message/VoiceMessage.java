package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class VoiceMessage extends BaseMessage {
	private SubVoiceMessage voice;
	public SubVoiceMessage getVoice() {
		return voice;
	}
	public void setVoice(SubVoiceMessage voice) {
		this.voice = voice;
	}
}
