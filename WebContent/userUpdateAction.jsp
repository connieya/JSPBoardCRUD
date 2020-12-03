<%@page import="user.UserDAO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="board.BoardDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty property="*" name="user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="false" />
	
	<% 
		String userID = null;
		if(session.getAttribute("sessionID") != null){
		userID = (String) session.getAttribute("sessionID");
		}
		
		if(userID == null ){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다. 로그인 하세요')");
			script.println("location.href ='login.jsp'");
			script.println("</script>");
		
		}else{
			UserDAO dao = new UserDAO();
			
			int result = dao.update(user);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원 수정 실패.')");
				script.println("history.back()");
				script.println("</script>");
			}else{
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원 수정 성공')");
				script.println("location.href = 'index.jsp'");
				script.println("</script>");
			}
				
		}
	%>
	
	
</body>
</html>