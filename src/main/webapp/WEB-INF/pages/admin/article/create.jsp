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
			<form class="form-horizontal form-wysiwyg" method="POST"
				action="/gnites/article/publish.do">
				<div class="control-group">
					<label class="control-label" for="textfield">文章名称:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text"
							name="title"> 
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="textfield">摘要:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text"
							name="summary"> 
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="textfield">内容:</label>
					<div class="controls">
							<textarea name="content" class='ckeditor span12' rows="5"></textarea>
					</div>
				</div>
				<div class="form-actions">
					<input type="button" class="btn btn-primary save" value="保存" />
					<button class="btn" type="button">取消</button>
				</div>

			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="/gnites/plugins/flat-admin/html/js/plugins/ckeditor/ckeditor.js"></script>	
<script type="text/javascript">
	var myeditor = CKEDITOR.replace('content');
	$(function(){
	    
	    $(".save").bind("click",function(){
			alert(myeditor.document.getBody().getHtml(););
			var form = $(this).closest("form");
			$.post(form.attr("action"),form.serialize(),function(data){
			    alert(data);
			});
	    });
	});
</script>
