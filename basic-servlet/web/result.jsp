<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogicServlet에서 포워딩된 페이지</title>
    </head>
    <body>

        ${v1} + ${v2} = ${result}       <%-- EL 표기법 --%>
        <br>
        <%
            int v1 = (int)request.getAttribute("v1");
            int v2 = (int)request.getAttribute("v2");
            int result = (int)request.getAttribute("result");
        %>

        <%=v1%> + <%=v2%> = <%=result%>
    </body>
</html>