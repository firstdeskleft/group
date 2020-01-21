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
    <h3 class="text-left"><b>My Tours</b></h3>
    <br>
    <button id="createTourBtn" class="btn btn-primary"><a href="${pageContext.request.contextPath}/tour/create" name="createTour" id="createTour">Create Tour</a></button>
    <div class="row padding">
        <table id="tourTable" class="bg-info table table-hover table-striped table-bordered col-8 border border-dark">
            <thead>
                <tr class="bg-dark text-primary">
                    <th class="text-center" scope="col">Tour ID</th>
                    <th class="text-center" scope="col">Location</th>
                    <th class="text-center" scope="col">Date</th>
                    <th class="text-center" scope="col">Cost</th>
                    <th class="text-center" scope="col">Customers</th>
                    <th colspan="2" class="text-center" scope="col">Actions</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${user.tours}" var="t">
                    <c:url var="updatelink" value="/tour/update">
                        <c:param name="tid" value="${t.tid}" />
                    </c:url>
                    <c:url value="/tour/delete" var="deletelink" >
                        <c:param name="tid" value="${t.tid}" />
                    </c:url>
                    <tr>
                        <td class="text-center">${t.tid}</td>
                        <td class="text-center">${t.location}</td>
                        <td class="text-center">${t.tdate}</td>
                        <td class="text-center"><b>${t.cost}$</b></td>
                        <td class="text-center">
                            
                                <c:forEach items="${t.customers}" var="tc">
                                    <ul class="col">
                                        <li><b>${tc.firstName}, ${tc.lastName}</b>
                                            <form:form action="${pageContext.request.contextPath}/message/send" method="POST" 
                                                       modelAttribute="message">
                                                <button class="customerMSG btn btn-primary">Send Message</button></li>
                                            </form:form>
                                    </ul>
                                </c:forEach>
                          

                        </td>

                        <td class="text-center"><a class="text-center" name="editTour" href="${updatelink}" id="editTour" type="submit">
                                <button class="btn btn-primary text-white text-center center-block" id="editTourBtn" name="editTourBtn">
                                    <b id="guideEditTour">Edit</b></button></a></td>
                        <td class="text-center"><a name="deleteTour" href="${deletelink}" id="deleteTour" type="submit">
                                <b class="text-dark"><button onclick="return tourDeleteConfirm(this);"
                                                             class="btn btn-danger text-center" id="deleteTourBtn" name="deleteTourBtn">
                                        <b id="guideDeleteTour">Delete</b></button></b></a></td>
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
</body>

</html>