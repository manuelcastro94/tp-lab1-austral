<%@ page import="model.Constants" %>
<%@ page import="model.user.User" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=model.Constants.SECURE_TITLE%>
    </title>
</head>
<body>

<h1><%=model.Constants.SECURE_TITLE%>
</h1>
<%
    User user = new User(request.getParameter(model.Constants.USER_EMAIL), request.getParameter(model.Constants.USER_PASSWORD));
    if (!User.valid(user)) {
        response.sendRedirect("forbiddenpage.jsp");
    } else if (request.getParameter(Constants.SIGN_IN) == null) {
%>
<h2>Valid user name, welcome back!</h2>
<%} else {%>
<h2>Welcome to StudyRoom!</h2>
<%}%>
<form name="<%=model.Constants.SECURE_POSTED_VALUE_FORM%>" action="">
    Yor email is:
    <ul>
        <li>
            <%=user.getEMail()%>
            <input type="hidden" name="<%=model.Constants.SECURE_POSTED_VALUE_FIELD%>" value="<%=user.getEMail()%>"/>
        </li>
    </ul>
    Yor password is:
    <ul>
        <li>
            <%=user.getPassword()%>
            <input type="hidden" name="<%=model.Constants.SECURE_POSTED_VALUE_FIELD%>" value="<%=user.getPassword()%>"/>
        </li>
    </ul>
</form>

</body>
</html>