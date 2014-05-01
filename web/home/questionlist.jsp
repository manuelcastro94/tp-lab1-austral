<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.entity.User: Federico
  Date: 29/03/2014
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--http://hmkcode.com/java-servlet-send-receive-json-using-jquery-ajax/--%>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div id="QuestionsDiv">
        <c:out value="User: ${question.getUser().getEmail()}"/><p>
            <c:out value="${question.getQuestion()}" escapeXml="false"/>
        <c:out value="Tags: ${question.getTags()}"/><p>
        <c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">

        <div id="AnswersDiv">
            <c:out value="By: ${answer.getUser().getEmail()}"/><p>
            <c:out value="${answer}" escapeXml="false"/><p>
        </div>
        </c:forEach>
        <%@include file="/secured/post/answer.jsp" %>
    </div>
</c:forEach>
</body>
</html>
