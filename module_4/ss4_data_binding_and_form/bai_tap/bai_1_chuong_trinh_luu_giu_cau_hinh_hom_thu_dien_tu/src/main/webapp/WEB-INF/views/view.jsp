<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/4/2022
  Time: 4:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>list Email</h1>
<a href="/list">Create Setting</a>
<table border="1">
    <tr>

        <th>Languages</th>
        <th>Page Size</th>
        <th>Spams</th>
        <th>Signature</th>
    </tr>
    <c:forEach var="mailbox" items="${mailbox}">
        <tr>

            <td>${mailbox.language}</td>
            <td>${mailbox.page_size}</td>
            <td>${mailbox.enable}</td>
            <td>${mailbox.signature}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>