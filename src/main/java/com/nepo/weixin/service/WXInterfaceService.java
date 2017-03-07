package com.nepo.weixin.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.NetUtils;
import com.gxufe.smarcampus.common.util.SessionUtils;
import com.nepo.weixin.constants.WeiXinConstants;
import com.nepo.weixin.pojo.TemplateContent;
import com.nepo.weixin.pojo.TemplteMassage;
import com.nepo.weixin.thread.TokenThread;

public class WXInterfaceService {
	private static Logger logger=Logger.getLogger(WXInterfaceService.class);
	
	/**
	 * 微信模板消息接口调用封装
	 * @author wcm
	 * @param HttpServletRequest
	 * @param String 模板消息id
	 * @param Map<String, TemplateContent> 模板消息的内容
	 * @param String 回调url必须是已http://或https://开头
	 * return String 微信返回的json数据结果
	 * */
	
	public static String WXTemplateMassageService(HttpServletRequest request,String template_id,Map<String, TemplateContent> map,String callBackUrl){
		if (template_id==null||map==null||callBackUrl==null) {
			return null;
		}
		String url = WeiXinConstants.SEND_TEMPLETE_MASSAGE_URL.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
		String openid=SessionUtils.getWXUserBySession(request).getOpenid();
		TemplteMassage templteMassage=new TemplteMassage(openid, template_id, callBackUrl, map);
		String data=JsonUtils.objectToJson(templteMassage);
		logger.info("[微信模板消息发送数据]="+data);
		String rs=null;
		try {
			rs=NetUtils.doPostData(data, url);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("网络异常");
			return null;
		}
		return rs;
	}
	/**
	 * 微信模板消息接口调用封装
	 * @author wcm
	 * @param String openid
	 * @param String 模板消息id
	 * @param Map<String, TemplateContent> 模板消息的内容
	 * @param String 回调url必须是已http://或https://开头
	 * return String 微信返回的json数据结果
	 * */
	
	public static String WXTemplateMassageService(String openid,String template_id,Map<String, TemplateContent> map,String callBackUrl){
		if (template_id==null||map==null||callBackUrl==null) {
			return null;
		}
		String url = WeiXinConstants.SEND_TEMPLETE_MASSAGE_URL.replace("ACCESS_TOKEN", TokenThread.accessToken.getToken());
		TemplteMassage templteMassage=new TemplteMassage(openid, template_id, callBackUrl, map);
		String data=JsonUtils.objectToJson(templteMassage);
		logger.info("[微信模板消息发送数据]="+data);
		String rs=null;
		try {
			rs=NetUtils.doPostData(data, url);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("网络异常");
			return null;
		}
		return rs;
	}
}
