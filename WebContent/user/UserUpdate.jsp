<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/custom.css" >
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container" style="text-align: center;" >
	<div class="col-lg-10">
	<div class="jumbotron" style="margin-top:20px; background-color: #f0f0f0;"  >
<form method="post" action="user/update.do">
	<div class="form-group">
    <label for="exampleInputPassword1">아이디</label>
    <input type="text" class="form-control" name="id" value='${user.id }' readonly />
  	</div>  	
 	<div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" name="password"   />
  	</div> 	
  	<div class="form-group">
    <label for="exampleInputPassword1">이름</label>
    <input type="text" class="form-control" name="name" value='${user.name}'/>
  	</div>
  
  	<div class="form-group">
    <label for="exampleInputEmail1">이메일</label>
    <input type="email" class="form-control" name="email" value='${user.email}' aria-describedby="emailHelp"/>
  	</div>
  	 <button type="submit" class="btn btn-primary">수정</button>
  	 <a style="margin: 0px 5px" onclick="return confirm('정말로 탈퇴하시겠습니까?')" href="user/delete.do?id='${user.id }'" >회원탈퇴</a>		
  	</form>
	 </div>   <!-- div.jumbotron 끝 -->
	 </div>		<!-- div.col-lg-8 -->
	 </div> <!--  div.container -->
</body>
</html>