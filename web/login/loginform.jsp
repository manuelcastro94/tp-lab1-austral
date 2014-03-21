<%@ page import="model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 20/03/2014
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="<%=Constants.HOME_FORM_ID%>"
      action="<%=response.encodeURL("securepage.jsp")%>" method="POST">
    e-mail: <input type="text" name="<%=Constants.USER_EMAIL%>">
    Password: <input type="password" name="<%=Constants.USER_PASSWORD%>">
    <input type="submit" value="Log in">
</form>
</body>
</html>
