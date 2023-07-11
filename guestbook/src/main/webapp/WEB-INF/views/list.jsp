<%--
  Created by IntelliJ IDEA.
  User: jeonsoyeong
  Date: 2023/06/27
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>방명록 목록</title>
</head>
<body>
    <h1>방명록</h1>
    <br> 방명록 전체 수 : ${count }, 방문한 수 : ${cookieCount }
    <br>
    <br>

    <c:forEach items="${list}" var="guestbook">
        ${guestbook.id} ${status.index}<br>
        ${guestbook.name} ${status.index}<br>
        ${guestbook.content} ${status.index}<br>
        ${guestbook.regdate} ${status.index}<br>
        <c:if test="${sessionScope.isAdmin == 'true'}"><a href="delete?id=${guestbook.id}">삭제</a><br><br></c:if>
    </c:forEach>
    <br>

    <c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
        <a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
    </c:forEach>

    <br>
    <br>
    <form method="post" action="write">
        name : <input type="text" name="name"><br>
        <textarea name="content" cols="60" rows="6"></textarea>
        <br> <input type="submit" value="등록">
    </form>
</body>
</html>
