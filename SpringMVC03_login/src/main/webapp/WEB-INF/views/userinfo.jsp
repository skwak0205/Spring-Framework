<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function deleteinfo(){
			if(confirm("정말 탈퇴하시겠습니까?")) {
				location.href="deleteinfo.do?memberno="+${dto.getMemberno()};
			}
		}
	</script>

</head>
<body>
	<h1>USER INFO</h1>
	
	<table border="1">
		<col width="50" />
		<col width="100" />
		<col width="100" />
		
		<tr>
			<th>NO</th>
			<th>ID</th>
			<th>NAME</th>
		</tr>
		

		<tr>
			<td>${dto.getMemberno()}</td>
			<td>${dto.getMemberid()}</td>
			<td>${dto.getMembername()}</td>
		</tr>

		
		<tr>
			<td colspan="8">
				<input type="button" value="정보수정" onclick="location.href='updateinfoform.do?memberno=${dto.getMemberno()}'" />
				<input type="button" value="탈퇴" onclick="deleteinfo()" />
				<input type="button" value="메인" onclick="location.href='login.do?memberid=${dto.getMemberid()}&memberpw=${dto.getMemberpw() }'" />
			</td>
		</tr>
	</table>
	
</body>
</html>