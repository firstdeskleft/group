<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            table, .tr{
                border: 1px solid black;
            }
        </style>

    </head>
    <body>
        <h1>Inbox</h1>


        <table>
            <c:forEach items="${listOfMessages}" var="message">

                <c:url value="/message/send" var="messagelink" >
                    <c:param name="gid" value="${message.sourceId}" />
                </c:url>

                <tr>
                    <td> 
                        ${message}
                    </td>
                    <td> 
                        <a href="${messagelink}" 
                           class="nav-link nav-link-hover">
                            <button onclick="console.log(${message.sourceId})" name="${message.sourceId}" value ="${message.sourceId}">
                                respond
                            </button>
                        </a>
                    </td>
                    <td> 
                        delete
                    </td>
                </tr>
            </c:forEach>
        </table>                  


    </body>
</html>
