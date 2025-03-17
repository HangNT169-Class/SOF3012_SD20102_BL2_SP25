<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 17/3/25
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Cate code:
<select>
    <c:forEach var="c" items="${listCate}">
        <option>${c.categoryCode}</option>
    </c:forEach>
</select>
<br/>
Table:
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>P.Code</th>
        <th>P.Name</th>
        <th>Price</th>
        <th>Cate code</th>
        <th>Cate name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${lists}" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${p.produtCode}</td>
            <td>${p.produtName}</td>
            <td>${p.pice}</td>
            <td>${p.cate1.categoryCode}</td>
            <td>${p.cate1.categoryName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
