package com.gxufe.smarcampus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class myContrller {
	
	@RequestMapping("/my")
	public String toEducationalManager(HttpServletRequest request,Model model){
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "My/my";
	}
}
