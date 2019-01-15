<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2019/1/12
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>查看评论</title>
</head>
<body>



   <%--<c:forEach var="comment" items="${comments}" >
        &lt;%&ndash;${comment.userName}
        ${comment.commentText}&ndash;%&gt;
        ${comment.id}
    </c:forEach>--%>

   <table border="1" align="center">
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>
                  ${comment.userName}
            </td>
            <td>
                    ${comment.parentId}
            </td>
            <td>
                ${comment.commentText}
            </td>

        </tr>
    </c:forEach>

   </table>


</body>
</html>
