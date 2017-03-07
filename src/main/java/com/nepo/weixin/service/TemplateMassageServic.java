package com.nepo.weixin.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gxufe.smarcampus.common.util.DateUtils;
import com.nepo.weixin.constants.GlobalConfig;
import com.nepo.weixin.constants.WeiXinConstants;
import com.nepo.weixin.pojo.TemplateContent;

public class TemplateMassageServic {
	public static final Logger logger=Logger.getLogger(TemplateMassageServic.class);
	
	/**
	 * 发送充值失败模板消息
	 * @author wcm
	 * @param String 充值失败原因
	 * @param String 充值金额
	 * @param String openid
	 * @param String 失败时间
	 * @return String 微信返回结果
	 */
	public static String templateRechargeFail(String msg,String tranAmt,String openid,String date){
		Map<String ,TemplateContent> data=new HashMap<String, TemplateContent>();
		data.put("first", new TemplateContent("您好，您有一笔充值资金没有成功。", "#ef0a1a"));
		data.put("keyword1", new TemplateContent(msg));
		data.put("keyword2", new TemplateContent(tranAmt+" 元"));
		data.put("keyword3", new TemplateContent(date));
		data.put("remark", new TemplateContent("如有疑问，请联系客服电话：4008113325"));
		String rs=WXInterfaceService.WXTemplateMassageService(openid, "tKO7tcJ71RpzHBf4AM7ePKSpm8GqgdTny7tn_3_SfJc", data, WeiXinConstants.TEMPLETE_RECHARGE_SUCCSSE_CALL_BACK_URL);
		return rs;
	}
	/**
	 * 发送充值成功模板消息
	 * @author wcm
	 * @param String 充值金额
	 * @param String openid
	 * @param String 充值成功时间
	 * @return String 微信返回结果
	 */
	public static String templateRechargeSuccess(String tranAmt,String openid,String date){
		Map<String ,TemplateContent> data=new HashMap<String, TemplateContent>();
		data.put("first", new TemplateContent(GlobalConfig.TEMPLETE_MASSAGE_RECHARGE_SUCCESS, "red"));
		data.put("keyword1", new TemplateContent(tranAmt+" 元"));
		data.put("keyword2", new TemplateContent(date));
		data.put("remark", new TemplateContent(GlobalConfig.CORPORATE_NAME));
		String rs=WXInterfaceService.WXTemplateMassageService(openid, "U8Y3aQmcfbk5C7lmj8CO5btDaMpyf_K77BleO23KgMA", data, WeiXinConstants.TEMPLETE_RECHARGE_SUCCSSE_CALL_BACK_URL);
		return rs;
	}
	/**
	 * 发送充值结果模板消息
	 * @author wcm
	 * @param String 充值金额
	 * @param String openid
	 * @param String 充值成功时间
	 * @return String 微信返回结果
	 */
	public static String templateRechargeResult(String tranAmt,String openid,String realName,String money,String rechargeWay,String bank,String rechargeState,String remark){
		Map<String ,TemplateContent> data=new HashMap<String, TemplateContent>();
		data.put("first", new TemplateContent(GlobalConfig.TEMPLETE_MASSAGE_RECHARGE_SUCCESS, "red"));
		data.put("keyword1", new TemplateContent(realName));
		data.put("keyword2", new TemplateContent(money));
		data.put("keyword3", new TemplateContent(rechargeWay));
		data.put("keyword4", new TemplateContent(bank));
		data.put("keyword5", new TemplateContent(rechargeState));
		if (null==remark||"".equals(remark)) {
			data.put("remark", new TemplateContent(GlobalConfig.CORPORATE_NAME));
		}
		else{
			data.put("remark", new TemplateContent(remark));
		}
		String rs=WXInterfaceService.WXTemplateMassageService(openid, "Kkvvr0Bd7woEZmU5qm7QOcq2zAHCGzNmTCgBWHdPbiI", data, WeiXinConstants.TEMPLETE_RECHARGE_SUCCSSE_CALL_BACK_URL);
		return rs;
	}
}
