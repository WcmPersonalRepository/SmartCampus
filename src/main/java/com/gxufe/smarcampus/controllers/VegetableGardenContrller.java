package com.gxufe.smarcampus.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("VegetableGarden")
public class VegetableGardenContrller {
	
	public String toVegetableGarden(HttpServletRequest request,Model model){
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "VegetableGarden/vegetableGarden";
	}
}
