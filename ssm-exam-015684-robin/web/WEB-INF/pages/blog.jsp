<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


    <script src="../../jquery/jquery-3.2.1.min.js"></script>
    <script src="../../jquery/jquery.validate.min.js"></script>
    <script src="../../jquery/jquery.form.js"></script>
    <script src="../../js/blog.js" type="text/javascript"></script>

    <style>
        li {
            list-style-type: none;
        }
    </style>
</head>
<body>
<div>
    <h1 style="margin-left:40px">Implementation of blog management based on SSM</h1>
    <form action="doSaveObject.do" method="post">
        <table style="margin-left:40px" border=1 cellpadding="0" cellspacing="0" width="50%">
            <tr>
                <th>标题</th>
                <th>状态</th>
            </tr>
            <c:forEach items="${blogs}" var="item">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.content}</td>
                    <td><a href="doDelete.do?id=${item.id}"> 删除</a></td>

                </tr>
            </c:forEach>
        </table>
        <ul>
            <li>title:
            <li><input type="text" name="title">
            <li>content:
            <li><textarea name="content" rows="5" cols="50"></textarea>
            <li><input type="submit" id="submit" value="submit">
        </ul>
    </form>

    <p>
        <li><input type="text" name="querytitle"  id="searchNameId"></li>
        <input type="button" value="查询名称" id="btn-search" />
    <p>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <div>
        <table border="1">
            <thead>
            <tr>
                <th>宠物名称</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody id="hello">
            <tr>
                <td>dd</td><td>tt</td>
            </tr>
            </tbody>
        </table>
    </div>



</div>
</body>
</html>