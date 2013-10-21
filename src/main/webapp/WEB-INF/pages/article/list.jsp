<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="articleList">
	<div class="post" id="post-${id }">
		<h2>
			<a href="archive?id=${id }" target="_blank" class="title">${title }</a>
		</h2>
		<div class="info">
			<span class="date">
				<s:date name="publishTime" format="yyyy-MM-dd HH:mm" />
			</span> 
			<span class="author"> 
				<a rel="author" title="由Sylvan____发布" href="#">Sylvan__${user.name }</a>
			</span> 
			<span class="editpost"> 
				<a class="post-edit-link" title="编辑文章" href="article/edit.do?aid=${id }">编辑</a>
			</span> 
			<span class="comments"> <a title="${title }上的评论" href="reply/create.do?aid=${id }">没有评论</a>
			</span>
			<div class="fixed"></div>
		</div>

		<div class="content">${summary }<div class="fixed"></div></div>

		<div class="under">
			<span class="categories">分类: </span> 
			<span>
				<a rel="category tag" title="查看${category.name }中的全部文章" 
					href="archives/category/${category.name }">${category.name }</a>
			</span>
			<span class="tags">标签:</span> 
			<span><a rel="tags" href="#">${tags }No tags now!</a></span>
		</div>
	</div>
</s:iterator>