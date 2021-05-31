<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		function idCheckConfirm() {
			var chk = document.getElementsByName("memberid")[0].title;
			if (chk == "n") {
				alert("id 중복체크를 먼저 해주세요.");
				document.getElementsByName("memberid")[0].focus();
			}
		}
		
		function idCheck() {
			var doc = document.getElementsByName("memberid")[0];
			if (doc.value.trim() == "" || doc.value == null) {
				alert("id를 입력해 주세요");
			} else {
				open("idcheck.do?memberid="+doc.value, "", "width=200, height=200");
			}
		}
	</script>

</head>
<body>
	<h1>REGISTER</h1>
	
	<form action="register.do" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="memberid" title="n" required="required" />
					<input type="button" value="중복체크" onclick="idCheck();" />
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="memberpw" required="required" onclick="idCheckConfirm();" /></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername" required="required" onclick="idCheckConfirm();" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="가입" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>