package com.nepo.weixin.aicha;

import org.apache.log4j.Logger;

import com.nepo.weixin.constants.WeiXinConstants;

/**
 * 爱查快递API
 */
public class IckdApi {

	private static Logger logger = Logger.getLogger(IckdApi.class);
	/**
	 * url
	 */
	private static String URL = "http://api.ickd.cn/";

	/**
	 * 数据返回格式
	 */
	private static String DEFAULT_TYPE_JSON = "json";

	private String id;

	private String secret;

	private String type;

	public IckdApi() {
		this("107733", "363464476ec74d77898f5aade4a5ff88");
	}

	public IckdApi(String id, String secret) {
		this.id = id;
		this.secret = secret;
		this.type = DEFAULT_TYPE_JSON;
	}

	public String response(String com, String nu) {
		String url = getUrl(com, nu);
		try {
			String content = HttpUtils.getUrl(url, WeiXinConstants.ENCODING);
			logger.debug(content);
			return content;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	/**
	 * 组装URL地址
	 */
	public String getUrl(String com, String nu) {
		StringBuffer params = new StringBuffer(URL);
		params.append("?id=").append(id);
		params.append("&secret=").append(secret);
		params.append("&com=").append(com);
		params.append("&nu=").append(nu);
		params.append("&type=").append(type);
		params.append("&encode=").append(WeiXinConstants.ENCODING);
		params.append("&ord=desc");

		return params.toString();
	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
