/**
 * 
 */
package com.sylvan41.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 打印Ajax返回值,非Json对象
 * 
 * @author asimple41@qq.com
 * 
 */
public class AjaxPrinter {

	/**
	 * Ajax返回值,非json对象的打印
	 * 
	 * @param o
	 *            打印的对象
	 * @param res
	 *            HttpServletResponse
	 */
	public static void print(Object o, HttpServletResponse res) {
		try {
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/plain");
			PrintWriter out = res.getWriter();
			out.print(o);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
