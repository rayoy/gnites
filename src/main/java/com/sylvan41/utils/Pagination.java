package com.sylvan41.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;





/**
 * 分页工具类
 * @author Administrator
 *
 */
public class Pagination implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Logger log=Logger.getLogger(this.getClass());


	// 每页记录数 默认为 20
	private int pageSize = 12;

	// 当前页数
	private int pageNum = 1;

	// 记录总数，需要从数据库中查询出来
	private int recordCount;

	// 页数，根据 recordCount 与 pageSize 计算出来
	private int pageCount;

	// 本页的第一条记录，根据 pageSize 与 pageNum 计算出来
	private int firstResult;

	// 页面 URL
	private String pageUrl;

	/**
	 * 分页工具类默认构造器
	 * @param request HttpRequest
	 * @param response HttpResponse
	 */
	public Pagination(HttpServletRequest request, HttpServletResponse response) {

		try {
			// 从 request 中取当前页数
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
		}

		for (Cookie cookie : request.getCookies()) {
			// 从 cookie 中取自定义的每页记录数
			if ("pageSize".equals(cookie.getName())) {
				try {
					pageSize = Integer.parseInt(cookie.getValue());
				} catch (Exception e) {
				}
			}
		}

		try {
			// 自定义的每页记录数
			pageSize = Integer.parseInt(request.getParameter("pageSize"));

			// 记录自定义的每页记录数到 Cookie 中
			Cookie cookie = new Cookie("pageSize", Integer.toString(pageSize));
			cookie.setMaxAge(Integer.MAX_VALUE);

			response.addCookie(cookie);

		} catch (Exception e) {
		}

		StringBuffer queryString = new StringBuffer();

		// 获取所有的 QueryString 参数
		for (Object parameterName : request.getParameterMap().keySet()) {
			String name = (String) parameterName;

			if ("pageNum".equals(name) || "pageSize".equals(name)) {
				continue;
			}

			for (String value : request.getParameterValues(name)) {
				if (queryString.length() > 0) {
					queryString.append("&");
				}

				try {
					/*
						queryString.append(name + "="
							+ URLEncoder.encode(value, "UTF-8"));
					*/
					queryString.append(name + "="+value);
				} catch (Exception e) {
					queryString.append(name + "=" + value);
				}
			}
		}

		pageUrl = request.getRequestURI() + "?" + queryString.toString();
		calculate();
	}

	public void calculate() {
		pageCount = (recordCount + pageSize - 1) / pageSize;
		firstResult = (pageNum - 1) * pageSize;
	}

	/**
	 * 生成分页信息 包括第一页，上一页，下一页，最后一页等等。
	 * 
	 * @param pageNum
	 *            当前页数
	 * @param pageCount
	 *            总页数
	 * @param recordCount
	 *            总记录数
	 * @param pageUrl
	 *            页面 URL
	 * @return
	 */
	public String toString() {

		calculate();

		String url = pageUrl.contains("?") ? pageUrl : pageUrl + "?";

		StringBuffer buffer = new StringBuffer();

		/**
		 * <a href="thread-htm-fid-82-page-1.html"
		 * style="font-weight:bold">&laquo;</a><b> 1 </b><a
		 * href="thread-htm-fid-82-page-2.html">2</a><a
		 * href="thread-htm-fid-82-page-3.html">3</a><a
		 * href="thread-htm-fid-82-page-4.html">4</a><a
		 * href="thread-htm-fid-82-page-5.html">5</a> <input type="text"
		 * size="3" onkeydown="javascript: if(event.keyCode==13){
		 * location='thread.php?fid=82&page='+this.value+'';return false;}"> <a
		 * href="thread-htm-fid-82-page-42.html"
		 * style="font-weight:bold">&raquo;</a> Pages: ( 1/42 total )
		 */

		buffer.append("每页");
		buffer
		.append("<select name=ibm_crl_scm_page_size_select onchange='changePageSize(\""+url+"\",this); ' >");
		buffer.append(" <option value=12"
				+ (pageSize == 12 ? " selected " : "") + ">12</option>");
		buffer.append(" <option value=20"
				+ (pageSize == 20 ? " selected " : "") + ">20</option>");
		buffer.append(" <option value=30"
				+ (pageSize == 30 ? " selected " : "") + ">30</option>");
		buffer.append(" <option value=40"
				+ (pageSize == 40 ? " selected " : "") + ">40</option>");
		buffer.append(" <option value=50"
				+ (pageSize == 50 ? " selected " : "") + ">50</option>");
		buffer.append("</select>条");

		buffer.append(" 第" + pageNum + "/" + pageCount + "页  ");

		buffer.append(" 共" + recordCount + "条 ");

		buffer.append(pageCount == 0 || pageNum == 1 ? " 第一页 " 
				: " <a href='##' onclick='gotoPage(\""+url+"&pageNum=1\",this);'>第一页</a> ");

		buffer.append("    ");

		
		buffer.append(pageCount == 0 || pageNum == 1 ? " 上一页 " 
				: " <a href='##' onclick='gotoPage(\""+url+"&pageNum="+(pageNum - 1)+"\",this);'>上一页</a> ");

		buffer.append("    ");
		
		buffer.append(pageCount == 0 || pageNum == pageCount ? " 下一页 "
				: " <a href='##' onclick='gotoPage(\""+url+"&pageNum="+(pageNum + 1)+"\",this);'>下一页</a> ");
		
		buffer.append("    ");

		
		buffer.append(pageCount == 0 || pageNum == pageCount ? " 最后一页 "
				: " <a href='##' onclick='gotoPage(\""+url+"&pageNum="+pageCount+"\",this);'>最后一页</a> ");

		buffer.append("   到<input type='text' name='ibm_crl_scm_goto_input' "
				+ " style='width:20px; font-size:12px; text-align:center; '>页");

		buffer.append("<input type='button' "
				+ " name='ibm_crl_scm_goto_button' value='Go' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'>");
		
		
		buffer.append("<script language='javascript'>");
		buffer.append("function helloweenvsfei_goto(){");
		buffer
				.append(" var numText = document.getElementsByName('ibm_crl_scm_goto_input')[0].value;");
		buffer.append(" var num = parseInt(numText, 10);");
		buffer.append(" if(!num){");
		buffer.append("     alert('页数必须为数字');   ");
		buffer.append("     return;");
		buffer.append(" }");
		buffer.append(" if(num<1 || num>" + pageCount + "){");
		buffer.append("     alert('页数需介于 1 与 " + pageCount + " 之间. ');    ");
		buffer.append("     return;");
		buffer.append(" }");
		buffer.append(" location='&pageNum=' + num;");
		buffer.append("}");
		buffer
				.append("document.getElementsByName('ibm_crl_scm_goto_button')[0].onclick = helloweenvsfei_goto;");
		buffer.append("</script>");
		return buffer.toString();

	}

	public int getPageSize() {
		calculate();
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calculate();
	}

	public int getRecordCount() {
		calculate();
		return recordCount;
	}

	/**
	 * 设定一共有多少条记录以初始化pagination对象去计算分页相关属性
	 * @param recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		calculate();
	}

	public int getFirstResult() {
		calculate();
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
		calculate();
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
