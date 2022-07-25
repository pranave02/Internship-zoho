<%@page import="com.pranave.maintenance_app.owner_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Values</title>
</head>
<body>
   <%
   owner_info a = (owner_info)request.getAttribute("val1");
   
   out.println(a);
   %>
</body>
</html>