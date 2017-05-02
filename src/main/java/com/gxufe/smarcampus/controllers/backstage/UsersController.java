package com.gxufe.smarcampus.controllers.backstage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.ParseExcel;
import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysOrganization;
import com.gxufe.smarcampus.models.SysPart;
import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.service.SysClassService;
import com.gxufe.smarcampus.service.SysCollegeService;
import com.gxufe.smarcampus.service.SysOrganizationService;
import com.gxufe.smarcampus.service.SysPartService;
import com.gxufe.smarcampus.service.SysPhoneBookService;
import com.gxufe.smarcampus.service.SysProfessionalService;
import com.gxufe.smarcampus.service.SysStudentService;
import com.gxufe.smarcampus.service.SysTeacherService;
import com.nepo.weixin.util.JsonUtil;
import com.nepo.weixin.util.WeixinUtil;

@Controller
@RequestMapping(value="backstage")
public class UsersController {
	private static Logger logger = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	public SysProfessionalService sysProfessionalService;
	@Autowired
	public SysCollegeService sysCollegeService;
	@Autowired
	public SysStudentService sysStudentService;
	@Autowired
	public SysClassService sysClassService;
	@Autowired
	public SysTeacherService sysTeacherService;
	@Autowired
	public SysOrganizationService sysOrganizationService;
	@Autowired
	public SysPartService sysPartService;
	@Autowired
	public SysPhoneBookService sysPhoneBookService;
	
	/**
	 * 跳转导入专业信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="toImportProfessionalInfo")
	public String toImportCProfessionalInfo(HttpServletRequest request,Model model){
		
		return "backstage/importProfessionalInfo";
	}
	
	/**
	 * 导入专业信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="importProfessionalInfo")
	public String importProfessionalInfo(@RequestParam("file") CommonsMultipartFile file,Model model){
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 2; i < list.size(); i++) {
				String[] vaules=list.get(i);
				SysProfessional sysProfessional=new SysProfessional();
				List<SysCollege> listSysCollege=sysCollegeService.findSysCollegeByName(vaules[1]);
				if (null==listSysCollege||listSysCollege.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+2+" 列在数据库中没有该学院的记录");
					return "backstage/importProfessionalInfo";
				}
				sysProfessional.setSysCollege(listSysCollege.get(0));
				sysProfessional.setProfessionalCode(vaules[2]);
				sysProfessional.setProfessionalName(vaules[3]);
				sysProfessional.setBelongCourse(vaules[4]);
				sysProfessional.setEducationLevel(vaules[5]);
				try {
					sysProfessional.setEducationDuration(Integer.valueOf(vaules[6]));
				} catch (Exception e) {
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+6+" 列数据格式错误");
					logger.error(e.getMessage());
					return "backstage/importProfessionalInfo";
				}
				
				List<SysProfessional> sysProfessionalList=sysProfessionalService.findObjectByHQL("from SysProfessional c where c.professionalName=?", vaules[3]);
				
				if (null==sysProfessionalList||sysProfessionalList.size()<1) {
					sysProfessionalService.saveOrUpdate(sysProfessional);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!");
		return "backstage/importProfessionalInfo";
	}
	
	/**
	 * 跳转导入学生信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="toImportClassInfo")
	public String toImportClassInfo(HttpServletRequest request,Model model){
		
		return "backstage/importClassInfo";
	}
	
	/**
	 * 导入学生信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="importClassInfo")
	public String importClassInfo(@RequestParam("file") CommonsMultipartFile file,Model model){
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 0; i < list.size(); i++) {
				String[] values=list.get(i);
				SysClass sysClass=new SysClass();
				List<SysProfessional> listProfessional=sysProfessionalService.findObjectByHQL("from SysProfessional professional where professional.professionalName like ?", "%"+values[5]+"%");
				if (null==listProfessional||listProfessional.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+5+" 列在数据库中没有该z专业的记录");
					return "backstage/importProfessionalInfo";
				}
				
				List<SysTeacher> listTeacher=sysTeacherService.findObjectByHQL("from SysTeacher teacher where teacher.realName=?", values[6]);
				if (null==listTeacher||listTeacher.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+6+" 列在数据库中没有该教师的记录");
					return "backstage/importProfessionalInfo";
				}
				sysClass.setSysTeacher(listTeacher.get(0));
				sysClass.setClassName(values[4]);
				sysClass.setSysProfessional(listProfessional.get(0));
				
				List<SysClass> sysClassList=sysClassService.findObjectByHQL("from SysClass c where c.className=?", values[4]);
				
				if (null==sysClassList||sysClassList.size()<1) {
					sysClassService.saveOrUpdate(sysClass);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!");
		return "backstage/importProfessionalInfo";
	}
	/**
	 * 导入部门信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="importPartInfo")
	public String importPartInfo(@RequestParam("file") CommonsMultipartFile file,Model model){
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 0; i < list.size(); i++) {
				String[] values=list.get(i);
				SysPart sysPart=new SysPart();
				List<SysOrganization> listOrganization=sysOrganizationService.findObjectByHQL("from SysOrganization organization where organization.organizationName like ?", "%"+values[1]+"%");
				if (null==listOrganization||listOrganization.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+5+" 列在数据库中没有该组织机构的记录");
					return "backstage/importProfessionalInfo";
				}
				
				sysPart.setPartName(values[0]);
				sysPart.setSysOrganization(listOrganization.get(0));
				
				List<SysPart> sysPartList=sysPartService.findObjectByHQL("from SysPart c where c.partName=?", values[0]);
				
				if (null==sysPartList||sysPartList.size()<1) {
					sysPartService.saveOrUpdate(sysPart);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!");
		return "backstage/importProfessionalInfo";
	}
	/**
	 * 导入教师信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="importTeacherInfo")
	public String importTeacherInfo(@RequestParam("file") CommonsMultipartFile file,Model model){
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 0; i < list.size(); i++) {
				String[] values=list.get(i);
				SysTeacher sysTeacher=new SysTeacher();
				List<SysPart> listPart=sysPartService.findObjectByHQL("from SysPart part where part.partName like ?", "%"+values[2]+"%");
				if (null==listPart||listPart.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+3+" 列在数据库中没有该部门信息的记录");
					return "backstage/importProfessionalInfo";
				}
				
				sysTeacher.setMobile(values[4]);
				sysTeacher.setWorkNumber(values[0]);
				sysTeacher.setPositionName(values[3]);
				sysTeacher.setRealName(values[1]);
				sysTeacher.setSysPart(listPart.get(0));
				
				List<SysTeacher> sysTeacherList=sysTeacherService.findObjectByHQL("from SysTeacher c where c.realName=?", values[0]);
				
				if (null==sysTeacherList||sysTeacherList.size()<1) {
					sysTeacherService.saveOrUpdate(sysTeacher);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!");
		return "backstage/importProfessionalInfo";
	}
	
	/**
	 * 跳转导入学生信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * */
	@RequestMapping(value="toImportStudentInfo")
	public String toStudentInfo(HttpServletRequest request,Model model){
		
		return "backstage/importStudentInfo";
	}
	
