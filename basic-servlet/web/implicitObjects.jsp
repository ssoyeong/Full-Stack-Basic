<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>내장 객체 실습 페이지</title>
    </head>
    <body>
        내장 객체 실습 페이지 <br>
        <%
            StringBuffer url = request.getRequestURL();
            out.print("url : " + url.toString());
            out.print("<br>");
        %>

    </body>
</html>