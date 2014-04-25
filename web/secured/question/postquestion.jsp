<%@ page import="org.studyroom.model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 16/04/2014
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Form</title>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MooEditable basic example</title>

<style type="text/css">
    body{
        font-family: sans-serif;
        font-size: .9em;
    }
    #textarea-1{
        width: 700px;
        height: 200px;
        padding: 10px;
        border: 2px solid #ddd;
    }
</style>

<link rel="stylesheet" type="text/css" href="editor/Assets/MooEditable/MooEditable.css">
<script type="text/javascript" src="editor/Assets/assets/mootools.js"></script>
<script type="text/javascript" src="editor/Source/MooEditable/MooEditable.js"></script>

<script type="text/javascript">
    window.addEvent('domready', function(){
        $('textarea-1').mooEditable();


    });
</script>
<%if (request.getRemoteUser() != null) {%>
<form id="<%=Constants.QUESTION_FORM%>" action="/studyroom/postQuestion" method="POST">

    <label for="textarea-1">Textarea 1</label>
    <textarea id="textarea-1" name="editable1">
        &lt;p&gt;&lt;strong&gt;This&lt;/strong&gt; is cool!&lt;/p&gt;
    </textarea>

    <input type="submit" value="Post">
    <%--<input type="Submit" value="Post">--%>
</form>
<%--<textarea name="comment" form="<%=Constants.QUESTION_FORM%>">Enter text here...</textarea>--%>
<%}%>
</body>
</html>