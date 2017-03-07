package com.nepo.weixin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.client.result.WifiParsedResult;
import com.nepo.weixin.constants.GlobalConfig;
import com.nepo.weixin.aicha.HttpUtils;
import com.nepo.weixin.constants.WeiXinConstants;
import com.nepo.weixin.thread.TokenThread;
import com.nepo.weixin.util.FileUtil;
import com.nepo.weixin.util.WeixinUtil;

/**
 * 初始化servlet
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

	public void init() throws ServletException {
		TokenThread.appid = WeiXinConstants.APP_ID;
		TokenThread.appsecret = WeiXinConstants.APP_SECRET;
		logger.info("weixin api appid:{}", TokenThread.appid);
		logger.info("weixin api appsecret:{}", TokenThread.appsecret);
		// 未配置appid、appsecret时给出提示
		if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
			logger.error("appid and appsecret configuration error, please check carefully.");
		} else {
			// 启动定时获取access_token的线程
			new Thread(new TokenThread()).start();
		}
		/*// 创建菜单
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					String dbrealpath = getServletContext().getRealPath(
							"/WEB-INF/menu-blz.json");
//					String dbrealpath = getServletContext().getRealPath(
//							"/WEB-INF/menu-aidaka.json");
					File mFile = new File(dbrealpath);
					String json = new String(FileUtil.getFileToBytes(mFile),
							"UTF-8");
					json=json.replaceAll("\r\n", "");
					json=json.replaceAll("\t", "");
					json=json.replaceAll(" ", "");
					String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
							+ TokenThread.accessToken.getToken();
					HttpUtils.sendPost(url, json);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();*/
		
		/*//初始胡资源文件
		new Thread(new InitPropertisFile()).start();*/
	}
	
}
