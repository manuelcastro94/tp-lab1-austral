<%@ page import="org.studyroom.model.Constants" %>
<%@ page import="static org.studyroom.model.Constants.QUESTION_HIDDEN_ID_VALUE" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 30/04/2014
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Post</title>
</head>
<body>
<%boolean responding = request.getQueryString() != null;%>
<form id="postForm" action="/studyroom/post" method="GET" name="form1">
    <input type="hidden"
           name="<%=QUESTION_HIDDEN_ID_VALUE%>"
           value="<%=request.getQueryString()%>"/>

    <div id="sample">
        <script type="text/javascript" src="../../editor/nicEdit.js"></script>
        <script type="text/javascript">
            bkLib.onDomLoaded(function () {
                nicEditors.allTextAreas()
            });
        </script>
        <textarea name="<%=Constants.TEXT_AREA%>" cols="40">
        </textarea><br/>

        <div id="media">
            <label>Youtube video 1:
                <input type="text" name="media1"/>
            </label>
            <label>Youtube video 2:
                <input type="text" name="media2"/>
            </label>
            <label>Youtube video 3:
                <input type="text" name="media3"/>
            </label>
        </div>
        <%if (!responding) {%>
        <div id="tags">
            <label>Tags:
                <input type="text" name="tags"/>
            </label>(separate with ; and don't leave spaces example c#;html;java)
        </div>
        <%}%>
    </div>
    <input type="submit" value="<%=responding ? "Post answer" : "Post question"%>">
</form>
</body>
</html>
