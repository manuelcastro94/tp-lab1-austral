<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.studyroom.control.HibernateUtil" %>
<%@ page import="static org.studyroom.model.Constants.QUESTION_HIDDEN_ID_VALUE" %>
<%@ page import="org.studyroom.control.dao.QuestionDao" %>
<%@ page import="org.studyroom.model.Constants" %>
<%@ page import="org.studyroom.model.entity.Question" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 30/04/2014
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<%
    boolean asking = request.getQueryString().contains("ask");
    boolean responding = request.getQueryString().contains("q=") && !request.getQueryString().contains("edit");
    boolean editing = request.getQueryString().contains("edit&q=");
    Question question = null;
    if (editing) {
        question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), Long.parseLong(request.getQueryString().substring(7)));
    }
    pageContext.setAttribute("responding", responding);
    pageContext.setAttribute("editing", editing);
    pageContext.setAttribute("asking", asking);
    pageContext.setAttribute("questionStr", editing ? question.getQuestion() : "");
    pageContext.setAttribute("questionTitle", editing ? question.getTitle() : "Untitled question");
    pageContext.setAttribute("questionTags", editing ? Arrays.toString(question.getTags().toArray()).replace("[", "").replace("]", "").replace(", ", ";") : "");
%>
<SCRIPT language="javascript">
    var i = 0;
    function add(link) {
        if (link.value != "") {
            //Create an input type dynamically.
            var element = document.createElement("input");
            element.type = "text";
            element.name = i;
            element.contenteditable = false;
            element.value = link;
            var foo = document.getElementById("youtubeLinks");
            document.getElementById('mediaInput').value = '';
            //Append the element in page (in span).
            foo.appendChild(element);
            i++;
        }
    }
</SCRIPT>
<a id="home" href="/studyroom/index.jsp">Home</a>

<form id="postForm" action="/studyroom/post" method="GET" name="form1">
    <input type="hidden"
           name="<%=QUESTION_HIDDEN_ID_VALUE%>"
           value="<%=request.getQueryString()%>"/>
    <c:if test="${!responding}">
        <INPUT value="${questionTitle}" id="<%=Constants.TITLE_FIELD%>" name="<%=Constants.TITLE_FIELD%>"/>
    </c:if>
    <div id="sample">
        <script type="text/javascript" src="../../editor/nicEdit.js"></script>
        <script type="text/javascript">
            bkLib.onDomLoaded(function () {
                //nicEditors.allTextAreas();
                new nicEditor().panelInstance('<%=Constants.TEXT_AREA%>');
            });
        </script>
        <textarea id="<%=Constants.TEXT_AREA%>" name="<%=Constants.TEXT_AREA%>" cols="40" style="width: 100%;">
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
