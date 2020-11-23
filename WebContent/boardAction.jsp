<%@page import="java.io.PrintWriter"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <jsp:useBean id="board" class="board.Board" scope="page" />
<jsp:setProperty property="title" name="board"/>
<jsp:setProperty property="content" name="board"/>
<jsp:setProperty property="writer" name="board"/> --%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 		<%
 			String title = request.getParameter("title");
 			String content = request.getParameter("content");
 			String writer = request.getParameter("writer");
 		
 			
 			if(title == null || content == null || writer ==null){
 				PrintWriter script = response.getWriter();
 				script.println("<script>");
 				script.println("alert('입력이 안된 사항이 있습니다.')");
 				script.println("history.back()");
 				script.println("</script>");
 			}else{
 				BoardDAO data = new BoardDAO();
 	 			int result = data.write(title, content , writer);
 	 			if(result == -1){
 	 				PrintWriter script = response.getWriter();
 	 				script.println("<script>");
 	 				script.println("alert('글등록 실패.')");
 	 				script.println("history.back()");
 	 				script.println("</script>");
 	 			}else{
 	 				PrintWriter script = response.getWriter();
 	 				script.println("<script>");
					script.println("alert('글 등록 성공.')");
					script.println("location.href='index.jsp'");
					script.println("</script>");
					
 	 			}
 			}
 		
 		%>
</body>
</html>