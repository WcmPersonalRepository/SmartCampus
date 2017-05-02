package com.gxufe.smarcampus.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxufe.smarcampus.common.json.Department;
import com.gxufe.smarcampus.common.json.Part;
import com.gxufe.smarcampus.common.json.PhoneBook;
import com.gxufe.smarcampus.common.json.PhoneBooks;
import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.PinyinComparator;
import com.gxufe.smarcampus.models.SysPart;
import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.service.SysPartService;
import com.gxufe.smarcampus.service.SysPhoneBookService;
import com.nepo.weixin.util.JsonUtil;

@Controller
@RequestMapping("/happyShare")
public class HappyShareContrller {
	public static Logger logger=LoggerFactory.getLogger(HappyShareContrller.class);
	
	@Autowired
	public SysPhoneBookService sysPhoneBookService;
	@Autowired
	public SysPartService sysPartService;
	@Autowired
	public JdbcTemplate JdbcTemplate;
	/**
	 * 跳转共享
	 * 
	 * */
	@RequestMapping("")
	public String toEducationalManager(HttpServletRequest request,Model model){
		String itemNum=request.getParameter("itemNum");
		model.addAttribute("itemNum",itemNum);
		return "HappyShare/happyShare";
	}
	
	/**
	 * 跳转部门通讯录
	 * 
	 * */
	@RequestMapping("toPart")
	public String toPart(HttpServletRequest request,Model model){
		
		return "HappyShare/part";
	}
	
	/**
	 * 异步获取部门通讯录
	 * 
	 * */
	@ResponseBody
	@RequestMapping("getParts")
	public String getParts(HttpServletRequest request,Model model){
		String json="";
		List sysParts=sysPartService.findObjectByHQL("from SysPart where id in(select sysPart.id from SysPhoneBook)");
		
		List list=PinyinComparator.sortList(sysParts,"partName",SysPart.class);
		//model.addAttribute("sysPartList", list);
		List<Part> parts=new ArrayList<Part>();
		for (int i = 0; i < list.size(); i++) {
			SysPart sysPart=(SysPart) list.get(i);
			Part part=new Part(sysPart.getId(), sysPart.getPartName(), null, null);
			parts.add(part);
		}
		json=JsonUtils.objectToJson(parts);
		return json;
	}
	
	/**
	 * 异步获取通讯录所有信息,并部门拼音排序
	 * 
	 * */
	@ResponseBody
	@RequestMapping("phoneBooksSortByDepartment")
	public String phoneBooksSortByDepartment(HttpServletRequest request,Model model){
		List<PhoneBooks> phoneBooksSortByDepartment=getAllSysPhoneBooksSortedByProperty("department");
		String json=JsonUtils.objectToJson(phoneBooksSortByDepartment);
		return json;
	}
	
	/**
	 * 异步获取通讯录所有信息,并部门姓名拼音排序
	 * 
	 * */
	@ResponseBody
	@RequestMapping("phoneBooksSortByRealName")
	public String phoneBooksSortByRealName(HttpServletRequest request,Model model){
		List<PhoneBooks> phoneBooksSortByRealName=getAllSysPhoneBooksSortedByProperty("realName");
		String json=JsonUtils.objectToJson(phoneBooksSortByRealName);
		return json;
	}
	
	
	public List<PhoneBooks> getAllSysPhoneBooksSortedByProperty(String property){
		List allSysPhoneBooks=sysPhoneBookService.findObjectByHQL("from SysPhoneBook");
		List<PhoneBooks> phoneBookList=new ArrayList<PhoneBooks>();
		for (int i = 0; i < allSysPhoneBooks.size(); i++) {
			SysPhoneBook sysPhoneBook=(SysPhoneBook) allSysPhoneBooks.get(i);
			SysPart sysPart=sysPhoneBook.getSysPart();
			PhoneBooks phoneBooks=new PhoneBooks(sysPhoneBook.getId(), sysPhoneBook.getDepartment(),
					sysPhoneBook.getAddress(), sysPhoneBook.getAge(), sysPhoneBook.getSex(),
					sysPhoneBook.getRealName(), sysPhoneBook.getPhone(), sysPhoneBook.getRemark(), sysPart.getId(),sysPart.getPartName());
			phoneBookList.add(phoneBooks);
		}
		
		return phoneBookList;
	}
	/**
	 * 跳转通讯录
	 * 
	 * */
	@RequestMapping("toDepartment")
	public String toDepartment(HttpServletRequest request,@RequestParam("partId")Integer id,Model model){
		model.addAttribute("partId", id);
		return "HappyShare/department";
	}
	
