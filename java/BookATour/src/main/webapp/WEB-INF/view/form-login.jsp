<%-- 
    Document   : newjsp
    Created on : 16 Δεκ 2019, 1:07:36 μμ
    Author     : nick.sabanis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Simple Login Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
    <body>
        <div class="login-form">



            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid parameters</p>
                </div>
            </c:if>

            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>Logged out successfully</p>
                </div>
            </c:if>

            <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                <h2 class="text-center">Log in</h2>       
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="Username" required="required">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" required="required">
                </div>
                <div class="form-group">
                    <button  type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>

            </form:form>

        </div>
    </body>
</body>
</html>
