<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.entity.User: Federico
  Date: 28/03/2014
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width = device - width, initial-escale = 1.0">
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/loginformStyle.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/buttonStyle.css" media="screen"/>
<html>
<form id="<%=Constants.LOGIN_FORM_ID%>" action="<%=response.encodeURL(Constants.LOGIN_FORM_ACTION)%>" method="POST">
    <%if (request.getRemoteUser() == null) {%>
    <%if (request.getQueryString() != null) {%>
    <div id="invalid">Invalid email and/or password</div>
    <%}%>

    Email:
    <input type="text"
           name="<%=Constants.LOGIN_USERNAME_FIELD%>"
           value="<%=Constants.VALID_USERNAME%>"
           class="form-control">
    Password:
    <input type="password"
           name="<%=Constants.LOGIN_PASSWORD_FIELD%>"
           value="<%=Constants.VALID_PASSWORD%>"
           class="form-control">
    <input type="Submit" value="<%=Constants.LOG_IN%>">
    <%} else {%>
    Welcome <%=request.getRemoteUser()%>

    <a href="<%=request.getContextPath()%>/logout">Log Out</a>
    <%}%>
</form>
<%if (request.getRemoteUser() == null) {%>
<form class="singinButoon" action="<%=response.encodeURL("/studyroom/register/registerpage.jsp")%>">
    <input type="Submit" value="<%=Constants.REGISTER%>">
    <%}%>
</form>
</html>
