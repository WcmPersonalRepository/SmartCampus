package com.gxufe.smarcampus.service;

import java.util.List;

import com.gxufe.smarcampus.models.SysAuthorities;
import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.models.SysCollege;

public interface SysCollegeService extends BaseService<SysCollege, Integer> {
	//根据学院名称查询学院记录
	public List<SysCollege> findSysCollegeByName(String sysCollegeName);
}
