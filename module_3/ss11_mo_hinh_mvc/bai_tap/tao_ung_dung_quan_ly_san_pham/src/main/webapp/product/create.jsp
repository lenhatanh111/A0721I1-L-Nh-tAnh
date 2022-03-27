<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/3/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>creat new product</title>
</head>
<body>
<h1>Create new product</h1>
<p style="color: olivedrab">
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" style="width: 300px">
    <fieldset>
        <legend>Product information</legend>
        <table STYLE="border-collapse: collapse">
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>price: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>status: </td>
                <td><input type="text" name="status" id="status"></td>
            </tr>
            <tr>
                <td>producer: </td>
                <td><input type="text" name="producer" id="producer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product" style="background-color: blue"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
