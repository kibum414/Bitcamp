<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>EL</title>
        <meta charset="utf-8">
    </head>
    <body style="text-align:center">
    
        <h2> EL </h2>

<%
    request.setAttribute("obj", new String("졸립죠?")); // at Controller
    session.setAttribute("user", new String("홍길동")); // at Controller
    session.setAttribute("obj", new String("괜찮아요")); // at Controller
    
    // String result = (String) request.getAttribute("obj"); // at View
%>
        java 사용 1: <%
            String result = (String) request.getAttribute("obj");
            out.println(result);
        %><br/>
        Scripting Elements 내 java 코드 사용 2: <%=result%> <br/>

        EL 사용 결과 1: ${obj} <br/>
        EL 사용 결과 2: ${sessionScope.obj} <br/>
        EL 사용 결과 3: ${user} <br/>
    </body>
</html>