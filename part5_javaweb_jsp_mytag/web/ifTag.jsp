<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/demotag"  prefix="hello"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hello:if value="true">
   HelloWorld 执行主体部分
</hello:if>
<br/>
<br/>
<br/>
<hello:if value="false">
  主体部分不被执行
</hello:if>
</body>
</html>