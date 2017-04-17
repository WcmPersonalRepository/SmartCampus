package com.gxufe.smarcampus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.repository.SysCollegeDao;
import com.gxufe.smarcampus.service.SysCollegeService;
import com.gxufe.smarcampus.service.SysRolesService;

@Service
public class SysCollegeServiceImpl extends BaseServicImpl<SysCollege, Integer> implements
SysCollegeService {
	@Autowired
	public SysCollegeDao sysCollegeDao;

	@Transactional(readOnly=true)
	public List<SysCollege> findSysCollegeByName(String sysCollegeName) {
		
		return sysCollegeDao.findSysCollegeByName(sysCollegeName);
	}
	
	
}
