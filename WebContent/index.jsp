<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br/>
	<h1>Home</h1> <br/>
	<% 
		String sessionID = null;
		if(session.getAttribute("sessionID") != null){
		sessionID = (String) session.getAttribute("sessionID");
		}
		if(sessionID !=null) {
		
		%>
	<button type="button" onclick="location.href='write.jsp'" class="btn btn-primary pull-right">글쓰기</button>
	<%
	}
	%>
	<br />
	<% String title = request.getParameter("title");
		String content = request.getParameter("content");
	%>
	<%= title %> <br/>
	<%= content %>
</body>
</html>