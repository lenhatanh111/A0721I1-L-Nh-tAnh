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
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styles.css">
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
                        <a class="nav-link active">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active">Contract Detail</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <form class="d-flex" method="post" action="/customers?action=search">
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
    <div class="left col-m-2">
        <ul>
            <li>
                <h2>
                    <a href="/customers?action=add">Add New Customer</a>
                </h2>
            </li>
            <li>

            </li>
            <li>

            </li>
        </ul>
    </div>
    <div class="col-m-10 contain">
        <div class="row" style="margin: 20px 10px 20px">
            <div align="center">
                <h2 style="color: green">
                    <c:if test="${message !=null}">
                        <p>${message}</p>
                    </c:if>
                </h2>
                <table border="1" cellpadding="5">
                    <caption><h2>List of Customers</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>ID Card</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Type ID</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="employee" items="${customers}">
                        <tr>
                            <td><c:out value="${employee.customer_id}"/></td>
                            <td><c:out value="${employee.customer_name}"/></td>
                            <td><c:out value="${employee.customer_birthday}"/></td>
                            <td><c:out value="${employee.customer_gender}"/></td>
                            <td><c:out value="${employee.customer_id_card}"/></td>
                            <td><c:out value="${employee.customer_phone}"/></td>
                            <td><c:out value="${employee.customer_email}"/></td>
                            <td><c:out value="${employee.customer_address}"/></td>
                            <td><c:out value="${employee.customer_type_id}"/></td>
                            <td>
                                <a href="/customers?action=edit&id=${employee.customer_id}">Edit</a>
                                <button onclick="infoDelete('${employee.customer_id}','${employee.customer_name}')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
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
            <form action="/customers?action=delete" method="post">
                <div class="modal-body">
                    <span>Do you want to delete customer? </span><span id="customerName"></span>
                    <input type="text" id="customerID" name="id" hidden>
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
        document.getElementById("customerName").innerText=name;
        document.getElementById("customerID").value=id;
    }
</script>
</body>
</html>
