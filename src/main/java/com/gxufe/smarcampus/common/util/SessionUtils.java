package com.gxufe.smarcampus.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nepo.weixin.pojo.UserBean;
import com.nepo.weixin.pojo.WXUserInfo;

public class SessionUtils {
	private static String SYS_USER_INFO = "sys_user_info";
	private static Logger logger=Logger.getLogger(SessionUtils.class);

	/**
	 * 获取Session中用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static UserBean getUserBySession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (UserBean) session.getAttribute(SYS_USER_INFO);
	}
	/**
	 * 获取微信Session中用户信息
	 * 
	 * @param request
	 * @return
	 */
	public static WXUserInfo getWXUserBySession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		logger.info("[获取微信信息的sessionid]="+session.getId());
		WXUserInfo wxUserInfo=(WXUserInfo) session.getAttribute("WXUserInfo");
		return wxUserInfo;
	}

	/**
	 * 获取Session中数据
	 * 
	 * @param request
	 * @return
	 */
	public static String getValueBySession(HttpServletRequest request,String key) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute(key);
	}
	
	/**
	 * 获取Session中数据
	 * 
	 * @param request
	 * @return
	 */
	public static void setValueBySession(HttpServletRequest request,String key,String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key,value);
	}


	
	/**
	 * 设置用户信息到Session中
	 * 
	 * @param request
	 * @return
	 */
	public static void setUserBySession(HttpServletRequest request,
			UserBean mUserBean) {
		HttpSession session = request.getSession();
		session.setAttribute(SYS_USER_INFO, mUserBean);
	}
	/**
	 * 设置微信用户信息到Session中
	 * 
	 * @param request
	 * @return
	 */
	public static void setWXUserBySession(HttpServletRequest request,
			WXUserInfo wxUserInfo) {
		HttpSession session = request.getSession();
		logger.info("[设置微信信息的sessionid]="+session.getId());
		session.setAttribute("WXUserInfo", wxUserInfo);
	}

	/**
	 * 清空用户信息
	 * 
	 * @param requestf
	 */
	public static void clearUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SYS_USER_INFO, null);
		session.invalidate();
	}

	/**
	 * 获取用户ID
	 * 
	 * @param request
	 * @return String
	 */
	public static String getUserIdBySession(HttpServletRequest request) {
		UserBean userBean = getUserBySession(request);

		return userBean == null ? "" : userBean.getUserId();
	}
	
	/**
	 * 获取用户Name
	 * 
	 * @param request
	 * @return String
	 */
	public static String getUserNameBySession(HttpServletRequest request) {
		UserBean userBean = getUserBySession(request);

		return userBean == null ? "" : userBean.getUserName();
	}
	
	/**
	 * 判断当前浏览器是否是微信浏览器
	 * @author wcm
	 * @param HttpServletRequest
	 * @param String
	 * @return
	 */
	public static void setIsWeiXin(HttpServletRequest request, String isWeiXin) {
		request.getSession().setAttribute("isWeiXin", isWeiXin);
	}
	
	/**
	 * 判断当前浏览器是否是微信浏览器
	 * @author wcm
	 * @param HttpServletRequest
	 */
	public static Boolean getIsWeiXin(HttpServletRequest request) {
		String isWeiXin=(String) request.getSession().getAttribute("isWeiXin");
		if ("true".equals(isWeiXin)) {
			return true;
		}else {
			return false;
		}
	}
}
