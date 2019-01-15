<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/1/15
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看评论</title>
</head>
<body>


    <br>

    <c:forEach var="comment" items="${comments}">

        ${comment.userName} &nbsp;  to  &nbsp; ${comment.toUserName} &nbsp; ${comment.commentText}<br>
    </c:forEach>

</body>
</html>
