<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <title class="registerTitle">Register</title>
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
                 <li class="nav-item main-item"><a href="/jsp/Home.html"
                        class="nav-link nav-link-hover"><b>Home</b></a></li>
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
                            <a class="dropdown-item nav-link-hover" href="/jsp/CustomerRegister.html">
                                Customer Registration</a>

                            <a class="dropdown-item nav-link-hover" href="/jsp/GuideRegister.html">
                                Tour Guide Registration</a>
                        </div>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="image"></div>
<br>
    <form:form action="${pageContext.request.contextPath}/register/guide" id="registerForm" class="form-horizontal Register" method="POST" modelAttribute="guide">
        <fieldset>
          <div id="legend">
            <legend class="">Tour Guide Registration</legend>
          </div>
          <div class="control-group">
            <!-- First name -->
            <label class="control-label"  for="firstName">First Name</label>
            <div class="controls">
              <form:input path="firstName" id="firstName" name="firstName" placeholder="" class="input-xlarge"/>
              <p class="help-block">First Name can contain any letters or numbers, without spaces</p>
            </div>
          </div>

          <div class="control-group">
            <!-- Last name -->
            <label class="control-label"  for="lastName">Last Name</label>
            <div class="controls">
              <form:input  path="lastName" type="text" id="lastName" name="lastName" placeholder="" class="input-xlarge"/>
              <p class="help-block">Last Name can contain any letters or numbers, without spaces</p>
            </div>
          </div>

          <div class="control-group">
            <!-- Subject -->
            <label class="control-label"  for="subject">Subject</label>
            <div class="controls">
              <form:input path="subject" type="text" id="subject" name="subject" placeholder="" class="input-xlarge"/>
              <p class="help-block">Subject can contain any letters or numbers</p>
            </div>
          </div>

          <div class="control-group">
            <!-- Certificate -->
            <label class="control-label"  for="certificate">Certificate</label>
            <div class="controls">
              <form:input path="certificate" type="text" id="certificate" name="certificate" placeholder="Certificate ID" class="input-xlarge"/>
              <p class="help-block"></p>
            </div>
          </div>



          <div class="control-group">
            <!-- Username -->
            <label class="control-label"  for="username">Username</label>
            <div class="controls">
              <form:input path="username" type="text" id="username" name="username" placeholder="" class="input-xlarge"/>
              <p class="help-block">Username can contain any letters or numbers, without spaces</p>
            </div>
          </div>
       
          <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">Password</label>
            <div class="controls">
              <form:input path="password" type="password" id="password" name="password" placeholder="" class="input-xlarge"/>
              <p class="help-block">Password should be at least 4 characters</p>
            </div>
          </div>
       
          <div class="control-group">
            <!-- Password -->
            <label class="control-label"  for="password_confirm">Password (Confirm)</label>
            <div class="controls">
              <form:input path="password" type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge"/>
              <p class="help-block">Please confirm password</p>
            </div>
          </div>
       
          <div class="control-group">
            <!-- Button -->
            <div class="controls">
              <button class="btn btn-primary">Register</button>
            </div>
          </div>
        </fieldset>
      </form:form >
      <br>
      <!--JQUERY-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<!--BOOTSTRAP-->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>