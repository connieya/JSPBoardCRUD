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
	<jsp:include page="../header.jsp" />
	<div class="container" style="margin-top:30px;">
		<div class="col-lg-16"></div>
		<div class="col-lg-8">
				<div class="jumbotron" style="padding-top: 20px;">
					<form method="post" action="<%=request.getContextPath() %>/auth/login">
						<h3 style= "text-align: center;">로그인 화면</h3>
						<div class ="form-group">
							<input type="text" name="id" placeholder="아이디" class="form-control" />
						</div>
						<div class ="form-group">
							<input type="password" name="password" placeholder="비밀번호" class="form-control" />
						</div>
						<input type="submit" class="btn btn-primary form-control" value="로그인"/>
					</form>
				</div>	
		</div>
			<div class="col-lg-8"></div>
	</div>
</body>
</html>