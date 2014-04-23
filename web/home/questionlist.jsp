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
<%@include file="/secured/question/postquestion.jsp" %>
<c:forEach var="item" items="${requestScope.questions}">
    <div>
        <c:out value="${item}"/><p>

    </div>
</c:forEach>
<%@include file="/secured/answerform.jsp" %>
</body>
</html>
