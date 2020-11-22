<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userID");
		String password = request.getParameter("userPassword");
		String email = request.getParameter("userEmail");
		String name = request.getParameter("userName");
		String gender = request.getParameter("userGender"); 
		
	
		
		
		UserDAO userdao = new UserDAO();
		userdao.join(id, password , name, email, gender);
		
		response.sendRedirect("index.jsp");
		
	%>
	
	
	
</body>
</html>