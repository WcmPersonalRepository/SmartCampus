package com.gxufe.smarcampus.controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxufe.smarcampus.common.util.JsonUtils;
import com.gxufe.smarcampus.common.util.SessionUtils;
import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysLeaveInfo;
import com.gxufe.smarcampus.models.SysLeaveInfoRecord;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.models.UserBean;
import com.gxufe.smarcampus.service.SysLeaveInfoRecordService;
import com.gxufe.smarcampus.service.SysLeaveInfoService;
import com.gxufe.smarcampus.service.SysProfessionalService;
import com.gxufe.smarcampus.service.SysRolesService;
import com.gxufe.smarcampus.service.SysStudentService;
import com.gxufe.smarcampus.service.SysTeacherService;
import com.gxufe.smarcampus.service.SysUsersService;

@RequestMapping("/educationalManager")
@Controller
public class EducationalManagerContrller {
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
	@Autowired
	public SysLeaveInfoService sysLeaveInfoService;
	@Autowired
	public SysLeaveInfoRecordService sysLeaveInfoRecordService;
	@Autowired
	public SysProfessionalService sysProfessionalService;
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
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();
		if ("1".equals(userType)) {//教师
			//查询当前老师所有未批假记录
			List<SysLeaveInfo> sysLeaveInfose=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where isNew=1 and id in(select sysLeaveInfo.id from SysLeaveInfoRecord where sysUsers.userId=?)", userInfo.getSysUsers().getUserId());
			if (sysLeaveInfose.size()>0) {
				model.addAttribute("isNew", 1);
			}
			else{
				model.addAttribute("isNew", 2);
			}
			//根据申请日期分组统计
			//sysLeaveInfoService.findObjectByHQL("SELECT day(s.applyDate),COUNT(s.id) FROM SysLeaveInfo as s GROUP BY day(r.recDate)");
			List list=sysLeaveInfoService.findObjectByHQL("SELECT new Map(year(s.applyDate) as year,month(s.applyDate) as month,day(s.applyDate) as day,COUNT(s.id) as count) FROM SysLeaveInfo as s where id in(select sysLeaveInfo.id from SysLeaveInfoRecord where sysUsers.userId=?) GROUP BY year(s.applyDate),month(s.applyDate),day(s.applyDate) order by year(s.applyDate) desc,month(s.applyDate) desc,day(s.applyDate) desc",userInfo.getSysUsers().getUserId());
			List<Map<String ,String>> makeLeaveRecords=new ArrayList<>();
			for (Object object : list) {
				Map<String ,String> map=new HashMap<String ,String>();
				String year=((Map)object).get("year").toString();
				String month=Integer.valueOf(((Map)object).get("month").toString())<10?"0"+((Map)object).get("month"):((Map)object).get("month").toString();
				String day=Integer.valueOf(((Map)object).get("day").toString())<10?"0"+((Map)object).get("day"):((Map)object).get("day").toString();
				map.put("date", year+"-"+month+"-"+day);
				map.put("count",((Map)object).get("count").toString());
				makeLeaveRecords.add(map);
			}
			logger.info("[makeLeaveRecords]="+makeLeaveRecords);
			model.addAttribute("makeLeaveRecords", makeLeaveRecords);
		}
		if ("2".equals(userType)) {//学生
			List<SysLeaveInfo> sysLeaveInfose=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where id in(select sysLeaveInfo.id from SysLeaveInfoRecord where sysUsers.userId=?) order by applyDate desc", userInfo.getSysUsers().getUserId());
			model.addAttribute("sysLeaveInfose", sysLeaveInfose);
		}
		model.addAttribute("userType", userType);
		return "EducationalManager/onlineLeave";
	}
	
	/**
	 * 跳转查看请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/onlineLeave/lookLeaveInfo",method=RequestMethod.GET)
	public String lookLeaveInfo(HttpServletRequest request,Model model){
		//UserBean userInfo=SessionUtils.getUserBySession(request);
		String stateCode=request.getParameter("stateCode");
		Integer id=Integer.valueOf(request.getParameter("id"));
		//根据id检索请假单信息
		List<SysLeaveInfo> sysLeaveInfose=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where id=?", id);
		SysUsers userInfo= sysLeaveInfose.get(0).getSysUsers();
		model.addAttribute("realName", userInfo.getSysStudent().getRealName());
		model.addAttribute("className", userInfo.getSysStudent().getSysClass().getClassName());
		model.addAttribute("studentNumber", userInfo.getSysStudent().getStudentNumber());
		model.addAttribute("professional", userInfo.getSysStudent().getSysClass().getSysProfessional().getProfessionalName());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String intoSchoolYear=sdf.format(userInfo.getSysStudent().getIntoSchoolYear());
		model.addAttribute("intoSchoolYear", intoSchoolYear);
		model.addAttribute("collegeName", userInfo.getSysStudent().getSysClass().getSysProfessional().getSysCollege().getCollegeName());
		model.addAttribute("sex", userInfo.getSysStudent().getSex());
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		model.addAttribute("studentMobile", sysLeaveInfose.get(0).getReservedField1());
		model.addAttribute("familyMobile", sysLeaveInfose.get(0).getReservedField2());
		String startTime=sdf2.format(sysLeaveInfose.get(0).getLeaveStartDate())+" "+sysLeaveInfose.get(0).getLeaveStartLesson();
		String endTime=sdf2.format(sysLeaveInfose.get(0).getLeaveEndDate())+" "+sysLeaveInfose.get(0).getLeaveEndLesson();
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("leaveReason", sysLeaveInfose.get(0).getApproverDescription());
		model.addAttribute("statusCode", sysLeaveInfose.get(0).getStatusCode());
		model.addAttribute("approverAdvice", sysLeaveInfose.get(0).getApproverAdvice());
		if (sysLeaveInfose.get(0).getIsFamilyAgree()==1) {
			model.addAttribute("isFamilyAgree", "是");
		}
		if (sysLeaveInfose.get(0).getIsFamilyAgree()==2) {
			model.addAttribute("isFamilyAgree", "否");
		}
		if ("1".equals(stateCode)) {//单人请假
			model.addAttribute("classTeacher", sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber()).getRealName());
			
			return "EducationalManager/lookSingleLeaveInfo";
		}
		if ("2".equals(stateCode)) {//多人请假
			List<SysLeaveInfoRecord> sysLeaveInfoRecords=sysLeaveInfoRecordService.findObjectByHQL("from SysLeaveInfoRecord where sysLeaveInfo.id=?", id);
			SysTeacher sysTeacher=null;
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			for (SysLeaveInfoRecord sysLeaveInfoRecord : sysLeaveInfoRecords) {
				Integer userId=sysLeaveInfoRecord.getSysUsers().getUserId();
				List<SysUsers> sysUsers=sysUsersService.findObjectByHQL("from SysUsers where userId=?", userId);
				SysUsers sysUser=sysUsers.get(0);
				List<SysRoles> sysRolese=sysRolesService.findObjectByHQL("from SysRoles where sysUsers.userId=?", userId);
				Boolean haveMakeLeaveRoll=false;
				for (SysRoles sysRoles : sysRolese) {
					if ("ROLL_STUDENT".equals(sysRoles.getRoleName())) {
						
					}
					if ("ROLL_LEADER_MAKE_LEAVE".equals(sysRoles.getRoleName())) {
						haveMakeLeaveRoll=true;
						break;
					}
				}
				if (haveMakeLeaveRoll) {
					sysTeacher=sysLeaveInfoRecord.getSysUsers().getSysTeacher();
				}
				if (!(userId==userInfo.getUserId()||haveMakeLeaveRoll)) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("userId", sysUser.getUserId().toString());
					map.put("realName", sysUser.getSysStudent().getRealName());
					map.put("studentNumber", sysUser.getSysStudent().getStudentNumber());
					map.put("className",sysUser.getSysStudent().getSysClass().getClassName());
					map.put("mobile",sysUser.getSysStudent().getMobile());
					list.add(map);
				}
			}
			model.addAttribute("students", list);
			model.addAttribute("classTeacher", sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber()).getRealName());
			return "EducationalManager/lookMoreLeaveInfo";
		}
		return "";
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
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();
		
		if ("1".equals(userType)) {//教师
			
		}
		if ("2".equals(userType)) {//学生
			model.addAttribute("realName", userInfo.getSysStudent().getRealName());
			model.addAttribute("className", userInfo.getSysClass().getClassName());
			model.addAttribute("studentNumber", userInfo.getSysStudent().getStudentNumber());
			model.addAttribute("professional", userInfo.getSysProfessional().getProfessionalName());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String intoSchoolYear=sdf.format(userInfo.getSysStudent().getIntoSchoolYear());
			model.addAttribute("intoSchoolYear", intoSchoolYear);
			model.addAttribute("collegeName", userInfo.getSysCollege().getCollegeName());
			model.addAttribute("sex", userInfo.getSysStudent().getSex());
			model.addAttribute("mobile", userInfo.getSysStudent().getMobile());
			model.addAttribute("classTeacher", sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber()).getRealName());
		}
		return "EducationalManager/studentLeave";
	}
	

	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@ResponseBody
	@RequestMapping(value="/onlineLeave/getSysProfessionalsAndClass",method=RequestMethod.GET)
	public String getsysProfessionalsAndClass(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String json="";
		//查出当前学生所在学院的所有专业
		List<SysProfessional>  sysProfessionals=sysProfessionalService.findObjectByHQL("from SysProfessional where sysCollege.id=?", userInfo.getSysCollege().getId());
		//查出当前学生所在学院的所有班级
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, Object>> sysProfessionalsList=new ArrayList<Map<String, Object>>();;
		
		for (SysProfessional sysProfessional : sysProfessionals) {
			Map<String, Object> map1=new HashMap<String, Object>();
			map1.put("professionalId", sysProfessional.getId());
			map1.put("professionalName", sysProfessional.getProfessionalName());
			Set<SysClass> sysClasses=sysProfessional.getSysClasses();
			List<Map<String, Object>> sysClassesList=new ArrayList<Map<String, Object>>();
			for (SysClass sysClass : sysClasses) {
				Map<String, Object> map2=new HashMap<String, Object>();
				map2.put("classId", sysClass.getId());
				map2.put("className", sysClass.getClassName());
				sysClassesList.add(map2);
			}
			map1.put("sysClasses", sysClassesList);
			sysProfessionalsList.add(map1);
		}
		map.put("sysProfessionals", sysProfessionalsList);
		map.put("code", "0");
		json=JsonUtils.objectToJson(map);
		return json;
	}

	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@ResponseBody
	@RequestMapping(value="/onlineLeave/getStudents",method=RequestMethod.POST)
	public String getStudents(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String professionalName=request.getParameter("professional");
		String className=request.getParameter("sysClass");
		String json="";
		Map<String,Object> rs=new HashMap<String,Object>();
		try {
			
			Object[] values={className,userInfo.getSysUsers().getUserId()};
			List<SysUsers> sysUsers=sysUsersService.findObjectByHQL("from SysUsers where sysStudent.id in(select id from SysStudent where sysClass.id=(select id from SysClass where className=?)) and userId!=?", values);
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			for (SysUsers sysUser : sysUsers) {
				Map<String, String> map=new HashMap<String, String>();
				map.put("userId", sysUser.getUserId().toString());
				map.put("realName", sysUser.getSysStudent().getRealName());
				map.put("studentNumber", sysUser.getSysStudent().getStudentNumber());
				map.put("className",className);
				map.put("mobile",sysUser.getSysStudent().getMobile());
				list.add(map);
			}
			if (list.size()>0) {
				rs.put("students", list);
				rs.put("code", "0");
			}else{
				rs.put("msg", "很遗憾没有任何记录");
				rs.put("code", "1");
			}
		} catch (Exception e) {
			rs.put("msg", "数据查询错误");
			rs.put("code", "-1");
			json=JsonUtils.objectToJson(rs);
			return json;	
		}
		json=JsonUtils.objectToJson(rs);
		return json;	
	}

	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@ResponseBody
	@RequestMapping(value="/onlineLeave/studentLeave",method=RequestMethod.POST)
	public String studentLeave(HttpServletRequest request,Model model){
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String userType=userInfo.getUserType();
		String json="";
		String studentPhone=request.getParameter("studentPhone");
		String familyPhone=request.getParameter("familyPhone");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String leaveReason=request.getParameter("leaveReason");
		String familyIsAgree=request.getParameter("familyIsAgree");
		String stateCode=request.getParameter("stateCode");
		String ids=request.getParameter("ids");
		Map<String, String> map=new HashMap<String, String>();
		//家长意见
		Integer isFamilyAgree=2;
		//请假结束日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp leaveEndDate=Timestamp.valueOf(endTime.substring(0,endTime.lastIndexOf(" "))+":00");
		//请假开始日期
		Timestamp leaveStartDate=Timestamp.valueOf(startTime.substring(0,startTime.lastIndexOf(" "))+":00");
		
		if ("是".equals(familyIsAgree)) {
			isFamilyAgree=1;
		}
		//申请人的辅导员
		SysTeacher sysTeacher=sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber());
		Timestamp applyDate=new Timestamp(new Date().getTime());
		if ("1".equals(stateCode)) {//单人请假
			SysLeaveInfo sysLeaveInfo=new SysLeaveInfo(
					userInfo.getSysUsers(), 
					null, leaveReason,
					isFamilyAgree, 
					leaveEndDate, 
					endTime.substring(endTime.lastIndexOf(" "),endTime.length()), leaveStartDate,
					startTime.substring(startTime.lastIndexOf(" "),startTime.length()), studentPhone, familyPhone, null, null, 
					1, 
					Integer.valueOf(stateCode), 0,applyDate, null, 0,null);
		
			try {
				sysLeaveInfoService.saveOrUpdate(sysLeaveInfo);
				//保存所有有关的记录，包括涉及到的学生和批假的老师
				//String[] idsArray=ids.split(",");
				Object[] values={userInfo.getSysUsers().getUserId(),applyDate};
				List<SysLeaveInfo> sysLeaveInfos=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where sysUsers.userId=? and applyDate=?", values);
				
				//保存辅导员的记录
				List<SysUsers> teacherSysUsers=sysUsersService.findObjectByHQL("from SysUsers where sysTeacher.id=?", sysTeacher.getId());
				SysLeaveInfoRecord sysLeaveInfoRecord2=new SysLeaveInfoRecord(teacherSysUsers.get(0), sysLeaveInfos.get(0));
				sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord2);
				
				//保存本人的记录
				SysLeaveInfoRecord sysLeaveInfoRecord=new SysLeaveInfoRecord(userInfo.getSysUsers(), sysLeaveInfos.get(0));
				sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord);
				/*for (int i = 0; i < idsArray.length; i++) {
				}*/
				
				map.put("code", "0");
				map.put("msg", "请假天提交成功");
				json=JsonUtils.objectToJson(map);
				return json;
			} catch (Exception e) {
				logger.error(e.getMessage());
				map.put("code", "-1");
				map.put("msg", "请假天提交失败");
				json=JsonUtils.objectToJson(map);
				return json;
			}
		}
		if ("2".equals(stateCode)) {//多人请假
			String[] idsArr=ids.split(",");
			Boolean isSameTeacher=true;
			//判断辅导员是否相同
			for (int i = 0; i < idsArr.length; i++) {
				List<SysUsers> sysUsers=sysUsersService.findObjectByHQL("from SysUsers where userId=?", Integer.valueOf(idsArr[i]));
				if (sysUsers.size()>0) {
					Integer teacherId=sysUsers.get(0).getSysStudent().getSysClass().getSysTeacher().getId();
					
					if (teacherId!=sysTeacher.getId()) {
						isSameTeacher=false;
						break;
					}
				}else{
					map.put("code", "1");
					map.put("msg", "有学生未进行校方认证");
					json=JsonUtils.objectToJson(map);
					return json;
				}
			}
			//辅导员相同
			if (isSameTeacher) {
				SysLeaveInfo sysLeaveInfo=new SysLeaveInfo(
						userInfo.getSysUsers(), //请假人
						null, //批假人意见
						leaveReason,//请假理由
						isFamilyAgree, //家长是否同意
						leaveEndDate, //请假结束日期
						endTime.substring(endTime.lastIndexOf(" "),//结束节次
						endTime.length()), leaveStartDate,//请假开始日期
						startTime.substring(startTime.lastIndexOf(" "),startTime.length()), //开始节次
						studentPhone, familyPhone, null, null, 
						1, //1未处理 2已处理
						Integer.valueOf(stateCode),//1单人请假 2多人请假
						0,//0审批中 1已同意 2已拒绝
						applyDate, //请假时间
						null,//批假日期
						0,//是否删除
						null);
			
				try {
					sysLeaveInfoService.saveOrUpdate(sysLeaveInfo);
					//保存所有有关的记录，包括涉及到的学生和批假的老师
					//String[] idsArray=ids.split(",");
					Object[] values={userInfo.getSysUsers().getUserId(),applyDate};
					List<SysLeaveInfo> sysLeaveInfos=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where sysUsers.userId=? and applyDate=?", values);
					//保存本人的记录
					SysLeaveInfoRecord sysLeaveInfoRecord1=new SysLeaveInfoRecord(userInfo.getSysUsers(), sysLeaveInfos.get(0));
					sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord1);
					//保存辅导员的记录
					List<SysUsers> teacherSysUsers=sysUsersService.findObjectByHQL("from SysUsers where sysTeacher.id=?", sysTeacher.getId());
					SysLeaveInfoRecord sysLeaveInfoRecord2=new SysLeaveInfoRecord(teacherSysUsers.get(0), sysLeaveInfos.get(0));
					sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord2);
					//保存其他请假人的记录
					for (int i = 0; i < idsArr.length; i++) {
						//根据id查找对应的用户user对象
						List<SysUsers> userList=sysUsersService.findObjectByHQL("from SysUsers where userId=?", Integer.valueOf(idsArr[i]));
						SysLeaveInfoRecord sysLeaveInfoRecord=new SysLeaveInfoRecord(userList.get(0), sysLeaveInfos.get(0));
						sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord);
						
					}
					
					map.put("code", "0");
					map.put("msg", "请假天提交成功");
					json=JsonUtils.objectToJson(map);
					return json;
				} catch (Exception e) {
					logger.error(e.getMessage());
					map.put("code", "-1");
					map.put("msg", "请假天提交失败");
					json=JsonUtils.objectToJson(map);
					return json;
				}
			}
			//辅导员不同
			else{
				Object[] values={"%分团委%","%信息与统计学院%"};
				//查找当前学生所在学院分团委的批假老师
				List<SysTeacher> fTTeachers=sysTeacherService.findObjectByHQL("from SysTeacher where positionName like ? and sysPart.id=(SELECT id FROM SysPart WHERE partName LIKE ?)", values);
				if (fTTeachers.size()>0) {
					for (SysTeacher sysTeacher2 : fTTeachers) {
						//判断该老师是否已在系统中进行认证
						SysUsers u=sysUsersService.findUsersByTeacherId(sysTeacher2.getId());
						if (null==u) {
							map.put("code", "-2");
							map.put("msg", "您所在学院扥分团委尚未在本系统认证，无法进行多人请假，请与有关工作人员联系");
							json=JsonUtils.objectToJson(map);
							return json;
						}else{
							//判断当前老师是否具有批假权限
							List<SysRoles> sysRoles=sysRolesService.findObjectByHQL("from SysRoles where sysUsers.userId=?", u.getUserId());
							for (SysRoles sysRoles2 : sysRoles) {
								if ("ROLL_LEADER_MAKE_LEAVE".equals(sysRoles2.getRoleName())) {
									SysLeaveInfo sysLeaveInfo=new SysLeaveInfo(
											userInfo.getSysUsers(), //请假人
											null, //批假人意见
											leaveReason,//请假理由
											isFamilyAgree, //家长是否同意
											leaveEndDate, //请假结束日期
											endTime.substring(endTime.lastIndexOf(" "),//结束节次
											endTime.length()), leaveStartDate,//请假开始日期
											startTime.substring(startTime.lastIndexOf(" "),startTime.length()), //开始节次
											studentPhone, familyPhone, null, null, 
											1, //1未处理 2已处理
											Integer.valueOf(stateCode),//1单人请假 2多人请假
											0,//0审批中 1已同意 2已拒绝
											applyDate, //请假时间
											null,//批假日期
											0,//是否删除
											null);
								
									try {
										sysLeaveInfoService.saveOrUpdate(sysLeaveInfo);
										//保存所有有关的记录，包括涉及到的学生和批假的老师
										//String[] idsArray=ids.split(",");
										//保存本人的记录
										Object[] values1={userInfo.getSysUsers().getUserId(),applyDate};
										List<SysLeaveInfo> sysLeaveInfos=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where sysUsers.userId=? and applyDate=?", values1);
										SysLeaveInfoRecord sysLeaveInfoRecord1=new SysLeaveInfoRecord(userInfo.getSysUsers(), sysLeaveInfos.get(0));
										sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord1);
										
										//保存辅导员的记录
										List<SysUsers> teacherSysUsers=sysUsersService.findObjectByHQL("from SysUsers where sysTeacher.id=?", sysTeacher.getId());
										SysLeaveInfoRecord sysLeaveInfoRecord2=new SysLeaveInfoRecord(u, sysLeaveInfos.get(0));
										sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord2);
										//保存其他请假人的记录
										for (int i = 0; i < idsArr.length; i++) {
											//根据id查找对应的用户user对象
											List<SysUsers> userList=sysUsersService.findObjectByHQL("from SysUsers where userId=?", Integer.valueOf(idsArr[i]));
											SysLeaveInfoRecord sysLeaveInfoRecord=new SysLeaveInfoRecord(userList.get(0), sysLeaveInfos.get(0));
											sysLeaveInfoRecordService.saveOrUpdate(sysLeaveInfoRecord);
											
										}
										
									} catch (Exception e) {
										logger.error(e.getMessage());
										map.put("code", "-1");
										map.put("msg", "请假天提交失败");
										json=JsonUtils.objectToJson(map);
										return json;
									}
									break;
								}
							}
						}
					}
					
					map.put("code", "0");
					map.put("msg", "请假天提交成功");
					json=JsonUtils.objectToJson(map);
					return json;
					
				}else{
					map.put("code", "-2");
					map.put("msg", "您所在学院扥分团委尚未在本系统认证，无法进行多人请假，请与有关工作人员联系");
					json=JsonUtils.objectToJson(map);
					return json;
				}
			}
			
		}
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
		UserBean userInfo=SessionUtils.getUserBySession(request);
		String date=request.getParameter("date");
		List<SysLeaveInfo> sysLeaveInfoList=null;
		if (!(null==date||"".equals(date))) {
			String[] dateArr=date.split("-");
			Object[] values={Integer.valueOf(dateArr[0]),Integer.valueOf(dateArr[1]),Integer.valueOf(dateArr[2]),userInfo.getSysUsers().getUserId()};
			sysLeaveInfoList=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo as s where year(s.applyDate)=? and month(s.applyDate)=? and day(s.applyDate)=? and id in(select sysLeaveInfo.id from SysLeaveInfoRecord where sysUsers.userId=?)", values);
		}else{
			Object[] values={userInfo.getSysUsers().getUserId()};
			sysLeaveInfoList=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo as s where s.isNew=1 and id in(select sysLeaveInfo.id from SysLeaveInfoRecord where sysUsers.userId=?) order by s.applyDate desc", values);
		}
		List<Map<String, String>> sysLeaveInfose=new ArrayList<Map<String, String>>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		int waitOptionCount=0;
		for (SysLeaveInfo sysLeaveInfo : sysLeaveInfoList) {
			Map<String, String> map=new HashMap<String, String>();
			map.put("id", sysLeaveInfo.getId().toString());
			map.put("stateCode", sysLeaveInfo.getStateCode().toString());
			map.put("applyDate", sdf.format(sysLeaveInfo.getApplyDate()));
			map.put("realName", sysLeaveInfo.getSysUsers().getSysStudent().getRealName());
			map.put("className", sysLeaveInfo.getSysUsers().getSysStudent().getSysClass().getClassName());
			map.put("sex", sysLeaveInfo.getSysUsers().getSysStudent().getSex());
			map.put("isNew", sysLeaveInfo.getIsNew().toString());
			if (sysLeaveInfo.getIsNew()==1) {
				waitOptionCount++;
			}
			sysLeaveInfose.add(map);
		}
		model.addAttribute("total", waitOptionCount);
		model.addAttribute("sysLeaveInfose", sysLeaveInfose);
		return "EducationalManager/makeLeave";
	}
	
	/**
	 * 批假请假信息
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@RequestMapping(value="/onlineLeave/toMakeLeaveInfo",method=RequestMethod.GET)
	public String toMakeLeaveInfo(HttpServletRequest request,Model model){
		//UserBean userInfo=SessionUtils.getUserBySession(request);
		String stateCode=request.getParameter("stateCode");
		Integer id=Integer.valueOf(request.getParameter("id"));
		//根据id检索请假单信息
		List<SysLeaveInfo> sysLeaveInfose=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where id=?", id);
		SysUsers userInfo= sysLeaveInfose.get(0).getSysUsers();
		model.addAttribute("id", id);
		model.addAttribute("realName", userInfo.getSysStudent().getRealName());
		model.addAttribute("className", userInfo.getSysStudent().getSysClass().getClassName());
		model.addAttribute("studentNumber", userInfo.getSysStudent().getStudentNumber());
		model.addAttribute("professional", userInfo.getSysStudent().getSysClass().getSysProfessional().getProfessionalName());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String intoSchoolYear=sdf.format(userInfo.getSysStudent().getIntoSchoolYear());
		model.addAttribute("intoSchoolYear", intoSchoolYear);
		model.addAttribute("collegeName", userInfo.getSysStudent().getSysClass().getSysProfessional().getSysCollege().getCollegeName());
		model.addAttribute("sex", userInfo.getSysStudent().getSex());
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		model.addAttribute("studentMobile", sysLeaveInfose.get(0).getReservedField1());
		model.addAttribute("familyMobile", sysLeaveInfose.get(0).getReservedField2());
		String startTime=sdf2.format(sysLeaveInfose.get(0).getLeaveStartDate())+" "+sysLeaveInfose.get(0).getLeaveStartLesson();
		String endTime=sdf2.format(sysLeaveInfose.get(0).getLeaveEndDate())+" "+sysLeaveInfose.get(0).getLeaveEndLesson();
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("leaveReason", sysLeaveInfose.get(0).getApproverDescription());
		model.addAttribute("statusCode", sysLeaveInfose.get(0).getStatusCode());
		model.addAttribute("approverAdvice", sysLeaveInfose.get(0).getApproverAdvice());
		if (sysLeaveInfose.get(0).getIsFamilyAgree()==1) {
			model.addAttribute("isFamilyAgree", "是");
		}
		if (sysLeaveInfose.get(0).getIsFamilyAgree()==2) {
			model.addAttribute("isFamilyAgree", "否");
		}
		if ("1".equals(stateCode)) {//单人请假
			model.addAttribute("classTeacher", sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber()).getRealName());
			
			return "EducationalManager/singleLeaveInfo";
		}
		if ("2".equals(stateCode)) {//多人请假
			List<SysLeaveInfoRecord> sysLeaveInfoRecords=sysLeaveInfoRecordService.findObjectByHQL("from SysLeaveInfoRecord where sysLeaveInfo.id=?", id);
			SysTeacher sysTeacher=null;
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			for (SysLeaveInfoRecord sysLeaveInfoRecord : sysLeaveInfoRecords) {
				Integer userId=sysLeaveInfoRecord.getSysUsers().getUserId();
				List<SysUsers> sysUsers=sysUsersService.findObjectByHQL("from SysUsers where userId=?", userId);
				SysUsers sysUser=sysUsers.get(0);
				List<SysRoles> sysRolese=sysRolesService.findObjectByHQL("from SysRoles where sysUsers.userId=?", userId);
				Boolean haveMakeLeaveRoll=false;
				for (SysRoles sysRoles : sysRolese) {
					if ("ROLL_STUDENT".equals(sysRoles.getRoleName())) {
						
					}
					if ("ROLL_LEADER_MAKE_LEAVE".equals(sysRoles.getRoleName())) {
						haveMakeLeaveRoll=true;
						break;
					}
				}
				if (haveMakeLeaveRoll) {
					sysTeacher=sysLeaveInfoRecord.getSysUsers().getSysTeacher();
				}
				if (!(userId==userInfo.getUserId()||haveMakeLeaveRoll)) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("userId", sysUser.getUserId().toString());
					map.put("realName", sysUser.getSysStudent().getRealName());
					map.put("studentNumber", sysUser.getSysStudent().getStudentNumber());
					map.put("className",sysUser.getSysStudent().getSysClass().getClassName());
					map.put("mobile",sysUser.getSysStudent().getMobile());
					list.add(map);
				}
			}
			model.addAttribute("students", list);
			model.addAttribute("classTeacher", sysUsersService.findTeacherByStudentNumber(userInfo.getSysStudent().getStudentNumber()).getRealName());
			return "EducationalManager/moreLeaveInfo";
		}
		return "";
	}
	
	/**
	 * 跳转请假信息页面
	 * @author wcm
	 * @param HttpServletRequest request
	 * @param Model model
	 * return String
	 * */
	@ResponseBody
	@RequestMapping(value="/onlineLeave/makeLeave",method=RequestMethod.POST)
	public String makeLeave(HttpServletRequest request,Model model){
		Integer id=Integer.valueOf(request.getParameter("id"));
		Integer statusCode=Integer.valueOf(request.getParameter("statusCode"));
		String approverAdvice=request.getParameter("approverAdvice");
		List<SysLeaveInfo> sysLeaveInfose=sysLeaveInfoService.findObjectByHQL("from SysLeaveInfo where id=?", id);
		SysLeaveInfo sysLeaveInfo=sysLeaveInfose.get(0);
		//更新处理状态
		sysLeaveInfo.setIsNew(2);
		//更新请假状态
		sysLeaveInfo.setStatusCode(statusCode);
		//更新请假日期
		sysLeaveInfo.setTeacherOptionDate(new Timestamp(new Date().getTime()));
		//更新批假意见
		sysLeaveInfo.setApproverAdvice(approverAdvice);
		String json="";
		Map<String, String> map=new HashMap<String, String>();
		try {
			sysLeaveInfoService.saveOrUpdate(sysLeaveInfo);
			map.put("code", "0");
			map.put("msg", "批假成功");
			json=JsonUtils.objectToJson(map);
		} catch (Exception e) {
			map.put("code", "1");
			map.put("msg", "批假失败");
			json=JsonUtils.objectToJson(map);
		}
		
		return json;
	}
	
	@RequestMapping("/showVideo")
	public String showVideo(HttpServletRequest request,Model model){
		return "EducationalManager/videoPlay";
	}
	
	
}
