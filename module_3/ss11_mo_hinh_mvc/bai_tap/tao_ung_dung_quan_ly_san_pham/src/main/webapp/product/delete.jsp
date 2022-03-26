<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/3/2022
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<form method="post">
    <h3>Are you sure?</h3>

    <fieldset>
        <legend>Product information</legend>
        <table style="border-collapse: collapse">
            <tr>
                <td>Name: </td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>Status: </td>
                <td>${product.getStatus()}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${product.getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product" style="background-color: blue"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>