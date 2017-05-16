package com.gxufe.smarcampus.service;

import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;

public interface SysUsersService extends BaseService<SysUsers, Integer> {

	SysUsers findUsersByTeacherId(Integer id);

	SysUsers findUsersByStudentId(Integer id);
	
	//根据学号获取辅导员信息
	SysTeacher findTeacherByStudentNumber(String studentNumber);
}
