package com.gxufe.smarcampus.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.gxufe.smarcampus.common.PaginationSupport;

public interface BaseService<T, ID extends Serializable> {
	public T findObjectById(ID id) throws DataAccessException;  
	  
    public boolean containsObject(T t) throws DataAccessException;  
  
    public Serializable addObject(T t) throws DataAccessException;  
  
    public void saveOrUpdate(T t) throws DataAccessException;  
  
    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException;  
  
    public void update(T t) throws DataAccessException;  
  
    public void delete(T t) throws DataAccessException;  
  
    public void deleteAll(Collection<T> entities) throws DataAccessException;  
  
    public List<T> findObjectByHQL(String queryString, Object value) throws DataAccessException;  
  
    public List<T> findObjectByHQL(String queryString, Object[] values) throws DataAccessException;  
  
    public List<T> findObjectByHQL(String queryString) throws DataAccessException;  
  
    public PaginationSupport findPageByCriteria(DetachedCriteria detachedCriteria,final int pageSize,  
            final int startIndex);  
  
    public PaginationSupport findPageByQuery(final String hql, final String countHql, final int pageSize,  
            final int startIndex); 
}
