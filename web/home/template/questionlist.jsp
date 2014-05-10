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
<body id="mainQuestionBody">
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div class="GeneralClass" style="width: 650px">
        <c:set var="question" value="${question}" scope="request"/>
        <%@include file="question.jsp" %>
    </div>
</c:forEach>
</body>
</html>
