<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fontAwesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
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
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/HomeCustomer"
                                                          class="nav-link nav-link-hover"><b>Home</b></a></li>
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/tour/listforcustomer"
                                                          class="nav-link nav-link-hover"><b>Our Tours</b></a></li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown1"
                               role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                                <b>${user.username}</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/customer/update">
                                    my Profile</a>
                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/customer/bookings">
                                    my Bookings</a>
                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/message/inbox">
                                    my Messages</a>
                                <a class="dropdown-item nav-link-hover">
                                    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                        <input type="submit" value="Logout">
                                    </form:form>
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <h3 class="text-left"><b>Personal Info</b></h3>
    <br>
    <form:form method="POST" action="${pageContext.request.contextPath}/customer/update" modelAttribute="user">
        <div class="row padding">
            <table id="customerInfoTable" class="bg-info table table-hover table-striped table-bordered col-4 border border-dark">
                <thead>
                    <tr class="bg-dark text-white">
                <label for="firstName"><th class="text-center" scope="col"><h5>First Name</h5></th></label>  
                <label for="lastName"><th class="text-center" scope="col"><h5>Last Name</h5></th></label>  
                <label for="credits"><th class="text-center" scope="col"><h5>Credits $</h5></th></label>  
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="text-center">
                            <form:input path="firstName" type="text"  id="firstName" name="firstName"  class="input-xlarge"/>
                        </td>
                        <td class="text-center">
                            <form:input path="lastName" type="text" id="lastName" name="lastName" class="input-xlarge"/>
                        </td>
                        <td class="text-center">
                            <form:input path="credits" type="text" id="credits" name="credits" class="input-xlarge"/>
                        </td>                     
                    </tr>
                </tbody>
            </table>
        </div>
        <button type="submit" id="editCustomerBtn" class="btn btn-primary"><a name="editCustomer" id="editCustomer">
                Update 
            </a>
        </button>
    </form:form>



    <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
</body>

</html>