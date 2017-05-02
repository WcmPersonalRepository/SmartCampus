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
import com.gxufe.smarcampus.repository.SysStudentDao;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.SysStudentService;
import com.gxufe.smarcampus.service.SysUsersService;

@Service
public class SysStudentServiceImpl extends BaseServicImpl<SysStudent, Integer> implements
SysStudentService {
	@Autowired
	public SysStudentDao sysStudentDao;
	@Override
	public SysStudent findStudentByWorkNumber(String userNumber) {
		List<SysStudent> list=sysStudentDao.find("from SysStudent where studentNumber=?", userNumber);
		if (list.size()>0) {
			
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public SysStudent findSysStudentById(Integer valueOf) {
		// TODO Auto-generated method stub
		return sysStudentDao.load(valueOf);
	}
}
