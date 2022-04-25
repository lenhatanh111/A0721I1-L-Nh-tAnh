<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/4/2022
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Sandwich Condiment</h2>
  <form action="/save" method="get">
   <input type="checkbox" name="condiment" value="Lettuce">Lettuce
   <input type="checkbox" name="condiment" value="Tomato">Tomato
   <input type="checkbox" name="condiment" value="Mustard">Mustard
   <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <button type="submit" value="save" >Save</button>
  </form>
  </body>
</html>
