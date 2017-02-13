package com.gxufe.smarcampus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.models.SysUsersRoles;
import com.gxufe.smarcampus.repository.SysUsersRolesDao;
import com.gxufe.smarcampus.service.BaseService;
import com.gxufe.smarcampus.service.SysUsersRolesService;
@Service
public class SysUsersRolesServiceImpl extends BaseServicImpl<SysUsersRoles, Integer> implements
SysUsersRolesService {
	@Autowired
	public SysUsersRolesDao sysUsersRolesDao;
	
}
