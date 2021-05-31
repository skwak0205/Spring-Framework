<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>UPDATE INFO</h1>
	
	<form action="updateinfo.do" method="post">
		<input type="hidden" name="memberno" value="${dto.getMemberno()}" />
		
		<table border="1">
			<tr>
				<th>ID</th>
				<td>${dto.getMemberid()}</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="memberpw" value="${dto.getMemberpw()}" /></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>${dto.getMembername()}</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="정보 수정" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>