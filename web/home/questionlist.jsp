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
<body>
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div class="GeneralClass">
        <div class="QuestionsClass">
            <div class="UserQuestion">
                <c:out value="${question.getUser().getEmail()}"/><p>
            </div>
            <div class="Question">
                <c:out value="${question.getQuestion()}" escapeXml="false"/>
            </div>
            <div class="Tags">
                    <%--<c:out value="Tags: ${question.getTags()}"/><p>--%>
                <c:out value="Tags:"/>
                <c:forEach var="tag" items="${question.getTags()}" varStatus="pStatus">
                    <c:out value="${tag}"/>
                </c:forEach>
            </div>
        </div>
        <div class="AnswersClass">
            <c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">
                <div class="AnswerClass">
                    <div class="UserAnswer">
                        <c:out value="${answer.getUser().getEmail()}"/><p>
                    </div>
                    <div class="Answer">
                        <c:out value="${answer}" escapeXml="false"/><p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <%@include file="/secured/post/answer.jsp" %>
    </div>
</c:forEach>
</body>
</html>
