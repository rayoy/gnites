<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="row-fluid">
<div class="span12">
<div class="box">
	<div class="box-title">
		<h3><i class="icon-table"></i>Articles</h3>
		<div class="actions">
		<!-- 
		<a class="btn" data-toggle="modal" href="#new-task">
				<i class="icon-plus-sign"></i>
				New Post
			</a>
		 -->
			<a class="btn newArtile" data-toggle="modal" href="javascript:void(0)" onclick="return newArticle(this);">
				<i class="icon-plus-sign"></i>
				New Post
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
												<select id="selHO0" class="chzn-done" name="DataTables_Table_2_length" size="1" aria-controls="DataTables_Table_2" style="display: none;">
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
							<a class="chzn-single" tabindex="-1" href="javascript:void(0)">
								<span>10</span>
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
					</div>
					<span>entries per page</span>
				</label>
			</div>

			<!-- Search -->
			<div id="DataTables_Table_2_filter" class="dataTables_filter">
				<label>
					<span>Search:</span>
					<input type="text" aria-controls="DataTables_Table_2" placeholder="Search here...">
				</label>
			</div>
			
			<!-- Table -->
			<table id="DataTables_Table_2" class="table table-hover table-nomargin table-bordered dataTable dataTable-nosort" data-nosort="0" aria-describedby="DataTables_Table_2_info" style="width: 1109px;">
				<thead>
					<tr class="thefilter" role="row">
						<th class="with-checkbox sorting_disabled" role="columnheader" rowspan="1" colspan="1" style="width: 17px;" aria-label="">
							<input id="check_all" type="checkbox" name="check_all">
						</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 222px;" aria-label="Rendering engine: activate to sort column ascending">Title</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 212px;" aria-label="Browser: activate to sort column ascending">Author</th>
						<th class="hidden-350 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 195px;" aria-label="Platform(s): activate to sort column ascending">Category</th>
						<th class="hidden-1024 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 192px;" aria-label="Engine version: activate to sort column ascending">Tags</th>
						<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_2" rowspan="1" colspan="1" style="width: 145px;" aria-label="CSS grade: activate to sort column ascending">Date</th>
					</tr>
				</thead>
				<tbody role="alert" aria-live="polite" aria-relevant="all">
					<s:iterator value="articleList">
					<tr class="odd">
						<td class="with-checkbox sorting_1"><input type="checkbox" value="1" name="check"></td>
						<td>${title }</td>
						<td>${user.nicName }</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><s:date name="publishTime" format="yyyy-MM-dd HH:mm" /></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<div id="DataTables_Table_1_info" class="dataTables_info">
				Showing <span>1</span> to <span>10</span> of <span>18</span> entries
			</div>
			<div id="DataTables_Table_1_paginate" class="dataTables_paginate paging_full_numbers">
				<a id="DataTables_Table_1_first" class="first paginate_button paginate_button_disabled" tabindex="0">First</a>
				<a id="DataTables_Table_1_previous" class="previous paginate_button paginate_button_disabled" tabindex="0">Previous</a>
				<span>
					<a class="paginate_active" tabindex="0">1</a>
					<a class="paginate_button" tabindex="0">2</a>
				</span>
				<a id="DataTables_Table_1_next" class="next paginate_button" tabindex="0">Next</a>
				<a id="DataTables_Table_1_last" class="last paginate_button" tabindex="0">Last</a>
			</div>
		</div>
	</div>
</div>

</div></div>


<script type="text/javascript">
	
		$(function(){
			
			$(".newArticle").bind('click', function() {
				var url = "article/create.do";
				$("#main .row-fluid").load(url);
				return false;
			});
			
		});
		
		function newArticle(btn){
			var url = "article/create.do";
			$("#main .row-fluid").load(url);
			return false;
		}
		
	</script>




<!-- 

 
<s:iterator value="articleList">

	

	<div class="post" id="post-${id }">
		<h2>
			<a href="archive?id=${id }" target="_blank" class="title">${title }</a>
		</h2>
		<div class="info">
			<span class="date">
				<s:date name="publishTime" format="yyyy-MM-dd HH:mm" />
			</span> 
			<span class="author"> 
				<a rel="author" title="由Sylvan____发布" href="#">Sylvan__${user.nicName }</a>
			</span> 
			<span class="editpost"> 
				<a class="post-edit-link" title="编辑文章" href="article/edit.do?aid=${id }">编辑</a>
			</span> 
			<span class="comments"> <a title="${title }上的评论" href="reply/create.do?aid=${id }">没有评论</a>
			</span>
			<div class="fixed"></div>
		</div>

		<div class="content">${summary }<div class="fixed"></div></div>
		<div class="under">
			<span class="categories">分类: </span> 
			<span>
				<a rel="category tag" title="查看${category.name }中的全部文章" 
					href="archives/category/${category.name }">${category.name }</a>
			</span>
			<span class="tags">标签:</span> 
			<span><a rel="tags" href="#">${tags }No tags now!</a></span>
		</div>
		 
		
	</div>
</s:iterator>-->