<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>晚安,博客</title>

<link href="plugins/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" >

<style type="text/css">

*{margin:0;padding:0;}

.title {
	padding-top: 250px;
	padding-left: 200px;
	font-size: 24px;
	font-family: '微软雅黑';
	color: #FFF;
	font-weight: bold;
	float: left;
}

.login {
	float: left;
	padding-top:200px;
	padding-left:400px;
	
}
.login label{
	color:#FFF;
	font-weight:700;
	font-style:italic;
}
input {
	background-color:#FFF;
	
}
</style>
</head>
<body>

	<div style="width: 100%; height: 750px; background: url(statics/images/gepsjids31.jpg)">
		<div class="title"></div>
		<div class="login">
			<form action="login.do" method="post">
				<p>
					<label>Email:</label><input type="text" name="email" />
				</p>
				<p>
					<label>Password:</label><input type="text" name="password" />
				</p>
				<p>
					<input type="submit" value="Login" class="btn large"/>
				</p>
			</form>
		</div>
		<div style="clear: both"></div>
	</div>

</body>
</html>