<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 07/05/2014
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%if (request.getRemoteUser() != null) {%>
<body>
<div class="EditButton">
    <a href="secured/post/post.jsp?edit&q=${question.getId()}"> Edit </a>
</div>
</body>
<%}%>
</html>
