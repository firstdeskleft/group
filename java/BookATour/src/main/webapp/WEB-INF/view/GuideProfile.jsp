<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fontAwesome/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
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
                        <li class="nav-item main-item"><a href="/jsp/Tours-Guide.html"
                            class="nav-link nav-link-hover"><b>myTours</b></a></li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown1"
                                role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                                <b>{user.username}</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item nav-link-hover" href="/jsp/Login.jsp">
                                    Logout</a>
                                    </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <h3 class="text-left"><b>Personal Info</b></h3>
    <br>
    <form action="" method="POST">

        <div class="row padding">
            <table id="customerInfoTable"
                class="bg-info table table-hover table-striped table-bordered col-4 border border-dark">
                <thead>
                    <tr class="bg-dark text-white">
                        <label for="firstName">
                            <th class="text-center" scope="col">
                                <h5>{user.firstName}</h5>
                            </th>
                        </label>
                        <label for="lastName">
                            <th class="text-center" scope="col">
                                <h5>{user.lastName}</h5>
                            </th>
                        </label>
                        <label for="credits">
                            <th class="text-center" scope="col">
                                <h5>{user.subject} $</h5>
                            </th>
                        </label>
                        <label for="credits">
                            <th class="text-center" scope="col">
                                <h5>{user.profits} $</h5>
                            </th>
                        </label>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="text-center">
                            <input type="text" id="firstName" name="firstName" placeholder="Edit here...">
                        </td>
                        <td class="text-center">
                            <input type="text" id="lastName" name="lastName" placeholder="Edit here...">
                        </td>
                        <td class="text-center">
                            <input type="text" id="subject" name="subject" placeholder="Edit here...">
                        </td>
                        <td class="text-center">
                            <input type="number" id="profits" name="profits" placeholder="Edit here...">
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>
        <button type="submit" id="editCustomerBtn" class="btn btn-primary"><a name="editCustomer" id="editCustomer">
                Submit Changes</a></button>
    </form>

    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- JavaScript -->
    <script src="/js/app.js"></script>
</body>

</html>