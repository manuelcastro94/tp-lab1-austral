<%@ page import="org.studyroom.control.HibernateUtil" %>
<%@ page import="org.studyroom.control.dao.UserDAO" %>
<%@ page import="org.studyroom.model.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 10/05/2014
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), request.getQueryString().replace("u=", ""));
    request.setAttribute("user", user);
%>
<head>
</head>
<body>
<c:out value="User: ${user.getEmail()}"/><p>
<c:out value="Questions: ${user.getQuestions().size()}"/><p>
<c:out value="Answers: ${user.getAnswers().size()}"/><p>
<c:out value="UpVotes: ${user.getUpVotes()}"/><p>
<c:out value="DownVotes: ${user.getDownVotes()}"/><p>
</body>
</html>
