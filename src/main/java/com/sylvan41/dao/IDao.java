/**
 * 
 */
package com.sylvan41.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;


/**
 * 数据库底层DAO接口
 * @author asimple41@qq.com
 *
 */
public interface IDao<T> {

	public void create(T baseBean);

	public void delete(T baseBean);
	
	public List<T> list(String hql);

	public int getTotalCount(String hql, Object... params);

	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params);

	public Query createQuery(String hql);
	
	
	
	/**
	 * 删除实体
	 * @param id 序列化实体id,必须于声明时的id类型一致,否则会报错
	 */
	public void DeleteById(Serializable id);
	
	
	/**
	 * 查询单个实体
	 * @param id 序列化实体id
	 * @return entity实例
	 */
	public T find(Serializable id);
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 查询全部数据并分页
	 * @param firstResult
	 * @param maxSize
	 * @return
	 */
	public List<T> findAll(int firstResult, int maxSize);
	
	/**
	 * 查询依据属性的distinct分组
	 * @param propertyName 属性名称
	 */
	public List<T> findDistinctByProperty(String propertyName);
	/**
	 * 查询依据对象的实例example
	 * @param entity 类实例
	 * @return List
	 */
	public List<T> findByExample(T entity);
	
	/**
	 * 查询依据对象的实例example分页
	 * @param entity 类实例
	 * @return List
	 */
	public List<T> findByExample(T entity,int firstResult,int maxResult);
	
	
	/**
	 * 查询依据对象的属性分页
	 * @param propertyName 属性名称
	 * @param value	属性值
	 * @param firstResult 
	 * @param maxSize
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value,int firstResult,int maxSize);
	
	/**
	 * 查询依据对象的属性
	 * @param properties
	 * @return
	 */
	public List<T> findByProperties(Map<String, Object> properties);
	
	/**
	 * 查询依据对象的属性分页
	 * @param properties
	 * @return
	 */
	public List<T> findByProperties(Map<String, Object> properties, 
			int firstResult, int maxResults);
	
	/**
	 * 查询对象记录总数
	 * @return int
	 */
	public Integer getCount();
	
	/**
	 * 查询对象记录依据对象的实例
	 * @return int
	 */
	public Integer getCountByExample(T entity);
	
	/**
	 * 查询对象记录依据对象的属性
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public Integer getCountByProperty(String propertyName,Object value);
	
	/**
	 * 实例化对象
	 * @param clazz
	 */
	public void save(T clazz);
	
	/**
	 * 更新对象
	 * @param clazz
	 */
	public void update(T clazz);
}
