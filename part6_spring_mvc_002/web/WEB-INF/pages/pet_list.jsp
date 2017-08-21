<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title>Insert title here</title>

<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" href="${basePath}/static/css/font-awesome.min.css">
<link rel="stylesheet" href="${basePath}/static/plugins/ztree/css/metroStyle/metroStyle.css">
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap-table.min.css">
<link rel="stylesheet" href="${basePath}/static/css/main.css">
<link rel="stylesheet" href="${basePath}/static/plugins/treegrid/jquery.treegrid.css">

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-datepicker.min.js"></script>
<script src="${basePath}/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${basePath}/static/plugins/layer/layer.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.min.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script src="${basePath}/static/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${basePath}/static/plugins/treegrid/tree.table.js"></script>
<script src="${basePath}/static/plugins/ztree/jquery.ztree.all.min.js"></script>
<script type="text/javascript">
    $(function(){
    	$(".btn-add").click(function(){
    		toUrl("editUI.do");
    	})
    })
    function toUrl(url){
    	document.location.href=url;
    }
</script>
</head>
<body>
 <!--动态的设置内容的容器 -->
 <div class="container">
        <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>宠物管理系统</h3>
			</div>
		</div>
		<form method="post" id="queryFormId">
		   <!-- 查询表单 -->
		   <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="宠物名称"></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-add">添加</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn-delete">删除</button></li>
				</ul>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th>选择</th>
							<th>宠物名称</th>
							<th>出生日期</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbodyId"></tbody>
				</table>
		 </div>
		</form>
 </div> 
</body>
</html>





