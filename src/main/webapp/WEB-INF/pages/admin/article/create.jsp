<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="span12">
	<div class="box">
		<div class="box-title">
			<h3>
				<i class="icon-edit"></i> 发布一篇文章
			</h3>
		</div>
		<div class="box-content">
			<form class="form-horizontal form-wysiwyg" method="POST" action="/gnites/article/publish.do">
				<div class="control-group">
					<label class="control-label" for="textfield">文章名称:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text" name="title">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="textfield">个人分类:</label>
					<div class="controls">
						<select name="articleCategoryId"><option>无</option></select>
					</div>
				</div>
				<!-- 
				<div class="control-group">
					<label class="control-label" for="textfield">摘要:</label>
					<div class="controls">
						<input id="textfield" class="input-xlarge" type="text" name="summary">
					</div>
				</div>
				 -->
				<div class="control-group">
					<label class="control-label" for="textfield">内容:</label>
					<div class="controls">
						<textarea name="ck" class='ckeditor span12' rows="5"></textarea>
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
    CKEDITOR.config.toolbar=[
	    
	    ['Cut','Copy','Paste','PasteText','-','Bold','Italic','Underline','Strike','TextColor','BGColor',
	     '-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','NumberedList','BulletedList','Outdent','Indent',
	     '-','Link','Unlink','Image','Table','Smiley','PageBreak','-','Maximize','ShowBlocks','-','About'],
	    ['Styles','Format','Font','FontSize']
	   ];

    var instance=CKEDITOR.instances['ck'];
    if(instance){	
		CKEDITOR.remove(instance);
    }
    var editor=CKEDITOR.replace('ck',{});

    $(function(){

	var url="article/category/select.do";
	$.getJSON(url,function(data){
	    var html=initSelect(data);
	    $(html).appendTo("select[name='articleCategoryId']");
	});

	$(".save").bind("click",function(){

	    var sTitle=$("input[name='title']").val();
	    var sSummary=$("input[name='summary']").val();
	    var sContent=editor.document.getBody().getHtml();
	    var sUrl=$(this).closest("form").attr("action");
	    var params={"title":sTitle,"summary":sSummary,"content":sContent};

	    $.post(sUrl,params,function(data){
		alert(data);
	    });
	});

    });

    function initSelect(sData){

	var sHtml="";
	for( var i=0;i<sData.length;i++){
	    var counter=0;
	    if(sData[i].parent==null){
		sHtml+="<option value='"+sData[i].id+"'>"+sData[i].name
			+"</option>";
		sHtml+=this.findByParent(sData,sData[i].id,counter);
	    }
	}
	return sHtml;
    }

    function findByParent(sData,pid,counter){
	var html="";
	for( var i=0;i<sData.length;i++){

	    if(sData[i].parent!=null&&sData[i].parent.id==pid){
		counter++;
		html+="<option value='"+sData[i].id+"'>"
			+this._setBlank(html,counter)+sData[i].name+"</option>";
		this.findByParent(html,sData,sData[i].id,counter);

	    }
	}
	return html;
    }

    function _setBlank(html,counter){
	for( var i=0;counter>0,i<counter;i++){
	    html+="--";
	}
	return html;
    }
</script>
