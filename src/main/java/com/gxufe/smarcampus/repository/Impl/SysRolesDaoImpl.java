package com.gxufe.smarcampus.repository.Impl;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.SysProfessional;
import com.gxufe.smarcampus.models.SysRoles;
import com.gxufe.smarcampus.repository.SysRolesDao;
@Repository
public class SysRolesDaoImpl extends BaseDaoImpl<SysRoles, Integer> implements SysRolesDao {
	public SysRolesDaoImpl() {
		this.entityClass = SysRoles.class;
	}
}
