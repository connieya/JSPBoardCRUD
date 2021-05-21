<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
	 #detail{
	 	color: black;
	 }
	 *{
	 	font-size : 20px;
	 }
	 .btn{
	 	font-size : 20px;
	 }
	 a.btn{
	 	margin : 5px;
	 	text-align: center;
	 	width: 50px;
	 	height: 40px;
	 }
	 h1#boardlist{
	 	text-align: center;
	 }
</style>
<link rel="stylesheet" href="css/custom.css" >
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<br/>
	<h1 id="boardlist">게시판 리스트</h1> <br/>
	<a href="write.jsp" class="btn btn-primary pull-right" style="float:right; margin-right:100px;" >글쓰기</a>
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
			<c:forEach var="board" items="${boards}">
				<tr>
					<td>${board.no}</td>
					<td><a id="detail" href="user/update.do?bno=${board.no }">${board.tittle}</a></td>
					<td>${board.wrtier }</td>
					<td>${board.createTime }</td>
				</tr>	
			</c:forEach>
			</tbody>
			</table>	
			 <a href="board.jsp?pagenum=" class="btn btn-success btn-arraw-left">이전</a>		
			<a href="board.jsp?pagenum=" class="btn btn-success btn-arraw-left">다음</a>						
		</div>
	</div>
	<jsp:include page="../tail.jsp" />
</body>
</html>