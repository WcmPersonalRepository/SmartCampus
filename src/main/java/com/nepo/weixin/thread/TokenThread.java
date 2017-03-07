package com.nepo.weixin.thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nepo.weixin.pojo.AccessToken;
import com.nepo.weixin.util.WeixinUtil;
/**
 * 定时获取微信access_token的线程
 * @author liuyq
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = "";
	// 第三方用户唯一凭证密钥
	public static String appsecret = "";
	public static AccessToken accessToken = null;
	// 外部调用TokenThread.accessToken.getToken()获得token
	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				logger.info("[accessToken]="+accessToken.getToken());
				if (null != accessToken) {
					logger.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());
					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (Exception e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (Exception e1) {
					logger.error("{}", e1);
				}
				logger.error("error", e);
			}
		}
	}
}