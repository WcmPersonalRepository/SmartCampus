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
 * @author xpeng
 */
public class CoreService {
	private static Logger logger = LoggerFactory.getLogger(CoreService.class);
	/**
	 * 处理微信发来的请求(文本消息)
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
			for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
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
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respMessage = "您发送的是图片消息！";
				textMessage.setContent(respMessage);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respMessage = "您发送的是地理位置消息！";
				textMessage.setContent(respMessage);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respMessage = "您发送的是链接消息！";
				textMessage.setContent(respMessage);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respMessage = "您发送的是音频消息！";
				textMessage.setContent(respMessage);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");
				// 事件KEY值，与创建自定义菜单时指定的KEY值对应
				String eventKey = requestMap.get("EventKey");
				// 订阅-关注
				if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
					textMessage.setContent(textMessage.getContent());
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// 取消订阅-取消关注
				else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				} else if (MessageUtil.EVENT_TYPE_CLICK.equals(eventType)) {
					List<Article> articleList = new ArrayList<Article>();
					// 创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setFuncFlag(0);
					if (eventKey.equals("11")) {
						StringBuffer buffer = new StringBuffer();
						buffer.append(
							"飞象金云作为一家国际上领先的供应链融资技术服务商，基于高度自动化的信息登记平台和供应链融资平台，通过与信用良好、实力强大的核心企业和金融机构合作，为核心企业的供应商或分销商提供基于网络平台操作的供应链融资服务。 ")
								.append("\n");
						buffer.append("了解更多内容请回复序号：").append("\n");
						buffer.append("【1】 飞象简介").append("\n");
						buffer.append("【2】 飞象金云服务概览").append("\n");
						buffer.append("【3】 飞象金云系统简介").append("\n");
						buffer.append("【4】  业务流程").append("\n");
						textMessage.setContent(buffer.toString());
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("12")) {
						StringBuffer buffer = new StringBuffer();
						buffer.append(
							"核心企业收益：进一步开展赊销，优化运营资金，创造更多利润的同时获得更多收入。无须投入任何资金的同时提高了信息化水平。 资金方收益：核心企业每日对供应商付款带来稳定的存款；对核心企业的授信带来巨大的融资收入；核心企业带来大量的优质客户。 供应商收益：订单能变现金，投入生产盈利；只需账款质押，降低准入门槛；在线审核对账，实现事半功倍。 ")
								.append("\n");
						buffer.append("了解更多内容请回复序号： ").append("\n");
						buffer.append("【5】 核心企业收益").append("\n");
						buffer.append("【6】 资金方收益").append("\n");
						buffer.append("【7】 供应商收益").append("\n");
						textMessage.setContent(buffer.toString());
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("13")) {
						Article article1 = new Article();
						article1.setTitle("成功案例");
						article1.setDescription("飞象金云产品已经在世界范围内十余家银行中得到广泛应用。");
						article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3EoZJyWsMZx7feVlKeoXE5a5fJjUVicp88wab2m8QicibetUSMZfgVX6dUGw/0");
						article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200261785&idx=1&sn=b14065dafea9228b3954c8fa6aadfdfc#rd");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("14")) {
						StringBuffer buffer = new StringBuffer();
						buffer.append("全球领先的供应链金融系统提供商，实现融资服务的便捷与迅速，倡导合作共赢的愉悦与满足。").append("\n");
						buffer.append("了解更多内容请回复序号： ").append("\n");
						buffer.append("【8】 合作伙伴").append("\n");
						buffer.append("【9】 联系我们").append("\n");
						buffer.append("【10】 加入我们").append("\n\n");
						textMessage.setContent(buffer.toString());
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else if (eventKey.equals("15")) {
						Article article1 = new Article();
						article1.setTitle("常见问题");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/html/question.jsp");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("21")) {
						Article article1 = new Article();
						article1.setTitle("贷款查询 ");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("22")) {
						Article article1 = new Article();
						article1.setTitle("预存费用查询");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("23")) {
						Article article1 = new Article();
						article1.setTitle("可融资票据查询");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("31")) {
						Article article1 = new Article();
						article1.setTitle("会员申请");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("32")) {
						Article article1 = new Article();
						article1.setTitle("我要融资");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if (eventKey.equals("33")) {
						Article article1 = new Article();
						article1.setTitle("我要还款");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("http://www.finshare.cn/");
						articleList.add(article1);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					}
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
		// 单图文消息
		if ("1".equals(content)) {
			Article article = new Article();
			article.setTitle("关于我们");
			article.setDescription("作为国际上一家领先的供应链金融系统提供商，我们拥有经验丰富的专业技术团队。我们利用自己的技术搭建飞象金云供应链金融云平台，通过与信誉良好的国内核心企业及资金方合作，为核心企业的供应商提供细致入微的供应链融资服务。");
			article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3EoE0b3o5HDICJ859QiaUOCNHV76Q8QzuRhsDeE4MNuBOKoy2dzLwd2Yng/0");
			article.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200254003&idx=1&sn=17026f5b77e5e1aaf247cadf816b7ea1#rd");
			articleList.add(article);
			// 设置图文消息个数
			newsMessage.setArticleCount(articleList.size());
			// 设置图文消息包含的图文集合
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 单图文消息---不含图片
		else if ("2".equals(content)) {
			Article article = new Article();
			article.setTitle("飞象金云服务概览");
			// 图文消息中可以使用QQ表情、符号表情
			article.setDescription("全球领先的供应链金融系统提供商，实现融资服务的便捷与迅速，倡导合作共赢的愉悦与满足。");
			// 将图片置为空
			article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGr9eTya24VYbscyf6ibetTXiaNIpumqRw2aB2crSUsbux3gMibeUeGHbNiaAVtmjHRl5lVxv4YKEak79Q/0");
			article.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253894&idx=1&sn=2e64195625effc948fba3303ae64df3a#rd");
			articleList.add(article);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 多图文消息
		else if ("3".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("飞象金云系统简介");
			article1.setDescription("在线登记，流程自主把控；\n在线融资，安全更要高效。");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGqqlnKKjzuPb78fv1oFicmlqeHIfez8NAMWG3T5pOahZqOiaGbHvJxpuVvIibvqttjmOIVdIojB8ic49w/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253844&idx=1&sn=5d815f3665cb2c6699e4db07e061b529#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 多图文消息---首条消息不含图片
		else if ("4".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("业务流程");
			article1.setDescription("");
			article1.setPicUrl("https://mp.weixin.qq.com/cgi-bin/getimgdata?token=1287828907&msgid=&mode=small&source=file&fileId=200138636&ow=-1");
			Article article2 = new Article();
			article1.setTitle("业务流程");
			article1.setDescription("");
			article1.setPicUrl("https://mp.weixin.qq.com/cgi-bin/getimgdata?token=1287828907&msgid=&mode=small&source=file&fileId=200138635&ow=-1");
			int b = (int)(Math.random() * 2);
			if (b == 0) {
				articleList.add(article1);
			} else {
				articleList.add(article2);
			}
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 多图文消息---最后一条消息不含图片
		else if ("5".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("核心企业收益");
			article1.setDescription("进一步开展赊销，优化运营资金，\n创造更多利润的同时获得更多收入。\n无须投入任何资金的同时提高了信息化水平。");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGqqlnKKjzuPb78fv1oFicmlqnUkf1RqNAicPV03UQZ6Yhe3JZVFU1DPJrqWdqicDH3g6Jxz7eFYOuK7A/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253930&idx=1&sn=715877de7e348f9cb8e379d79c985843#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("6".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("资金方收益");
			article1.setDescription("核心企业每日对供应商付款带来稳定的存款；\n对核心企业的授信带来巨大的融资收入；\n核心企业带来大量的优质客户");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGqqlnKKjzuPb78fv1oFicmlqVoLeUU5wqXicjnpPXk0FXCOn1CI4tMHLrRP3ObKHSHqDribmKiaSZ1XYw/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253937&idx=1&sn=006f12b490baee8cbc9701a2183c4e4d#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("7".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("供应商收益");
			article1.setDescription("订单能变现金，投入生产盈利；\n只需账款质押，降低准入门槛；\n在线审核对账，实现事半功倍。");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGqqlnKKjzuPb78fv1oFicmlq7MHj5KadYd8Ou1xuSmo9VOT4tpoqgGVQ0icPFdSMS1PvX9xS1iaCS5IA/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253923&idx=1&sn=294b109cf6b6ccc4087678d1945ca585#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("8".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("合作伙伴");
			article1.setDescription("备受信耐的企业合作伙伴，值得拥有的供应链金融服务。");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3Eo2dlegicVBVd22Gd6SHYWicPcpdNTWvL9AjHhLotdQeR2DoKLWIpTPHJw/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253914&idx=1&sn=538df7c3ba9243b4d74f8a80a3be32f1#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("9".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("联系我们");
			article1.setDescription("公司名称：北京飞象金云信息技术有限公司\n电话：010-82781278\n邮箱：info@finshare.cn");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3Eoz8dfYD0gsQnHsBU5sPub8YraibcbJLBbJTYRTUEib25ZMfcwicWxzz47g/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200253956&idx=1&sn=df4622f2342c72e54939571582a1a328#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("16".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("高级Java工程师");
			article1.setDescription("高级Java工程师（国际银行贸易金融）\n您可以直接将简历投送到：\njob@finshare.cn");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3EoxYusmOvEzRkQbhI6TV7GtrI0pxtsmU4g21vVg278txBUB7YB61BA0A/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200255107&idx=1&sn=1800ab68d80e181e3b268240b804ce3f#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("17".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("Application Support（软件技术支持）​");
			article1.setDescription("Application Support（软件技术支持）\n您可以直接将简历投送到：\njob@finshare.cn");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3EoGnqQLBw7PHbuwSnETEZU1DNtRaibxwxibWMybvuZjEZXo8RVlELcDXFg/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200261541&idx=1&sn=71f227562dadbf7c0d3ce97fb89eeec4#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("18".equals(content)) {
			Article article1 = new Article();
			article1.setTitle("技术支持/运维工程师");
			article1.setDescription("技术支持/运维工程师\n您可以直接将简历投送到：\njob@finshare.cn");
			article1.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/zBhlh3ndTGp12OD3Vyj3q72gcicxCW3EoQaIPiaZLpaybWBDTtDKQzNliab8Sbce7njjqZRzFVul4EQrcMZUJ8rBg/0");
			article1.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQ1NjMyMw==&mid=200261543&idx=1&sn=54e395f773a0768600dce5bcb42a1612#rd");
			articleList.add(article1);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		} else if ("10".equals(content)) {
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			StringBuffer buffer = new StringBuffer();
			buffer.append("人尽其才则百事兴，飞象金云欢迎有识之士加入，共同推动中国供应链金融的发展。 您可以直接将简历投送到：job@cn.premiumit.com").append("\n");
			buffer.append("更多内容请回复序号：").append("\n");
			buffer.append("【16】高级Java工程师（国际银行贸易金融）").append("\n");
			buffer.append("【17】ApplicationSupport（软件技术支持）").append("\n");
			buffer.append("【18】技术支持/运维工程师").append("\n");
			textMessage.setContent(buffer.toString());
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} else if ("?".equals(content)) {
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
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
	/**
	 * robot的主菜单
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("您好，欢迎关注飞象金云供应商融资平台！飞象金云作为国际上一家领先的供应链金融系统提供商，致力于通过与信誉良好的国内核心企业及资金方合作，为核心企业的供应商提供细致入微的供应链融资服务。")
				.append("\n\n");
		buffer.append("回复以下数字可获取其它信息。").append("\n");
		buffer.append("【1】 关于我们").append("\n");
		buffer.append("【2】 飞象金云服务概览").append("\n");
		buffer.append("【3】 飞象金云系统简介").append("\n");
		buffer.append("【4】 业务流程").append("\n");
		buffer.append("【5】 核心企业收益").append("\n");
		buffer.append("【6】 资金方收益").append("\n");
		buffer.append("【7】 供应商收益").append("\n");
		buffer.append("【8】 合作伙伴").append("\n");
		buffer.append("【9】 联系我们").append("\n");
		buffer.append("【10】 加入我们").append("\n");
		buffer.append("回复?显示此帮助菜单");
		return buffer.toString();
	}
}
