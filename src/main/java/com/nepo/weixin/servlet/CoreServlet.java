package com.nepo.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepo.weixin.service.SmartCampusCoreService;
import com.nepo.weixin.util.SignUtil;

/**
 * 核心请求处理类
 * 
 * @author xpeng
 * @date 2013-05-18
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * 确认请求来自微信服务器
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------doGet------------------------");
		// 微信加密签名
        String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out
				.println("------------------CoreServlet doPost begin------------------------");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// request.setAttribute("OpenId", "12121212");
		// response.sendRedirect("/pages/kaka/index.jsp");
		// 调用核心业务类接收消息、处理消息
		String respMessage = SmartCampusCoreService.processRequest(request);
		if (respMessage == null || respMessage.equals("")) {
			return;
		}
		System.out.println("=======:服务器-->微信的信息:\n" + respMessage);
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
		System.out
				.println("------------------CoreServlet doPost end------------------------");

	}
}