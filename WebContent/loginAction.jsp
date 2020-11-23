<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
 <jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty property="id" name="user"/>
<jsp:setProperty property="password" name="user"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
		<%
			
			/* String id = request.getParameter("userID");
			String pw = request.getParameter("userPassword"); */
			
			String sessionID = null;
			//session.getAttribute() 세션의 정보를 불러옴
			// 세션에 저장된 속성이름을 불러오기 때문에 똑같이 sessionID 입력
			if(session.getAttribute("sessionID") != null){
				sessionID = (String) session.getAttribute("sessionID");
			}
			if(sessionID != null){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 로그인 되어있습니다.')" );
				script.println("location.href ='index.jsp'");
				script.println("</script>");
			}
			
			
			
			UserDAO userdao = new UserDAO();
			
			int result = userdao.login(user.getId(), user.getPassword());
			
			if(result ==1){
				//로그인에 성공했기 때문에 세션 부여
				session.setAttribute("sessionID", user.getId());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인 성공.')");
				script.println("location.href ='index.jsp'");
				script.println("</script>");
				//response.sendRedirect("index.jsp");
			}
			else if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('해당 아이디가 없습니다.')");
				script.println("history.back()");
				script.println("</script>");
				//response.sendRedirect("login.jsp");
			}
			else if(result == 0){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('비밀번호가 틀렸습니다.')");
				script.println("history.back()");
				script.println("</script>");
				
			}else{
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('데이터베이스 오류')");
				script.println("history.back()");
				script.println("</script>");
				//response.sendRedirect("login.jsp");
			}
		%>
		
</body>
</html>