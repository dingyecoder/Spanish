<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/12/24
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>文章列表</title>
</head>
<body>


    <table border="1" align="center">
        <tr>
            <td>标题</td>
            <td>创建时间</td>
            <td>发表人</td>
            <td>最后一次修改时间</td>
            <td>文章内容</td>
        </tr>
        <c:forEach var="article" items="${articles}">
            <tr>
                <td>
                        ${article.title}
                </td>
                <td>
                        ${article.initTime}
                </td>
                <td>
                        ${article.publisher}
                </td>
                <td>
                        ${article.lastModifyTime}
                </td>
                <td>
                        ${article.contentHtml}
                </td>

            </tr>
        </c:forEach>

    </table>





</body>
</html>
