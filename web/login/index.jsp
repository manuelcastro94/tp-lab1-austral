<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=model.Constants.HOME_TITLE%>
    </title>
</head>
<body>
<h1><%=model.Constants.HOME_TITLE%>
</h1>
You are seeing StudyRoom as a public user

<h2>Login to your StudyRoom account</h2>
<%@include file="loginform.jsp" %>

<h2>Don't have an account? Sign in</h2>
<%@include file="signinform.jsp" %>
</body>
</html>