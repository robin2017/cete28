<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/19
  Time: 上午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="postServlet?method=updateConfire" method="post">
  id:<input type="text" value="${post.id}" name="id"/>
  姓名：<input type="text" value="${post.name}" name="name"/>
  关键字：<input type="text" value="${post.keyword}" name="keyword"/>
  内容：<input type="text" value="${post.content}" name="content"/>
  <input type="submit" value="提交"/>
</form>

</body>
</html>
