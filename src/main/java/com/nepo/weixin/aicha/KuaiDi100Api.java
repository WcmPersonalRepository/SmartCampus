package com.nepo.weixin.aicha;

import org.apache.log4j.Logger;

import com.nepo.weixin.constants.WeiXinConstants;

/**
 * 爱查快递API
 */
public class KuaiDi100Api {

	private static Logger logger = Logger.getLogger(KuaiDi100Api.class);
	/**
	 * url
	 */
	private static String URL = "http://api.kuaidi100.com/api";

	/**
	 * 数据返回格式
	 */
	private static String DEFAULT_TYPE_JSON = "json";

	private String id;


	public KuaiDi100Api() {
		this("635de2547a7dd7e0");
	}

	public KuaiDi100Api(String id) {
		this.id = id;
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
		params.append("&com=").append(com);
		params.append("&nu=").append(nu);
		params.append("&order=desc");

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


}
