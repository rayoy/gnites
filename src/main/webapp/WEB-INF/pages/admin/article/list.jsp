<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="span12">
	<div class="box">
		<div class="box-title">
			<h3>
				<i class="icon-table"></i>Articles
			</h3>
			<div class="actions">
				<!-- 
		<a class="btn" data-toggle="modal" href="#new-task">
				<i class="icon-plus-sign"></i>
				New Post
			</a>
		 -->
				<a class="btn newArtile" data-toggle="modal" href="javascript:void(0)" onclick="return newArticle(this);"> <i class="icon-plus-sign"></i>
					New Post
				</a>
			</div>
		</div>

		<div class="alert" style="margin-top: 10px;display:none;">
			<button class="close" data-dismiss="alert" type="button">×</button>
		</div>


		<div class="box-content nopadding">



			<div id="DataTables_Table_2_wrapper" class="dataTables_wrapper" role="grid">
				<div id="DataTables_Table_2_length" class="dataTables_length"></div>

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
								aria-label="Rendering engine: activate to sort column ascending">Title</th>
							<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 212px;"
								aria-label="Browser: activate to sort column ascending">Author</th>
							<th class="hidden-350 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1"
								style="width: 195px;" aria-label="Platform(s): activate to sort column ascending">Category</th>
							<th class="hidden-1024 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1"
								style="width: 192px;" aria-label="Engine version: activate to sort column ascending">Tags</th>
							<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1"
								style="width: 145px;" aria-label="CSS grade: activate to sort column ascending">Date</th>
							<th class="hidden-480 sorting_disabled" role="columnheader" rowspan="1" colspan="1" style="width: 150px;" aria-label="Options">Options</th>
						</tr>
					</thead>
					<tbody role="alert" aria-live="polite" aria-relevant="all">
						<s:if test="articles.size>0">
							<s:iterator value="articles">
								<tr class="odd">
									<td class="with-checkbox sorting_1"><input type="checkbox" value="1" name="check"></td>
									<td><a href="/gnites/article/view.do?articleId=${id}" target="_blank">${title }</a></td>
									<td>${user.nicName }</td>
									<td>${category.name }</td>
									<td>&nbsp;</td>
									<td><s:date name="publishTime" format="yyyy-MM-dd HH:mm" /></td>
									<td><a class="btn" title="" rel="tooltip" href="#" data-original-title="View"> <i class="icon-search"></i>
									</a> <a class="btn" title="" rel="tooltip" href="#" data-original-title="Edit"> <i class="icon-edit"></i>
									</a> <a class="btn delete" title="" rel="tooltip" href="article/del.do?articleId=${id }" data-original-title="Delete"> <i
											class="icon-remove"></i>
									</a></td>
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
					<span>${pagination.recordCount }</span> entries
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
${pagination }
<input id="blogId" type="hidden" value="${s_blog.id }" />
<script type="text/javascript">
    $(function(){

	$(".delete").bind("click",function(){

	    var sUrl=$(this).attr("href");
	    $.get(sUrl,function(data){
		$("#main .row-fluid").load("article/list.do",function(){
		    if(data=="success"){
				$(".alert").addClass("alert-success");
				$("<strong>Success!</strong>  <span>文章删除成功</span>").appendTo(".alert");
				$(".alert").show();
				$(".alert").delay(1000);
				$(".alert").slideUp();
		    }
		});
	    });

	    return false;
	});

    });

    // 		$(function(){

    // 			$(".newArticle").bind('click', function() {
    // 				var url = "article/create.do";
    // 				$("#main .row-fluid").load(url);
    // 				return false;
    // 			});

    // 		});

    // 		function newArticle(btn){
    // 			var url = "article/create.do";
    // 			$("#main .row-fluid").load(url);
    // 			return false;
    // 		}
</script>



