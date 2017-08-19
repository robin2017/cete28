<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/19
  Time: 上午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="postServlet?method=addPostConfire" method="post">
  ID：<input type="text"   name="id"/><br/>
  姓名：<input type="text"   name="name"/><br/>
  关键字：<input type="test"   name="keyword"/><br/>
  内容：<input type="text"   name="content"/><br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>
