package com.nepo.weixin.constants;

import org.apache.poi.hssf.util.HSSFColor.GOLD;

import com.nepo.weixin.constants.GlobalConfig;


/**
 * @author xpeng
 * @since Jun 2, 2014
 */
public class WeiXinConstants {
	/**-------------------------升级前必须检查--------------------------------------------------------------------------------*/
	// 公众号id
	//public static final String APP_ID = "wx21f1cbf2f8669804";
	// 测试公众号id
	public static final String APP_ID = "wx48ff47f8ecd9e673";
	// 第三方用户唯一凭证密钥
	//public static final String APP_SECRET = "edca83dfb664aa419528f1a453765a93";
	// 测试公众号第三方用户唯一凭证密钥
	public static final String APP_SECRET = "d8a6b1bcfe04144da55ef539d351d94b";
	/**---------------------------------------------------------------------------------------------------------*/
	public static final String ENCODING = "UTF-8";
	//网页网页授权重定向地址
	public static final String REDIRECT_URI=GlobalConfig.MAPPING_ADDRESS+"/blz/";
	
	//微信充值成功模板消息回调地址
	public static final String TEMPLETE_RECHARGE_SUCCSSE_CALL_BACK_URL=GlobalConfig.MAPPING_ADDRESS+"/blz/account/myAccount";

	// 获取access_token的接口地址（GET） 限200（次/天）
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 菜单创建（POST） 限100（次/天）
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// 发送客服消息
	public static final String SEND_MSG_TO_USER_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	// 获取用户信息accessToken凭证
	public static final String GET_USERINFO_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// 获取用户基本信息
	public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 获取用户基本信息
	public static final String GET_USER_INFO_URL1 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//网页授权
	public static final String WXAUTHORIZE_UEL="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APP_ID+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=122#wechat_redirect";
	//发送模板消息
	public static final String SEND_TEMPLETE_MASSAGE_URL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
}
