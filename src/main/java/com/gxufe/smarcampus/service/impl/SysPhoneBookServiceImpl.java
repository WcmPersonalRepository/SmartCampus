package com.gxufe.smarcampus.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.models.SysUsers;
import com.gxufe.smarcampus.repository.SysPhoneBookDao;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.repository.Impl.SysUsersDaoImpl;
import com.gxufe.smarcampus.service.SysPhoneBookService;
import com.gxufe.smarcampus.service.SysUsersService;

@Service
public class SysPhoneBookServiceImpl extends BaseServicImpl<SysPhoneBook, Integer> implements
SysPhoneBookService {
	@Autowired
	SysPhoneBookDao sysPhoneBookDao;
	@Override
	public List<SysPhoneBook> findPhoneBookByDepartmentHQL(String HQL,
			String department) {
		// TODO Auto-generated method stub
		return sysPhoneBookDao.find(HQL, department);
	}
	@Override
	public SysPhoneBook loadSysPhoneBookById(Integer id) {
		// TODO Auto-generated method stub
		return sysPhoneBookDao.load(id);
	}
}
