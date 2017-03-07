package com.nepo.weixin.util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.NetUtils;
import com.nepo.weixin.constants.WeiXinConstants;
import com.nepo.weixin.pojo.AccessToken;
import com.nepo.weixin.pojo.Menu;
import com.nepo.weixin.pojo.UserInfoAccessToken;
import com.nepo.weixin.pojo.message.SubTextMessage;
import com.nepo.weixin.pojo.message.TextMessage;
/**
 * 公众平台通用接口工具类
 * @author xpeng
 */
public class WeixinUtil {
	private static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);
	/**
	 * 发起https请求并获取结果
	 * @param requestUrl
	 *        请求地址
	 * @param requestMethod
	 *        请求方式（GET、POST）
	 * @param outputStr
	 *        提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new WeixinX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			// 兼容GET、POST两种方式；
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 兼容有数据提交、无数据提交两种情况，也有相当一部分人不知道如何POST提交数据；
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return jsonObject;
	}
	/**
	 * 获取access_token
	 * @param appid
	 *        凭证
	 * @param appsecret
	 *        密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;
		String requestUrl = WeiXinConstants.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
					jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}
	/**
	 * 处理access_token过期类
	 */
	public static String getAccessToken() {
		AccessToken accessToken = getAccessToken(WeiXinConstants.APP_ID, WeiXinConstants.APP_SECRET);
		if (accessToken != null) {
			return accessToken.getToken();
		}
		return null;
	}
	/**
	 * 创建菜单
	 * @param menu
	 *        菜单实例
	 * @param accessToken
	 *        有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单的url
		String url = WeiXinConstants.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
					jsonObject.getString("errmsg"));
			}
		}
		return result;
	}
	/**
	 * 判断是否是QQ表情
	 * @param content
	 * @return
	 */
	public static boolean isQqFace(String content) {
		boolean result = false;
		// 判断QQ表情的正则表达式
		String qqfaceRegex =
			"/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}
	/**
	 * 指定openId用户发送客服消息的方法
	 * @param type
	 *        必选 文本 图片 语音 视频 音乐 图文
	 * @param openId
	 *        必选 用户ID
	 * @param text
	 *        文本内容 ,图片Id ,语音Id
	 * @param title
	 *        可选 视频的标题
	 * @param description
	 *        可选 视频视频描述
	 * @return
	 */
	public static boolean sendMsgToOpenId(String type, String openId, String text, String title, String description) {
		if (openId == null || "".equals(openId) || text == null || "".equals(text) || type == null || "".equals(type)) {
			return false;
		}
		// 发送文本消息
		if (MessageUtil.RESP_MESSAGE_TYPE_TEXT.equals(type)) {
			return sendTextMsg(type, openId, text);
		}
		// 发送图片消息
		if (MessageUtil.RESP_MESSAGE_TYPE_IMAGE.equals(type)) {
			return sendMediaMsg(type, openId, text);
		}
		// 发送语音消息
		if (MessageUtil.RESP_MESSAGE_TYPE_VOICE.equals(type)) {
			return sendMediaMsg(type, openId, text);
		}
		// 发送视频消息
		if (MessageUtil.RESP_MESSAGE_TYPE_VIDEO.equals(type)) {
			return sendVideoMsg(type, openId, text, title, description);
		}
		// 发送音乐消息 单独方法 sendMusicMsg()
		// 发送图文信息 单独方法sendNewMsg()
		return false;
	}
	/**
	 * 发送文本客服信息
	 * @param openId
	 *        必须
	 * @param text
	 *        必须
	 * @param type
	 *        必须
	 * @return
	 */
	private static boolean sendTextMsg(String type, String openId, String text) {
		String access_token = getAccessToken();
		String requestUrl = WeiXinConstants.SEND_MSG_TO_USER_URL.replace("ACCESS_TOKEN", access_token);
		TextMessage textMessage = new TextMessage();
		SubTextMessage sub = new SubTextMessage();
		sub.setContent(text);
		textMessage.setText(sub);
		textMessage.setMsgtype(type);
		textMessage.setTouser(openId);
		String jsonText = JSONObject.fromObject(textMessage).toString();
		JSONObject jsonObject = httpRequest(requestUrl, "POST", jsonText);
		if (null != jsonObject) {
			String result = jsonObject.getString("errmsg");
			if ("ok".equals(result)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 发送图片/语音客服信息
	 * @param openId
	 *        必须
	 * @param text
	 *        必须
	 * @param type
	 *        必须
	 * @return
	 */
	private static boolean sendMediaMsg(String type, String openId, String media_id) {
		String access_token = getAccessToken();
		String requestUrl = WeiXinConstants.SEND_MSG_TO_USER_URL.replace("ACCESS_TOKEN", access_token);
		StringBuilder str = new StringBuilder();
		str.append("{\"touser\": \"");
		str.append(openId);
		str.append("\", \"msgtype\": \"");
		str.append(type);
		str.append("\", \"");
		str.append(type);
		str.append("\": {\"media_id\": \"");
		str.append(media_id);
		str.append("\"}}");
		JSONObject jsonObject = httpRequest(requestUrl, "POST", str.toString());
		if (null != jsonObject) {
			String result = jsonObject.getString("errmsg");
			if ("ok".equals(result)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 发送视频信息
	 * @param type
	 *        必须
	 * @param openId
	 *        必须
	 * @param text
	 *        必须
	 * @param description
	 *        选填
	 * @param title
	 *        选填
	 * @return
	 */
	private static boolean sendVideoMsg(String type, String openId, String media_id, String title, String description) {
		String access_token = getAccessToken();
		String requestUrl = WeiXinConstants.SEND_MSG_TO_USER_URL.replace("ACCESS_TOKEN", access_token);
		StringBuilder str = new StringBuilder();
		str.append("{\"touser\": \"");
		str.append(openId);
		str.append("\", \"msgtype\": \"");
		str.append(type);
		str.append("\", \"");
		str.append(type);
		str.append("\": {\"media_id\": \"");
		str.append(media_id);
		str.append(",\"title\":\"");
		str.append(title);
		str.append(",\"description\":\"");
		str.append(description);
		str.append("\"}}");
		JSONObject jsonObject = httpRequest(requestUrl, "POST", str.toString());
		if (null != jsonObject) {
			String result = jsonObject.getString("errmsg");
			if ("ok".equals(result)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 发送音乐消息
	 * @param type
	 *        必须
	 * @param openId
	 *        必须
	 * @param text
	 *        必须
	 * @param title
	 *        选填
	 * @param description
	 *        选填
	 * @param musicurl
	 *        必须
	 * @param hqmusicurl
	 *        必须
	 * @param thumb_media_id
	 *        必须
	 * @return
	 */
	private static boolean sendMusicMsg(String openId, String media_id, String title, String description,
			String musicurl, String hqmusicurl, String thumb_media_id) {
		String access_token = getAccessToken();
		String requestUrl = WeiXinConstants.SEND_MSG_TO_USER_URL.replace("ACCESS_TOKEN", access_token);
		String type = MessageUtil.RESP_MESSAGE_TYPE_NEWS;
		StringBuilder str = new StringBuilder();
		str.append("{\"touser\": \"");
		str.append(openId);
		str.append("\", \"msgtype\": \"");
		str.append(type);
		str.append("\", \"");
		str.append(type);
		str.append("\": {\"media_id\": \"");
		str.append(media_id);
		str.append(",\"title\":\"");
		str.append(title);
		str.append(",\"description\":\"");
		str.append(description);
		str.append(",\"musicurl\":\"");
		str.append(musicurl);
		str.append(",\"hqmusicurl\":\"");
		str.append(hqmusicurl);
		str.append(",\"thumb_media_id\":\"");
		str.append(thumb_media_id);
		str.append("\"}}");
		JSONObject jsonObject = httpRequest(requestUrl, "POST", str.toString());
		if (null != jsonObject) {
			String result = jsonObject.getString("errmsg");
			if ("ok".equals(result)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 发送图文信息
	 */
	private static boolean sendNewMsg(String type, String openId, String media_id, String requestUrl, String title,
			String description, String musicurl, String hqmusicurl, String thumb_media_id) {
		return false;
	}
	
	/**
	 * 获取用户信息的accessToken
	 * @param code 用户同意授权的code
	 * @return userInfoAccessToken
	 * */
	public static UserInfoAccessToken getUserInfoAccessToken(String code){
		String getAccessTokenUrl=WeiXinConstants.GET_USERINFO_ACCESS_TOKEN;
		getAccessTokenUrl=getAccessTokenUrl.replace("APPID",WeiXinConstants.APP_ID);
		getAccessTokenUrl=getAccessTokenUrl.replace("SECRET", WeiXinConstants.APP_SECRET);
		getAccessTokenUrl=getAccessTokenUrl.replace("CODE", code);
		String accessToken=NetUtils.getNetData(getAccessTokenUrl);
		//new Thread(new Test(getAccessTokenUrl)).start();
		logger.info("[getAccessTokenUrl]="+getAccessTokenUrl);
		logger.info("[accessToken]="+accessToken);
		if (accessToken.indexOf("errcode")>0) {
			return null;
		}
		UserInfoAccessToken userInfoAccessToken=JsonUtils.jsonToObject(accessToken, UserInfoAccessToken.class);
		return userInfoAccessToken;
	}
	/**
	 * 获取用户信息的accessToken
	 * @param userInfoAccessToken
	 * @return userInfoAccessToken
	 * @throws UnsupportedEncodingException 
	 * */
	public static String getWXUserInfo(UserInfoAccessToken userInfoAccessToken) throws UnsupportedEncodingException{
		String useinfoUrl=WeiXinConstants.GET_USER_INFO_URL1;
		useinfoUrl=useinfoUrl.replace("ACCESS_TOKEN",userInfoAccessToken.getAccess_token());
		useinfoUrl=useinfoUrl.replace("OPENID", userInfoAccessToken.getOpenid());
		String useinfo=new String(NetUtils.getNetData(useinfoUrl).getBytes(),"utf-8");
		logger.info("[useinfoUrl]="+useinfoUrl);
		logger.info("[useinfo]="+useinfo);
		return useinfo;
	}
}
