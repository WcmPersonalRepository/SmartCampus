package com.gxufe.smarcampus.repository.Impl;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysPhoneBook;
import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.repository.SysProfessionalDao;
import com.gxufe.smarcampus.repository.SysRolesDao;
@Repository
public class SysProfessionalDaoImpl extends BaseDaoImpl<SysProfessional, Integer> implements SysProfessionalDao {
	
	public SysProfessionalDaoImpl() {
		this.entityClass = SysProfessional.class;
	}
}
