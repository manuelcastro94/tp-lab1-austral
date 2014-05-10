<%@ page import="org.studyroom.control.HibernateUtil" %>
<%@ page import="org.studyroom.control.dao.UserDAO" %>
<%@ page import="org.studyroom.model.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.entity.User: Federico
  Date: 29/03/2014
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/questionformStyle.css" media="screen"/>
<html>
<%
    User thisUser = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), request.getRemoteUser());
    pageContext.setAttribute("user", thisUser);
%>
<head>
    <a id="home" href="/studyroom/index.jsp">Home</a>
    <a id="filter">Filtering questions by tag = "${requestScope.tag}" </a>
</head>
<body id="mainQuestionBody">
<c:forEach var="questionByTag" items="${requestScope.questionsByTag}" varStatus="pStatus">
    <div class="GeneralClass">
        <c:set var="question" value="${questionByTag}" scope="request"/>
        <%@include file="template/question.jsp" %>
    </div>
</c:forEach>
</body>
</html>