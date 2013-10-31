<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<h2>文章归档</h2>
<ul>
	<s:iterator value="articleCategoryList">
		<li><a href="#">${name }</a></li>
	</s:iterator>
</ul>