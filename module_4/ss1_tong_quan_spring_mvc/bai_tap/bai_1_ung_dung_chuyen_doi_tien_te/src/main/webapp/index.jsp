<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/22/2022
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<h2>Currency Converter</h2>
<form class="login" action="/convert" method="get">
  <label>Rate: </label><br/>
  <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
  <label>USD: </label><br/>
  <input type="text" name="usd" placeholder="USD" value="0"/><br/>
  <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>
