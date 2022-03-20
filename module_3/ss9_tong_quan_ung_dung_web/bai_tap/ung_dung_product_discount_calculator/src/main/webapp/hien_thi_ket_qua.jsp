<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/3/2022
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form  style="width: 400px;height: 100px ;padding: 50px">

    <div class="mb-3">
        <label for="list_price" class="form-label">List Price</label>
        <input type="text" class="form-control" id="list_price" name="list_price" value="${gia}">
    </div>
    <div class="mb-3">
        <label for="discount_percent" class="form-label">Discount Percent</label>
        <input type="text" class="form-control" id="discount_percent" name="discount_percent" value="${chiet_khau}" >
    </div>
    <div class="mb-3">
        <label for="Discount Amount" class="form-label">Discount Amount</label>
        <input type="text" class="form-control" id="Discount Amount" name="discount_amount" value="${ket_qua}" >
    </div>

</form>
</body>
</html>
