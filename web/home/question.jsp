<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 08/05/2014
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="QuestionsClass">
    <div class="UserQuestion">
        <c:out value="${question.getUser().getEmail()}"/><p>
    </div>
    <c:if test="${question.getUser().equals(user)}">
    <div class="UserEdit">
        <%@include file="/secured/post/edit.jsp" %>
    </div>
    <div class="QuestionControlPanelClass">
        <c:if test="${!question.isClosed()}">
            <div class="closed">
                <%@include file="/secured/mark/close.jsp" %>
            </div>
        </c:if>
    </div>
    </c:if>
    <div class="Question">
        <c:out value="${question.getQuestion()}" escapeXml="false"/>
    </div>
    <div class="Tags">
        <%--<c:out value="Tags: ${question.getTags()}"/><p>--%>
        <c:out value="Tags:"/>
        <c:forEach var="tag" items="${question.getTags()}" varStatus="pStatus">
            <%@include file="/home/tag.jsp" %>
        </c:forEach>
    </div>
</html>
