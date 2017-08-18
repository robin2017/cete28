<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/18
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
<script src="jquery.js"/>
  <script>
    function check(){
      var email=$("#email").val();
//      function是一个回调函数
      $.get("UserServlet",{email:email},function(data){
        alert(data)
      })
    }

  </script>
</head>
<body>



<input type="text" name="email"/>
<input type="button" value="checkmail" onclick="check">


</body>
</html>
