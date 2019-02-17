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
<form:form action="/emp" method="POST"  modelAttribute="employee">
    <%--path属性对应 html表单的name属性值--%>
    LastName:<form:input path="lastName"></form:input>
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
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
