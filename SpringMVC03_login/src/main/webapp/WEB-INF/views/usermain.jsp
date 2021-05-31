<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${dto.getMembername() }님, 환영합니다.</h1>
	
	<p>
		<a href="logout.do">로그아웃</a>
	</p>

	<div>
		<p>
			<a href="userinfo.do?memberno=${dto.getMemberno()}">내 정보 보기</a>
		</p>
	</div>
</body>
</html>