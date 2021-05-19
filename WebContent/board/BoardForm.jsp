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
	<jsp:include page="../header.jsp" flush="false" />
	<div class="container" style="text-align: center; margin-top:10px;">
		<h1>게시판 글 쓰기</h1>
	<div class="jumbotron">	
	<form action="boardAction.jsp" method="post">
  <div class="form-group">
    	<h2>제목:</h2>
    <input type="text" class="form-control"  name="title">
  </div>
  <div class="form-group">
  		<h2>내용:</h2>
  <textarea class="form-control" rows="5" name="content"></textarea>
	</div>
  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>  <!--  div.jumbotron -->
</div>   <!-- div.container -->
</body>
</html>