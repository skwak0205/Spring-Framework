<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- modelAttribute : form에 있는 요소들의 값을 채우기 위해 사용될 객체를 request로부터 찾을때 사용할 이름 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h1>UPLOAD FORM</h1>
		
		file<br/>
		<input type="file" name="mpfile" /><br/>
		<p style="color:red; font-weight:bold;">
			<form:errors path="mpfile" />
		</p>
		<br/>
		
		description<br />
		<textarea rows="10" cols="60" name="desc"></textarea>
		
		<input type="submit" value="send" />
	</form:form>
	
	<!-- 
		form tag의 enctype 속성
			1. application/www-form-urlencoded : 문자들이 encoding 됨 (default)
			2. multipart/form-data : file upload 가능 (post만 써야함)
			3. text/plain : encoding하지 않음
			
			
		spring form tag
			form:errors : Errors, BindingResult를 사용할 때, command 객체의 특정 field에서 발생하는 에러 메세지 출력 가능
	
	 -->
	
	
	
</body>
</html>