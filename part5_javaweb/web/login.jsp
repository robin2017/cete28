<%@ page import="bean.Product" %>

<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/17
  Time: ����2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="userServlet?action=login" method="post">

  ������<input type="text" name="username"/><br/>
  ���룺<input type="text" name="userpass"/>
  <input type="submit" value="�ύ"/>
</form>

<a href="userServlet?action=quit">�˳�</a>


<%--jsp����--%>
<%
  request.setAttribute("aa","aa");
  session.setAttribute("bb","bb");
%>
<%--el����--%>
${aa}


<%
  Product p=new Product();
  p.setName("robin");

%>
${p.name}



</body>
</html>
