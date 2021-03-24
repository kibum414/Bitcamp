<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HTML 구 버전과의 호환성 때문에 입력
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/~~~"> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 빈 양식을 보낼 땐 get 방식
		 양식을 채워서 보낼 땐 post 방식 -->
	<form method="get" action="LoginServlet">
		<label for="userid"> 아이디 : </label>
		<input type="text" name="id" id="userid"><br>
		<label for="userpwd"> 암 &nbsp;호 : </label>
		<input type="password" name="pwd" id="userpwd"><br>
		
		<input type="submit" value="로그인">
	</form>
</body>
</html>