package com.gxufe.smarcampus.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.models.SysStudent;
import com.gxufe.smarcampus.models.SysTeacher;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysTeacherDao;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.SysStudentService;
import com.gxufe.smarcampus.service.SysTeacherService;
import com.gxufe.smarcampus.service.SysUsersService;

@Service
public class SysTeacherServiceImpl extends BaseServicImpl<SysTeacher, Integer> implements
SysTeacherService {

	@Autowired
	public SysTeacherDao sysTeacherDao;
	
	@Override
	public SysTeacher findTeacherByWorkNumber(String userNumber) {
		List<SysTeacher> list=sysTeacherDao.find("from SysTeacher where workNumber=?", userNumber);
		if (list.size()>0) {
			
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public SysTeacher findSysTeacherById(Integer id) {
		// TODO Auto-generated method stub
		return sysTeacherDao.load(id);
	}
}
