<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 28/03/2014
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    <%@include file="../css/contextuallogin.css" %>
    <%@include file="../css/buttonStyle.css" %>
</style>
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

    <%@include file="../loginjsp/registerform.jsp" %>
    <%} else {%>
    Welcome <%=request.getRemoteUser()%>
    <%}%>
</form>
</html>