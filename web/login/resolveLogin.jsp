<%@ page import="model.user.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 20/03/2014
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resolving...</title>
</head>
<body>
<%
    User user = new User(request.getParameter(model.Constants.USER_EMAIL), request.getParameter(model.Constants.USER_PASSWORD));
    if (User.valid(user)) {
        response.sendRedirect("securePage.jsp");
    } else {
        response.sendRedirect("forbiddenPage.jsp");
    }
%>
</body>
</html>
