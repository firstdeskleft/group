<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title>BookATour</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fontAwesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static//css/style.css">   
</head>

<body>

    <header>
        <nav class="navbar navbar-expand-lg navbar-info bg-dark">
            <div class="container">
                <a id="appTitle" class="navbar-brand nav-link-hover text-primary"><b>Book a Tour</b></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarUtils"
                        aria-controls="NavbarUtils" aria-expanded="false" aria-label="Toggle navigation">
                    <span style="font-size:20px;" class="text-primary navbar-toggler-icon fas fa-bars">
                    </span>
                </button>
                <div class="collapse navbar-collapse" id="NavbarUtils">
                    <ul class="navbar-nav mr-auto">
                        <security:authorize access="hasRole('CUSTOMER')">
                            <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/HomeCustomer"
                                                              class="nav-link nav-link-hover"><b>Home</b></a></li>
                        </security:authorize>
                        <security:authorize access="hasRole('GUIDE')">
                            <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/HomeGuide"
                                                              class="nav-link nav-link-hover"><b>Home</b></a></li>
                        </security:authorize>
                        <security:authorize access="hasRole('ADMIN')">
                            <li class="nav-item"><a href="${pageContext.request.contextPath}/HomeAdmin"
                                                    class="nav-link nav-link-hover"><b>Home</b></a></li>
                        </security:authorize>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="image"></div>
        <div class="jumbotron jumbotron-fix">
            <div class="container">
                <div class="row">
                    <h1>This Page is Forbidden!</h1>
                </div>
            </div>
        </div>
    </main>




    <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
</body>

</html>