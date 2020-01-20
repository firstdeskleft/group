<%-- 
    Document   : messageForm
    Created on : 20 Ιαν 2020, 12:00:39 μμ
    Author     : nick.sabanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a message</h1>

    <form:form 
        action="${pageContext.request.contextPath}/message/send" 
        id="registerForm" 
        class="form-horizontal Register" 
        method="POST" 
        modelAttribute="message">

        <form:input path="body" type="text" id="body"  placeholder="Enter message" />
        
        <button type="submit" class="btn btn-primary">Send message</button>

    </form:form>
</body>
</html>