	/**
	 * 导入学生信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * @throws ParseException 
	 * */
	@RequestMapping(value="importStudentInfo")
	public String importStudentInfo(@RequestParam("file") CommonsMultipartFile file,Model model) throws ParseException{
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 0; i < list.size(); i++) {
				String[] values=list.get(i);
				SysStudent sysStudent=new SysStudent();
				List<SysClass> listClass=sysClassService.findObjectByHQL("from SysClass c where c.className like ?","%"+values[4]+"%");
				if (null==listClass||listClass.size()<1) {
					Map<String, String> map=new HashMap<String, String>();
					model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+4+" 列在数据库中没有该班级的记录");
					return "backstage/importProfessionalInfo";
				}
				sysStudent.setStudentNumber(values[0]);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date date=sdf.parse(values[1]);
				sysStudent.setIntoSchoolYear(new Timestamp(date.getTime()));
				sysStudent.setRealName(values[2]);
				sysStudent.setSex(values[3]);
				sysStudent.setSysClass(listClass.get(0));
				sysStudent.setMobile(values[9]);
				
				List<SysStudent> listStudent=sysStudentService.findObjectByHQL("from SysStudent c where c.studentNumber=?",values[0]);
				if (null==listStudent||listStudent.size()<1) {
					sysStudentService.saveOrUpdate(sysStudent);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!");
		return "backstage/importProfessionalInfo";
	}
	
	/**
	 * 导入通讯录信息
	 * @author wcm
	 * @param HttpServletRequest
	 * @param Model
	 * @return String 
	 * @throws ParseException 
	 * */
	@RequestMapping(value="importPhoneBookInfo")
	public String importPhoneBookInfo(@RequestParam("file") CommonsMultipartFile file,Model model) throws ParseException{
		String fileName=file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
		String html="";
		try {
			List<String[]> list=ParseExcel.rosolveFile(file.getInputStream(), suffix, 1);
			for (int i = 2; i < list.size(); i++) {
				String[] values=list.get(i);
				if (!(null==values[0]||"".equals(values[0]))) {
					
					SysPhoneBook sysPhoneBook=new SysPhoneBook();
					
					values[0]=values[0].trim();
					values[1]=values[1].trim();
					values[3]=values[3].trim();
					List<SysPart> listPart=sysPartService.findObjectByHQL("from SysPart c where c.partName like ?","%"+values[0]+"%");
					if (null==listPart||listPart.size()<1) {
						Map<String, String> map=new HashMap<String, String>();
						model.addAttribute("msg", "对不起您导入的数据表中的第    "+(i+1)+"  行  第  "+1+" 列在数据库中没有该部门的记录");
						return "backstage/importProfessionalInfo";
					}
					sysPhoneBook.setSysPart(listPart.get(0));
					sysPhoneBook.setDepartment(values[1]);
					sysPhoneBook.setRealName(values[2]);
					sysPhoneBook.setPhone(values[3]);
					String[] parms={values[2],values[3],values[1]};
					
					List<SysPhoneBook> listStudent=sysPhoneBookService.findObjectByHQL("from SysPhoneBook c where c.realName=? and c.phone=? and c.department=?",parms);
					if (null==listStudent||listStudent.size()<1) {
						sysPhoneBookService.saveOrUpdate(sysPhoneBook);
					}
					if (listStudent!=null&&listStudent.size()>0) {
						html+=listStudent.get(0).getDepartment()+"\t"+listStudent.get(0).getRealName()+"<br>";
					}
						
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("msg", "数据导入成功!<br>"+html);
		return "backstage/importProfessionalInfo";
	}
}
