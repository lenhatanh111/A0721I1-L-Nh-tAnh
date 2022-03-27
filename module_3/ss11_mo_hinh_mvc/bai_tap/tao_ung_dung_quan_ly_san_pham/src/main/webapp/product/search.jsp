<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/3/2022
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>search product by name</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h3 style="color: red">
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</h3>
<form class="d-flex" method="post">
    <input class="form-control " type="text" placeholder="Search By Name" name="productName" style="width: 400px ">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
</body>
</html>
