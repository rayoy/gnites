<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<form class="form-horizontal" method="POST" action="article/category/save.do">
	<div class="control-group">
		<label class="control-label" for="textfield">名称:</label>
		<div class="controls">
			<input id="textfield" class="input-xlarge" type="text" name="name"> <span class="help-block">这将是它在站点上显示的名字。</span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="textfield">别名:</label>
		<div class="controls">
			<input id="textfield" class="input-xlarge" type="text" name="summary"> <span class="help-block">This is just a supporting text</span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="textfield">父级:</label>
		<div class="controls">
			<select name="parentId"><option>无</option></select>
			<span class="help-block">This is just a supporting text</span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="textfield">描述:</label>
		<div class="controls">
			<textarea name="description"></textarea>
			<span class="help-block">描述只会在一部分主题中显示。</span>
		</div>
	</div>
</form>

<script type="text/javascript">
    $(function(){
			
		var url = "article/category/select.do";
		$.getJSON(url,function(data){
		    var html  = initSelect(data);
		    $(html).appendTo("select[name='parentId']");
		});
	
    });
    
    function initSelect(sData){

	var sHtml="";
	for( var i=0;i<sData.length;i++){
	    var counter=0;
	    if(sData[i].parent==null){
		sHtml+="<option value='"+sData[i].id+"'>"+sData[i].name+"</option>";
		sHtml+=findByParent(sData,sData[i].id,counter);
	    }
	}
	return sHtml;
    }

    function findByParent(sData,pid,counter){
	var html="" ;
	for( var i=0;i<sData.length;i++){
	    
	    if(sData[i].parent!=null&&sData[i].parent.id==pid){
		counter++;
		html+="<option value='"+sData[i].id+"'>"+this._setBlank(html,counter)+sData[i].name
			+"</option>";
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
</body>
</html>