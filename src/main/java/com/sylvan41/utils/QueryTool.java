/**
 * 
 */
package com.sylvan41.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 查询工具(面向对象),解决实体类及关联实体类的多条件组合查询工具,利用反射机制
 * 
 * @author Administrator
 * 
 */
public class QueryTool {

	private String queryString;// 查询字符串

	private List<Object> params = new ArrayList<Object>();// 查询参数

	private Object entity;// 查询的实体

	/** 反射类的属性名称 */
	String name;

	/** 反射类的属性名称首字符大写*/
	String upCaseName;

	/** 反射类的属性类型 */
	String type;
	
	/** 反射类的方法 */
	Method m;
	
	public static final String SVUID="serialVersionUID";

	public QueryTool() {

	}

	/**
	 * 初始化查询工具
	 * 
	 * @param entity
	 *            查询的实体实例
	 */
	public QueryTool(Object entity) {
		this.entity = entity;
	}

	/**
	 * 通过反射机制得到托管实体提交的属性,过滤掉Null和空字符串,无线级联(?)
	 * 
	 * @param entity
	 *            需要查询的实体
	 * @param childName
	 *            子类在父类中定义的属性名
	 * @return
	 */
	public Map<String, Object> getProperty(Object entity, String childName) {
		
		// XXX 反射异常处理
		
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		Field[] fields = entity.getClass().getDeclaredFields();
		a:for (Field field : fields) {
			name = field.getName(); // 获取属性的名字
			if(propertyFilter(name)){
				continue a;
			}
			upCaseName = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
			type = field.getGenericType().toString();
			try {
				if (!type.contains("com")) {
					m = entity.getClass().getMethod("get" + upCaseName);
					Object value = m.invoke(entity);
					if (value != null && !value.equals("")) {
						if (childName!=null) {
							propertyMap.put(childName + "." + name, value);
						} else {
							propertyMap.put(name, value);
						}
					}
				} else {
					m = entity.getClass().getMethod("get" + upCaseName);
					Object value = m.invoke(entity);
					if (value != null && !value.equals("")) {
						propertyMap.putAll(getProperty(m.invoke(entity), name));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return propertyMap;
	}

	/**
	 * 得到查询字符串和查询的参数
	 * 
	 * @param entity
	 *            查询的实体
	 * @return
	 */
	public void getQuerySqlAndParam() {
		Map<String, Object> sqlAndParam = new HashMap<String, Object>();

		sqlAndParam = getProperty(entity, null);
		Set<String> key = sqlAndParam.keySet();
		queryString = "from " + entity.getClass().getSimpleName()
				+ " model where ";
		for (Iterator<String> it = key.iterator(); it.hasNext();) {
			String s = (String) it.next();
			queryString += "model." + s + "=? and ";
			params.add(sqlAndParam.get(s));
		}
		if(params.size()>0){
			queryString = queryString.substring(0, queryString.length() - 4);
		}else{
			queryString = queryString.substring(0, queryString.length() - 7);
		}
		

		System.out.println("查询语句:" + queryString);
		System.out.println("查询参数:" + params.toArray().toString());
	}
	
	
	
	/**
	 * 过滤不需要查询的属性,例如serialVersionUID等
	 * @param pname 属性名称
	 * @return
	 */
	public Boolean propertyFilter(String pname){
		return pname.equals(SVUID);
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}
}
