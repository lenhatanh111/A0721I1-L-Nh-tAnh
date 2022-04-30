<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/4/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Declaration</title>
</head>
<body>
<table border="1">
    <a href="${pageContext.request.contextPath}/declaration/create">Create new Declaration</a>
    <tr>
        <th hidden>ID</th>
        <th> Name </th>
        <th> Birthday </th>
        <th> Gender </th>
        <th> Nationality </th>
        <th> ID Card </th>
        <th> Vehicle </th>
        <th> Vehicle ID</th>
        <th> Seats </th>
        <th> Start Date </th>
        <th> End Date </th>
        <th> Travel History </th>
        <th> Action </th>
    </tr>
<c:forEach items="${declarations}" var="declaration">
    <tr>
        <td hidden>${declaration.id}</td>
        <td >${declaration.name}</td>
        <td >${declaration.birthday}</td>
        <td >${declaration.gender ? "Nam":"Nu"}</td>
        <td >${declaration.nationality}</td>
        <td >${declaration.id_card}</td>
        <td >${declaration.vehicle}</td>
        <td >${declaration.vehicle_id}</td>
        <td >${declaration.seats}</td>
        <td >${declaration.start_day}/${declaration.start_month}/${declaration.start_year}</td>
        <td >${declaration.end_day}/${declaration.end_month}/${declaration.end_year}</td>
        <td >${declaration.travel_history}</td>
        <td>
        <a href="${pageContext.request.contextPath}/declaration/update?id=${declaration.id}">Update</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
