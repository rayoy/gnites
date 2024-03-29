<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<div id="left" class="ui-sortable ui-resizable">
	<form action="search-results.html" method="GET" class='search-form'>
		<div class="search-pane">
			<input type="text" name="search" placeholder="Search here...">
			<button type="submit">
				<i class="icon-search"></i>
			</button>
		</div>
	</form>
	<div class="subnav">
		<div class="subnav-title">
			<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Articles</span></a>
		</div>
		<ul class="subnav-menu">
			<!-- 
					<li class='dropdown'>
						<a href="#" data-toggle="dropdown">Articles</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">Action #1</a>
							</li>
							<li>
								<a href="#">Antoher Link</a>
							</li>
							<li class='dropdown-submenu'>
								<a href="#" data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">This is level 3</a>
									</li>
									<li>
										<a href="#">Unlimited levels</a>
									</li>
									<li>
										<a href="#">Easy to use</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					 -->
			<li><a href="article/list.do?blogId=${s_blog.id }">所有文章</a></li>
			<li><a href="article/create.do">写文章</a></li>
			<li><a href="article/category/list.do?blogId=${s_blog.id }">分类目录</a></li>
			<li><a href="article/tags/list.do?blogId=${s_blog.id }">标签</a></li>
		</ul>
	</div>
	<div class="subnav">
		<div class="subnav-title">
			<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Process</span></a>
		</div>
		<ul class="subnav-menu">
			<li><a href="/gnites/workflow/list.do?taskRole=owner">All
					Process</a></li>
			<li class='dropdown'><a href="#" data-toggle="dropdown">Import
					manager</a>
				<ul class="dropdown-menu">
					<li><a href="#">Action #1</a></li>
					<li><a href="#">Antoher Link</a></li>
					<li class='dropdown-submenu'><a href="#"
						data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
						<ul class="dropdown-menu">
							<li><a href="#">This is level 3</a></li>
							<li><a href="#">Unlimited levels</a></li>
							<li><a href="#">Easy to use</a></li>
						</ul></li>
				</ul></li>
			<li><a href="/gnites/workflow/list.do">Tasks</a></li>
			<li><a href="#">SEO optimization</a></li>
		</ul>
	</div>
	<div class="subnav">
		<div class="subnav-title">
			<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>Settings</span></a>
		</div>
		<ul class="subnav-menu">
			<li><a href="#">Theme settings</a></li>
			<li class='dropdown'><a href="#" data-toggle="dropdown">Page
					settings</a>
				<ul class="dropdown-menu">
					<li><a href="#">Action #1</a></li>
					<li><a href="#">Antoher Link</a></li>
					<li class='dropdown-submenu'><a href="#"
						data-toggle="dropdown" class='dropdown-toggle'>Go to level 3</a>
						<ul class="dropdown-menu">
							<li><a href="#">This is level 3</a></li>
							<li><a href="#">Unlimited levels</a></li>
							<li><a href="#">Easy to use</a></li>
						</ul></li>
				</ul></li>
			<li><a href="#">Security settings</a></li>
		</ul>
	</div>
	<div class="subnav subnav-hidden">
		<div class="subnav-title">
			<a href="#" class='toggle-subnav'><i class="icon-angle-right"></i><span>Default
					hidden</span></a>
		</div>
		<ul class="subnav-menu">
			<li><a href="#">Menu</a></li>
			<li class='dropdown'><a href="#" data-toggle="dropdown">With
					submenu</a>
				<ul class="dropdown-menu">
					<li><a href="#">Action #1</a></li>
					<li><a href="#">Antoher Link</a></li>
					<li class='dropdown-submenu'><a href="#"
						data-toggle="dropdown" class='dropdown-toggle'>More stuff</a>
						<ul class="dropdown-menu">
							<li><a href="#">This is level 3</a></li>
							<li><a href="#">Easy to use</a></li>
						</ul></li>
				</ul></li>
			<li><a href="#">Security settings</a></li>
		</ul>
	</div>
</div>
<!-- ./ Left navigation end -->

