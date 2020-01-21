<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib prefix="secutiry" uri="http://www.springframework.org/security/tags" %>
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
    <h3 class="text-left"><b>Available Tours</b></h3>

    <br>
    <br>
    <section class="row" id="filters">
        <p class="row col-2"><button id="buttonReset" onclick="performReset()" class="btn btn-primary">Reset Filters</button></p>
        <input class="data-filter row col-2 text-center" type="text" id="searchTour" onkeyup="filterTours();"
               placeholder="Search for Locations..." title="Type in a Location">
        <input class="data-filter row col-1" type="number" id="searchTourCost" onkeyup="filterToursCost()"
               placeholder="Tour Price">
    </section>
    <div class="row data-credits">
        <h4 id="showCredits"><b>Your Credits: ${user.credits}$</b></h4>
    </div>
    <c:if test="${hasError}">
        <div id="errorDiv" class="alert alert-dark alert-dismissible text-center row data-lowCredits" role="alert">
            <button id="errBtn" class="btn btn-danger text-left err" data-dismiss="alert" aria-label="Close" ><b>${errorMessage}<b></button>
                        </div>
                    </c:if>
                    <div class="row padding">
                        <table id="tourTable" class="table table-hover table-striped table-bordered col-8 border border-dark">
                            <thead>
                                <tr class="bg-info data-tourInfo">
                                    <th class="text-center" scope="col">Tour ID#</th>
                                    <th class="text-center" scope="col">Location</th>
                                    <th class="text-center" scope="col">Date</th>
                                    <th class="text-center" scope="col">Cost</th>
                                    <th class="text-center" scope="col">Guide</th>
                                    <th colspan="2" class="text-center" scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <c:forEach items="${listOfTours}" var="t">
                                        <c:url var="booklink" value="/booking/create">
                                            <c:param name="tid" value="${t.tid}" />
                                        </c:url>

                                    <tr>
                                        <td class="text-center">${t.tid}</td>
                                        <td class="text-center">${t.location}</td>
                                        <td class="text-center">${t.tdate}</td>
                                        <td id="tourCost" class="text-center"><b>${t.cost}$</b></td>
                                        <td class="text-center">${t.guide.username}</td>                      
                                        <td class="text-center">
                                            <a href="${booklink}">
                                                <button onclick="return confirmBooking(this);" type="submit" class="btn btn-primary" 
                                                        id="bookButton" name="bookButton">
                                                    Book now
                                                </button>
                                            </a>
                                        </td>
                                    </c:forEach>
                                </tr>   
                            </tbody>
                        </table>
                    </div>

                    <!--JQUERY-->
                    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
                    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
                    <!--BOOTSTRAP-->
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
                    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>

                    <script>
                                                    const btn = document.getElementById('errBtn');
                                                    btn.addEventListener('click', () => {
                                                     
                                                      error = ${hasError};
                                                      error = !error;
                                                     console.log(error);
                                                  });
                    </script>
                    </body>

                    </html>