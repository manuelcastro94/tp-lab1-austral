<%@ page import="org.studyroom.control.dao.QuestionDao" %>
<%@ page import="org.studyroom.model.Constants" %>
<%@ page import="org.studyroom.model.entities.Question" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 30/04/2014
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="../../resources/javascript/editor/nicEdit.js"></script>
<script type="text/javascript" src="../../resources/javascript/dynamicVideoLoader.js"></script>
<html>
<%
    boolean editing = request.getQueryString().contains("edit&q=");
    Question question = editing ? QuestionDao.getInstance().getQuestion(org.studyroom.control.utilities.HibernateUtil.getGuestSession(), Long.parseLong(request.getQueryString().substring(7))) : null;
    pageContext.setAttribute("responding", request.getQueryString().contains("q=") && !request.getQueryString().contains("edit"));
    pageContext.setAttribute("editing", request.getQueryString().contains("edit&q="));
    pageContext.setAttribute("asking", request.getQueryString().contains("ask"));
    pageContext.setAttribute("questionStr", editing ? question.getQuestion() : "");
    pageContext.setAttribute("questionTitle", editing ? question.getTitle() : "Untitled question");
    pageContext.setAttribute("questionTags", editing ? Arrays.toString(question.getTags().toArray()).replace("[", "").replace("]", "").replace(", ", ";") : "");
    pageContext.setAttribute("hidden", Constants.QUESTION_HIDDEN_ID_VALUE);
    pageContext.setAttribute("tittleField", Constants.TITLE_FIELD);
    pageContext.setAttribute("textArea", Constants.TEXT_AREA);
    pageContext.setAttribute("query", request.getQueryString());
%>
<body>
<a id="home" href="/studyroom/index.jsp">Home</a>
<form id="postForm" action="/studyroom/post" method="GET" name="form1">
    <input type="hidden"
           name="${hidden}"
           value="${query}"/>
    <c:if test="${!responding}">
        <INPUT value="${questionTitle}" id="${tittleField}" name="${tittleField}"/>
    </c:if>
    <div id="sample">
        <script type="text/javascript">
            bkLib.onDomLoaded(function () {
                new nicEditor().panelInstance('${textArea}');
            });
        </script>
        <textarea id="${textArea}" name="${textArea}" cols="40" style="width: 100%;">
        ${questionStr}
        </textarea><br/>
        <div name="media">
            <label>Youtube video:
                <input type="text" id="mediaInput"/>
            </label>
            <INPUT type="button" value="Add" onclick="add(document.getElementById('mediaInput').value)"/>
            <div id="youtubeLinks" style="max-width: 100px"></div>
        </div>
        <c:if test="${!responding || editing}">
            <div id="tags">
                <label>Tags:
                    <input type="text" name="tags" value="${questionTags}"/>
                </label>(separate with ; and don't leave spaces example c#;html;java)
            </div>
        </c:if>
    </div>
    <c:if test="${asking}">
        <input type="submit" value="Post Question">
    </c:if>
    <c:if test="${responding}">
        <input type="submit" value="Answer">
    </c:if>
    <c:if test="${editing}">
        <input type="submit" value="Edit your question">
    </c:if>
</form>
</body>
</html>
