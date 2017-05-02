package com.gxufe.smarcampus.repository.Impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.models.PersistentLogins;
import com.gxufe.smarcampus.repository.PersistentLoginsDao;
@Repository
public class PersistentLoginsDaoImpl extends BaseDaoImpl<PersistentLogins, String> implements
		PersistentLoginsDao {
	public PersistentLoginsDaoImpl() {
		this.entityClass = PersistentLogins.class;
	}
}
