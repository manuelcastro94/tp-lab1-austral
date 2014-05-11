<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 11/05/2014
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="resources/css/mainControlPanel.css"/>
<html>
<head>
    <title>Control panel</title>
</head>
<body>
<div name="ControlPanel">
    "Falta diseño"
    "Estaria bueno que esto apareciese en otras partes, pero por ejemplo mostrando un link al home cuando estas viendo
    una pregunta, ordenando por tags, etc"
    <div name="Ask">
        <jsp:include page="../../secured/post/ask.jsp"/>
    </div>
    <div name="OrderBy">
        Order questions by
        <div name="Last">
            <a href="/studyroom/index.jsp"> Last first </a>
        </div>
        <div name="NoAanswers">
            <a href="/studyroom/index.jsp?orderBy=NoAnswers"> No answers first </a>
        </div>
        <div name="MoreAnswers">
            <a href="/studyroom/index.jsp?orderBy=MoreAnswers"> More answers first </a>
        </div>
    </div>
    <div name="SearchPanel">
        "aca ira el search"
    </div>
</div>

</body>
</html>
