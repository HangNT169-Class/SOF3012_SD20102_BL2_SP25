<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="">
      Tên: <input name="ten" />
      <button type="submit">Search</button>
    </form>
    <br />
    <button><a href="/category/view-add">Add Cate</a></button>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Cate Code</th>
          <th>Cate name</th>
          <th colspan="2">Action</th>
        </tr>
      </thead>
      <tbody>
<%--      for(SinhVien sv: listSinhVien){--%>
<%--      }--%>
<%--      Items: la mang, var--%>
      <c:forEach items="${listCate1}" var="sv">
        <tr>
          <td>${sv.id}</td>
          <td>${sv.categoryCode}</td>
          <td>${sv.categoryName}</td>
          <td>
            <a href="/category/delete?a1=${sv.id}">Delete</a>
            <a href="/category/view-update?id=${sv.id}">Update</a>
            <a href="/category/detail?a=${sv.id}">Detail</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </body>
</html>
