<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 09/04/2014
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register to StudyRoom</title>
</head>
<body>
<form id="<%=Constants.REGISTER_FORM_ID%>" action="/studyroom/register" method="POST">
    <input type="Submit" value="<%=Constants.REGISTER%>">
</form>
</body>
</html>
