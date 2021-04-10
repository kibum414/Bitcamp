<%@ page contentType="text/html; charset=utf-8" 
	import="pkb.board.domain.Board" %>

<!DOCTYPE html>
<html>
<head>
<title>Spring Board</title>
<meta charset="utf-8">
<style>
a {
	text-decoration: none
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	    function f(){
	    	input.email.value = "";
	    	input.subject.value = "";
	    	//input.content.innerText = "";
	    	$("#ta").text("");
	    	
	    	input.email.focus();
	    }
	</script>
</head>
<body>
	<div style="text-align: center;">
		<font color='gray' size='4' face='휴먼편지체'>
			<hr width='650' size='2' color='gray' noshade>
			<h3>Spring Board</h3>
		</font>
		<font color='gray' size='4' face='휴먼편지체'>
			<a href='list.do'>목록</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='write.do'>글쓰기</a><br />
		</font>
		<hr width='650' size='2' color='gray' noshade>
	</div>

	<form name='input' method='post' action='update.do'>
		<input type="hidden" name="seq" value="17">
		<table border='0' width='600' align='center' cellpadding='3'
			cellspacing='1' bordercolor='gray'>
<%
			Board dto = (Board) request.getAttribute("board");
%>
			<tr>
				<td width='20%' align='center'>WRITER</td>
				<td>
					<input name='writer' readonly value='<%= dto.getWriter() %>' size="81" />
				</td>
			</tr>

			<tr>
				<td align='center'>EMAIL</td>
				<td>
					<input name='email' value="<%= dto.getEmail() %>" size="81" />
				</td>
			</tr>

			<tr>
				<td align='center'>SUBJECT</td>
				<td>
					<input name='subject' value="<%= dto.getSubject() %>" size="81" />
				</td>
			</tr>

			<tr>
				<td align='center'>CONTENT</td>
				<td>
					<textarea id='ta' name='content' rows='15' cols='70'><%= dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan='2' align='center'>
					<input type='submit' value='수정'>
					<input type="button" value="다시 입력" onclick="f()">
				</td>
			</tr>

		</table>
		<hr width="650" size="2" color="gray" noshade>
	</form>
</body>
</html>

