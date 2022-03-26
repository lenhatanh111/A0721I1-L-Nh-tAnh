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
    <title>update product</title>
</head>
<body>
<h1>Update product</h1>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table STYLE="border-collapse: collapse">

            <tr>
                <td>name: </td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>price: </td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
            </tr>
            <tr>
                <td>status: </td>
                <td><input type="text" name="status" id="status" value="${product.getStatus()}"></td>
            </tr>
            <tr>
                <td>producer: </td>
                <td><input type="text" name="producer" id="producer" value="${product.getProducer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product" style="background-color: blue"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
