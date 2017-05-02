package com.gxufe.smarcampus.repository.Impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.ParameterizedType;  

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gxufe.smarcampus.common.PaginationSupport;
import com.gxufe.smarcampus.repository.BaseDao;

@Component("baseDao")
public class BaseDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements BaseDao<T, ID> {

	private Logger logger = Logger.getLogger(BaseDaoImpl.class);  
	protected Class<T> entityClass;
    
   /* @Autowired
    private HibernateTemplate hibernateTemplate;*/
    
    
  /*  private HibernateTemplate getHibernateTemplate() {
    	
		return hibernateTemplate;
	}*/
    
    @Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory)  
    {  
  
        super.setSessionFactory(sessionFactory);  
    }  
    
    public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
    
/*    protected Class getEntityClass() {  
          
        return this.entityClass;  
    }  */

    protected Class getEntityClass() {  
        if (entityClass == null) {  
            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
            logger.debug("T class = " + entityClass.getName());  
        }  
        return entityClass;  
    } 
  
  /*  public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}*/

	public void saveOrUpdate(T t) throws DataAccessException {  
        this.getHibernateTemplate().saveOrUpdate(t);  
    }  
  
    public T load(ID id) throws DataAccessException {  
        T load = (T) getHibernateTemplate().load(getEntityClass(), id);  
        return load;  
    }  
  
    public T get(ID id) throws DataAccessException {  
        T load = (T) getHibernateTemplate().get(getEntityClass(), id);  
        return load;  
    }  
  
    public boolean contains(T t) throws DataAccessException {  
        return getHibernateTemplate().contains(t);  
    }  
  
    public void delete(T t, LockMode lockMode) throws DataAccessException {  
        getHibernateTemplate().delete(t, lockMode);  
    }  
  
    public void delete(T t) throws DataAccessException {  
        getHibernateTemplate().delete(t);  
    }  
  
    public void deleteAll(Collection<T> entities) throws DataAccessException {  
        getHibernateTemplate().deleteAll(entities);  
    }  
  
    public List<T> find(String queryString, Object value) throws DataAccessException {  
        List<T> find = (List<T>) getHibernateTemplate().find(queryString, value);  
        return find;  
    }  
  
    public List<T> find(String queryString, Object[] values) throws DataAccessException {  
        List<T> find = (List<T>) getHibernateTemplate().find(queryString, values);  
        return find;  
    }  
  
    public List<T> find(String queryString) throws DataAccessException {  
        return (List<T>) getHibernateTemplate().find(queryString);  
    }  
  
    public void refresh(T t, LockMode lockMode) throws DataAccessException {  
        getHibernateTemplate().refresh(t, lockMode);  
    }  
  
    public void refresh(T t) throws DataAccessException {  
        getHibernateTemplate().refresh(t);  
    }  
  
    public Serializable save(T t) throws DataAccessException {  
        return getHibernateTemplate().save(t);  
    }  
  
    public void saveOrUpdateAll(Collection<T> entities) throws DataAccessException {  
        getHibernateTemplate().saveOrUpdateAll(entities);  
    }  
  
    public void update(T t, LockMode lockMode) throws DataAccessException {  
        getHibernateTemplate().update(t, lockMode);  
    }  
  
    public void update(T t) throws DataAccessException {  
        getHibernateTemplate().update(t);  
    }  
  
    public List<T> list() throws DataAccessException {  
        return getHibernateTemplate().loadAll(getEntityClass());  
  
    }  
  
    public List<T> findByNamedQuery(String queryName) throws DataAccessException {  
        return getHibernateTemplate().findByNamedQuery(queryName);  
    }  
  
    public List<T> findByNamedQuery(String queryName, Object value) throws DataAccessException {  
        return getHibernateTemplate().findByNamedQuery(queryName, value);  
    }  
  
    public List<T> findByNamedQuery(String queryName, Object[] values) throws DataAccessException {  
        return getHibernateTemplate().findByNamedQuery(queryName, values);  
    }  
  
    public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize,  
            final int startIndex) {  
        return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session) throws HibernateException {  
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);  
                int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();  
                criteria.setProjection(null);  
                List items = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();  
                PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);  
                return ps;  
            }  
        });  
    }  
  
    public PaginationSupport findPageByQuery(final String hql, final String countHql, final int pageSize,  
            final int startIndex) {  
        return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session) throws HibernateException, SQLException {  
                int totalCount = ((Integer) session.createQuery(countHql).iterate().next()).intValue();  
                Query query = session.createQuery(hql);  
                query.setFirstResult(startIndex);  
                query.setMaxResults(pageSize);  
                List items = query.list();  
                PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);  
                return ps;  
  
            }  
        });  
    }  
	
}
