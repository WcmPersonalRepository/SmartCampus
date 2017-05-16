package com.gxufe.smarcampus.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gxufe.smarcampus.common.util.SessionUtils;
import com.gxufe.smarcampus.models.UserBean;
import com.nepo.weixin.constants.WeiXinConstants;

/**
 * @discription <br>
 *              </br>
 * @author pc
 * @date 2016-7-28
 * @version 1.0
 */
public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger logger = Logger.getLogger(this.getClass()); 

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String fullPath = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = fullPath.replace(contextPath, "");
		if (!(requestPath.indexOf(".png")>=0||requestPath.indexOf(".js")>=0||requestPath.indexOf(".png")>=0||requestPath.indexOf(".jpg")>=0||requestPath.indexOf(".css")>=0)) {
			logger.info(new StringBuilder("requestPath[").append(requestPath).append(
					"]"));
		}
		
		if ("/".equals(requestPath)) {
			return true;
		} else {
			for (String url : excludedUrls) {
				if (requestPath.startsWith(url)) {
					
					UserBean userBean = SessionUtils.getUserBySession(request);
					if (userBean == null) {
						String isWinXin=(String) request.getSession().getAttribute("isWeiXin");
						if ("true".equals(isWinXin)) {
							response.sendRedirect("/SmartCampus/my/toLogin");
						}else{
							//response.sendRedirect(WeiXinConstants.REDIRECT_URI);
							String jumpUrl=request.getRequestURI();
							StringBuffer redirectUrl=new StringBuffer();
							redirectUrl.append("/SmartCampus/my/toLogin");
							if (!(null==jumpUrl||"".equals(jumpUrl))) {
								redirectUrl.append("?jumpUrl=").append(jumpUrl);
							}
							response.sendRedirect(redirectUrl.toString());
						}
						return false;
					} else {
						return true;
					}
				}
			}
			return true;
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView model) throws Exception {
		
	}
}
