<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/3/2022
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>search by country</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>User Management</h1>
<h2>
    <a href="users?action=users">List All Users</a>
</h2>
<form class="d-flex" method="post" >
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="country" style="width: 300px">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
</body>
</html>
