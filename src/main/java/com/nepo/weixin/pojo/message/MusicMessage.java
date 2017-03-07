package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class MusicMessage extends BaseMessage {
	private SubMusicMessage music;
	public SubMusicMessage getMusic() {
		return music;
	}
	public void setMusic(SubMusicMessage music) {
		this.music = music;
	}
}
