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
	
	<div class="container" >
		<div class="row">
	 		<form method="post" action="updateAction.jsp?bno=<%= bno %>">
			<table class="table table-striped" style="text-align :center; border: 1px solid #dddddd; width : 800px;" >
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 수정</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						
						<td><input type="text" class="form-control" name="title" value="<%= board.getTitle() %>" /></td>
					</tr>
					
					<tr>
						<td><textarea class="form-control" name="content" style="height: 350px;" maxlength="2048" ><%= board.getContent() %></textarea></td>
					</tr>
					
					
				</tbody>
				
			</table>
				<input type="submit" class ="btn btn-primary pull-right" value="수정" />
				<a  style="margin: 0px 5px" href="detail.jsp?bno=<%= board.getBno() %>" class="btn btn-primary">취소</a>
	
			</form>
			
		</div>
		
	</div>
	
</body>
</html>