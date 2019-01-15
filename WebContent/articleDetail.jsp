<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/12/15
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArticleDetail</title>
    <script type="text/javascript" src="/static/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

</head>
<body>

    <div class="panel panel-default">

        <div class="panel-heading">
            <h3 class="panel-title">
                ${article.title}
            </h3>
        </div>

        <div class="info">
            <span class="name">${article.publisher}</span>
            <div class="meta">
                <span>${article.initTime}</span>
                <span>阅读 3689</span>
                <span>评论 222</span>
                <span>喜欢 111</span>
            </div>
        </div>

        <div class="panel-body">
            ${article.contentHtml}
        </div>
    </div>

    <div>
        <c:forEach var="comment" items="${comments}">
            <c:if test="${comment.parentId != 0}">
                ${comment.userName}  &nbsp;  to  &nbsp; ${comment.toUserName} : &nbsp; ${comment.commentText} <br>
            </c:if>
            <c:if test="${comment.parentId == 0}">
                ${comment.userName} : &nbsp;   &nbsp; ${comment.commentText} <br>
            </c:if>
        </c:forEach>

    </div>


</body>
</html>
