package com.gxufe.smarcampus.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxufe.smarcampus.common.util.SpringSecurityUtils;

@Controller
public class OtherController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request , Model model){
		/*System.out.println(SpringSecurityUtils.getCurrentUsername()+"************");
		System.out.println(SpringSecurityUtils.getCurrentUserId()+"************");
		System.out.println(SpringSecurityUtils.getCurrentUserIp()+"************");
		System.out.println(SpringSecurityUtils.getRoles()+"************");*/
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "index";
	}
	@RequestMapping("login")
	public String login(HttpServletRequest request , Model model){
		HttpSession session=request.getSession();
		Exception exceptionContext= (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		
		model.addAttribute("msg","用户名或密码不正确");
		return "login";
	}
	
}
