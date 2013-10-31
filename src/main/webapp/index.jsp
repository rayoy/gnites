<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- index.jsp 首页 (显示一些精选文章)
=================================================================================================
	 --%>



<% 
	String path = request.getContextPath();    
	//获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" >  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${name }</title>

<link href="statics/style.css" rel="stylesheet" type="text/css">
<link href="statics/default.css" rel="stylesheet" type="text/css">

</head>
<body>

	<input id="blogId" type="hidden" value="${blog.id }" />

	<div id="wrap">
		<div id="container">

			<!-- Header -->
			<div id="header">
				<div id="caption">
					<h1 id="title">
						<a href="#">${name }</a>
					</h1>
					<div id="tagline">${description }${basePath }<%=basePath %></div>
				</div>
				<div class="fixed"></div>
			</div>

			<!-- Navigation -->
			<div id="navigation">
				<ul id="menus">
					<li class="current_page_item">
						<a class="home" href="${url }" title="首页">首页</a></li>
					<li class="page_item page-item-2"><a
						href="http://sylvan41.gnites.com/sample-page">相册</a></li>
					<li class="page_item page-item-125"><a
						href="http://sylvan41.gnites.com/%e5%85%b3%e4%ba%8e%e6%88%91">关于我</a>
					</li>
					<li><a class="lastmenu" href="javascript:void(0);"></a></li>
				</ul>
				<div id="searchbox">
					<form method="get" action="http://sylvan41.gnites.com">
						<div class="content">
							<input class="textfield searchtip" type="text" value="" size="24"
								name="s"> <input class="button" type="submit" value="">
						</div>
					</form>
				</div>
				<script type="text/javascript">
					//<![CDATA[
					var searchbox = MGJS.$("searchbox");
					var searchtxt = MGJS.getElementsByClassName("textfield",
							"input", searchbox)[0];
					var searchbtn = MGJS.getElementsByClassName("button",
							"input", searchbox)[0];
					var tiptext = "请输入关键字...";
					if (searchtxt.value == "" || searchtxt.value == tiptext) {
						searchtxt.className += " searchtip";
						searchtxt.value = tiptext;
					}
					searchtxt.onfocus = function(e) {
						if (searchtxt.value == tiptext) {
							searchtxt.value = "";
							searchtxt.className = searchtxt.className.replace(
									" searchtip", "");
						}
					}
					searchtxt.onblur = function(e) {
						if (searchtxt.value == "") {
							searchtxt.className += " searchtip";
							searchtxt.value = tiptext;
						}
					}
					searchbtn.onclick = function(e) {
						if (searchtxt.value == "" || searchtxt.value == tiptext) {
							return false;
						}
					}
					//]]>
				</script>
				<div class="fixed"></div>
			</div>


			<div id="content">
				<div id="main"></div>
				<div id="sidebar">
					<div id="northsidebar" class="sidebar">

						<div id="search-2" class="widget widget_search">
							<form id="searchform" class="searchform"
								action="http://sylvan41.gnites.com/" method="get" role="search">
								<div>
									<label class="screen-reader-text" for="s">搜索：</label> <input
										id="s" type="text" name="s" value=""> <input
										id="searchsubmit" type="submit" value="搜索">
								</div>
							</form>
						</div>

						<div id="recent-posts-2" class="widget widget_recent_entries">
							<h3>近期文章</h3>
							<ul>
								<li><a title="apk反编译"
									href="http://sylvan41.gnites.com/archives/139">apk反编译</a></li>
								<li><a title="Windows Live Writer推荐SyntaxHighlighter代码着色插件"
									href="http://sylvan41.gnites.com/archives/133">Windows Live
										Writer推荐SyntaxHighlighter代码着色插件</a></li>
								<li><a title="Java冒泡排序"
									href="http://sylvan41.gnites.com/archives/130">Java冒泡排序</a></li>
								<li><a title="Java性能优化问题"
									href="http://sylvan41.gnites.com/archives/128">Java性能优化问题</a></li>
								<li><a title="使用SSH，不要每次GIT PUSH都输入密码"
									href="http://sylvan41.gnites.com/archives/120">使用SSH，不要每次GIT
										PUSH都输入密码</a></li>
							</ul>
						</div>

						<div id="recent-comments-2" class="widget widget_recent_comments">
							<h3>近期评论</h3>
							<ul id="recentcomments"></ul>
						</div>

						<div id="archives-2" class="widget widget_archive">
							<h3>文章归档</h3>
							<ul>
								<li><a title="2013年十月"
									href="http://sylvan41.gnites.com/archives/date/2013/10">2013年十月</a>
								</li>
								<li><a title="2013年九月"
									href="http://sylvan41.gnites.com/archives/date/2013/09">2013年九月</a>
								</li>
								<li><a title="2013年八月"
									href="http://sylvan41.gnites.com/archives/date/2013/08">2013年八月</a>
								</li>
							</ul>
						</div>


						<div id="categories-2" class="widget widget_categories">
							<h3>分类目录</h3>
							<ul>
								<li class="cat-item cat-item-56"><a title="查看Android下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/android">Android</a>
									(1)</li>
								<li class="cat-item cat-item-8"><a title="查看Emacs下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/emacs">Emacs</a>
									(2)</li>
								<li class="cat-item cat-item-5"><a
									title="查看Exceptions下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/exceptions">Exceptions</a>
									(2)</li>
								<li class="cat-item cat-item-31"><a
									title="查看Extreme Programming下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/extreme-programming">Extreme
										Programming</a> (1)
									<ul class="children"></li>
								<li class="cat-item cat-item-22"><a title="查看Git下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/git">Git</a>
									(2)</li>
								<li class="cat-item cat-item-24"><a title="查看IDE下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/ide">IDE</a>
									(1)
									<ul class="children"></li>
								<li class="cat-item cat-item-6"><a title="查看Java下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/java">Java</a>
									(3)</li>
								<li class="cat-item cat-item-4"><a title="查看Maven下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/maven">Maven</a>
									(1)</li>
								<li class="cat-item cat-item-3"><a title="查看Network下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/network">Network</a>
									(1)</li>
								<li class="cat-item cat-item-2"><a
									title="查看wordpress下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/wordpress">wordpress</a>
									(1)</li>
								<li class="cat-item cat-item-52"><a title="查看数据结构与算法下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/%e6%95%b0%e6%8d%ae%e7%bb%93%e6%9e%84%e4%b8%8e%e7%ae%97%e6%b3%95">数据结构与算法</a>
									(1)</li>
								<li class="cat-item cat-item-1"><a title="查看未分类下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/uncategorized">未分类</a>
									(4)</li>
								<li class="cat-item cat-item-18"><a title="查看编程语言下的所有文章"
									href="http://sylvan41.gnites.com/archives/category/%e7%bc%96%e7%a8%8b%e8%af%ad%e8%a8%80">编程语言</a>
									(1)</li>
							</ul>
						</div>

						<div id="meta-2" class="widget widget_meta">
							<h3>功能</h3>
							<ul>
								<s:if test="#session.user!=null">
								<li><a href="http://sylvan41.gnites.com/wp-admin/">管理站点</a>
								</li>
								<li>
									<a href="logout.do">登出</a>
								</li>
								</s:if><s:else>
									<li>
										<a href="login">登录</a>
									</li>
								</s:else>
								<li><a title="使用RSS 2.0订阅本站点内容" href="http://sylvan41.gnites.com/feed"></a></li>
								<li><a title="使用RSS订阅本站点的所有文章的近期评论" href="http://sylvan41.gnites.com/comments/feed"></a></li>
								<li><a title="基于WordPress，一个优美、先进的个人信息发布平台。" href="http://cn.wordpress.org/">WordPress.org</a></li>
							</ul>
						</div>

					</div>
				</div>
				<div class="fixed"></div>
			</div>
			<div id="footer">
				<a id="gotop" onclick="MGJS.goTop();return false;" href="#">回到顶部</a>
				<a id="powered" href="http://wordpress.org/">WordPress</a>
				<div id="copyright">版权所有 © 2013 晚安，博客</div>
				<div id="themeinfo">
					主题由 <a href="http://www.neoease.com/">NeoEase</a> 提供, 通过 <a
						href="http://validator.w3.org/check?uri=referer">XHTML 1.1</a> 和 <a
						href="http://jigsaw.w3.org/css-validator/check/referer?profile=css3">CSS
						3</a> 验证.
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="statics/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function() {

			$(".delArticle").live("click", function() {

				var aid = $(this).closest(".block").attr("id");

				$.post("article/del.do?articleId=" + aid, function() {
					reloadArticle();
				});

				return false;
			});

		});

		function reloadArticle() {
			var bid = $("#blogId").val();
			$("#main").load("article/list.do?blogId=" + bid);
		}

		function loadArticleCategory() {
			var bid = $("#blogId").val();
			$("#category").load("ac/list.do?blogId=" + bid);
		}

		reloadArticle();
	</script>

</body>
</html>