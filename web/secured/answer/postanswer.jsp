<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 22/04/2014
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer</title>
</head>
<body>
<%if (request.getRemoteUser() != null) {%>
<form id="<%=Constants.ANSWER_FORM%>" action="/studyroom/postAnswer" method="POST">
    Answer:
    <input type="text"
           name="<%=Constants.ANSWER_FIELD%>">
    <input type="Submit" value="ANSWER">
    <%----%>
    <%--<input name="<%=Constants.QUESTION_ID%>"--%>
    <%--value="<%=Constants.QUESTION_ID_VALUE%>" />--%>
</form>
<%}%>
</body>
</html>
