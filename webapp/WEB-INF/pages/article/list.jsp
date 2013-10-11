<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="articleList">
	<div class="block" id="${id }">
		<div class="title">
			<a href="archive?id=${id }" target="_blank">${title }</a>
		</div>
		<div class="content">${summary }</div>
		<!-- 
			<div class="content">${content }</div>
			 -->
		<div class="time">
			posted @
			<s:date name="publishTime" format="yyyy-MM-dd HH:mm" />
			<a href="javascript:void(0)" class="delArticle">删除</a>
		</div>
	</div>
</s:iterator>