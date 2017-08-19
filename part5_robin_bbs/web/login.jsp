<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 2017/8/18
  Time: 下午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<form action="/userServlet?method=login" method="post">
  姓名:<input type="text" name="name"/><br/>
  密码:<input type="text" name="password"/><br/>
  <input type="submit" value="登陆"/>&nbsp&nbsp&nbsp
  <a href="userServlet?method=register"method="post">注册</a>
</form>

</body>
</html>
