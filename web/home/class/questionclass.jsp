<%@ page import="org.studyroom.control.PostChecker" %>
<%@ page import="org.studyroom.model.entity.Question" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 09/05/2014
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String question = ((Question) request.getAttribute("question")).getQuestion();
    pageContext.setAttribute("str", PostChecker.decode(question));
%>
<link rel="stylesheet" type="text/css" href="css/questionformStyle.css" media="screen"/>
<html>
<c:if test="${question.isClosed()}">
    <div class="ClosedQuestion">
    </div>
</c:if>
<div class="UserQuestion">
    <c:set var="question" value="${requestScope.question}" scope="request"/>
    <a href="/studyroom/home/userprofile.jsp?u=${question.getUser().getEmail()}"> <c:out
            value="${question.getUser().getEmail()}"/></a>
</div>
<div class="Title">
    <c:out value="${question.getTitle()}" escapeXml="false"/>
</div>
<div class="Question">
    <c:out value="${str}" escapeXml="false"/>
</div>
<div class="Tags">
    <%--<c:out value="Tags: ${question.getTags()}"/><p>--%>
    <c:out value="Tags:"/>
    <c:forEach var="tag" items="${question.getTags()}" varStatus="pStatus">
        <a href="/studyroom/filterByTag?byTag&t=${tag.getId()}"> <c:out value="${tag}"/></a>
    </c:forEach>
</div>
</html>
