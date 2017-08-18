<%@ page import="bean.Product" %>

<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/17
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="userServlet?action=login" method="post">

  姓名：<input type="text" name="username"/><br/>
  密码：<input type="text" name="userpass"/>
  <input type="submit" value="提交"/>
</form>

<a href="userServlet?action=quit">退出</a>


<%--jsp代码--%>
<%
  request.setAttribute("aa","aa");
  session.setAttribute("bb","bb");
%>
<%--el代码--%>
${aa}


<%
  Product p=new Product();
  p.setName("robin");

%>
${p.name}



</body>
</html>
