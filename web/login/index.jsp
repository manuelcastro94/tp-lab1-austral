<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=model.Constants.HOME_TITLE%>
    </title>
</head>
<body>
<h1><%=model.Constants.HOME_TITLE%>
</h1>
Welcome to the Security Filter example application. Use the menu above to navigate the site.

<h2>POST to the Secure Page</h2>
This form POSTs to the Secure Page. By entering a value here and clicking the submit button below, you can
verify that POSTed parameters are maintained through the login sequence.
<%@include file="loginform.jsp" %>

</body>
</html>