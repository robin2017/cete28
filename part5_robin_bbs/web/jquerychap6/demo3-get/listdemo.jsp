<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  String sex = request.getParameter("sex");
  out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+sex+"</td><td><input type=\"button\" class=\"del\" value=\"删除\"/></td></tr>");
%>

