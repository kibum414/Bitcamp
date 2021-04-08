<%@ page contentType="text/html;charset=utf-8" 
	import="java.util.*, pkb.md.domain.Address" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px;
	}
	a { text-decoration:none }
</style>
<center>
	<h1>
		Address List with SpringMVC + (JSTL/EL)
	</h1>
	<a href="write.do">입력폼</a>
	<table border='1' cellpadding="7" cellspacing="2" width="50%">
	    <tr>
		    <th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<!-- ${list} = ${requestScope.list} -->
		<c:if test="${empty list}"> <!-- list size: 0 이거나 null 일 경우 -->
			<tr>
				<td align='center' colspan="5">데이터가 하나도 없음</td>
			</tr>
		</c:if>
		<c:forEach items="${list}" var="dto">
			<tr>
			    <td align='center'>${dto.seq}</td>
				<td>${dto.name}</td>
				<td>${dto.addr}</td>
				<td>${dto.rdate}</td>
				<td align='center'><a href='del.do?seq=${dto.seq}'>삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</center>