	/**
	 * 获取科室信息
	 * 
	 * */
	@ResponseBody
	@RequestMapping("departmentData")
	public String departmentData(HttpServletRequest request,@RequestParam("partId")Integer id,Model model){
		String json="";
		SysPart sysPart=sysPartService.loadSysPartById(id);
		
		Set<SysPhoneBook> sysPhoneBooks=sysPart.getSysPhoneBooks();
		Set<String> departmentNames=new HashSet<String>();
		List departments=new ArrayList();
		List<Department> departmentList=new ArrayList<Department>();
		for (SysPhoneBook sysPhoneBook : sysPhoneBooks) {
			departmentNames.add(sysPhoneBook.getDepartment());
		}
		//new Department(id, department, address, age, sex, realName, phone, remark)
		for (String string : departmentNames) {
			departments.add(new Department(id, string, null));
		}
		List list=PinyinComparator.sortList(departments,"department",Department.class);
		for (int i = 0; i < list.size(); i++) {
			departmentList.add((Department) list.get(i));
		}
		json=JsonUtils.objectToJson(departmentList);
		return json;
	}
	
	/**
	 * 跳转通讯录
	 * @author wcm
	 * @param String department
	 * @param HttpServletRequest request
	 * @param Model model
	 * @return　String
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("toPhoneBook")
	public String toPhoneBook(HttpServletRequest request,@RequestParam("department")String department,@RequestParam("partId")Integer partId,Model model) throws UnsupportedEncodingException{
		model.addAttribute("department", new String(department.getBytes("iso-8859-1"),"utf-8"));
		model.addAttribute("partId", partId);
		return "HappyShare/phoneBook";
	}
	
	/**
	 * 跳转通讯录
	 * @throws UnsupportedEncodingException 
	 * 
	 * */
	@ResponseBody
	@RequestMapping("phoneBookData")
	public String phoneBookData(HttpServletRequest request,@RequestParam("department")String department,@RequestParam("partId")Integer partId,Model model) throws UnsupportedEncodingException{
		List sysPhoneBooks=sysPhoneBookService.findPhoneBookByDepartmentHQL("from SysPhoneBook where department=?",department);
		List list=PinyinComparator.sortList(sysPhoneBooks,"realName",SysPhoneBook.class);
		List<PhoneBook> phoneBooks=new ArrayList<PhoneBook>();
		for (int i = 0; i < list.size(); i++) {
			SysPhoneBook sysPhoneBook=(SysPhoneBook) list.get(i);
			if (sysPhoneBook.getSysPart().getId()==partId) {
				phoneBooks.add(new PhoneBook(sysPhoneBook.getId(), sysPhoneBook.getRealName(), sysPhoneBook.getPhone()));
			}
		}
		String json=JsonUtils.objectToJson(phoneBooks);
		return json;
	}
	/**
	 * 跳转通讯录
	 * 
	 * */
	@RequestMapping("toPhoneBookDetail")
	public String toPhoneBookDetail(HttpServletRequest request,@RequestParam("id")Integer id,Model model){
		SysPhoneBook sysPhoneBook=sysPhoneBookService.loadSysPhoneBookById(id);
		model.addAttribute("phoneBookDetail",sysPhoneBook);
		model.addAttribute("partName",sysPhoneBook.getSysPart().getPartName());
		return "HappyShare/phoneBookDetail";
	}
}
