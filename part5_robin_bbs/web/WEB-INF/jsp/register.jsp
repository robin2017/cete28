<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/19
  Time: 上午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<form action="userServlet?method=registerConfire" method="post">
  ID：<input type="text"   name="id"/><br/>
  姓名：<input type="text"   name="name"/><br/>
  密码：<input type="password"   name="password"/><br/>
  手机号：<input type="text"   name="phone"/><br/>
  邮箱：<input type="text"   name="email"/><br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>
