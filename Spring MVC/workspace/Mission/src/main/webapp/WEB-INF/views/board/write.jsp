<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Spring Board</title>
    <style>
		a{text-decoration:none}
	</style>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("ëª¨ë  ê°ì ìë ¥ íìì¼ í©ëë¤. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
  </head>
  <body onload="input.writer.focus()">
	<font color="gray" size='4' face="í´ë¨¼í¸ì§ì²´">
    <center>
	   <hr width="650" size='2' color="gray" noshade>
	      <h3> Spring Board</h3>
		  	<font color="gray" size="3" face="í´ë¨¼í¸ì§ì²´">
			<a href='list.do'>ë¦¬ì¤í¸</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='../'>ì¸ë±ì¤</a>
			</font>
	   <hr width="650" size="2" color="gray" noshade>
	</center>

	<form name="input" method="post" action="write.do">
	   <table border="0" width="600" align="center"  cellpadding="3" cellspacing="1" bordercolor="gray">
	      <tr>
		     <td width="30%" align="center">WRITER</td>
			 <td><input type="text" name="writer" size="93"></td>
		  </tr>
		  <tr>
		     <td align="center">EMAIL</td>
			 <td><input type="text" name="email" size="93"></td>
		  </tr>
          <tr>
		     <td align="center">SUBJECT</td>
			 <td><input type="text" name="subject" size="93"></td>
		  </tr>
		  <tr>
		     <td align="center">CONTENT</td>
			 <td><textarea  name="content" rows="15" cols="70"></textarea></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="ì ì¡" onclick="check()">
				<input type="reset" value="ë¤ììë ¥" onclick="input.writer.focus()">
			 </td>
		  </tr>
	   </table>
	   <hr width="650" size="2" color="gray" noshade>
	</form>
	</font>
  </body>
</html>