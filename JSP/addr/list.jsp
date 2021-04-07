<%@ page contentType="text/html;charset=utf-8" import="java.sql.*" %>
<%!
	Connection con;
	Statement stmt;
	String sql = "select * from ADDRESS order by SEQ desc";

	public void jspInit() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement();
			System.out.println("(1) 드라이버 로딩 + (2) 커넥션 생성 + (3) 스테이트먼트 생성");
		} catch(ClassNotFoundException cf) {
            System.out.println("(1) 오라클 드라이버 로딩 실패");
		} catch (SQLException se) {
			System.out.println("(2) 오라클과 커넥션 생성 실패");
			System.out.println("(3) Statement 생성 / 실행 실패");
		}
	}
%>
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
		Address List 
	</h1>
	<a href="../">인덱스</a>
	&nbsp;&nbsp;&nbsp;
	<a href="input.jsp">입력폼</a>
	<table border='1' cellpadding="7" cellspacing="2" width="50%">
	    <tr>
		    <th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
<%
	ResultSet rs = null;

	try {
		rs = stmt.executeQuery(sql); // DQL (SELECT)
		
		while (rs.next()) {
			long seq = rs.getLong(1);
			String name = rs.getString(2);
			String addr = rs.getString(3);
			Date rdate = rs.getDate(4);
%>
			<tr>
				<td align='center'><%=seq%></td>
				<td><%=name%></td>
				<td><%=addr%></td>
				<td><%=rdate%></td>
				<td align='center'><a href='del.jsp?seq=<%=seq%>'>삭제</a></td>
			</tr>
<%
		}
	} catch (SQLException se) {

	} finally {
		try {
			if (rs != null) rs.close();
		} catch (SQLException se) {

		}
	}
%>
	</table>
</center>