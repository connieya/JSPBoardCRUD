<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="id" name="user"/>
<jsp:setProperty property="password" name="user"/>
<jsp:setProperty property="name" name="user"/>
<jsp:setProperty property="email" name="user"/>
<jsp:setProperty property="gender" name="user"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		
		 
		UserDAO userdao = new UserDAO();
		userdao.join(user);
		
		response.sendRedirect("index.jsp");
		
	%>
	
	
	
</body>
</html>