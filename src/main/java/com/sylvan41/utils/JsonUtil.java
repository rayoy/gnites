/**
 * 
 */
package com.sylvan41.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * JSON数据格式化工具
 * @author Administrator
 * 
 */
public class JsonUtil {


	
	
	
	/**
	 * 转换object对象为jsonArray数据
	 * @param o
	 * @param response
	 */
	public static void toJsonArray(Object o, HttpServletResponse response) {
		JSONArray json = (JSONArray) JSONSerializer.toJSON(o);
		try {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("JSON数据为:"+json);
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void toJsonObject(Object o, HttpServletResponse response){
		JSONObject json =  JSONObject.fromObject(o);
		
		try {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			System.out.println("JSON数据为:"+json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
