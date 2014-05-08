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
        <div class="QuestionsClass">
            <div class="UserQuestion">
                <c:out value="${question.getUser().getEmail()}"/><p>
            </div>
            <c:if test="${question.getUser().equals(user)}">
                <div class="UserEdit">
                    <%@include file="/secured/post/edit.jsp" %>
                </div>
                <div class="QuestionControlPanelClass">
                    <div class="Check">
                        <%@include file="/secured/mark/close.jsp" %>
                    </div>
                </div>
            </c:if>
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
                        <div class="VoteUP">
                            <%@include file="/secured/vote/voteup.jsp" %>
                        </div>
                        <div class="VotesCount">
                            <c:out value="${answer.getDifference()}" escapeXml="false"/>
                        </div>
                        <div class="VoteDown">
                            <%@include file="/secured/vote/votedown.jsp" %>
                        </div>
                        <c:if test="${question.getUser().equals(user) && !answer.isMarked()}">
                            <div class="Check">
                                <%@include file="/secured/mark/mark.jsp" %>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
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
