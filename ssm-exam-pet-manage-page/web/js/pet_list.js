$(document).ready(function(){
$("#queryFormId")
.on("click",".btn-search",doQueryObjects)
.on("click",".btn-delete",doDeleteObject);

$("#pageId").on("click",".pre,.next,.first,.last",jumpToPage);

doFindObjects();
});//$(function(){})
function doQueryObjects(){
  doFindObjects();
}
function doFindObjects(){
	var url="doFindObjects.do"
    var params={"name":$("#searchNameId").val()};
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent)pageCurrent=1;
	params.pageCurrent=pageCurrent;
	console.log(JSON.stringify(params));
    $.post(url,params,function(result){
	        if(result.state==1){
			//这个表格中tbody数据
			setTableBodyRows(result.data.list);
			//设置分页信息
			setPagination(result.data.pageObject);
			}else{
			alert(result.message);
			}
	});
}
function doDeleteObject(){
	var url="doDeleteObjects.do";
	var checkedIds=getCheckedIds();
	console.log("params="+JSON.stringify(params));
	if(checkedIds.length==0){
	alert("请至少选择一个");
	return;
	}
	var params={"checkedIds":checkedIds};
	$.post(url,params,function(result){
		if(result.state==1){
			doFindObjects();
		}else{
			alert(result.message);
		}
	})
}
//获得选中的checkbox
function getCheckedIds(){//1,2,3,4,5
	var checkedIds="";
	$("#tbodyId input[name='checkItem']")
	.each(function(){
		console.log("checked="+$(this).prop("checked"));
		if($(this).prop("checked")){
			
			if(checkedIds==""){
				checkedIds+=$(this).val();
				console.log("checkedIds="+checkedIds);
			}else{
				checkedIds+=","+$(this).val();
			}
		}
	});
	return checkedIds;
	
}
/**设置分页*/
function setPagination(pageObject){
	$(".pageCount").html("总页数("+pageObject.pageCount+")");
	$(".pageCurrent").html("当前页("+pageObject.pageCurrent+")");
	//绑定总页数
	$("#pageId").data("pageCount",pageObject.pageCount);
	//绑定当前页面
	$("#pageId").data("pageCurrent",pageObject.pageCurrent);
}
//跳转到下一页
function jumpToPage(){
	
	//获得点击对象上class属性对应的值
	var clazz=$(this).attr("class");
	//获得pageId对象上绑定的pageCurrent对应的值
	var pageCurrent=$('#pageId').data("pageCurrent");
	//获得pageId对象上绑定的pageCount对应的值
	var pageCount=$('#pageId').data("pageCount")
	//判断点击的是否是上一页
	if(clazz=='pre'&&pageCurrent>1){
		pageCurrent--;
	}
	//判断点击的是否是下一页
	if(clazz=="next"&&pageCurrent<pageCount){
		pageCurrent++;
	}
	if(clazz=="first"){
		pageCurrent=1;
	}
	if(clazz=="last"){
		pageCurrent=pageCount;
	}
	console.log("pageCurrent="+pageCurrent);
	//重写绑定pageCurrent的值,
	$('#pageId').data("pageCurrent",pageCurrent);
	//重新执行查询操作
	doFindObjects();
}
function setTableBodyRows(result){
	var tBody=$("#tbodyId");
	tBody.empty();
	for(var i in result){
		var tr=$("<tr></tr>");
		var firstTd="<td><input type='checkbox' name='checkItem' value='[id]'/></td>";
		tr.append(firstTd.replace("[id]",result[i].id));
		tr.append("<td>"+result[i].name+"</td>");
		tr.append("<td>"+result[i].note+"</td>");
		tBody.append(tr);
	}
}
