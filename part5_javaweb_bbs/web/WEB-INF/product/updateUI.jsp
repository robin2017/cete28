<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet?action=update" method="post">
id:${product.id }<br/>
<input type="hidden" name="id" value="${product.id }"/>
proname:<input type="text" name="proname" value="${product.proname }"/>
<br/>
prodes:<input type="text" name="prodes" value="${product.prodes }"/>
<br/>
procount:<input type="text" name="procount" value="${product.proCount }"/>
<br/>
<input type="submit" value="update"/>
</form>
</body>
</html>