<link rel="stylesheet" type="text/css" href="css/indexStyle.css" media="screen"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=Constants.HOME_TITLE%>
    </title>
    <%@include file="../login/contextualloginform.jsp" %>
</head>
<body>
<h1><%=Constants.HOME_TITLE%>
</h1>
<%@include file="../secured/post/ask.jsp" %>
<%@include file="questionlist.jsp" %>


</body>
</html>