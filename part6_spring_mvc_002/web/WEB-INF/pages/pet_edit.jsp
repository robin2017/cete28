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
//初始化datepicker对象
$('.datepicker').datepicker({
    format: 'yyyy/mm/dd',
    autoclose: true//选中自动关闭
})
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
 <form action="doSave.do" method="post" class="form-horizontal" role="form">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >项目名称:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required" name="name" id="nameId"  placeholder="请输入名字">
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">项目编号:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="code" id="codeId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">开始时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="code" id="beginDateId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">结束时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker "  name="code" id="endDateId">
		</div>
	</div>
	<div class="form-group">
         <label class="col-sm-2 control-label"> 有效: </label>
         <div class="col-sm-10">
            <label class="radio-inline"><input  type="radio" name="valid" checked value="1" > 启用</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="0"> 禁用</label>
          </div>
    </div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
	<div class="form-group">
		<div class="col-sm-10 control-label"></div>
		<input type="submit" id="btn-save" class="btn btn-primary" value="Save">
		<input type="button" id="btn-return" class="btn btn-warning" value="Back">
	</div>
 </form>
 </div> 
</body>
</html>





