package com.gxufe.smarcampus.repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysClass;
import com.gxufe.smarcampus.models.SysCollege;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.repository.SysCollegeDao;
import com.gxufe.smarcampus.repository.SysProfessionalDao;
import com.gxufe.smarcampus.repository.SysRolesDao;
@Repository
public class SysCollegeDaoImpl extends BaseDaoImpl<SysCollege, Integer> implements SysCollegeDao {

	public SysCollegeDaoImpl() {
		this.entityClass = SysCollege.class;
	}
	
	@Override
	public List<SysCollege> findSysCollegeByName(String sysCollegeName) {
		List<SysCollege> list=this.getHibernateTemplate().find("from SysCollege college where college.collegeName like ?", "%"+sysCollegeName+"%");
		return list;
	}
	
	
}
