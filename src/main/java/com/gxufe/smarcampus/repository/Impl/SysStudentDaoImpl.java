package com.gxufe.smarcampus.repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.repository.SysCollegeDao;
import com.gxufe.smarcampus.repository.SysProfessionalDao;
import com.gxufe.smarcampus.repository.SysRolesDao;
import com.gxufe.smarcampus.repository.SysStudentDao;
@Repository
public class SysStudentDaoImpl extends BaseDaoImpl<SysStudent, Integer> implements SysStudentDao {
	public SysStudentDaoImpl() {
		this.entityClass = SysStudent.class;
	}
}
