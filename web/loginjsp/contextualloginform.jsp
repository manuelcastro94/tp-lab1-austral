<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.user.User: Federico
  Date: 28/03/2014
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/contextuallogin.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/buttonStyle.css" media="screen"/>
<html>
<form id="<%=Constants.LOGIN_FORM_ID%>" action="<%=response.encodeURL(Constants.LOGIN_FORM_ACTION)%>" method="POST">
    <%if (request.getRemoteUser() == null) {%>
    Email:
    <input type="text"
           name="<%=Constants.LOGIN_USERNAME_FIELD%>"
           value="<%=Constants.VALID_USERNAME%>"
            >
    Password:
    <input type="password"
           name="<%=Constants.LOGIN_PASSWORD_FIELD%>"
           value="<%=Constants.VALID_PASSWORD%>"
            >
    <input type="Submit" value="<%=Constants.LOG_IN%>">
    <%} else {%>
    Welcome <%=request.getRemoteUser()%>
    <%}%>
</form>
<form class="singinButoon" action="<%=response.encodeURL("/studyroom/register/registerpage.jsp")%>">
    <input type="Submit" value="<%=Constants.REGISTER%>">
</form>
</html>
