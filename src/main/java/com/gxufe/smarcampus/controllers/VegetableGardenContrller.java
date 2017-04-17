package com.gxufe.smarcampus.controllers;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.SysUsersService;

@Controller
@RequestMapping("VegetableGarden")
public class VegetableGardenContrller {
	@Autowired
	public SysUsersService sysUsersService;
	
	public String toVegetableGarden(HttpServletRequest request,Model model){
		String itemNum=request.getParameter("itemNum");
		
		model.addAttribute("itemNum",itemNum);
		return "VegetableGarden/vegetableGarden";
	}
}
