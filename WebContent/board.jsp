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
				int pagenum = 1;  // 기본 페이지는 1페이지니깐 초기화 시켜줌
			
				//여기서 request.getParameter는 뭔데?....
				if(request.getParameter("pagenum") != null){
					pagenum = Integer.parseInt(request.getParameter("pagenum"));
				}
				BoardDAO boardlist = new BoardDAO();
				
				ArrayList<Board> list =	boardlist.list(pagenum);
				for(int i=0; i< list.size(); i++){
					
					
					%>
			
				<tr>
					<td><%= list.get(i).getBno() %></td>
					<td><a id="detail" href="detail.jsp?bno=<%=list.get(i).getBno()%>"><%= list.get(i).getTitle() %></a></td>
					<td><%= list.get(i).getWriter() %></td>
					<td><%= list.get(i).getCreateTime() %></td>
				</tr>
				<% 
					}
			%>
			</tbody>
			</table>
			<%
				if(pagenum != 1){
			
			%>
			 		<a href="board.jsp?pagenum=<%= pagenum -1 %>" class="btn btn-success btn-arraw-left">이전</a>
			<%
				} else if(boardlist.nextPage(pagenum +1)) {
					
				
			 %>
			 	<a href="board.jsp?pagenum=<%= pagenum +1 %>" class="btn btn-success btn-arraw-left">다음</a>
			 <%
				}
			 %>
		
		</div>
	</div>
</body>
</html>