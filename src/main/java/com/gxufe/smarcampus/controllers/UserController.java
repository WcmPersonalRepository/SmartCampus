package com.gxufe.smarcampus.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.service.SysUsersService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private SysUsersService sysUsersService;
	
	@RequestMapping("/index")
	public String login(HttpServletRequest request ,Model model){
		//Users user=new Users();
		/*user.setUserAge(23);
		user.setUserid(19);
		user.setUserName("wu");
		user.setUserPwd("12");
		user.setUserSex("M");*/
		/*user.setEnabled(true);
		user.setPassword("kkk");
		user.setUsername("wwww");
		userService.addUser(user);*/
		/*List<Users> userList=userService.find("from Users");
		for (Users u:userList) {
			System.out.println(u.getPassword());
			System.out.println(u.getEnabled());
			System.out.println(u.getUsername());
		}*/
		SysUsers sysUsers=new SysUsers();
		sysUsers.setName("wuchaoming");
		sysUsers.setPassword("456");
		sysUsers.setUsername("ppp");
		sysUsersService.addUser(sysUsers);
		return "index";
	}
	
}
