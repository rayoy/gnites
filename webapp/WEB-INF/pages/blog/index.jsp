<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.nicName }的博客</title>

<style type="text/css">

*{margin:0;padding:0;}
body {
	font-size: 12px;
	font-family: Verdana, ​arial, ​微软雅黑;
}

#userInfo {
	width: 300px;
}

#main {
	width: 700px;
	
	padding: 50px;
}

.left {
	float: left;
}

.block {
	padding: 10px;
	color: #666666;
	font-size: 13px;
}

.title {
	padding-top: 10px;
	padding-bottom: 10px;
}

.time {
	padding-top: 10px;
	padding-bottom: 5px;
	font-size: 12px;
	font-family: Verdana, ​arial, ​微软雅黑;
}

.time a {
	font-family: Verdana, ​arial, ​微软雅黑;
	font-size: 12px;
	color: #666666;
}

.title a {
	font-family: Verdana, ​arial, ​微软雅黑;
	font-size: 15px;
	color: #000;
	text-decoration: none;
	font-weight: 700;
}

.content {
	color: #666666;
	font-size: 13px;
}

#top{
	padding:5px;
	border-bottom:1px solid #CCC;
	text-align:right;
}
</style>
</head>
<body>

	<div id="top">
		
		<span>${user.nicName }</span>
		<span><a href="user/logout.do">退出</a></span>
	</div>
	<div id="userInfo" class="left"></div>

	<!-- 文章列表   -->
	<div id="main" class="left"></div>
	
	<div>
		<div id="category"></div>
	</div>

	
	<input id="blogId" type="hidden" value="${blogId }" />

	<script type="text/javascript" src="/Gnites/statics/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$(".delArticle").live("click",function(){
				
				var aid = $(this).closest(".block").attr("id");
				
				$.post("article/del.do?articleId="+aid,function(){
					reloadArticle();
				});
				
				return false;
			});
			
		});
		
		
		function reloadArticle(){
			var bid= $("#blogId").val();
			$("#main").load("article/list.do?blogId="+bid);
		}
	
		function loadArticleCategory(){
			var bid= $("#blogId").val();
			$("#category").load("ac/list.do?blogId="+bid);
		}
		
		
		reloadArticle();
	</script>
	
</body>
</html>