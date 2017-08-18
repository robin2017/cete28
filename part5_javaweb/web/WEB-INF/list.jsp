
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Product" %>

<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/17
  Time: ÏÂÎç2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<br>
<head>
    <title></title>
</head>

success</br>

<%
  ArrayList<Product> list=(ArrayList<Product>)request.getAttribute("list");
  for(Product p:list)
    out.println(p.getName()+":"+p.getDes()+":"+p.getCount()+"</br>");
%>

<%--<%--%>
  <%--List<Product> list=((List<Product>))request.getAttribute("list");--%>
  <%--for()--%>
<%--%>--%>
</body>
</html>
