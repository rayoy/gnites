<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	font-size: 12px;
	font-family: "微软雅黑";
}

#left {
	width: 200px;
	float: left;
	padding: 5px;
}

#right {
	width: 850px;
	padding: 5px;
	float: left;
	border-left: 1px solid #CCC;
}

input {
	font-size: 12px;
	font-family: "微软雅黑";
}

#title {
	padding: 5px;
	border-bottom: 1px solid #CCC;
}

.clear {
	clear: both;
}
</style>

</head>
<body>
	<div id="title">发布一篇博客</div>
	<div id="main">
		<form action="article/publish.do" method="post">
		<div id="left">
			<p>
				<label>文章名称:</label><input type="text" name="title" />
			</p>
			<p>
				<label>文章分类:</label><input type="text" name="category" />
			</p>
			<p>
				<label>摘要:</label><input type="text" name="summary" />
			</p>
			<p>
				<input type="submit" value="保存"/>
			</p>
		</div>
		<div id="right">
			<script id="content" type="text/plain" name="content" style="width:1024px;height:500px"></script>
		</div>
		</form>
		<!-- 
	
	<form action="article/publish.do" method="post">
		<div id="left">
			<p><label>文章名称:</label><input type="text" name="title" /></p>
			<p><label>文章分类:</label><input type="text" name="category" /></p>
			<p><label>摘要:</label><input type="text" name="summary" /></p>
			<p><input type="submit" value="保存" /></p>
		</div>
		<div id="right">
			<textarea id="content" name="content"></textarea>
		</div>
	</form>
	
	 -->

	</div>

	<%
		String basePath =request.getContextPath();
	%>


	<script type="text/javascript" charset="utf-8"
		src="<%=basePath %>/plugins/ueditor1_2_6_1-src/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=basePath %>/plugins/ueditor1_2_6_1-src/_examples/editor_api.js"></script>


	<script type="text/javascript" charset="utf-8"
		src="<%=basePath %>/statics/js/jquery-1.4.2.js"></script>


	<script type="text/javascript" src="<%=basePath %>/plugins/FCKeditor/fckeditor.js"></script>
	<script type="text/javascript">
		window.UEDITOR_HOME_URL = "/Gnites/plugins/ueditor1_2_6_1-src/";
		var ue = UE.getEditor('content');

		
		function newArticle(){
			alert(ue.getContent());
		}
		
		
		/**
		var oFCKeditor = new FCKeditor('content');
		oFCKeditor.BasePath = 'plugins/FCKeditor/';
		oFCKeditor.ToolbarSet = 'Basic';
		oFCKeditor.Width = '1000';
		oFCKeditor.Height = '500';
		oFCKeditor.Value = '文章内容';
		oFCKeditor.ReplaceTextarea();
		//oFCKeditor.Create() ;
		*/
		
	</script>
</body>
</html>