<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span12">
	<div class="box">
		<div class="box-title">
			<h3>
				<i class="icon-table"></i>文章归档
			</h3>
			<div class="actions">
				<a class="btn newCategory" data-toggle="modal" href="javascript:void(0)"> <i class="icon-plus-sign"></i>
					New Category
				</a>
			</div>
		</div>

		<div class="box-content nopadding">
			<div id="DataTables_Table_2_wrapper" class="dataTables_wrapper" role="grid">
				<div id="DataTables_Table_2_length" class="dataTables_length">
					<label>
						<div class="input-mini">
							<div class="input-mini">
								<div class="input-mini">
									<div class="input-mini">
										<div class="input-mini">
											<div class="input-mini">
												<div class="input-mini">
													<select id="selHO0" class="chzn-done" name="DataTables_Table_2_length" size="1" aria-controls="DataTables_Table_2"
														style="display: none;">
														<option value="10" selected="selected">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="selHO0_chzn" class="chzn-container chzn-container-single chzn-container-single-nosearch" style="width: 60px;" title="">
								<a class="chzn-single" tabindex="-1" href="javascript:void(0)"> <span>10</span>
									<div>
										<b></b>
									</div>
								</a>
								<div class="chzn-drop" style="left: -9000px; width: 58px; top: 31px;">
									<div class="chzn-search">
										<input type="text" autocomplete="off" style="width: 23px;">
									</div>
									<ul class="chzn-results">
										<li id="selHO0_chzn_o_0" class="active-result result-selected" style="">10</li>
										<li id="selHO0_chzn_o_1" class="active-result" style="">25</li>
										<li id="selHO0_chzn_o_2" class="active-result" style="">50</li>
										<li id="selHO0_chzn_o_3" class="active-result" style="">100</li>
									</ul>
								</div>
							</div>
						</div> <span>entries per page</span>
					</label>
				</div>

				<!-- Search -->
				<div id="DataTables_Table_2_filter" class="dataTables_filter">
					<label> <span>Search:</span> <input type="text" aria-controls="DataTables_Table_2" placeholder="Search here...">
					</label>
				</div>

				<!-- Table -->
				<table id="DataTables_Table_2" class="table table-hover table-nomargin table-bordered dataTable dataTable-nosort" data-nosort="0"
					aria-describedby="DataTables_Table_2_info" style="width: 1109px;">
					<thead>
						<tr class="thefilter" role="row">
							<th class="with-checkbox sorting_disabled" role="columnheader" rowspan="1" colspan="1" style="width: 17px;" aria-label=""><input
								id="check_all" type="checkbox" name="check_all"></th>
							<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 222px;"
								aria-label="Rendering engine: activate to sort column ascending">名称</th>
							<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 212px;"
								aria-label="Browser: activate to sort column ascending">别名</th>
							<th class="hidden-350 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1"
								style="width: 195px;" aria-label="Platform(s): activate to sort column ascending">父类</th>
						</tr>
					</thead>
					<tbody role="alert" aria-live="polite" aria-relevant="all">
						<s:if test="articleCategoryList.size>0">
							<s:iterator value="articleCategoryList">
								<tr class="odd">
									<td class="with-checkbox sorting_1"><input type="checkbox" value="1" name="check"></td>
									<td><a href="article/view.do?articleId=${id}">${name }</a></td>
									<td></td>
									<td>${parent.name }</td>
								</tr>
							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td colspan="6" align="center">No result!</td>
							</tr>
						</s:else>

					</tbody>
				</table>
				<div id="DataTables_Table_1_info" class="dataTables_info">
					Showing <span>1</span> to <span>10</span> of <span>18</span> entries
				</div>
				<div id="DataTables_Table_1_paginate" class="dataTables_paginate paging_full_numbers">
					<a id="DataTables_Table_1_first" class="first paginate_button paginate_button_disabled" tabindex="0">First</a> <a
						id="DataTables_Table_1_previous" class="previous paginate_button paginate_button_disabled" tabindex="0">Previous</a> <span> <a
						class="paginate_active" tabindex="0">1</a> <a class="paginate_button" tabindex="0">2</a>
					</span> <a id="DataTables_Table_1_next" class="next paginate_button" tabindex="0">Next</a> <a id="DataTables_Table_1_last"
						class="last paginate_button" tabindex="0">Last</a>
				</div>
			</div>
		</div>

	</div>
</div>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">添加新分类目录</h3>
	</div>
	<div class="modal-body">
		<p>One fine body…</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button class="btn btn-primary save">Save changes</button>
	</div>
</div>
<script type="text/javascript">
    $(function(){

	$(".newCategory").bind("click",function(){
	    $("#myModal .modal-body").load("article/category/create.do",function(){
		 	$('#myModal').modal();
	    });
	});
	
	$(".save").bind("click",function(){
	    var form = $(this).closest(".modal").find("form");
	    $.post(form.attr("action"),form.serialize(),function(){
			alert("~~~");
	    });
	});

    });

    var sData=[{id:1,name:"22",parent:"null"}];

    alert(initSelect());

    function initSelect(){

	var sData=[{id:1,name:"22",parent:"null"}];
	var sHtml="";
	for( var i=0;i<sData.length;i++){
	    var counter=0;
	    if(sData[i].parent=="null"){
		sHtml+="<option>"+sData[i].name+"</option>";
		this.findByParent(sHtml,sData,sData[i].id,counter);
	    }
	}
	return sHtml;
    }

    function findByParent(sHtml,sData,pid,counter){
	for( var i=0;i<sData.length;i++){
	    if(sData[i].parent==pid){
		sHtml+="<option>"+this._setBlank(sHtml,counter)+sData[i].name
			+"</option>";
		this.findByParent(sHtml,sData,sData[i].id,counter);
		counter++;
	    }
	}
    }

    function _setBlank(html,counter){
	for( var i=0;counter>0,i<counter;i++){
	    html+="--";
	}
	return html;
    }
</script>
