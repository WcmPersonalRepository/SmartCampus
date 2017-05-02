package com.gxufe.smarcampus.service;

import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;

public interface SysTeacherService extends BaseService<SysTeacher, Integer> {

	SysTeacher findTeacherByWorkNumber(String userNumber);

	SysTeacher findSysTeacherById(Integer id);
}
