<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.entitieses.User: Federico
  Date: 28/03/2014
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width = device - width, initial-escale = 1.0">
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/loginformStyle.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="resources/css/buttonStyle.css" media="screen"/>
<html>
<%
    pageContext.setAttribute("formId", Constants.LOGIN_FORM_ID);
    pageContext.setAttribute("noUser", request.getRemoteUser() == null);
    pageContext.setAttribute("userField", Constants.LOGIN_USERNAME_FIELD);
    pageContext.setAttribute("passwordField", Constants.LOGIN_PASSWORD_FIELD);
    pageContext.setAttribute("invalidUser", request.getQueryString() != null && request.getQueryString().contains("loginError"));
    pageContext.setAttribute("register", Constants.REGISTER);
    pageContext.setAttribute("action", response.encodeURL(Constants.LOGIN_FORM_ACTION));
%>
<form id="${formId}" action="${action}" method="POST">
    <c:if test="${noUser}">
        <c:if test="${invalidUser}">
            <div id="invalid">Invalid email and/or password</div>
        </c:if>

        <label>
            Email:
            <input type="text"
                   name="${userField}"
                   class="form-control">
        </label>
        <label>
            Password:
            <input type="password"
                   name="<%=Constants.LOGIN_PASSWORD_FIELD%>"
                   class="form-control">
        </label>
        <input type="Submit" value="<%=Constants.LOG_IN%>">
    </c:if>
    <c:if test="${!noUser}">
        Welcome <%=request.getRemoteUser()%>
        <a href="<%=request.getContextPath()%>/logout">Log Out</a>
    </c:if>
</form>
<c:if test="${noUser}">
    <form class="singinButoon" action="<%=response.encodeURL("home/register/registerpage.jsp")%>">
        <input type="Submit" value="<%=Constants.REGISTER%>">
    </form>
</c:if>
</html>


