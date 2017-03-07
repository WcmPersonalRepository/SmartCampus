package com.nepo.weixin.aicha;

import java.net.URLEncoder;


/**
 * 片云网络短信API
 */
public class SmsPYApi {

	/**
	 * url
	 */
	private static String URL = "http://yunpian.com/v1/sms/send.json";


	private String apikey;

	public SmsPYApi() {
//		this("2388083cbae6bafa131444ac8b064d8f");
		this("131abbcf49d829d4b9f6ecda1746e7e2");
	}

	public SmsPYApi(String apikey) {
		this.apikey = apikey;
	}

	public String response(String mobile, String yzm) {
		try {
			String content = HttpUtils.postUrl(getUrl(mobile, yzm),null, null);
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 组装URL地址
	 */
	public String getUrl(String mobile, String yzm) {
		StringBuffer params = new StringBuffer(URL);
		params.append("?apikey=").append(apikey);
		params.append("&mobile=").append(mobile);
//		String msg =URLEncoder.encode("【卡乐极美#】欢迎使用卡乐极美官方微信公众号，您的手机验证码是" + yzm + "。本条信息无需回复");
		String msg ="【卡乐极美】欢迎使用卡乐极美官方微信公众号，您的手机验证码是"+yzm+"。本条信息无需回复";
		params.append("&text=").append(msg);
		return params.toString();
	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}

}
