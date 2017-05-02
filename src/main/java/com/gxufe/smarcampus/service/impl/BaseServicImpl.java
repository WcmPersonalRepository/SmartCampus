package com.gxufe.smarcampus.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.repository.BaseDao;
import com.gxufe.smarcampus.service.BaseService;

@Service
public class BaseServicImpl<T,ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public T findObjectById(ID id) throws DataAccessException {
		return (T) baseDao.load(id);
	}

	@Override
	public boolean containsObject(T t) throws DataAccessException {
		// TODO Auto-generated method stub
		return baseDao.contains(t);
	}

	@Override
	public Serializable addObject(T t) throws DataAccessException {
		// TODO Auto-generated method stub
		return baseDao.save(t);
	}

	@Override
	public void saveOrUpdate(T t) throws DataAccessException {
		baseDao.saveOrUpdate(t);
		
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException {
		baseDao.saveOrUpdateAll(entities);
	}

	@Override
	public void update(T t) throws DataAccessException {
		baseDao.update(t);
	}

	@Override
	public void delete(T t) throws DataAccessException {
		baseDao.delete(t);
		
	}

	@Override
	public void deleteAll(Collection<T> entities) throws DataAccessException {
		baseDao.deleteAll(entities);
		
	}

	@Override
	public List<T> findObjectByHQL(String queryString, Object value)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return baseDao.find(queryString, value);
	}

	@Override
	public List<T> findObjectByHQL(String queryString, Object[] values)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return baseDao.find(queryString, values);
	}

	@Override
	public List<T> findObjectByHQL(String queryString)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return baseDao.find(queryString);
	}

	@Override
	public PaginationSupport findPageByCriteria(DetachedCriteria detachedCriteria, int pageSize,
			int startIndex) {
		return baseDao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
	}

	@Override
	public PaginationSupport findPageByQuery(String hql, String countHql,
			int pageSize, int startIndex) {
		// TODO Auto-generated method stub
		return baseDao.findPageByQuery(hql, countHql, pageSize, startIndex);
	}


}
