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
    <title>Register</title>
    <meta name = "viewport" content = "width = device - width, initial-escale = 1.0">
    <meta http-equiv = "content-type" content = "text/html; charset=UTF-8"/>
    <link rel="stylesheet" type = "text/css" href="../bootstrap/css/bootstrap.css">
    <link rel = "stylesheet" type = "text/css" href = ../css/registerStyle.css >
</head>
<body>
    <div class = "jumbotron loginbox">
        <form id = "<%=Constants.REGISTER_FORM_ID%>" action = "/studyroom/register" method = "POST">
            <label>Welcome To StudyRoom!</label>
            <Br>
            <Br>
            <label>Username/Email:</label>
            <%if (request.getQueryString() != null) {%>
            <div>user already exists</div>
            <%}%>
            <input type="text"
            name="<%=Constants.REGISTER_USERNAME_FIELD%>"
            value="<%=Constants.VALID_USERNAME%>"
            class="form-control">
            <br>
            <label>Password:</label>
            <input type="password"
            name="<%=Constants.REGISTER_PASSWORD_FIELD%>"
            value="<%=Constants.VALID_USERNAME%>"
            class="form-control">
            <br>
            <input type="Submit" class = "btn btn-success" value="<%=Constants.REGISTER%>">
        </form>
    </div>

</body>
<%--<head>--%>
    <%--<title>Register to StudyRoom</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form id="<%=Constants.REGISTER_FORM_ID%>" action="/studyroom/register" method="POST">--%>
    <%--<%if (request.getQueryString() != null) {%>--%>
    <%--<div>user already exists</div>--%>
    <%--<%}%>--%>
    <%--Email:--%>
    <%--<input type="text"--%>
           <%--name="<%=Constants.REGISTER_USERNAME_FIELD%>"--%>
           <%--value="<%=Constants.VALID_USERNAME%>">--%>
    <%--Password:--%>
    <%--<input type="password"--%>
           <%--name="<%=Constants.REGISTER_PASSWORD_FIELD%>"--%>
           <%--value="<%=Constants.VALID_USERNAME%>">--%>
    <%--<input type="Submit" value="<%=Constants.REGISTER%>">--%>
<%--</form>--%>
<%--</body>--%>
</html>
