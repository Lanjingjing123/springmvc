<%--
  Created by IntelliJ IDEA.
  User: ljj
  Date: 2019/2/17
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
</head>
<body>
    <c:if test="${empty requestScope.employees }"> 没有任何员工信息</c:if>
    <c:if test="${!empty requestScope.employees }">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>ID</td>
                <td>LastName</td>
                <td>Email</td>
                <td>Department</td>
                <td>Department Name</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender=="0"?'Female':'Male'}</td>
                    <td>${emp.department.departmentName }</td>
                    <td><a href="">Edit</a> </td>
                    <td><a href="">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="/emp">Input Page</a>
</body>
</html>
