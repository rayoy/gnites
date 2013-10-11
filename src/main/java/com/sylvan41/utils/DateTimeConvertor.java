/**
 * 
 */
package com.sylvan41.utils;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * 
 * 时间格式接受参数格式化(string to datetime),struts2 conversion支持
 * 
 * @author asimple41@qq.com
 * 
 */
public class DateTimeConvertor extends StrutsTypeConverter {

	/**
	 * 定义需要拦截并转好的日期字符串的格式
	 */
	private final SimpleDateFormat[] sdfs = {
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("MM/dd/yyyy") };

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if (arg2.equals(java.util.Date.class)) {
			String paramValues = arg1[0];

			if (!paramValues.equals("")) {
				for (SimpleDateFormat sdf1 : sdfs) {
					try {
						return sdf1.parse(paramValues);
					} catch (Exception e) {
						continue;
					}

				}
			}else{
				return null;
			}
			throw new TypeConversionException();
		}

		// TODO 完善conventor
		return super.convertValue(arg0, arg1, arg2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util
	 * .Map, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
