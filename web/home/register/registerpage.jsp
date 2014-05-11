<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 09/04/2014
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<meta name="viewport" content="width = device - width, initial-escale = 1.0">
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="../../resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../resources/css/registerStyle.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    pageContext.setAttribute("taken", request.getQueryString() != null);
    pageContext.setAttribute("formId", Constants.REGISTER_FORM_ID);
    pageContext.setAttribute("userField", Constants.REGISTER_USERNAME_FIELD);
    pageContext.setAttribute("passwordField", Constants.REGISTER_PASSWORD_FIELD);
    pageContext.setAttribute("register", Constants.REGISTER);
%>
<head>
    <title>Register</title>
</head>
<body>
<div class="jumbotron loginbox">
    <form id="<%=Constants.REGISTER_FORM_ID%>" action="/studyroom/register" method="POST">
        <label>Welcome To StudyRoom!</label>
        <Br>
        <Br>
        <label>Username/Email:</label>
        <c:if test="${taken}">
            <div>user already taken</div>
        </c:if>
        <input type="text"
               name="${userField}"
               class="form-control">
        <br>
        <label>Password:</label>
        <input type="password"
               name="${passwordField}"
               class="form-control">
        <br>
        <input type="Submit" class="btn btn-success" value="${register}">
    </form>
</div>
</body>
</html>
