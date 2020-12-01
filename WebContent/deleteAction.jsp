<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="board.BoardDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			script.println("alert('로그인 하세요')");
			script.println("location.href ='login.jsp'");
			script.println("</script>");
		
		}
		int bno = 0;
		if(request.getParameter("bno") != null){
			bno = Integer.parseInt(request.getParameter("bno"));
		}
		
		
		if(bno ==0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다.')");
			script.println("location.href = 'board.jsp'");
			script.println("</script>");
			
		}else{
			BoardDAO dao = new BoardDAO();
			int result = dao.delete(bno);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('삭제 실패.')");
				script.println("history.back()");
				script.println("</script>");
			}else{
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('삭제 성공')");
				script.println("location.href = 'board.jsp'");
				script.println("</script>");
			}
				
		}
	%>
	
	
</body>
</html>