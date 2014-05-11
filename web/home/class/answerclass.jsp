<%@ page import="org.studyroom.control.dao.UserDAO" %>
<%@ page import="org.studyroom.control.utilities.Converter" %>
<%@ page import="org.studyroom.control.utilities.HibernateUtil" %>
<%@ page import="org.studyroom.model.entities.Answer" %>
<%@ page import="org.studyroom.model.entities.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 09/05/2014
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="resources/css/questionformStyle.css" media="screen"/>
<html>
<%
    String answer = ((Answer) request.getAttribute("answer")).getAnswer();
    pageContext.setAttribute("str", Converter.decode(answer));
    User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), request.getRemoteUser());
    request.setAttribute("user", user);
    request.setAttribute("diffUser", !(((Answer) request.getAttribute("answer")).getUser()).equals(user));
%>
<div class="ShadowAnswer">sdff</div>
<c:set var="answer" value="${requestScope.answer}" scope="request"/>
<c:if test="${answer.isMarked()}">
    <div class="Marked">
    </div>
</c:if>
<div class="UserAnswer">
    <a href="/studyroom/home/subpages/userprofile.jsp?u=${answer.getUser().getEmail()}"> <c:out
            value="${answer.getUser().getEmail()}"/></a>
</div>
<div class="Answer">
    <c:out value="${str}" escapeXml="false"/><p>
</div>
<div class="AnswerControlPanelClass">
    <c:if test="${!user.hasVoted(answer) && logged && diffUser}">
        <div class="VoteUP">
            <a href="/studyroom/up?a=${answer.getId()}"><img src="/studyroom/resources/images/up.ico" width="20"
                                                             height="20"></a>
        </div>
    </c:if>
    <div class="VotesCount">
        <c:out value="${answer.getDifference()}" escapeXml="false"/>
    </div>
    <c:if test="${!user.hasVoted(answer) && logged && diffUser}">
        <div class="VoteDown">
            <a href="/studyroom/down?a=${answer.getId()}"><img src="/studyroom/resources/images/down.ico" width="20"
                                                               height="20"></a>
        </div>
    </c:if>
    <c:if test="${question.getUser().equals(user) && !answer.isMarked()}">
        <div class="Check">
            <a href="/studyroom/mark?a=${answer.getId()}"> <img src="/studyroom/resources/images/mark.ico" width="20"
                                                                height="20">
            </a>
        </div>
    </c:if>
</div>
</html>
