<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.user.User: Federico
  Date: 29/03/2014
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="/secured/question/postquestion.jsp" %>
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div id="QuestionsDiv">
        <c:out value="User: ${question.getUser().getEmail()}"/><p>
        <c:out value="Question: ${question.getQuestion()}"/><p>
            <%--<c:out value="Answers: ${question.getAnswers()}"/><p>--%>
        <c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">

        <div id="AnswersDiv">
            <c:out value="--Answers start--"/><p>
            <c:out value="By: ${answer.getUser().getEmail()}"/><p>
            <c:out value="Answer: ${answer}"/><p>
            <c:out value="--Answers end--"/><p>
        </div>
        </c:forEach>
            <%--<c:out value="question[${pStatus.index}].getUser"/><p>--%>
            <%--<form:input path="Question[${pStatus.index}].getUser" />--%>
        <%@include file="/secured/answer/postanswer.jsp" %>
    </div>
</c:forEach>
</body>
</html>
