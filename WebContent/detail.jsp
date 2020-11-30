<%@page import="java.io.PrintWriter"%>
<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	 #detail{
	 	color: black;
	 }
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br/>
	
	
	<br/>
	<br />
	<%
		String UserId = null;
		if(session.getAttribute("sessionID") != null){
			UserId = (String) session.getAttribute("sessionID");
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
			
		}
		
		Board board = new BoardDAO().detail(bno);
	
	%>
	
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align :center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:20%">글 제목</td>
						<td colspan="2"><%=board.getTitle() %></td>
					</tr>
					
					<tr>
						<td >작성자</td>
						<td colspan="2"><%=board.getWriter() %></td>
					</tr>
					
					<tr>
						<td >작성일</td>
						<td colspan="2"><%=board.getCreateTime() %></td>
					</tr>
					<tr>
						<td >글 내용</td>
						<td colspan="2" style="height: 200px; text-align: left;"><%=board.getContent() %></td>
					</tr>
				</tbody>
			</table>
			<a  style="margin: 0px 5px" href="board.jsp" class="btn btn-primary">목록</a>
			<% 
			
				if(UserId != null && UserId.equals(board.getWriter())){
					
					
			%>
				<a style="margin: 0px 5px"href="update.jsp?bno=<%= bno %>" class="btn btn-primary">수정</a>
				
				<a style="margin: 0px 5px" href="deleteAction.jsp?bno=<%= bno %>" class="btn btn-primary">삭제</a>		
			
			<% 
			
				}
			
			%>
		</div>
	
	</div>
	
</body>
</html>