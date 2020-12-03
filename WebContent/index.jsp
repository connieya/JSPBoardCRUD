<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/custom.css" >
<style>
	h2#sessionID{
		text-align: center;
		font-family: serif;
		font-weight: bold;
	}
	span#sessionID{
		color: blue;
		font-style: italic;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<h1>메인화면</h1> <br/>
	<% 
	String sessionID = null;
	if(session.getAttribute("sessionID") != null){
			sessionID = (String) session.getAttribute("sessionID");
	}
	
	if(sessionID != null){
		
	
	%>
	<h2 id="sessionID">	<span id="sessionID"><%=sessionID %></span> 님 환영합니다. </h2>
	
	<% 
	}
    %>
	
	<div class="container">
		<div class="jumbotron" style="height: 400px;">
			<div class="container">
			  		<h1>웹 사이트 소개</h1>
			  		<h3>간단한 CRUD 게시판을 만들어보았습니다.</h3>
			  		<p>주요 기능은 다음과 같습니다.</p>
			  		<ul id="main">
			  			<li>회원가입</li>
			  			<li>로그인(세션 설정)</li>
			  			<li>게시판 글 등록(로그인 해야 가능)</li>
			  			<li>게시판 리스트(페이징 기능)</li>
			  			<li>게시판 상세보기</li>
			  			<li>게시판 글 수정,삭제(해당 작성자만 가능)</li>
			  			
			  		</ul>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>