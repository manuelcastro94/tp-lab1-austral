<%--
  Created by IntelliJ IDEA.
  model.user.User: Federico
  Date: 30/03/2014
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%if (request.getRemoteUser() != null) {%>
<br/>Como el usuario se ha logiado podra responder preguntas</p>
<%}%>
</body>
</html>
