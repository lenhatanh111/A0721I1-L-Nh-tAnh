<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/4/2022
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2022
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/3/2022
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="DataTables-1.11.5/css/dataTables.bootstrap4.min.css">
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <script src="DataTables-1.11.5/js/jquery.dataTables.min.js"></script>
    <script src="DataTables-1.11.5/js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styles.css">
    <script>
        $(document).ready(function () {
            $('#tableEmployee').dataTable({
                "dom":'lrtip',
                "lengthChange": false,
                "pageLength": 5
            })

        })
    </script>
</head>
<body>
<div class="row head">
    <ul>
        <li><img class="img-rounded"
                 src="https://scontent.fdad2-1.fna.fbcdn.net/v/t1.6435-9/166094091_1443315519337010_2031018493667448292_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=sA9Bfl-hDPoAX_NOo81&_nc_ht=scontent.fdad2-1.fna&oh=00_AT836G5unCILnnF6ISzXk1QBfTPS_iVEMSsZEjDNqbH0Dg&oe=626AA7C0"
                 height="100%" width="40px"/></li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp;
        </li>
        <li> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        </li>
        <li class="pull-right">Lê Nhật Anh</li>
    </ul>


</div>
<div class="row ">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/employees">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/customers">Customer</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/services">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/contracts">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/contract_details">Contract Detail</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <form class="d-flex" method="post" action="/employees?action=search">
                            <input class="form-control me-2" type="search" placeholder="Search By Name" aria-label="Search" name="name">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</div>
<div class="row height-full">
    <div class="left col-m-1">
        <ul>
            <li>
                <h3>
                    <a href="/employees?action=add">Add New Employee</a>
                </h3>
            </li>
            <li>

            </li>
            <li>

            </li>
        </ul>
    </div>
    <div class="col-m-11 contain">
        <div class="row" style="margin: 20px 10px 20px">
            <div align="center">
                <h2 style="color: green">
                    <c:if test="${message !=null}">
                        <p>${message}</p>
                    </c:if>
                </h2>
                <table border="1" cellpadding="5" id="tableEmployee"  class="table table-striped table-bordered" >
                    <caption><h2>List of Employees</h2></caption>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>ID Card</th>
                        <th>Salary</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Position ID</th>
                        <th>Education Degree ID</th>
                        <th>Division ID</th>
                        <th>UserName</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${employees}">
                        <tr>
                            <td><c:out value="${customer.employee_id}"/></td>
                            <td><c:out value="${customer.employee_name}"/></td>
                            <td><c:out value="${customer.employee_birthday}"/></td>
                            <td><c:out value="${customer.employee_id_card}"/></td>
                            <td><c:out value="${customer.employee_salary}"/></td>
                            <td><c:out value="${customer.employee_phone}"/></td>
                            <td><c:out value="${customer.employee_email}"/></td>
                            <td><c:out value="${customer.employee_address}"/></td>
                            <td><c:out value="${customer.position_id}"/></td>
                            <td><c:out value="${customer.education_degree_id}"/></td>
                            <td><c:out value="${customer.division_id}"/></td>
                            <td><c:out value="${customer.username}"/></td>
                            <td>
                                <a href="/employees?action=edit&id=${customer.employee_id}">Edit</a>
                                <button onclick="infoDelete('${customer.employee_id}','${customer.employee_name}')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<footer >
    <p>&copy; 2020 Design by Nhat Anh.</p>
</footer>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/employees?action=delete" method="post">
                <div class="modal-body">
                    <span>Do you want to delete employee? </span><span id="employeeName"></span>
                    <input type="text" id="employeeID" name="id" hidden>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function infoDelete(id,name) {
        document.getElementById("employeeName").innerText=name;
        document.getElementById("employeeID").value=id;
    }
</script>
</body>
</html>
