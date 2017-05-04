package com.gxufe.smarcampus.controllers;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.SessionUtils;
import com.gxufe.smarcampus.common.util.SpringSecurityUtils;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.models.UserBean;
import com.gxufe.smarcampus.service.SysRolesService;
import com.gxufe.smarcampus.service.SysStudentService;
import com.gxufe.smarcampus.service.SysTeacherService;
import com.gxufe.smarcampus.service.SysUsersService;

@Controller
@RequestMapping("/my")
public class myContrller {
	 private static Logger logger = LoggerFactory.getLogger(myContrller.class);
	@Autowired
	public SysTeacherService sysTeacherService;
	@Autowired
	public SysStudentService sysStudentService;
	@Autowired
	public SysUsersService sysUsersService;
	@Autowired
	public BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	public SysRolesService sysRolesService;
	
	/**
	 * 跳转我的
	 * 
	 * */
	@RequestMapping("/")
	public String toEducationalManager(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		if (null!=userInfo) {
			Set<SysRoles> sysRolesSet=(Set<SysRoles>)userInfo.getSysUsers().getSysRoleses();
			String userType=null;
			for (SysRoles sysRoles : sysRolesSet) {
				if ("ROLL_TEACHER".equals(sysRoles.getRoleName())||"ROLL_STUDENT".equals(sysRoles.getRoleName())) {
					userType=sysRoles.getRoleName();
					break;
				}
			}
			if ("ROLL_TEACHER".equals(userType)) {
				model.addAttribute("realName", userInfo.getSysUsers().getSysTeacher().getRealName());
			}
			if ("ROLL_STUDENT".equals(userType)) {
				model.addAttribute("realName", userInfo.getSysUsers().getSysStudent().getRealName());
			}
		}
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "My/my";
	}
	
	/**
	 * 跳转校方认证
	 * 
	 * */
	@RequestMapping("toCampusAuthentication")
	public String toCampusAuthentication(HttpServletRequest request,Model model){
		return "My/campusAuthentication";
	}
	
