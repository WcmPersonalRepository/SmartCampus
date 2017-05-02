package com.gxufe.smarcampus.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.SysUsersService;

@Service
public class SysUsersServiceImpl extends BaseServicImpl<SysUsers, Integer> implements
		SysUsersService {
	@Autowired
	public SysUsersDao sysUsersDao;
	@Override
	public SysUsers findUsersByTeacherId(Integer id) {
		List<SysUsers> list=sysUsersDao.find("from SysUsers as c where c.sysTeacher.id=?", id);
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public SysUsers findUsersByStudentId(Integer id) {
		List<SysUsers> list=sysUsersDao.find("from SysUsers as c where c.sysStudent.id=?", id);
		if (list.size()>0) {
			return list.get(0);
		}else{
			return null;
		}
	}
}
