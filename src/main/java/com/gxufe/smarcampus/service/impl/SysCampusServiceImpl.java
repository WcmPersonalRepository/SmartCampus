package com.gxufe.smarcampus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.models.SysAuthorities;
import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.repository.SysCampusDao;
import com.gxufe.smarcampus.repository.SysUsersDao;
import com.gxufe.smarcampus.service.SysAuthoritiesService;
import com.gxufe.smarcampus.service.SysCampusService;

@Service
public class SysCampusServiceImpl extends BaseServicImpl<SysCampus, Integer> implements
SysCampusService {
	@Autowired
	public SysCampusDao sysCampusDao;
}
