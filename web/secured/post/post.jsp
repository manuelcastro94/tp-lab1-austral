<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.studyroom.control.HibernateUtil" %>
<%@ page import="static org.studyroom.model.Constants.QUESTION_HIDDEN_ID_VALUE" %>
<%@ page import="org.studyroom.control.dao.QuestionDao" %>
<%@ page import="org.studyroom.model.Constants" %>
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
    String questionStr = "";
    if (editing) {
        questionStr = QuestionDao.getInstance().getQuestionById(HibernateUtil.getGuestSession(), Long.parseLong(request.getQueryString().substring(7))).getQuestion();
    }
    pageContext.setAttribute("responding", responding);
    pageContext.setAttribute("editing", editing);
    pageContext.setAttribute("asking", asking);
    pageContext.setAttribute("questionToEdit", questionStr);
%>
<form id="postForm" action="/studyroom/post" method="GET" name="form1">
    <input type="hidden"
           name="<%=QUESTION_HIDDEN_ID_VALUE%>"
           value="<%=request.getQueryString()%>"/>

    <div id="sample">
        <script type="text/javascript" src="../../editor/nicEdit.js"></script>
        <script type="text/javascript">
            bkLib.onDomLoaded(function () {
                //nicEditors.allTextAreas();
                new nicEditor().panelInstance('<%=Constants.TEXT_AREA%>');
            });
        </script>
        <textarea id="<%=Constants.TEXT_AREA%>" name="<%=Constants.TEXT_AREA%>" cols="40" style="width: 100%;">
            <%=questionStr%>
        </textarea><br/>

        <div id="media">
            <label>Youtube video 1:
                <input type="text" name="media1"/>
            </label>
            <label>Youtube video 2:
                <input type="text" name="media2"/>
            </label>
            <label>Youtube video 3:
                <input type="text" name="media3"/>
            </label>
        </div>
        <c:if test="${!responding || editing}">
            <div id="tags">
                <label>Tags:
                    <input type="text" name="tags"/>
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
