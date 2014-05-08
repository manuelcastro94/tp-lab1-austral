<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 07/05/2014
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%if (request.getRemoteUser() != null) {%>
<body>
<a href="/studyroom/mark?a=${answer.getId()}"> <img src="/studyroom/images/mark.png" width="20" height="20"> </a>
</body>
<%}%>
</html>