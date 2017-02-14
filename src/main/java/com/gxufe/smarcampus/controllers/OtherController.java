package com.gxufe.smarcampus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request , Model model){
		return "index";
	}
	@RequestMapping("login")
	public String login(HttpServletRequest request , Model model){
		return "login";
	}
}
