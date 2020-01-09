<%-- 
    Document   : formCustomerr
    Created on : Jan 3, 2020, 8:23:22 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a Customerr</title>
    </head>
    <body>
        <h1>Create a Customerr</h1>
        
        <form:form 
            action="${pageContext.request.contextPath}/register/customer" 
            method="POST"
            modelAttribute="customerr">
            <form:hidden path="id"/>
             
            Username: <form:input path="username"/>           
            <br>
            Password: <form:input path="password"/>           
            <br>
            Credits: <form:input path="credits"/>           
            <br>
             
             
            <input type="submit" value="Submit">
        </form:form>
            
            <%--<form:select path="roles" items="${roloi}" multiple="true" itemValue="rid" itemLabel="rname" />--%>
    </body>
</html>
