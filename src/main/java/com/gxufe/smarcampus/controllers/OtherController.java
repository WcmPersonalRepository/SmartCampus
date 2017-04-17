package com.gxufe.smarcampus.controllers;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxufe.smarcampus.common.util.SpringSecurityUtils;
import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.service.SysCampusService;
import com.gxufe.smarcampus.service.SysUsersService;

@Controller
public class OtherController {
	@Autowired
	public SysUsersService sysUsersServiceImpl;
	@Autowired
	public SysCampusService sysCampusService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request , Model model){
		/*System.out.println(SpringSecurityUtils.getCurrentUsername()+"************");
		System.out.println(SpringSecurityUtils.getCurrentUserId()+"************");
		System.out.println(SpringSecurityUtils.getCurrentUserIp()+"************");
		System.out.println(SpringSecurityUtils.getRoles()+"************");*/
		String itemNum=request.getParameter("itemNum");
		
		/*SysUsers user=new SysUsers();
		user.setName("wcm");
		user.setNickname("xiamoing");
		user.setPassword("123456");
		user.setStatus("0");
		user.setUsername("wcm");
		SysStudent sysStudent=new SysStudent();
		sysStudent.setIntoSchoolYear(new Timestamp(System.currentTimeMillis()));
		sysStudent.setRealName("吴朝明");
		sysStudent.setSex("M");
		sysStudent.setStudentNumber("120604303028");
		SysClass sysClass=new SysClass();
		sysClass.setClassName("计应1331班");
		SysProfessional sysProfessional=new SysProfessional();
		sysProfessional.setBelongCourse("计科");
		sysProfessional.setEducationDuration(3);
		sysProfessional.setEducationLevel("专科");
		sysProfessional.setProfessionalCode("1234");
		sysProfessional.setProfessionalName("计算机应用技术");
		SysCollege sysCollege=new SysCollege();
		sysCollege.setCollegeName("信息与统计学院");
		SysCampus sysCampus=new SysCampus();
		sysCampus.setCampusName("明秀校区");
		sysCollege.setSysCampus(sysCampus);
		sysProfessional.setSysCollege(sysCollege);
		sysClass.setSysProfessional(sysProfessional);
		sysStudent.setSysClass(sysClass);
		user.setSysStudent(sysStudent);
		sysUsersService.addUser(user);*/
		
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
