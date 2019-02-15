<%--
  Created by IntelliJ IDEA.
  User: ljj
  Date: 2019/2/12
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success page！</title>
</head>
<body>
    <div>
        <input  value="12345" type="button"/>
        <br>
        成功跳转！！！
        <br>
        time:${requestScope.time }
        <br>
        names: ${requestScope.names}
        <br>

        RequestUser: ${requestScope.user}
        <br>
        SessionUser: ${sessionScope.user}
        <br>

        Request Sex: ${requestScope.sex}
        <br>
        Session Sex: ${sessionScope.sex}
    </div>


</body>
</html>
