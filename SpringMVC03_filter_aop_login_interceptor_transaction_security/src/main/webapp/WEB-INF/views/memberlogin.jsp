<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>

<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if (memberid == null || memberid == "" || memberpw == null || memberpw == "") {
			alert("ID와 PW를 다시 확인해 주세요!");
		} else {
			$.ajax({
				type: "post",
				url: "ajaxlogin.do",
				data: JSON.stringify(loginVal), // json 형태의 문자열로 만들어 보냄
				contentType: "application/json", // request header에 저장됨 (서버에 json 보낸다고 알리는 것) / 이 코드 없으면 415 에러 뜸
				dataType: "json",
				success: function(msg) {
					if(msg.check == true) {
						location.href="list.do";
					} else {
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW를 다시 확인해 주세요!");
					}
				},
				error: function() {
					alert("통신 실패!");
				}
			});
		}
	}
</script>

</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid" /></td>
		</tr>
		
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw" /></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="button" value="login" onclick="login();" />
				<input type="button" value="register" onclick="location.href='registerform.do'" />
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>