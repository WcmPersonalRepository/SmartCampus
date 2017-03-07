package com.nepo.weixin.util;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.nepo.weixin.constants.WeiXinConstants;
@SuppressWarnings("deprecation")
public class MenuUtil {
	// http客户端
	public static DefaultHttpClient httpclient;
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient)HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	/**
	 * 创建菜单
	 */
	public static String createMenu(String params, String accessToken)
		throws Exception {
		String requestUrl = WeiXinConstants.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost httpost = HttpClientConnectionManager.getPostMethod(requestUrl);
		httpost.setEntity(new StringEntity(params, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject demoJson = new JSONObject(jsonStr);
		return demoJson.getString("errmsg");
	}
	/**
	 * 获取accessToken
	 */
	public static String getAccessToken(String appid, String secret)
		throws Exception {
		String requestUrl = WeiXinConstants.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", secret);
		HttpGet get = HttpClientConnectionManager.getGetMethod(requestUrl);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject demoJson = new JSONObject(jsonStr);
		return demoJson.getString("access_token");
	}
	/**
	 * 查询菜单
	 */
	public static String getMenuInfo(String accessToken)
		throws Exception {
		String requestUrl = WeiXinConstants.MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
		HttpGet get = HttpClientConnectionManager.getGetMethod(requestUrl);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		return jsonStr;
	}
	/**
	 * 删除菜单
	 */
	public static String deleteMenuInfo(String accessToken)
		throws Exception {
		String requestUrl = WeiXinConstants.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		HttpGet get = HttpClientConnectionManager.getGetMethod(requestUrl);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject demoJson = new JSONObject(jsonStr);
		return demoJson.getString("errmsg");
	}
	/*
	 * 测试
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"button\":[");
		sb.append("     {");
		sb.append("         \"name\":\"第一个菜单\","); // 第一个菜单
		sb.append("         \"sub_button\":[");
		sb.append("             {");
		sb.append("                 \"type\":\"click\",");
		sb.append("                 \"name\":\"子菜单1\",");
		sb.append("                 \"key\":\"M1\"");
		sb.append("             },");
		sb.append("             {");
		sb.append("                 \"type\":\"click\",");
		sb.append("                 \"name\":\"子菜单2\",");
		sb.append("                 \"key\":\"M2\"");
		sb.append("             },");
		sb.append("             {");
		sb.append("                 \"type\":\"click\",");
		sb.append("                 \"name\":\"子菜单3\",");
		sb.append("                 \"key\":\"M3\"");
		sb.append("             }");
		sb.append("         ]");
		sb.append("     },");
		sb.append("     {");
		sb.append("         \"name\":\"第二个菜单\",");
		sb.append("         \"sub_button\":[");
		sb.append("             {");
		sb.append("                 \"type\":\"click\",");
		sb.append("                 \"name\":\"子菜单\",");
		sb.append("                 \"key\":\"M4\"");
		sb.append("             }");
		sb.append("         ]");
		sb.append("     },");
		sb.append("     {");
		sb.append("         \"name\":\"URL菜单\","); // URL 连接
		sb.append("         \"sub_button\":[");
		sb.append("             {");
		sb.append("                 \"type\":\"view\",");
		sb.append("                 \"name\":\"无主题\",");
		sb.append("                 \"url\":\"http://www.wuzhuti.cn\","); // 连接地址
		sb.append("             }");
		sb.append("         ]");
		sb.append("     }");
		sb.append(" ]");
		sb.append("}");
		try {
			// 获取accessToken -参数appid，secret
			String accessToken = getAccessToken(WeiXinConstants.APP_ID, WeiXinConstants.APP_SECRET);
			String res = "";
			res = createMenu(sb.toString(), accessToken);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}