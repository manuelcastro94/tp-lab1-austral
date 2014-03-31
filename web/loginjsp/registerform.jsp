<%@ page import="model.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: Federico
  Date: 28/03/2014
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form id="<%=Constants.REGISTER_FORM_ID%>" action="RegisterServlet" method="POST">
<input type="Submit" value="<%=Constants.REGISTER%>">
</form>
</body>
</html>
