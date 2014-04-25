<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 23/04/14
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
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

            // Post submit
            $('theForm').addEvent('submit', function(e){
                alert($('textarea-1').value);
                return true;
            });
        });
    </script>

</head>
<body>

<h1>MooEditable basic example</h1>

<form id="theForm" method="post" action ="studyroom/postQuestion"/>

    <label for="textarea-1">Textarea 1</label>
    <textarea id="textarea-1" name="editable1">
        &lt;p&gt;&lt;strong&gt;This&lt;/strong&gt; is cool!&lt;/p&gt;
    </textarea>

    <input type="submit">

</form>

<div id="data"></div>

</body>
</html>