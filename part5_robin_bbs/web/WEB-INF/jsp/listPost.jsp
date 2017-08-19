<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/18
  Time: 下午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
欢迎${user.name}访问！<br/>
<tr>
  <td>id</td><td>姓名</td> <td>关键字</td><td>内容</td>
</tr><br/>

<c:forEach items="${list}" var="post">
<tr>
  <td>${post.id}</td>
  <td>${post.name}</td>
  <td>${post.keyword}</td>
  <td>${post.content}</td>

  <a href="postServlet?method=delete&id=${post.id}">删除</a>
  <a href="postServlet?method=update&id=${post.id}">修改</a>

</tr><br/>
</c:forEach>
<br/>
<a href="postServlet?method=addPost">发帖</a>
</body>
</html>
