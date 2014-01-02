<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta names="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />

<title>GNITES - Dashboard</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/bootstrap.min.css">
<!-- Bootstrap responsive -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/bootstrap-responsive.min.css">
<!-- jQuery UI -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/jquery-ui/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/jquery-ui/smoothness/jquery.ui.theme.css">
<!-- PageGuide -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/pageguide/pageguide.css">
<!-- Fullcalendar -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/fullcalendar/fullcalendar.css">
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/fullcalendar/fullcalendar.print.css"
	media="print">
<!-- chosen -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/chosen/chosen.css">
<!-- select2 -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/select2/select2.css">
<!-- icheck -->
<link rel="stylesheet"
	href="../plugins/flat-admin/html/css/plugins/icheck/all.css">
<!-- Theme CSS -->
<link rel="stylesheet" href="../plugins/flat-admin/html/css/style.css">
<!-- Color CSS -->
<link rel="stylesheet" href="../plugins/flat-admin/html/css/themes.css">

<!-- jQuery -->
	<script src="../plugins/flat-admin/html/js/jquery.min.js"></script>
	
	<!-- Nice Scroll -->
	<script src="../plugins/flat-admin/html/js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- imagesLoaded -->
	<script src="../plugins/flat-admin/html/js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
	<!-- jQuery UI -->
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.core.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.widget.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.mouse.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.resizable.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.sortable.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.spinner.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/jquery-ui/jquery.ui.slider.js"></script>
	<!-- Bootstrap -->
	<script src="../plugins/flat-admin/html/js/bootstrap.min.js"></script>
	<!-- Bootbox -->
	<script src="../plugins/flat-admin/html/js/plugins/bootbox/jquery.bootbox.js"></script>
	<!-- Masked inputs -->
	<script src="../plugins/flat-admin/html/js/plugins/maskedinput/jquery.maskedinput.min.js"></script>
	<!-- TagsInput -->
	<script src="../plugins/flat-admin/html/js/plugins/tagsinput/jquery.tagsinput.min.js"></script>
	<!-- Datepicker -->
	<script src="../plugins/flat-admin/html/js/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Daterangepicker -->
	<script src="../plugins/flat-admin/html/js/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/daterangepicker/moment.min.js"></script>
	<!-- Timepicker -->
	<script src="../plugins/flat-admin/html/js/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<!-- Colorpicker -->
	<script src="../plugins/flat-admin/html/js/plugins/colorpicker/bootstrap-colorpicker.js"></script>
	<!-- Chosen -->
	<script src="../plugins/flat-admin/html/js/plugins/chosen/chosen.jquery.min.js"></script>
	<!-- MultiSelect -->
	<script src="../plugins/flat-admin/html/js/plugins/multiselect/jquery.multi-select.js"></script>
	
	<!-- PLUpload -->
	<script src="../plugins/flat-admin/html/js/plugins/plupload/plupload.full.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/plupload/jquery.plupload.queue.js"></script>
	<!-- Custom file upload -->
	<script src="../plugins/flat-admin/html/js/plugins/fileupload/bootstrap-fileupload.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/mockjax/jquery.mockjax.js"></script>
	<!-- select2 -->
	<script src="../plugins/flat-admin/html/js/plugins/select2/select2.min.js"></script>
	<!-- icheck -->
	<script src="../plugins/flat-admin/html/js/plugins/icheck/jquery.icheck.min.js"></script>
	<!-- complexify -->
	<script src="../plugins/flat-admin/html/js/plugins/complexify/jquery.complexify-banlist.min.js"></script>
	<script src="../plugins/flat-admin/html/js/plugins/complexify/jquery.complexify.min.js"></script>
	<!-- Mockjax -->
	<script src="../plugins/flat-admin/html/js/plugins/mockjax/jquery.mockjax.js"></script>


	<!-- Theme framework -->
	<script src="../plugins/flat-admin/html/js/eakroko.min.js"></script>
	<!-- Theme scripts -->
	<script src="../plugins/flat-admin/html/js/application.min.js"></script>
	<!-- Just for demonstration -->
	<script src="../plugins/flat-admin/html/js/demonstration.min.js"></script>


<!--[if lte IE 9]>
		<script src="js/plugins/placeholder/jquery.placeholder.min.js"></script>
		<script>
			$(document).ready(function() {
				$('input, textarea').placeholder();
			});
		</script>
	<![endif]-->

<!-- Favicon -->
<link rel="shortcut icon"
	href="../plugins/flat-admin/html/img/favicon.ico" />
<!-- Apple devices Homescreen icon -->
<link rel="apple-touch-icon-precomposed"
	href="../plugins/flat-admin/html/img/apple-touch-icon-precomposed.png" />

<style type="text/css">
#navigation #brand {
	padding-right: 45px;
}
</style>
</head>

<body>

	<%
		// 判断当前用户是否登录 
		if (session.getAttribute("s_user") == null) {
			response.sendRedirect("login.html");
		}
	%>


	<!-- Header -->
	<jsp:include page="/WEB-INF/pages/admin/header.jsp" />

	<div class="container-fluid">

		<!-- Sidebar left panel -->
		<jsp:include page="/WEB-INF/pages/admin/sidebar.jsp" />

		<!-- Right content start -->
		<div id="main">
			<div class="container-fluid">
				<!-- 
				<div class="page-header">
					<div class="pull-left">
						<h1>Dashboard</h1>
					</div>
					<div class="pull-right">
						<ul class="minitiles">
							<li class='grey'>
								<a href="#"><i class="icon-cogs"></i></a>
							</li>
							<li class='lightgrey'>
								<a href="#"><i class="icon-globe"></i></a>
							</li>
						</ul>
						<ul class="stats">
							<li class='satgreen'>
								<i class="icon-money"></i>
								<div class="details">
									<span class="big">$324,12</span>
									<span>Balance</span>
								</div>
							</li>
							<li class='lightred'>
								<i class="icon-calendar"></i>
								<div class="details">
									<span class="big">February 22, 2013</span>
									<span>Wednesday, 13:56</span>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="breadcrumbs">
					<ul>
						<li>
							<a href="more-login.html">Home</a>
							<i class="icon-angle-right"></i>
						</li>
						<li>
							<a href="index.html">Dashboard</a>
						</li>
					</ul>
					<div class="close-bread">
						<a href="#"><i class="icon-remove"></i></a>
					</div>
				</div> -->
				<div class="row-fluid"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
		
		$(function() {
			$.ajaxSetup({
				cache:false
			});
			$(".subnav-menu a").bind("click", function() {

				var url = $(this).attr("href");
				$(".active").removeClass("active");
				$(this).parent().addClass("active");
				$("#main .row-fluid").load(url,function(){
					//CKEDITOR.replace('content');
				});
				return false;

			});

		});
	</script>
</body>
</html>