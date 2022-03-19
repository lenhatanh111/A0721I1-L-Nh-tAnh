<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/3/2022
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body>
  <form method="post" action="/result" style="width: 400px;height: 100px ;padding: 50px">
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label" >Product Description</label>
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name=">Product Description">
    </div>
    <div class="mb-3">
      <label for="list_price" class="form-label">List Price</label>
      <input type="text" class="form-control" id="list_price" name="list_price">
    </div>
    <div class="mb-3">
      <label for="discount_percent" class="form-label">Discount Percent</label>
      <input type="text" class="form-control" id="discount_percent" name="discount_percent" >
    </div>
    <button type="submit" class="btn btn-primary">Calculate Discount</button>
  </form>
  </body>
</html>
