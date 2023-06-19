<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1부터 10까지 더하는 페이지</title>
    </head>
    <body>
        <%      // Scriptlet: 여기 안에는 Java 코드를 입력할 수 있음
            int total = 0;
            for(int i = 1; i <= 10; i++) {
                total += i;
            }
        %>
        1부터 10까지의 합 : <%=total%>
    </body>
</html>