package com.nepo.weixin.pojo.message;
/**
 * 文本消息
 * @author xpeng
 */
public class NewsMessage extends BaseMessage {
	private SubNewsMessage news;
	public SubNewsMessage getNews() {
		return news;
	}
	public void setNews(SubNewsMessage news) {
		this.news = news;
	}
}
