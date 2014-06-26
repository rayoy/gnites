<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	//获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link href="${ctx }/plugins/flat-admin/html/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/plugins/flat-admin/html/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${ctx }/plugins/flat-admin/html/css/plugins/jquery-ui/smoothness/jquery-ui.css" rel="stylesheet">
<link href="${ctx }/plugins/flat-admin/html/css/plugins/jquery-ui/smoothness/jquery.ui.theme.css" rel="stylesheet">
<link href="${ctx }/plugins/flat-admin/html/css/style.css" rel="stylesheet">
<link href="${ctx }/plugins/flat-admin/html/css/themes.css" rel="stylesheet">
<style type="text/css">
.container {
	width: 940px;
}
</style>
</head>
<body>
	<!--  Header -->
	<jsp:include page="/WEB-INF/pages/admin/header-min.jsp" />
	<div id="content" class="nav-hidden container">
		<div id="main" style="margin-left: 0px;">
			<div class="container-fluid">
				<div class="page-header">
					<div class="pull-left">
						<h1>Blog post</h1>
					</div>
				</div>
			</div>
			<div class="preview-img">
				<a href="more-blog-post.html"> <img alt="" src="${ctx }/plugins/flat-admin/html/img/demo/big/blog-1.jpg">
				</a>
			</div>
			<div class="row-fluid">
				<!-- Left panel -->
				<div class="span9">
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
								<div class="post-text">${content }</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Right panel -->
				<div class="span3">
					<div class="blog-widget">
						<h4 class="blog-widget-title">Related posts</h4>
						<ul class="blog-widget-recent-posts">
							<li><a href="more-blog-post.html"> Lorem ipsum Ex proident <span class="details"> <span class="date"> <i
											class="icon-calendar"></i> July 5, 2013
									</span> <span class="tags"> <i class="icon-tag"></i> lorem,ipsum
									</span>
								</span>
							</a></li>
							<li><a href="more-blog-post.html"> Lorem ipsum Ex proident <span class="details"> <span class="date"> <i
											class="icon-calendar"></i> July 5, 2013
									</span> <span class="tags"> <i class="icon-tag"></i> lorem,ipsum
									</span>
								</span>
							</a></li>
							<li><a href="more-blog-post.html"> Lorem ipsum Ex proident <span class="details"> <span class="date"> <i
											class="icon-calendar"></i> July 5, 2013
									</span> <span class="tags"> <i class="icon-tag"></i> lorem,ipsum
									</span>
								</span>
							</a></li>
						</ul>
					</div>

					<div class="blog-widget">
						<h4 class="blog-widget-title">Categories</h4>
						<ul class="blog-widget-categories">
							<li><a href="#">Business</a></li>
						</ul>
					</div>
				</div>


			</div>
		</div>


		<input id="blogId" type="hidden" value="${blog.id }" />
		<script type="text/javascript" src="statics/js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
	    $(function(){

		$(".delArticle").live("click",function(){

		    var aid=$(this).closest(".block").attr("id");

		    $.post("article/del.do?articleId="+aid,function(){
			reloadArticle();
		    });

		    return false;
		});

	    });

	</script>
</body>
</html>