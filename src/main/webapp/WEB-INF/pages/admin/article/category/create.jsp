<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="span12">
	<div class="box">
		<div class="box-title">
			<h3>
				<i class="icon-edit"></i> 发布一篇文章
			</h3>
		</div>
		<div class="box-content">
			<form class="form-horizontal" method="POST" action="/gnites/article/publish.do">
				<div class="control-group">
					<label class="control-label" for="textfield">文章名称:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text"
							name="title"> <span class="help-block">This is
							just a supporting text</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="textfield">摘要:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text"
							name="summary"> <span class="help-block">This is
							just a supporting text</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="textfield">内容:</label>
					<div class="controls">
						<textarea id="textarea" class="input-block-level" rows="5" name="content"></textarea>
						<span class="help-block">This is just a supporting text</span>
					</div>
				</div>
				<div class="form-actions">
					<button class="btn btn-primary" type="submit">Save changes</button>
					<button class="btn" type="button">Cancel</button>
				</div>

			</form>
		</div>
	</div>
</div>




<!--
<script type="text/javascript" charset="utf-8"
		src="/gnites/statics/js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="/gnites/plugins/FCKeditor/fckeditor.js"></script>
-->

<script type="text/javascript">
	/*
		window.UEDITOR_HOME_URL = "/gnites/plugins/ueditor1_2_6_1-src/";
		var ue = UE.getEditor('content');

		
		function newArticle(){
			//alert(ue.getContent());
		}
		
		
		 
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