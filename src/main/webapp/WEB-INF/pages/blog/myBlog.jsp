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

h2{font-size:16px;}


li{list-style:none;}
a{text-decoration:none;}
a:hover{text-decoration:underline;}
#userInfo {
	width: 300px;
}

#left {
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

#right{
	
	padding:50px;
	margin-left:50px;
}

#category ul{padding:10px;}
#category ul li{}
#category ul li a{padding:3px;display:block;}
#category ul li a:hover{text-decoration:underline;}

#middle{
	width:1200px;
	margin:0 auto;
}
</style>
</head>
<body>

	<s:include value="/WEB-INF/pages/common/top.jsp" />
	<div id="middle">
		<!-- 文章列表   -->
		<div id="left" class="left"></div>
	
		<div id="right" class="left">
			<div id="category"></div>
		</div>
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
			$("#left").load("article/list.do?blogId="+bid);
		}
	
		function loadArticleCategory(){
			var bid= $("#blogId").val();
			$("#category").load("ac/list.do?blogId="+bid);
		}
		
		loadArticleCategory();
		reloadArticle();
	</script>
	
</body>
</html>