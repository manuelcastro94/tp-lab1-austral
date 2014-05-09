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
<%--http://hmkcode.com/java-servlet-send-receive-json-using-jquery-ajax/--%>
<html>
<head>
    <title></title>
</head>
<%
    User thisUser = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), request.getRemoteUser());
    pageContext.setAttribute("user", thisUser);
%>
<body id="mainQuestionBody">
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div class="GeneralClass">
        <%@include file="question.jsp" %>
    </div>
    <div class="AnswersClass">
        <%@include file="answer.jsp" %>
    </div>
    <c:if test="${!question.isClosed()}">
        <div class="AnswerClassNode">
            <%@include file="/secured/post/answer.jsp" %>
        </div>
    </c:if>
    </div>
</c:forEach>
</body>
</html>
