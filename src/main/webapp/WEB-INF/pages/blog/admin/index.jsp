<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="target-densitydpi=device-dpi, width=device-width, initial-scale=1.0, maximum-scale=1" name="viewport">
<title>Console</title>
<!-- 
<link href="plugins/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" >
 -->

<link href="plugins/olton-Metro-UI-CSS-ce20509/css/modern.css" type="text/css" rel="stylesheet" >
<link href="plugins/olton-Metro-UI-CSS-ce20509/css/modern-responsive.css" type="text/css" rel="stylesheet" >
</head>
<body class="modern-ui" onload="prettyPrint()">

	<div class="page">
<div class="nav-bar">
    <div class="nav-bar-inner padding10">
        <span class="pull-menu"></span>

        <a href="index.html"><span class="element brand">
            <img class="place-left" src="plugins/olton-Metro-UI-CSS-ce20509/images/logo32.png" style="height: 20px"/>
           Bootstrap Metro UI CSS 中文版 <small>0.15.8.12</small>
        </span></a>

        <div class="divider"></div>

        <ul class="menu">
            <li><a href="index.html">首页</a></li>
            <li data-role="dropdown">
                <a href="#">脚手架</a>
                <ul class="dropdown-menu">
                    <li><a href="global.html">全局样式</a></li>
                    <li><a href="layout.html">布局与模板</a></li>
                    <li><a href="grid.html">网格系统</a></li>
                    <li class="divider"></li>
                    <li><a href="responsive.html">响应式设计</a>
                    </li>
                </ul>
            </li>
             <li data-role="dropdown"><a href="#">基本样式</a>
                <ul class="dropdown-menu">
                    <li><a href="typography.html">排版</a></li>
                    <li><a href="tables.html">表格</a></li>
                    <li><a href="forms.html">表单</a></li>
                    <li><a href="buttons.html">按钮</a></li>
                    <li><a href="images.html">图像</a></li>
                    <li class="divider"></li>
                    <li><a href="icons.html">图标</a></li>
                </ul>
            </li>
             <li data-role="dropdown"><a href="#">组件</a>
                <ul class="dropdown-menu">
                    <li><a href="tiles.html">Tiles</a></li>
                    <li><a href="menus.html">菜单与导航</a></li>
                    <li><a href="sidebar.html">侧边栏</a></li>
                    <li><a href="pagecontrol.html">多页控件</a></li>
                    <li><a href="accordion.html">手风琴</a></li>
                    <li><a href="buttons-set.html">按钮组</a></li>
                    <li><a href="rating.html">评分</a></li>
                    <li><a href="progress.html">进度条</a></li>
                    <li><a href="carousel.html">幻灯片</a></li>
                    <li><a href="listview.html">列表视图</a></li>
                    <li><a href="slider.html">滑块</a></li>
                    <li><a href="dialog.html">对话框</a></li>
                    <li class="divider"></li>
                    <li><a href="notices.html">通知与回复</a></li>
                    <li class="divider"></li>
                    <li><a href="cards.html">额外惊喜 - 一副扑克</a></li>
                </ul>
            </li>

            <li><a href="https://github.com/olton/Metro-UI-CSS" target="_blank">源码</a></li>
        </ul>

    </div>
</div>
</div>
	














	<div id="header" style="padding:20px;">
		当前登录:<a href="#">${session.user.nicName}</a>
		|<a href="logout.do">退出</a>
	</div>
	<div id="wrap" style="width:1200px;margin:0 auto;padding:20px;">
	
	<div id="nav" style="width:150px;float:left;">
		<ul>
			<li><a href="admin/article/list.do?blogId=${myBlog.id }">文章管理</a></li>
			<li><a href="workflow/list.do?user=${session.user.nicName }">流程管理</a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
		</ul>
	</div>

	<div id="main" style="width:800px;float:left;">
		<a class="newArticle" href="javascript:void(0)">新建文章</a>
		<div id="list"></div>
	</div>
	
	<div style="clear:both" ></div>
</div>
	<jsp:include page="sidebar.jsp" />


	<script type="text/javascript" src="statics/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor1_2_6_1-src/ueditor.config.js?t="+new Date().getTime()></script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor1_2_6_1-src/_examples/editor_api.js?t="+new Date().getTime()></script>
	<script type="text/javascript">
		$(function() {

			$(".subnav-menu a").bind('click', function() {
				var url = $(this).attr("href");
				$("#list").load(url);
				//alert("work?");
				return false;
			});
			
			$("#main a.newArticle").live('click', function() {
				var url = "article/create.do";
				$("#list").load(url);
				return false;
			});

			alert("dd");

		});
	</script>
</body>
</html>