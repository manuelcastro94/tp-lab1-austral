<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=model.user.Constants.HOME_TITLE%>
    </title>
    <%@include file="loginjsp/contextualloginform.jsp" %>
    <style type = "text/css">
        <%@include file="css/indexStyle.css" %>
    </style>

</head>
<body>
<h1><%=model.user.Constants.HOME_TITLE%>
</h1>
Usar la imaginacion y creer que aca se ven preguntas en forma publica
<%@include file="secured/securePage.jsp" %>
</body>
</html>