package com.gxufe.smarcampus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gxufe.smarcampus.common.util.SessionUtils;
import com.gxufe.smarcampus.models.UserBean;

@RequestMapping("/educationalManager")
@Controller
public class EducationalManagerContrller {
	
	/**
	 * 跳转管理页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String toEducationalManager(HttpServletRequest request,Model model){
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "EducationalManager/educationalManager";
	}
	
	/**
	 * 跳转在线请假页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="onlineLeave",method=RequestMethod.GET)
	public String onlineApply(HttpServletRequest request,Model model){
		/*UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();*/
		model.addAttribute("userType", "1");
		return "EducationalManager/onlineLeave";
	}
	
	/**
	 * 跳转学生请假页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/onlineLeave/toStudentLeave",method=RequestMethod.GET)
	public String toStudentLeave(HttpServletRequest request,Model model){
		return "EducationalManager/studentLeave";
	}

	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/onlineLeave/toLeaveInfo",method=RequestMethod.GET)
	public String toLeaveInfo(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();
		model.addAttribute("userType", userType);
		return "EducationalManager/leaveInfo";
	}
	
	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/onlineLeave/toMakeLeave",method=RequestMethod.GET)
	public String toMakeLeave(HttpServletRequest request,Model model){
		return "EducationalManager/makeLeave";
	}
	
	@RequestMapping("/showVideo")
	public String showVideo(HttpServletRequest request,Model model){
		return "EducationalManager/videoPlay";
	}
	
	
}
