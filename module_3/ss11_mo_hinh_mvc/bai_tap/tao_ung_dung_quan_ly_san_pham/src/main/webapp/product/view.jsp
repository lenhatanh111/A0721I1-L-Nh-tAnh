<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/3/2022
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>view product</title>
</head>
<body>
<h1>view product</h1>

<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" style="width: 200px">
    <fieldset>
        <legend>Product information</legend>
        <table STYLE="border-collapse: collapse">

            <tr>
                <td>name: </td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>price: </td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>status: </td>
                <td>${product.getStatus()}</td>
            </tr>
            <tr>
                <td>producer: </td>
                <td>${product.getProducer()}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
