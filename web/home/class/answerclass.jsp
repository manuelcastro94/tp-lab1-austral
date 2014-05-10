<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 09/05/2014
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/questionformStyle.css" media="screen"/>
<html>
<div class="ShadowAnswer">sdff</div>
<c:set var="answer" value="${requestScope.answer}" scope="request"/>
<c:if test="${answer.isMarked()}">
    <div class="Marked">
    </div>
</c:if>
<div class="UserAnswer">
    <c:out value="${answer.getUser().getEmail()}"/><p>
</div>
<div class="Answer">
    <c:out value="${answer}" escapeXml="false"/><p>
</div>
<div class="AnswerControlPanelClass">
    <c:if test="${!answer.hasVoted(user)}">
        <div class="VoteUP">
            <a href="/studyroom/up?a=${answer.getId()}"><img src="/studyroom/images/up.ico" width="20" height="20"></a>
        </div>
    </c:if>
    <div class="VotesCount">
        <c:out value="${answer.getDifference()}" escapeXml="false"/>
    </div>
    <c:if test="${!answer.hasVoted(user)}">
        <div class="VoteDown">
            <a href="/studyroom/down?a=${answer.getId()}"><img src="/studyroom/images/down.ico" width="20" height="20"></a>
        </div>
    </c:if>
    <c:if test="${question.getUser().equals(user) && !answer.isMarked()}">
        <div class="Check">
            <a href="/studyroom/mark?a=${answer.getId()}"> <img src="/studyroom/images/mark.ico" width="20" height="20">
            </a>
        </div>
    </c:if>
</div>
</html>