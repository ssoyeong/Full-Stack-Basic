<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginform</title>
</head>
<body>
    <h1>관리자 로그인</h1>
    <br><br>
    ${errorMessage}<br>

    <form method="post" action="login">
        암호: <input type="password" name="passwd"><br>
        <input type="submit">
    </form>
</body>
</html>
