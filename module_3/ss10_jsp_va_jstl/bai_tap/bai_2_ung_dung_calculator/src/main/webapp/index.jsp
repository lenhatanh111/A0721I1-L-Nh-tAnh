<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body >
<div class="border border-secondary bg-info" style="width: 500px;height: 350px; margin: 20px;padding: 10px">
<h1>Simple Calculator</h1>
<form method="post" action="/calculator">
    <div class="mb-3">
        <label  class="form-label">First Operand</label>
        <input type="text" class="form-control" name="firstOperand" >

    </div>
    <div class="mb-3">
        <label  class="form-label">Operator</label>
       <select name="operator">
           <option value="+"> Addition </option>
           <option value="-">Subtraction</option>
           <option value="*">multiplication</option>
           <option value="/">division</option>
       </select>
    </div>
    <div class="mb-3">
        <label  class="form-label">Second Operand</label>
        <input type="text" class="form-control" name="secondOperand" >

    </div>
    <button type="submit" class="btn btn-warning">Calculate</button>
</form>
</div>
</body>
</html>