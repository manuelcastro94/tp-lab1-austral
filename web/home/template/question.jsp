<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 08/05/2014
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/questionformStyle.css" media="screen"/>
<%
    pageContext.setAttribute("logged", request.getRemoteUser() != null);
    pageContext.setAttribute("filterByTag", request.getQueryString() != null && request.getQueryString().contains("byTag"));
    pageContext.setAttribute("filterByGoTo", request.getQueryString() != null && request.getQueryString().contains("goto"));
%>
<html>
<c:set var="question" value="${requestScope.question}" scope="request"/>
<div class="QuestionBody" style="width: 650px">
    <div class="Shadow">sdff</div>
    <div class="QuestionsClass">
        <div class="QuestionControlPanelClass">
            <c:if test="${!filterByGoTo}">
                <div class="GoToClass">
                    <a href="/studyroom/goTo?goto&q=${question.getId()}"><img src="/studyroom/images/goto.ico"
                                                                              width="20" height="20"></a>
                </div>
            </c:if>
            <c:if test="${question.getUser().equals(user)}">
                <div class="EditButton">
                    <a href="secured/post/post.jsp?edit&q=${question.getId()}"><img src="/studyroom/images/edit.ico"
                                                                                    width="20" height="20"></a>
                </div>
                <c:if test="${!question.isClosed()}">
                    <div class="closed">
                        <a href="/studyroom/close?q=${question.getId()}"><img src="/studyroom/images/close.ico"
                                                                              width="20" height="20"></a>
                    </div>
                </c:if>
            </c:if>
        </div>
        <%@include file="../class/questionclass.jsp" %>
        <c:if test="${!filterByGoTo}">
            <div class="AnswersNum">
                <c:out value="Answers: "/>
                <c:out value="${question.getAnswers().size()}" escapeXml="false"/>
            </div>
        </c:if>
    </div>
    <c:if test="${!filterByTag && filterByGoTo}">
        <div class="AnswersClass">
            <c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">
                <div class="AnswerClass">
                    <c:set var="logged" value="${logged}" scope="request"/>
                    <c:set var="answer" value="${answer}" scope="request"/>
                    <%@include file="../class/answerclass.jsp" %>
                </div>
            </c:forEach>
        </div>
        <c:if test="${!question.isClosed()}">
            <div class="AnswerClassNode">
                <%@include file="/secured/post/answer.jsp" %>
            </div>
        </c:if>
    </c:if>
</div>
</html>
