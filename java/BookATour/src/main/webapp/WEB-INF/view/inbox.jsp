<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inbox</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fontAwesome/css/all.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>
    <style>
        table, .tr{
            border: 1px solid black;
        }
    </style>
<body>
    <br>
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
    <h1 class="inboxTitle"><b>Inbox</b></h1>
    <div class="row padding">
        <table id="tourTable" class="table table-hover table-striped table-bordered col-8 border border-dark">
            <thead>
                <tr class="bg-primary">
                    <th class="text-center text-white" scope="col"><b>Messages Info<b></th>
                    <th class="text-center bg-primary text-white" scope="col" colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOfMessages}" var="message">

                    <c:url value="/message/send" var="messagelink" >
                        <c:param name="gid" value="${message.sourceId}" />
                    </c:url>
                    <c:url value="/message/delete" var="messagedeletelink" >
                        <c:param name="mid" value="${message.id}" />
                    </c:url>
                    <tr class="bg-info">
                        <td> 
                         <b>Message:</b> ${message.body}
                                 <br>
                                 <br>
                         <b>Source ID:</b> ${message.sourceId}
                                <br>
                                <br>
                         <b>Target ID:</b> ${message.targetId}
                        </td>
                        <td> 
                            <a href="${messagelink}" 
                               class="nav-link nav-link-hover">
                                <button class="mb-n2 btn btn-primary" onclick="console.log(${message.sourceId})" name="${message.sourceId}" value ="${message.sourceId}">
                                    Reply Message
                                </button>
                            </a>
                        </td>
                        <td> 
                            <a name="deleteMessage" href="${messagedeletelink}" id="deleteMessage" type="submit">
                                    <button 
                                        onclick="return messageDeleteConfirm(this);"
                                        class="mt-2 btn btn-danger text-center" id="deleteMessageBtn" name="deleteCustomerBtn">
                                            Delete Message
                                    </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
</body>
</html>
