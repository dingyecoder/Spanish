<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/12/27
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/servletUser" method="post">
        <input type="hidden" name="method" value="addUser"><br>
        请输入用户名：<input type="text" name="username"><br>
        请输入密码：<input type="password" name="password"><br>
        确认密码：<input type="password" name="repassword"><br>
        请输入手机号码：<input type="text" name="phone"><br>
        请输入邮箱：<input type="text" name="mail"><br>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
    </form>

</body>
</html>
