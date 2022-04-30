<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/4/2022
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tờ khai y tế</title>
</head>
<body>
<h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
<h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
    THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
<h5 style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử
    lý hình sự</h5>
<form:form action="/declaration/create" method="post" modelAttribute="declaration" >
    <table>
        <tr>
            <td>ID</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="id"></form:input>
            </td>
        </tr>
        <tr>
            <td>Họ tên (ghi chữ IN HOA)</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="name"></form:input>
            </td>
        </tr>
        <tr>
            <td>Năm sinh</td>
            <td>Giới tính</td>
            <td>Quốc tịch</td>
        </tr>
        <tr>
            <td><form:select path="birthday" items="${birthday}"></form:select></td>
            <td><form:select path="gender">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nu</form:option>
            </form:select></td>
            <td><form:select path="nationality" items="${nationality}"></form:select></td>
        </tr>
        <tr>
            <td colspan="2">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="id_card"></form:input>
            </td>
        </tr>
        <tr>
            <td>Thông tin đi lại</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2">
                <form:radiobutton path="vehicle" value="tau bay"></form:radiobutton>tau bay
                <form:radiobutton path="vehicle" value="thuyen"></form:radiobutton>thuyen
                <form:radiobutton path="vehicle" value="xe may"></form:radiobutton>xe may
                <form:radiobutton path="vehicle" value="tau lua"></form:radiobutton>tau lua
                <form:radiobutton path="vehicle" value="khac"></form:radiobutton>khac
            </td>
            <td></td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
            <td></td>
        </tr>
        <tr>
            <td><form:input path="vehicle_id"></form:input></td>
            <td><form:input path="seats"></form:input></td>
        </tr>
        <tr>
            <td>ngay khoi hanh</td>
            <td>thang khoi hanh</td>
            <td>nam khoi hanh</td>

            <td>ngay ket thuc</td>
            <td>thang ket thuc</td>
            <td>nam ket thuc</td>

        </tr>
        <tr>
            <td><form:select path="start_day" items="${start_day}"></form:select></td>
            <td><form:select path="start_month" items="${start_month}"></form:select></td>
            <td><form:select path="start_year" items="${start_year}"></form:select></td>

            <td><form:select path="end_day" items="${end_day}"></form:select></td>
            <td><form:select path="end_month" items="${end_month}"></form:select></td>
            <td><form:select path="end_year" items="${end_year}"></form:select></td>
        </tr>

        <tr>
            <td colspan="2">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="travel_history"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Gửi">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
