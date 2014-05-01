<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 30/04/2014
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%if (request.getRemoteUser() != null) {%>
<body>
<a href="secured/post/post.jsp"> Preguntar </a>
<%}%>
</body>
</html>