	/**
	 * 校方认证
	 * 
	 * */
	@ResponseBody
	@RequestMapping("campusAuthentication")
	public String campusAuthentication(HttpServletRequest request,Model model){
		String json="";
		String userType=request.getParameter("userType");
		String userNumber=request.getParameter("userNumber");
		String realName=request.getParameter("realName");
		Map<String, String> map=new HashMap<String,String>();
		if (userType.equals("")) {
			map.put("code", "1");
			map.put("msg", "请选择用户类型");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (userNumber.equals("")) {
			map.put("code", "2");
			map.put("msg", "请输入工号或学号");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (realName.equals("")) {
			map.put("code", "3");
			map.put("msg", "请输入姓名");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (userType.equals("教师")) {
			SysTeacher sysTeacher=sysTeacherService.findTeacherByWorkNumber(userNumber);
			
			if (null!=sysTeacher) {
				SysUsers sysUsers=sysUsersService.findUsersByTeacherId(sysTeacher.getId());
				if (null!=sysUsers) {
					map.put("code", "-4");
					map.put("msg", "该工号或学号已认证");
					json=JsonUtils.objectToJson(map);
					return json;
				}
				String sysRealName=sysTeacher.getRealName();
				if (sysRealName.equals(realName)) {
					map.put("code", "0");
					map.put("msg", "恭喜您认证成功");
					map.put("id", sysTeacher.getId()+"");
					map.put("userType","1");
					json=JsonUtils.objectToJson(map);
					return json;
				}else{
					map.put("code", "-2");
					map.put("msg", "对不起您的工号或学号与您的姓名不匹配，请重新认证或已管理员联系");
					json=JsonUtils.objectToJson(map);
					return json;
				}
				
			}else{
				map.put("code", "-3");
				map.put("msg", "对不起,没有找到您的信息记录，请重试或联系管理员");
				json=JsonUtils.objectToJson(map);
				return json;
			}
		}
		if (userType.equals("学生")) {
			SysStudent sysStudent=sysStudentService.findStudentByWorkNumber(userNumber);
			if (null!=sysStudent) {
				SysUsers sysUsers=sysUsersService.findUsersByStudentId(sysStudent.getId());
				if (null!=sysUsers) {
					map.put("code", "-4");
					map.put("msg", "该工号或学号已认证");
					json=JsonUtils.objectToJson(map);
					return json;
				}
				String sysRealName=sysStudent.getRealName();
				if (sysRealName.equals(realName)) {
					map.put("code", "0");
					map.put("msg", "恭喜您认证成功");
					map.put("id", sysStudent.getId()+"");
					map.put("userType","2");
					json=JsonUtils.objectToJson(map);
					return json;
				}else{
					map.put("code", "-2");
					map.put("msg", "对不起您的工号或学号与您的姓名不匹配，请重新认证或已管理员联系");
					json=JsonUtils.objectToJson(map);
					return json;
				}
				
			}else{
				map.put("code", "-3");
				map.put("msg", "对不起,没有找到您的信息记录，请重试或联系管理员");
				json=JsonUtils.objectToJson(map);
				return json;
			}
		}
		else{
			map.put("code", "-1");
			map.put("msg", "对不起系统没有该用户类型");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		//return json;
	}
	
	/**
	 * 跳转设置密码
	 * 
	 * */
	@RequestMapping("toSettingPwd")
	public String toSettingPwd(HttpServletRequest request,Model model){
		String userType=request.getParameter("userType");
		model.addAttribute("userType", userType);
		model.addAttribute("id", request.getParameter("id"));
		return "My/settingPwd";
	}
	
	/**
	 * 设置密码
	 * 
	 * */
	@ResponseBody
	@RequestMapping("settingPwd")
	public String settingPwd(HttpServletRequest request,Model model){
		String json="";
		String id=request.getParameter("id");
		String userType=request.getParameter("userType");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String safeCode=request.getParameter("safeCode");
		String cacheSafeCode=(String) request.getSession().getAttribute("safecode");
		Map<String, String> map=new HashMap<String, String>();
		if ("".equals(password)) {
			map.put("code", "1");
			map.put("msg", "请输入密码");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if ("".equals(confirmPassword)) {
			map.put("code", "2");
			map.put("msg", "请输入确认密码");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if ("".equals(safeCode)) {
			map.put("code", "3");
			map.put("msg", "请输入验证码");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (!password.equals(confirmPassword)) {
			map.put("code", "4");
			map.put("msg", "对不起，您两次输入的密码不一致，请重新设置");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (!safeCode.equalsIgnoreCase(cacheSafeCode)) {
			map.put("code", "5");
			map.put("msg", "对不起，您输入的验证码不正确");
			json=JsonUtils.objectToJson(map);
			return json;
		}
		if (userType.equals("1")) {
			SysTeacher sysTeacher=sysTeacherService.findSysTeacherById(Integer.valueOf(id));
			SysUsers sysUsers=new SysUsers();
			sysUsers.setIsCampusAuthentication(1);
			sysUsers.setPassword(bcryptEncoder.encode(password));
			sysUsers.setSysTeacher(sysTeacher);
			SysRoles sysRole=new SysRoles();
			sysRole.setRoleName("ROLL_TEACHER");
			try {
				sysUsersService.saveOrUpdate(sysUsers);
				List<SysUsers> sysUserList=sysUsersService.findObjectByHQL("from SysUsers where sysTeacher.id=?",Integer.valueOf(id));
				sysRole.setSysUsers(sysUserList.get(0));
				sysRolesService.saveOrUpdate(sysRole);
				map.put("code", "0");
				map.put("msg", "恭喜您认证成功");
				json=JsonUtils.objectToJson(map);
				return json;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			
		}if (userType.equals("2")) {
			SysStudent sysStudent=sysStudentService.findSysStudentById(Integer.valueOf(id));
			SysUsers sysUsers=new SysUsers();
			sysUsers.setIsCampusAuthentication(1);
			sysUsers.setPassword(bcryptEncoder.encode(password));
			sysUsers.setSysStudent(sysStudent);
			SysRoles sysRole=new SysRoles();
			sysRole.setRoleName("ROLL_STUDENT");
			try {
				sysUsersService.saveOrUpdate(sysUsers);
				List<SysUsers> sysUserList=sysUsersService.findObjectByHQL("from SysUsers where sysStudent.id=?",Integer.valueOf(id));
				sysRole.setSysUsers(sysUserList.get(0));
				sysRolesService.saveOrUpdate(sysRole);
				map.put("code", "0");
				map.put("msg", "恭喜您认证成功");
				json=JsonUtils.objectToJson(map);
				return json;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return json;
	}
	

	/**
	 * 跳转登录
	 * 
	 * */
	@RequestMapping("toLogin")
	public String toLogin(HttpServletRequest request,Model model){
		
		return "My/login";
	}
	
	/**
	 * 登录
	 * 
	 * */
	@ResponseBody
	@RequestMapping("login")
	public String login(HttpServletRequest request,Model model){
		String userType=request.getParameter("userType");
		String userNumber=request.getParameter("userNumber");
		String password=request.getParameter("password");
		String json="";
		Map<String, String> map=new HashMap<String,String>();
		if ("教师".equals(userType)) {
			List<SysUsers> sysUsersList=sysUsersService.findObjectByHQL("from SysUsers where sysTeacher.workNumber=?",userNumber);
			if (sysUsersList.size()>0) {
				String dbPasspword=sysUsersList.get(0).getPassword();
				if (bcryptEncoder.matches(password, dbPasspword)) {
					UserBean userInfo=new UserBean();
					SysUsers sysUser=sysUsersList.get(0);
					userInfo.setSysUsers(sysUser);
					userInfo.setSysTeacher(sysUser.getSysTeacher());
					userInfo.setSysPart(sysUser.getSysTeacher().getSysPart());
					userInfo.setSysOrganization(sysUser.getSysTeacher().getSysPart().getSysOrganization());
					userInfo.setUserType("1");
					request.getSession().setAttribute("sys_user_info", userInfo);
					
					map.put("code", "0");
					map.put("msg", "登录成功");
					map.put("url", "my/?itemNum=3");
					json=JsonUtils.objectToJson(map);
					return json;
				}else{
					map.put("code", "2");
					map.put("msg", "密码输入错误");
					json=JsonUtils.objectToJson(map);
					return json;
				}
			}else{
				map.put("code", "1");
				map.put("msg", "对不起该用户不存在或未认证");
				json=JsonUtils.objectToJson(map);
				return json;
			}
		}
		
		if ("学生".equals(userType)) {
			List<SysUsers> sysUsersList=sysUsersService.findObjectByHQL("from SysUsers where sysStudent.studentNumber=?",userNumber);
			if (sysUsersList.size()>0) {
				String dbPasspword=sysUsersList.get(0).getPassword();
				if (bcryptEncoder.matches(password, dbPasspword)) {
					UserBean userInfo=new UserBean();
					SysUsers sysUser=sysUsersList.get(0);
					userInfo.setSysUsers(sysUsersList.get(0));
					userInfo.setSysStudent(sysUser.getSysStudent());
					userInfo.setSysClass(sysUser.getSysStudent().getSysClass());
					userInfo.setSysProfessional(sysUser.getSysStudent().getSysClass().getSysProfessional());
					userInfo.setSysCollege(sysUser.getSysStudent().getSysClass().getSysProfessional().getSysCollege());
					userInfo.setSysCampus(sysUser.getSysStudent().getSysClass().getSysProfessional().getSysCollege().getSysCampus());
					userInfo.setUserType("2");
					request.getSession().setAttribute("sys_user_info", userInfo);
					map.put("code", "0");
					map.put("msg", "登录成功");
					map.put("url", "my/?itemNum=3");
					json=JsonUtils.objectToJson(map);
					return json;
				}else{
					map.put("code", "2");
					map.put("msg", "密码输入错误");
					json=JsonUtils.objectToJson(map);
					return json;
				}
			}else{
				map.put("code", "1");
				map.put("msg", "对不起该用户不存在或未认证");
				json=JsonUtils.objectToJson(map);
				return json;
			}
		}
		return "My/my";
	}
	
	/**
	 * 个人信息
	 * 
	 * */
	@RequestMapping("baseInfo")
	public String baseInfo(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();
		if ("1".equals(userType)) {
			model.addAttribute("realName", userInfo.getSysTeacher().getRealName());
			model.addAttribute("partName", userInfo.getSysPart().getPartName());
			model.addAttribute("positionName", userInfo.getSysTeacher().getPositionName());
			model.addAttribute("organizationName", userInfo.getSysOrganization().getOrganizationName());
			model.addAttribute("workNumber", userInfo.getSysTeacher().getWorkNumber());
		}
		if ("2".equals(userType)) {
			model.addAttribute("realName", userInfo.getSysStudent().getRealName());
			model.addAttribute("className", userInfo.getSysClass().getClassName());
			model.addAttribute("studentNumber", userInfo.getSysStudent().getStudentNumber());
			model.addAttribute("professional", userInfo.getSysProfessional().getProfessionalName());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String intoSchoolYear=sdf.format(userInfo.getSysStudent().getIntoSchoolYear());
			model.addAttribute("intoSchoolYear", intoSchoolYear);
			model.addAttribute("collegeName", userInfo.getSysCollege().getCollegeName());
		}
		model.addAttribute("userType", userInfo.getUserType());
		return "My/baseInfo";
	}

	/**
	 * 跳转设置
	 * 
	 * */
	@RequestMapping("toSetting")
	public String toSetting(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		model.addAttribute("userInfo", userInfo);
		return "My/setting";
	}
	
	/**
	 * 登出
	 * 
	 * */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,Model model){
		SessionUtils.clearUserBean(request);
		return "redirect:/my/?itemNum=3";
	}
}
