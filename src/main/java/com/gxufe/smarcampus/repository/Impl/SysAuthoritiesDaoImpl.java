package com.gxufe.smarcampus.repository.Impl;

import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.models.PersistentLogins;
import com.gxufe.smarcampus.models.SysAuthorities;
import com.gxufe.smarcampus.repository.SysAuthoritiesDao;
@Repository
public class SysAuthoritiesDaoImpl extends BaseDaoImpl<SysAuthorities, Integer> implements
		SysAuthoritiesDao {
	public SysAuthoritiesDaoImpl() {
		this.entityClass = SysAuthorities.class;
	}
}
