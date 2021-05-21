<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<jsp:useBean id="user" scope="session" class="vo.User"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top ">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/home.do">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/board/list.do">게시판</a>
      </li>
      		<c:if test="${!empty sessionScope.user}">
      	<li class="nav-item" >
          <a class="nav-link" href="<%=request.getContextPath() %>/auth/login.do">로그인</a>
      </li>
      <li class="nav-item" >
          <a class="nav-link" href="<%=request.getContextPath() %>/user/add.do">회원가입</a>     
      </li>
      		</c:if>
      			<li class="nav-item">
        	<span>${sessionScope.user.name}</span>
      			</li>
      	<li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/auth/logout.do">로그아웃</a> 
         </li>
         <li>
          <a class="nav-link" href="<%=request.getContextPath() %>/user/update.do?no=${user.no}">회원 수정</a>   
      </li>        
    </ul>
   
  </div>
</nav>
</body>
</html>