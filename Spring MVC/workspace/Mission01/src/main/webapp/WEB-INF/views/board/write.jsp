<%@ page contentType="text/html; charset=utf-8" %>

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
<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력하셔야 합니다.");
			     return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
</head>
<body onload="input.writer.focus()">
	<div style="text-align: center;">
		<hr width="650" size='2' color="gray" noshade>
		<font color="gray" size='4' face="휴먼편지체">
			<h3>Spring Board</h3>
			<a href='list.do'>리스트</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='../'>인덱스</a>
		</font>
		<hr width="650" size="2" color="gray" noshade>
	</div>

	<form name="input" method="post" action="write.do">
		<table border="0" width="600" align="center" cellpadding="3"
			cellspacing="1" bordercolor="gray">
			<tr>
				<td width="30%" align="center">WRITER</td>
				<td>
					<input type="text" name="writer" size="81">
				</td>
			</tr>
			<tr>
				<td align="center">EMAIL</td>
				<td>
					<input type="text" name="email" size="81">
				</td>
			</tr>
			<tr>
				<td align="center">SUBJECT</td>
				<td>
					<input type="text" name="subject" size="81">
				</td>
			</tr>
			<tr>
				<td align="center">CONTENT</td>
				<td>
					<textarea name="content" rows="15" cols="70"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="전송" onclick="check()">
					<input type="reset" value="다시 입력" onclick="input.writer.focus()">
				</td>
			</tr>
		</table>
		<hr width="650" size="2" color="gray" noshade>
	</form>
</body>
</html>