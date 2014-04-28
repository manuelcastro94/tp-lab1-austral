<%--
  Created by IntelliJ IDEA.
  org.studyroom.model.user.User: Federico
  Date: 29/03/2014
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--http://hmkcode.com/java-servlet-send-receive-json-using-jquery-ajax/--%>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="/secured/question/postquestion.jsp" %>
<c:forEach var="question" items="${requestScope.questions}" varStatus="pStatus">
    <div id="QuestionsDiv">
        <c:out value="User: ${question.getUser().getEmail()}"/><p>
            <c:out value="${question.getQuestion()}" escapeXml="false"/>
            <%--<c:out value="Question: ${question.getQuestion()}"/><p>--%>
        <input name="<%=Constants.QUESTION_ID%>"
               type="hidden"
               value="<c:out value="${question.getId()}"/>"/>
        <c:forEach var="answer" items="${question.getAnswers()}" varStatus="pStatus">

        <div id="AnswersDiv">
            <c:out value="By: ${answer.getUser().getEmail()}"/><p>
            <c:out value="${answer}" escapeXml="false"/><p>
        </div>
        </c:forEach>
        <%@include file="/secured/answer/postanswer.jsp" %>
            <%--<%if (request.getRemoteUser() != null) {%>--%>
            <%--<form id="<%=Constants.ANSWER_FORM%>" action="/studyroom/postAnswer" method="POST">--%>
            <%--Answer:--%>
            <%--<input type="text"--%>
            <%--name="<%=Constants.ANSWER_FIELD%>">--%>
            <%--<input name="<%=Constants.QUESTION_ID%>" type="hidden"--%>
            <%--value="<c:out value="${question.getId()}"/>"/>--%>
            <%--<input type="Submit" value="ANSWER">--%>
            <%--&lt;%&ndash;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input name="<%=Constants.QUESTION_ID%>"&ndash;%&gt;--%>
            <%--&lt;%&ndash;value="<%=Constants.QUESTION_ID_VALUE%>" />&ndash;%&gt;--%>
            <%--</form>--%>
            <%--<%}%>--%>
            <%--<jsp:include page="/secured/answer/postanswer.jsp" >--%>
            <%--&lt;%&ndash;<jsp:param name="<%=Constants.QUESTION_ID_VALUE%>" value="${question.getId()}" />&ndash;%&gt;--%>
            <%--</jsp:include>--%>
            <%--&lt;%&ndash;<%@include file="/secured/answer/postanswer.jsp" %>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:out value="question[${pStatus.index}].getUser"/><p>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<form:input path="Question[${pStatus.index}].getUser" />&ndash;%&gt;--%>
    </div>
</c:forEach>
</body>
</html>
