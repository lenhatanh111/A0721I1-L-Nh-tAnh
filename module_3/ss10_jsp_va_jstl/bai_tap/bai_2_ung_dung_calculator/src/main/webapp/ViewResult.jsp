<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/3/2022
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <style>
        span{
            font-weight: bold;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body >
<div class="border border-secondary bg-info" style="width: 500px;height: 350px; margin: 20px;padding: 10px">
<h1>Simple Calculator</h1>
<form >
    <div class="mb-3">
        <label  class="form-label">First Operand :</label>
       <span >${firstOperand}</span>

    </div>
    <div class="mb-3">
        <label  class="form-label">Operator :</label>
        <span >${Operator}</span>

    </div>

    <div class="mb-3">
        <label  class="form-label">Second Operand :</label>
       <span>${secondOperand}</span>

    </div>
    <div class="mb-3">
        <label  class="form-label">Result :</label>
        <span>${Result}</span>

    </div>
</form>
</div>
</body>
</html>
