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
    <%--
        SpringMVC 处理静态资源：
        1. 为什么会有这样的问题
        优雅的REST风格的资源URL 不希望带 .html 或 .do等后缀
        若将DispatcherServlet 请求配置为 /.
        则SpringMVC 将捕获WEB容器的所有请求，包括静态资源的请求，SpringMVC会将他们当成一个普通请求处理，
        因找不到对应处理器导致报 404
        2. 解决：
            在springmvc.xml配置 <mvc:default-servlet-handler>和<mvc:annotation-driven></mvc:annotation-driven>
    --%>
    <script type="text/javascript" src="scripts/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            alert("hello jQuery!");
            $(".delete").click(function(){
                // 获取超链接
               var href = $(this).attr("href");
               // 设置表单元素，提交
               $("form").attr("action",href).submit();
               return false;
            });
        })


    </script>
</head>
<body>

    <form action="" method="POST">
        <input type="hidden" name="_method" value="DELETE">
    </form>
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
                    <td><a href="/emp/${emp.id}">Edit</a> </td>
                    <td><a  class="delete" href="/emp/${emp.id}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="/emp">Input Page</a>
</body>
</html>
