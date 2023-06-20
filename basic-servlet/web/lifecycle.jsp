<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP 라이프 사이클 확인 페이지</title>
    </head>
    <body>
        Hello!
        <%
            System.out.println("서블릿의 Service 메소드에 들어감");
        %>

        <%!     // 느낌표 추가함
            public void jspInit() {
                System.out.println("서블릿의 Init 메소드에 들어감");
            }

            public void jspDestroy() {
                System.out.println("서블릿의 Destroy 메소드에 들어감");
            }
        %>
    </body>
</html>