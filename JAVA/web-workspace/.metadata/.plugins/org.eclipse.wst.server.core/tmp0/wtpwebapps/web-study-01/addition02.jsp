<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition</title>
</head>
<body>
	<!-- JSP : View. 출력. HTML 프로그램에 JAVA 추가
		 Servlet : Controller. 로직. JAVA 프로그램에 HTML 추가 -->
	
	
	<!-- % : Scriptlet. JSP 프로그램 -->
	<%
		int num1 = 10;
		int num2 = 20;
		int add = num1 + num2;
	%>
	<!-- %= : Expression. 표현하는 것, 출력 -->
	<%=num1 %> + <%=num2 %> = <%=add %>
</body>
</html>