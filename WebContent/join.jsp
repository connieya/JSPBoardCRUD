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
	
	<div class="container" style="text-align: center;" >
	<div class="col-lg-10">
	<div class="jumbotron" style="margin-top:20px; background-color: #f0f0f0;"  >
		<h2>회원가입 페이지</h2>
	<form method="post" action="joinAction.jsp">
	<div class="form-group">
    <label for="exampleInputPassword1">아이디</label>
    <input type="text" class="form-control" name="id" />
  	</div>
  	
  	<div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" name="password" />
  	</div>
  	
  	<div class="form-group">
    <label for="exampleInputPassword1">이름</label>
    <input type="text" class="form-control" name="name" />
  	</div>
  
  	<div class="form-group">
    <label for="exampleInputEmail1">이메일</label>
    <input type="email" class="form-control" name="email" aria-describedby="emailHelp"/>
  	</div>
  	
 	<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="gender" value="남"/>
  <label class="form-check-label" for="inlineCheckbox1">남자</label>
	</div>
	
	<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="gender" value="여"/>
  <label class="form-check-label" for="inlineCheckbox2">여자</label>
	</div> 
	
<br/>
<div>
  <button type="submit" class="btn btn-primary">회원가입</button>

</div>
</form>
	 </div>   <!-- div.jumbotron 끝 -->
	 </div>		<!-- div.col-lg-8 -->
	 </div> <!--  div.container -->
</body>
</html>