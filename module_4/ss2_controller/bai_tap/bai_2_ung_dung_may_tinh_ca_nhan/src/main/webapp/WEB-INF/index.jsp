<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/4/2022
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="/calculator" method="get">
    <input type="text" name="parameters1" value="${parameters1}">
    <input type="text" name="parameters2" value="${parameters2}">
    <br><br>
    <input type="submit" name="calculation" value="add">
    <input type="submit" name="calculation" value="sub">
    <input type="submit" name="calculation" value="mul">
    <input type="submit" name="calculation" value="div">
  </form>
  </body>
</html>
