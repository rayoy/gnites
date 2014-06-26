<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:iterator value="articleList">
<div class="row-fluid">
	<div class="blog-list-post">
		<div class="post-content">
			<h4 class="post-title">
				<a href="#">${title }</a>
			</h4>
			<div class="post-meta">
				<span class="date"> <i class="icon-calendar"></i> ${publishTime }
				</span> <span class="comments"> <i class="icon-comments"></i> <a href="#">5 comments</a>
				</span> <span class="tags"> <i class="icon-tag"></i> <a href="#">ui</a> <a href="#">flat</a> <a href="#">clean</a>
				</span> <span class="author"> <i class="icon-user"></i> <a href="#">eakroko</a>
				</span>
			</div>
			<div class="post-text">${content }
				</div>
		</div>
	</div>
</div>
</s:iterator>