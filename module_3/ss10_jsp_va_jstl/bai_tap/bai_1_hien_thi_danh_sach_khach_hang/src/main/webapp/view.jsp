<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/3/2022
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        img{
            width: 40px;
            height: 30px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead class="table-dark">
    <td> STT</td>
    <td> Name</td>
    <td> Birthday</td>
    <td> Address</td>
    <td> Image </td>
    </thead>
    <tbody>
    <c:forEach items="${list_customer}" var="customer" varStatus="item">
        <tr>
            <td>${item.count}</td>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.img}"></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
