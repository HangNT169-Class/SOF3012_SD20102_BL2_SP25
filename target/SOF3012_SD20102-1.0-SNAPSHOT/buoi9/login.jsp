<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 28/3/25
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>dang nhap</h1>
<p>${error}</p>
<form action="/login" method="post">
    Ten Tai Khoan: <input type="text" name="uname">
    Mat Khau: <input type="text" name="p1">
    <button type="submit">Submit</button>
</form>
</body>
</html>
