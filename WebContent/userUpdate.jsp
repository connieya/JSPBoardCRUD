<%@page import="user.User"%>
<%@page import="user.UserDAO"%>
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
<jsp:include page="header.jsp"/>
<% 

	String UserId = null;
	if(session.getAttribute("sessionID") != null){
	UserId = (String) session.getAttribute("sessionID");
	}

	if(UserId == null ){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다. 로그인 후 이용바랍니다.)");
		script.println("location.href ='login.jsp'");
		script.println("</script>");
	
	}
		User user = new UserDAO().userDetail(UserId);
		
		String name = user.getName();
	
	

	

%>
	
<div class="container" style="text-align: center;" >
	<div class="col-lg-10">
	<div class="jumbotron" style="margin-top:20px; background-color: #f0f0f0;"  >
<form method="post" action="userUpdateAction.jsp">
	<div class="form-group">
    <label for="exampleInputPassword1">아이디</label>
    <input type="text" class="form-control" name="id" readonly="true" value="<%=UserId %>" />
  	</div>
  	
  	<div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" name="password"   />
  	</div>
  	
  	<div class="form-group">
    <label for="exampleInputPassword1">이름</label>
    <input type="text" class="form-control" name="name" value="<%=name %>"/>
  	</div>
  
  	<div class="form-group">
    <label for="exampleInputEmail1">이메일</label>
    <input type="email" class="form-control" name="email" value="<%=user.getEmail() %>" aria-describedby="emailHelp"/>
  	</div>
  	 <button type="submit" class="btn btn-primary">수정</button>
  	 <a style="margin: 0px 5px" onclick="return confirm('정말로 탈퇴하시겠습니까?')" href="userDeleteAction.jsp?id=<%=  UserId %>" class="btn btn-primary">회원탈퇴</a>		
  	
  	</form>
	 </div>   <!-- div.jumbotron 끝 -->
	 </div>		<!-- div.col-lg-8 -->
	 </div> <!--  div.container -->
</body>
</html>