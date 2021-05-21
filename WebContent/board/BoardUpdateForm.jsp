<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/custom.css" >
<style>
	#detail{
	 	color: black;
	 }
</style>
</head>
<body>
	<jsp:include page="../header.jsp"/>	
	<br />	
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align :center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:20%">글 제목</td>
						<td colspan="2">${board.title}</td>
					</tr>	
					<tr>
						<td >작성자</td>
						<td colspan="2">${board.writer}></td>
					</tr>				
					<tr>
						<td >작성일</td>
						<td colspan="2">${board.createTime}</td>
					</tr>
					<tr>
						<td >글 내용</td>
						<td colspan="2" style="height: 200px; text-align: left;">${board.content}</td>
					</tr>
				</tbody>
			</table>
			<a  style="margin: 0px 5px" href="board.jsp" class="btn btn-primary">목록</a>	
				<a style="margin: 0px 5px"href="update.jsp?bno=${board.bno}" class="btn btn-primary">수정</a>		
				<a style="margin: 0px 5px" onclick="return confirm('정말로 삭제하시겠습니까?')" href="/board/delete.do?bno=${board.bno }" class="btn btn-primary">삭제</a>		
		</div>	
	</div>
</body>
</html>