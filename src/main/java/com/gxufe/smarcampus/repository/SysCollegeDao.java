package com.gxufe.smarcampus.repository;

import java.util.List;

import com.gxufe.smarcampus.models.PersistentLogins;
import com.gxufe.smarcampus.models.SysCampus;
import com.gxufe.smarcampus.models.SysCollege;

public interface SysCollegeDao extends BaseDao<SysCollege, Integer> {
	//根据学院名称查询学院记录
	public List<SysCollege> findSysCollegeByName(String sysCollegeName);
}
