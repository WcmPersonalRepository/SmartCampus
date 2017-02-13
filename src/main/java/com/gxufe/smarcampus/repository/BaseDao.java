package com.gxufe.smarcampus.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.gxufe.smarcampus.common.PaginationSupport;

public interface BaseDao<T, ID extends Serializable> {
	public T load(ID id) throws DataAccessException;  
	  
    public T get(ID id) throws DataAccessException;  
  
    public boolean contains(T t) throws DataAccessException;  
  
    public void refresh(T t, LockMode lockMode) throws DataAccessException;  
  
    public void refresh(T t) throws DataAccessException;  
  
    public Serializable save(T t) throws DataAccessException;  
  
    public void saveOrUpdate(T t) throws DataAccessException;  
  
    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException;  
  
    public void update(T t, LockMode lockMode) throws DataAccessException;  
  
    public void update(T t) throws DataAccessException;  
  
    public void delete(T t, LockMode lockMode) throws DataAccessException;  
  
    public void delete(T t) throws DataAccessException;  
  
    public void deleteAll(Collection<T> entities) throws DataAccessException;  
  
    public List<T> find(String queryString, Object value) throws DataAccessException;  
  
    public List<T> find(String queryString, Object[] values) throws DataAccessException;  
  
    public List<T> find(String queryString) throws DataAccessException;  
  
    public List<T> list() throws DataAccessException;  
  
    public List<T> findByNamedQuery(String queryName) throws DataAccessException;  
  
    public List<T> findByNamedQuery(String queryName, Object value) throws DataAccessException;  
  
    public List<T> findByNamedQuery(String queryName, Object[] values) throws DataAccessException;  
  
    public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize,  
            final int startIndex);  
  
    public PaginationSupport findPageByQuery(final String hql, final String countHql, final int pageSize,  
            final int startIndex);  
  
}
