<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//현재 세션에 저장된 모든 속성을 제거한다.
		session.invalidate();
	%>
	
		<script>
			location.href= "index.jsp";
		</script>
</body>
</html>