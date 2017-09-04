$(document).ready(function(){
	$("#queryFormId").on("click",".btn-search",doQueryObjects);
});//$(function(){})
function doQueryObjects(){
	var url="doQueryObjects.do"
	var params={
		"name":$("#searchNameId").val()
	}
	$.post(url,params,function(result){
		//alert("query ok");
		//console.log(JSON.stringify(result))
		if(result.state==1){
		setTableBodyRows(result.data);
		}else{
		alert(result.message);
		}
	});
}
function setTableBodyRows(result){
	alert(result[1].name);

	var tBody=$("#tbodyId");
	tBody.empty();
	for(var i in result){
		var tr=$("<tr></tr>");
		tr.append("<td>"+result[i].name+"</td>");
		tr.append("<td>"+result[i].note+"</td>");
		tBody.append(tr);
	}
}
