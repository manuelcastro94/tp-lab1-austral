<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 22/04/2014
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="css/questionformStyle.css" media="screen"/>
<html>
<head>
    <title>Question Form</title>
</head>
<%if (request.getRemoteUser() != null) {%>
<body>
<div class="AnswerButton">
    <a href="secured/post/post.jsp?q=${question.getId()}"> Responder </a>
</div>
</body>
<%}%>
</html>