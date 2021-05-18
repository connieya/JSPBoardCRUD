<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDAO"%>
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
<jsp:include page="header.jsp" />
	<%
		/* String sessionID = null;
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
		} */
		
	
		if(user.getId() == null || user.getPassword() == null || user.getEmail() ==null 
		|| user.getName() == null || user.getGender() == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			UserDAO userdao = new UserDAO();
			int result = userdao.join(user);
				if(result == -1){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('회원가입 실패.')");
					script.println("history.back()");
					script.println("</script>");
				}else{
					//회원가입에 성공했기 때문에 세션 부여
					//로그인 하면 세션 부여해주기
					//session.setAttribute("sessionID", user.getId());
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('회원가입 성공.')");
					script.println("location.href='index.jsp'");
					script.println("</script>");
				}
			
		}
		
		 
		
		
		//response.sendRedirect("index.jsp");
		
	%>
	
	
	
</body>
</html>