<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.user.User: Federico
  Date: 29/03/2014
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="sd" action="/studyroom/loadQuestion" method="POST">

    <input type="Submit" value="ADAdasd">
</form>
<c:out value="asdfasd ${requestScope.questions}"/>
<c:out value="Usar la imaginacion y creer que aca se ven preguntas"/>
<c:forEach var="item" items="${requestScope.questions}">
Item <c:out value="${item}"/><p>
    </c:forEach>
    <%@include file="/secured/answerform.jsp" %>
</body>
</html>
