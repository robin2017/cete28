$(document).ready(function(){

    $("#btn-search").on("click",doQueryObjects);
});//$(function(){})
function doQueryObjects(){

    alert("doqueryobject function comein")
    var url="doQueryObjectsAjax.do"
    var params={
        "name":$("#searchNameId").val()
    }
    $.post(url,params,function(result){


        console.log(result);
        //console.log(JSON.stringify(result))
        if(result.state==1){
            alert("state==1");
            setTableBodyRows(result.data);
        }else{
            alert("state==0");
            alert(result.message);
        }
    });
}
function setTableBodyRows(result){

    alert("fffddd");
    var tBody=$("#hello");
    alert("end");
    alert(tBody.text())
    tBody.empty();
    for(var i in result){

        var tr=$("<tr></tr>");
        tr.append("<td>"+result[i].title+"</td>");
        tr.append("<td>"+result[i].content+"</td>");

        tBody.append(tr);
    }
}