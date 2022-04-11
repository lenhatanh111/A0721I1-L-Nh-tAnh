<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2022
  Time: 8:27 PM
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
                        <a class="nav-link active" href="/contracts">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/contract_details">Contract Detail</a>
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
                <form method="post">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>
                                Edit Customer Service Is Using
                            </h2>
                        </caption>
                        <c:if test="${service != null}">
                            <input type="hidden" name="id" value="<c:out value='${service.service_id}' />"/>
                        </c:if>
                        <tr>
                            <td>Service Name</td>
                            <td>${service.service_name}</td>
                            <td>
                                <select name="service_id">
                                    <c:forEach items="${services}" var="service">
                                        <option value="${service.service_id}">${service.service_name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        <tr>
                            <th>Service Area:</th>
                            <td>
                                ${service.service_area}
                            </td>
                        </tr>
                        <tr>
                            <th>Service Cost:</th>
                            <td>
                                ${service.service_cost}

                            </td>
                        </tr>
                        <tr>
                            <th>Max People:</th>
                            <td>
                              ${service.service_max_people}
                            </td>
                        </tr>
                        <tr>
                            <th>Rent Type ID:</th>
                            <td>
                                ${service.rent_type_id}
                            </td>
                        </tr>
                        <tr>
                            <th>Type ID:</th>
                            <td>
                               ${service.service_type_id}
                            </td>
                        </tr>

                        <tr>
                            <th>Standard Room:</th>
                            <td>
                                ${service.standard_room}
                            </td>
                        </tr>
                        <tr>
                            <th>Description Other Convenience:</th>
                            <td>
                                ${service.description_other_convenience}
                            </td>
                        </tr>
                        <tr>
                            <th>Pool Area:</th>
                            <td>
                                ${service.pool_area}
                            </td>
                        </tr>
                        <tr>
                            <th>Number Of Floors:</th>
                            <td>
                               ${service.number_of_floors}
                            </td>
                        </tr>
                        <tr hidden>
                            <th >Customer ID:</th>
                            <td>
                                <input type="text" name="customer_id" size="45"
                                       value="${customer_id}"
                                />
                            </td>
                        </tr>
                        <tr hidden>
                            <th >S ID:</th>
                            <td>
                                <input type="text" name="old_service_id" size="45"
                                       value="${s_id}"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<footer >
    <p>&copy; 2020 Design by Nhat Anh.</p>
</footer>
</body>
</html>
