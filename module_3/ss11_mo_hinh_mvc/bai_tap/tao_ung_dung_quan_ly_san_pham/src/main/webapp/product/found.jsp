<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/3/2022
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Found</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>

<table class="table table-striped">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>price</td>
        <td>Status</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>

    </tr>
    <c:forEach items='${productList}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getStatus()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
