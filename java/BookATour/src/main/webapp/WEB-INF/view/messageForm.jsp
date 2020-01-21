<%-- 
    Document   : messageForm
    Created on : 20 Ιαν 2020, 12:00:39 μμ
    Author     : nick.sabanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send a message</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fontAwesome/css/all.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>
    <body>
        <security:authorize access="hasRole('ADMIN')">
            <%@include file="AdminHeader.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('CUSTOMER')">
            <%@include file="CustomerHeader.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('GUIDE')">
            <%@include file="GuideHeader.jsp" %>
        </security:authorize>
        <br>
        <br>
        <h1 class="SendMsg">Send a Message</h1>
        <form:form action="${pageContext.request.contextPath}/message/send" 
                   id="sendMsgForm" 
                   name="sendMsgForm" 
                   class="form-horizontal Register" 
                   method="POST" 
                   modelAttribute="message">
            <fieldset>
                <div class="control-group">
                    <!-- First name -->
                    <label class="control-label"  for="sendMsg"></label>
                    <div class="controls">
                        <form:textarea path="body" id="msgBody" name="msgBody" class="text" form="sendMsgForm" rows="5" cols="30"/>
                    </div>
                </div>
                <br>
                <div class="control-group">
                    <!-- Button -->
                    <br>
                    <div class="controls">
                        <button type="submit" class="btn btn-primary">Send Message</button>
                    </div>
                </div>
            </fieldset>
            <br>
        </form:form>
        <!--JQUERY-->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <!--BOOTSTRAP-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
    </body>
</html>
