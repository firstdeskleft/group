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
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="NavbarUtils">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/HomeAdmin"
                                                          class="nav-link nav-link-hover"><b>Home</b></a></li>
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/tour/listforAdmin"
                                                          class="nav-link nav-link-hover"><b>Tours</b></a></li>
                        <li class="nav-item main-item"><a href="${pageContext.request.contextPath}/guide/list"
                                                          class="nav-link nav-link-hover"><b>Guides</b></a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/customer/list"
                                                class="nav-link nav-link-hover"><b>Customers</b></a></li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown1"
                               role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                                <b>${user.username}</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
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
    <h3 class="text-left"><b>List of Customers</b></h3>

    <div class="row padding">
        <table id="tourTable" class="table table-hover table-striped table-bordered col-8 border border-dark">
            <thead>
                <tr class="bg-info">
                    <th class="text-center" scope="col">Customer ID#</th>
                    <th class="text-center" scope="col">First Name</th>
                    <th class="text-center" scope="col">Last Name</th>
                    <th class="text-center" scope="col">Credits</th>
                    <th colspan="2" class="text-center" scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOfCustomers}" var="c">

                    <c:url value="/customer/delete" var="deletelink" >
                        <c:param name="id" value="${c.id}" />
                    </c:url>

                    <c:url value="/message/send" var="messagelink" >
                        <c:param name="gid" value="${c.id}" />
                    </c:url>
                    <tr>
                        <td class="text-center">${c.id}</td>
                        <td class="text-center">${c.firstName}</td>
                        <td class="text-center">${c.lastName}</td>
                        <td class="text-center">${c.credits}</td>
                        <td class="text-center">
                            <a 
                                href="${messagelink}" 
                                class="nav-link nav-link-hover">
                                <button class="btn btn-primary text-center">
                                    Send message
                                </button
                            </a>
                        </td>
                        <td class="text-center">
                            <a name="deleteCustomer" href="${deletelink}" id="deleteCustomer" type="submit">
                                    <button 
                                        onclick="return customerDeleteConfirm(this);"
                                        class="btn btn-danger text-center" id="deleteCustomerBtn" name="deleteCustomerBtn">
                                            Delete Customer
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
</body>

</html>