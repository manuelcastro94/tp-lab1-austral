<%@ page import="org.studyroom.model.Constants" %>
<link rel="stylesheet" type="text/css" href="resources/css/indexStyle.css" media="screen"/>
<html>
<head id="mainHeader">
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title><%=Constants.HOME_TITLE%>
    </title>

    <h1 id="mainTitle"><%=Constants.HOME_TITLE%>
    </h1>
    <jsp:include page="login/contextualloginform.jsp"/>
</head>
<body>
<div id="MainControlPanel">
    <jsp:include page="subpages/maincontrolpanel.jsp"/>
</div>
<div id="QuestionList">
    <jsp:include page="template/questionlist.jsp"/>
</div>
</body>
</html>