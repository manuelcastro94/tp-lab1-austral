<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 08/05/2014
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">
    <div class="AnswerClass">
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
                    <%@include file="/secured/vote/voteup.jsp" %>
                </div>
            </c:if>
            <div class="VotesCount">
                <c:out value="${answer.getDifference()}" escapeXml="false"/>
            </div>
            <c:if test="${!answer.hasVoted(user)}">
                <div class="VoteDown">
                    <%@include file="/secured/vote/votedown.jsp" %>
                </div>
            </c:if>
            <c:if test="${question.getUser().equals(user) && !answer.isMarked()}">
                <div class="Check">
                    <%@include file="/secured/mark/mark.jsp" %>
                </div>
            </c:if>
        </div>
    </div>
</c:forEach>
</html>
