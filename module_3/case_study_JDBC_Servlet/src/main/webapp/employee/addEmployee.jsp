<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/4/2022
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/4/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
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
                        <a class="nav-link active">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active">Contract Detail</a>
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
    <div class="left col-m-2">
        <ul>
            <li>
                <h2>
                    <a href="/employees?action=add">Add New Employee</a>
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
                <form method="post">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>
                                Add Neww Employee
                            </h2>
                        </caption>
                        <tr>
                            <th>Employee Name:</th>
                            <td>
                                <input type="text" name="name" size="45"
                                       value="<c:out value='${employee.employee_name}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>employee Birthday:</th>
                            <td>
                                <input type="text" name="birthday" size="45"
                                       value="<c:out value='${employee.employee_birthday}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee id card:</th>
                            <td>
                                <input type="text" name="id_card" size="45"
                                       value="<c:out value='${employee.employee_id_card}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Salary:</th>
                            <td>
                                <input type="text" name="salary" size="45"
                                       value="<c:out value='${employee.employee_salary}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Phone:</th>
                            <td>
                                <input type="text" name="phone" size="45"
                                       value="<c:out value='${employee.employee_phone}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Email:</th>
                            <td>
                                <input type="text" name="email" size="45"
                                       value="<c:out value='${employee.employee_email}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Address:</th>
                            <td>
                                <input type="text" name="address" size="45"
                                       value="<c:out value='${employee.employee_address}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Position ID:</th>
                            <td>
                                <input type="text" name="position_id" size="15"
                                       value="<c:out value='${employee.position_id}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Education Degree ID:</th>
                            <td>
                                <input type="text" name="education_degree_id" size="15"
                                       value="<c:out value='${employee.education_degree_id}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Division ID:</th>
                            <td>
                                <input type="text" name="division_id" size="15"
                                       value="<c:out value='${employee.division_id}' />"
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

