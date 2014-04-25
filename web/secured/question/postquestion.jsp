<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 16/04/2014
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Form</title>
</head>

<body>
<%if (request.getRemoteUser() != null) {%>
<form id="<%=Constants.QUESTION_FORM%>" action="/studyroom/postQuestion" method="POST">

    Ask:
    <input type= "text"
           name="<%=Constants.QUESTION_FIELD%>">
    <input type="Submit" value="Post">
</form>
<textarea name="comment" form="<%=Constants.QUESTION_FORM%>">Enter text here...</textarea>
<%}%>
</body>
</html>