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
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br/>
	<h1>게시판</h1> <br/>
	<% 
		String sessionID = null;
		if(session.getAttribute("sessionID") != null){
		sessionID = (String) session.getAttribute("sessionID");
		}
		if(sessionID !=null) {
		
		%>
		<a href="write.jsp" class="btn btn-primary pull-right" style="float:right; margin-right:100px;" >글쓰기</a>
	<%
	}
	%>
	<br/>
	<br />
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #ddddddd" >
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center">번호</th>
					<th style="background-color: #eeeeee; text-align: center">제목</th>
					<th style="background-color: #eeeeee; text-align: center">작성자</th>
					<th style="background-color: #eeeeee; text-align: center">작성일</th>
				</tr>
			</thead>
			<tbody>
			<%
				BoardDAO boardlist = new BoardDAO();
				
				ArrayList<Board> list =	boardlist.list();
				for(int i=0; i< list.size(); i++){
					
					
					%>
			
				<tr>
					<td><%= list.get(i).getBno() %></td>
					<td><%= list.get(i).getTitle() %></td>
					<td><%= list.get(i).getWriter() %></td>
					<td><%= list.get(i).getCreateTime() %></td>
				</tr>
				<% 
					}
			%>
			</tbody>
			</table>
		
		</div>
	</div>
</body>
</html>