<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib uri="/struts-tags" prefix="s" %>

<!-- Navigation Start -->

<div id="navigation">
	<div class="container-fluid">
		<a href="#" id="brand">GNITES</a> 
		<a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="Toggle navigation">
			<i class="icon-reorder"></i>
		</a>
		
		<!-- Header navigation -->
		<ul class='main-nav'>
			<li class='active'>
				<a href="index.html"> <span>Dashboard</span></a>
			</li>
		</ul>
		
	
		<div class="user">	<!-- 
			<ul class="icon-nav">
				<li class='dropdown'><a href="#" class='dropdown-toggle'
					data-toggle="dropdown"><i class="icon-envelope"></i><span
						class="label label-lightred">4</span></a>
					<ul class="dropdown-menu pull-right message-ul">
						<li><a href="#"> <img src="img/demo/user-1.jpg" alt="">
								<div class="details">
									<div class="name">Jane Doe</div>
									<div class="message">Lorem ipsum Commodo quis nisi ...</div>
								</div>
						</a></li>
						<li><a href="#"> <img src="img/demo/user-2.jpg" alt="">
								<div class="details">
									<div class="name">John Doedoe</div>
									<div class="message">Ut ad laboris est anim ut ...</div>
								</div>
								<div class="count">
									<i class="icon-comment"></i> <span>3</span>
								</div>
						</a></li>
						<li><a href="#"> <img src="img/demo/user-3.jpg" alt="">
								<div class="details">
									<div class="name">Bob Doe</div>
									<div class="message">Excepteur Duis magna dolor!</div>
								</div>
						</a></li>
						<li><a href="components-messages.html" class='more-messages'>Go
								to Message center <i class="icon-arrow-right"></i>
						</a></li>
					</ul></li>
				<li class="dropdown sett"><a href="#" class='dropdown-toggle'
					data-toggle="dropdown"><i class="icon-cog"></i></a>
					<ul class="dropdown-menu pull-right theme-settings">
						<li><span>Layout-width</span>
							<div class="version-toggle">
								<a href="#" class='set-fixed'>Fixed</a> <a href="#"
									class="active set-fluid">Fluid</a>
							</div></li>
						<li><span>Topbar</span>
							<div class="topbar-toggle">
								<a href="#" class='set-topbar-fixed'>Fixed</a> <a href="#"
									class="active set-topbar-default">Default</a>
							</div></li>
						<li><span>Sidebar</span>
							<div class="sidebar-toggle">
								<a href="#" class='set-sidebar-fixed'>Fixed</a> <a href="#"
									class="active set-sidebar-default">Default</a>
							</div></li>
					</ul></li>
				<li class='dropdown colo'><a href="#" class='dropdown-toggle'
					data-toggle="dropdown"><i class="icon-tint"></i></a>
					<ul class="dropdown-menu pull-right theme-colors">
						<li class="subtitle">Predefined colors</li>
						<li><span class='red'></span> <span class='orange'></span> <span
							class='green'></span> <span class="brown"></span> <span
							class="blue"></span> <span class='lime'></span> <span
							class="teal"></span> <span class="purple"></span> <span
							class="pink"></span> <span class="magenta"></span> <span
							class="grey"></span> <span class="darkblue"></span> <span
							class="lightred"></span> <span class="lightgrey"></span> <span
							class="satblue"></span> <span class="satgreen"></span></li>
					</ul></li>
				<li class='dropdown language-select'><a href="#"
					class='dropdown-toggle' data-toggle="dropdown"><img
						src="img/demo/flags/us.gif" alt=""><span>US</span></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="#"><img src="img/demo/flags/br.gif" alt=""><span>Brasil</span></a>
						</li>
						<li><a href="#"><img src="img/demo/flags/de.gif" alt=""><span>Deutschland</span></a>
						</li>
						<li><a href="#"><img src="img/demo/flags/es.gif" alt=""><span>España</span></a>
						</li>
						<li><a href="#"><img src="img/demo/flags/fr.gif" alt=""><span>France</span></a>
						</li>
					</ul></li>
			</ul> -->
			<s:if test="#session.s_user!=null">
					<div class="dropdown">
					<a href="#" class='dropdown-toggle' data-toggle="dropdown"> 
						${session.s_user.nicName} 
						<img src="${ctx }/img/demo/user-avatar.jpg" alt="">
					</a>
					<ul class="dropdown-menu pull-right">
					<li><a href="more-userprofile.html">Edit profile</a></li>
					<li><a href="#">Account settings</a></li>
					<li><a href="logout.do">Sign out</a></li>
				</ul>
			</div>
					</s:if><s:else>
						<a href="${ctx }/admin/login.html">Login</a>
					</s:else>
			
		</div>
	</div>
</div>