<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ljj
  Date: 2019/2/17
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input Page</title>
</head>


<body>
<%--
    Why user form tag?
    1.可以快速的开发页面，而且可以更方便地进行表单回显
    2.注意：
        可以通过modelAttribute 属性指定绑定的模型属性，
        若没有指定改属性，则默认从request域对象中读取command的表单bean，
        若改属性也没有，则会出错。
--%>
<form:form action="${pageContext.request.contextPath}/emp" method="POST"  modelAttribute="employee">
    <%--path属性对应 html表单的name属性值--%>
    <c:if test="${ employee.id == null}">
        LastName:<form:input path="lastName"></form:input>
    </c:if>
    <%--ID设置为隐藏属性，隐藏域设置为PUT--%>
    <c:if test="${employee.id != null}">
        <form:hidden path="id"></form:hidden>
        <input type="hidden" name="_method" value="PUT">
    </c:if>

    <br>
    Email:<form:input path="email"></form:input>
    <br>
        <%
            Map<String,Object> genders = new HashMap();
            genders.put("1","Male");
            genders.put("0","Female");

            request.setAttribute("genders",genders);
        %>
    Gender:<br>
    <form:radiobuttons path="gender" items="${genders}" delimiter="<br>"></form:radiobuttons>
    <br>
    Department:<form:select path="department.id"
                            items="${departments}" itemLabel="departmentName"  itemValue="id">

    </form:select>
    <br>
    <%--
        1. 数据类型转换
        2. 数据类型格式化
        3. 数据校验
            1）如何校验？注解？
                ①使用JSR 303验证标准
                ②使用hibernate validator验证框架
                ③在SpringMVC配置文件中添加<mvc:annotation-driven/>注解
                ④ 需要在bean的属性上添加对应注解
                ⑤在目标方法bean类型的前面添加@Valid注解
            2）验证出错转向一个页面？
            3）错误消息？如何显示，如何把错误信息国际化
    --%>
    Birth:<form:input path="birth"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
