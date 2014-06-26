/**
 * 
 */
package com.sylvan41.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sylvan41.model.BaseEntity;
import com.sylvan41.utils.*;;

/**
 * DAO实现类,此类封装了DAO的数据库操作,通过HibernateTemplate,Criteria,反射来实现各种数据的CRUD操作
 * 
 * @author asimple41@qq.com
 * @version 1.0
 * 
 */
@Repository
public class DaoImpl<T extends BaseEntity> extends HibernateDaoSupport implements IDao<T> {

	public Logger log = Logger.getLogger(this.getClass());

	public DaoImpl() {
		log.setLevel(Level.INFO);
	}

	/**
	 * 注入sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 定义T的实际类型，通过反射获取T的实际类型，以供其它方法使用
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());

	public T find(Class<T> clazz, String id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public void create(T baseBean) {
		getHibernateTemplate().persist(baseBean);
	}

	public Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}

	public void delete(T baseBean) {
		getHibernateTemplate().delete(baseBean);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public int getTotalCount(String hql, Object... params) {

		Query query = createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		Object obj = query.uniqueResult();
		log.info("查询结果集数量:" + obj.toString());
		return ((Long) obj).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxResults,
			Object... params) {
		Query query = createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);

		}
		List<T> list = query.setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
		return list;
	}

	@Transactional
	public void save(T baseBean) {
		getHibernateTemplate().save(baseBean);
	}

	@Transactional
	public void update(T baseBean) {
		getHibernateTemplate().update(baseBean);
	}

	public T find(Class<T> clazz, Integer id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public Integer getCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass)
				.setProjection(Projections.rowCount());
		return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String queryString = "from " + entityClass.getName();
		log.info("查询结果集数量:" + getHibernateTemplate().find(queryString).size());
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(int firstResult, int maxSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		// criteria.addOrder(Order.desc(""));
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxSize);
	}

	@Transactional
	public void DeleteById(Serializable id) {
		getHibernateTemplate().delete(find(id));
		log.info("Delete success...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#find(java.io.Serializable)
	 */
	public T find(Serializable id) {
		T t = null;
		try {
			t = getHibernateTemplate().get(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		String queryString = "from " + entityClass.getName()
				+ " as model where model." + propertyName + "= ?";
		return getHibernateTemplate().find(queryString, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findByProperty(java.lang.String,
	 * java.lang.Object, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value,
			int firstResult, int maxSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findDistinctByProperty(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findDistinctByProperty(String propertyName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		criteria.setProjection(Projections.distinct(Projections
				.property(propertyName)));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findByExample(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T entity) {
		Example example = Example.create(entity);
		// 空的不做查询条件
		example.setPropertySelector(new PropertySelector() {
			private static final long serialVersionUID = 1L;

			public boolean include(Object propertyValue, String propertyName,
					Type type) {
				if (propertyValue == null)
					return false;
				if (propertyValue instanceof Number)
					if (((Number) propertyValue).longValue() == 0)
						return false;
				if (propertyValue instanceof String)
					if (((String) propertyValue).length() == 0)
						return false;
				return true;
			}

		});
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass).add(
				example);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findByExample(java.lang.Object, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T entity, int firstResult, int maxResult) {
		Example example = Example.create(entity);
		// 空的不做查询条件
		example.setPropertySelector(excludeEmptyStringSelecter);
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass).add(
				example);
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResult);
	}

	// 自定义选择器查询排除空字符串""
	private PropertySelector excludeEmptyStringSelecter = new PropertySelector() {
		private static final long serialVersionUID = 1L;

		public boolean include(Object propertyValue, String propertyName,
				Type type) {
			if (propertyValue == null)
				return false;
			if (propertyValue instanceof Number)
				if (((Number) propertyValue).longValue() == 0)
					return false;
			if (propertyValue instanceof String)
				if (((String) propertyValue).length() == 0)
					return false;
			return true;
		}

	};

	public Integer getCountByExample(T entity) {
		Example example = Example.create(entity);
		example.setPropertySelector(excludeEmptyStringSelecter);
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass)
				.add(example).setProjection(Projections.rowCount());
		return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	public Integer getCountByProperty(String propertyName, Object value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass)
				.add(Restrictions.eq(propertyName, value))
				.setProjection(Projections.rowCount());
		return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findByProperties(java.util.Map)
	 */
	public List<T> findByProperties(Map<String, Object> properties) {
		return findByProperties(properties, -1, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.euronet.core.dao.IDao#findByProperties(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperties(Map<String, Object> properties,
			int firstResult, int maxResults) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		for (Entry<String, Object> entry : properties.entrySet()) {
			criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}
}
