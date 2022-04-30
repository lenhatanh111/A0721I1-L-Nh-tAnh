--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Email</title>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" action="${pageContext.request.contextPath}/update" modelAttribute="mailbox">
  <table>

    <tr>
      <td>Languages</td>
      <td><form:select path="language" items="${languages}"></form:select></td>
    </tr>
    <tr>
      <td>Page Size</td>
       <td>show <form:select  items="${pageSizes}" path="page_size"></form:select> email per page</td>
    </tr>
    <tr>
      <td>Spams filter</td>
      <td>
        <form:radiobutton path="enable" value="true"></form:radiobutton>

      </td>
    </tr>
    <tr>
      <td>Signature</td>
      <td><form:textarea type="text"  path="signature"></form:textarea></td>
    </tr>
    <tr>
      <td><input type="submit" value="Update"></td>
    </tr>
  </table>
</form:form>

</body>
</html>