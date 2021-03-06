<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title>BookATour</title>
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
                    <span style="font-size:20px;" class="navbar-toggler-icon fas fa-bars">
                    </span>
                </button>
                <div class="collapse navbar-collapse" id="NavbarUtils">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/HomeGuide"
                                                          class="nav-link nav-link-hover"><b>Home</b></a></li>
                        <li class="nav-item  active"><a href="${pageContext.request.contextPath}/tour/guidetours"
                                                        class="nav-link nav-link-hover"><b>myTours</b></a></li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown1"
                               role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                                <b>${user.username}</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/guide/update">
                                    my Profile
                                </a>
                                    <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/message/inbox">
                                    my Messages
                                </a>
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
    <div class="image"></div>
    <h3 class="text-left"><b>Create Your Tour</b></h3>
    <br>
    <form:form action="${pageContext.request.contextPath}/tour/create" method="POST" modelAttribute="tour">
        <button type="submit" id="addTourBtn" class="btn btn-primary"><a name="addTour" id="addTour">
                Submit Tour</a></button>
        <div class="row padding">
            <table id="CreateTourTable" class="bg-info table table-hover table-striped table-bordered col-4 border border-dark">

                <thead>
                    <tr class="bg-dark text-primary">
                <label for="location"><th class="text-center" scope="col">Location</th></label>  
                <label for="date"><th class="text-center" scope="col">Date</th></label>  
                <label for="cost"><th class="text-center" scope="col">Cost</th></label>  
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <form:hidden path="tid"/>
                        <td class="text-center">

                            <form:input path="location" type="text" id="location" name="location" placeholder="Enter Location"   />
                        </td>
                        <td class="text-center">
                            <form:input path="tdate" type="date" id="createTourDate" name="createTourDate" placeholder="Enter Date" value=""  />
                        </td>
                        <td class="text-center">
                            <p><form:input path="cost" type="number" id="cost" name="cost" placeholder="Enter Price in Euros..."  />  </p>
                        </td>

                    </tr>
                </tbody>
            </table>
        </div>
    </form:form>



    <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
</body>

</html>