package com.nepo.weixin.pojo.message;
import java.util.ArrayList;
/**
 * 文本消息
 * @author xpeng
 */
public class SubNewsMessage {
	// 回复的消息内容
	private ArrayList<Article> articles;
	public ArrayList<Article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
}
