<link rel="stylesheet" type="text/css" href="css/indexStyle.css" media="screen"/>
<html>
<head id="mainHeader">
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=Constants.HOME_TITLE%>
    </title>

    <h1 id="mainTitle"><%=Constants.HOME_TITLE%>
    </h1>
    <%@include file="../login/contextualloginform.jsp" %>
</head>
<body>
<%@include file="../secured/post/ask.jsp" %>
<%@include file="questionlist.jsp" %>


</body>
</html>