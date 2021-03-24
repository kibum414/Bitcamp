<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
	<!-- form의 이름을 알 필요가 있기 때문에 name 지정 -->
	<form method="get" action="ParamServlet" name="frm">
		아이디 : <input type="text" name="id"><br>
		<!-- &nbsp; : 공백 표시
			 HTML 문법에서는 공백 2개를 연속으로 사용해도 2칸을 띄어 쓸 수 없음
			 그래서 공백을 여러 개 사용해야 할 때는 빈 칸을 &nbsp; 라고 표시해 줌 -->
		나 &nbsp; 이 : <input type="text" name="age"><br>
		
		<input type="submit" value="전송" onclick="return check()">
	</form>
</body>
</html>