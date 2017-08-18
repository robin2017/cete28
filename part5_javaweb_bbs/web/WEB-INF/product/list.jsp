<%@page import="entity.User"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎${user.username}访问!<br/>
<table border = "1" width="50%">
<tr>
  <td>pId</td><td>pName</td><td>pcount</td><td>操作</td>
</tr>
<c:forEach items="${products }" var="product">
   <tr>
     <td>${product.id }</td>
     <td>${product.proname }</td>
     <td>${product.proCount }
     <td><a href="ProductServlet?id=${product.id }&action=del">删除</a>&nbsp;&nbsp;<a href="ProductServlet?id=${product.id }&action=updateUI">修改</a></td>
   </tr>
</c:forEach>
</table>
<br/>
<a href="UserServlet?action=exit">退出</a>
</body>
</html>