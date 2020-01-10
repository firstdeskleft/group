<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title>Home</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontAwesome/css/all.css">
    <link rel="stylesheet" href="/css/style.css">
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
                        <li class="nav-item main-item"><a href="/jsp/Tours.html"
                            class="nav-link nav-link-hover"><b>Our Tours</b></a></li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown1"
                                role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                                <b>User</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item nav-link-hover" href="/jsp/Login.jsp">
                                    Login</a>
                                    </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle nav-link-hover" id="navbarDropdown2"
                                role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-edit"></i>
                                <b>Register</b>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/register/customer">
                                    Customer Registration</a>

                                <a class="dropdown-item nav-link-hover" href="${pageContext.request.contextPath}/register/guide">
                                    Tour Guide Registration</a>
                            </div>
                        </li>
                        
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
                <h1>Welcome to <b>Book A Tour</b> Project</h1>
            </div>
        </div>
    </div>
</main>




    <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!--BOOTSTRAP-->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/js/app.js"></script>
</body>

</html>