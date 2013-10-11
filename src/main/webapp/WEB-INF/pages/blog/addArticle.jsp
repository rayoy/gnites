<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	
<div id="contest"></div>





<script type="text/javascript" src="../../../plugins/FCKeditor/fckeditor.js" ></script>
	<script type="text/javascript">
		var oFCKeditor = new FCKeditor('contest');
		//oFCKeditor.BasePath = 'FCKeditor/' ;
		oFCKeditor.ToolbarSet = 'Default';
		oFCKeditor.Width = '600';
		oFCKeditor.Height = '400';
		oFCKeditor.Value = '';
		oFCKeditor.ReplaceTextarea();
		//oFCKeditor.Create() ;
	</script>
</body>
</html>