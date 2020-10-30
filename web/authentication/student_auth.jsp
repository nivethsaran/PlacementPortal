<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 29-10-2020
  Time: 09:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="shortcut icon" href="../favicon.ico">--%>
    <link rel="stylesheet" type="text/css" href="./authentication/css/styles_auth.css" />
    <link rel="stylesheet" type="text/css" href="./authentication/css/styles_student.css" />
    <link rel="stylesheet" type="text/css" href="./authentication/css/animate-custom.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light navbar-transparent fixed-top">
    <a class="navbar-brand" href="#">Preparely</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fas fa-home"></i></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#"><i class="fas fa-book"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="fas fa-star-half-alt"></i></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">

    <header>
        <nav class="codrops-demos">
            <span>Click <strong>"Join us"</strong> to Login</span>
            <a href="faculty_auth">Faculty</a>
            <a href="student_auth" class="current-demo">Student</a>
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  method="POST" action="/PlacementPortalFrontend_war_exploded/dashboard" autocomplete="on">
                        <h1>Student Log in</h1>
                        <p>
                            <label for="rollno" class="uname" data-icon="u" > Your email or username </label>
                            <input id="rollno" name="rollno" required="required" type="text" placeholder="myusername or mymail@mail.com" onkeyup="validateUserLogin()" onchange="validateUserLogin()"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" onkeyup="validatePassLogin()" onchange="validatePassLogin()"/>
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Login" />
                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister" class="to_register">Join us</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form method="post" action="/PlacementPortalFrontend_war_exploded/student_auth" autocomplete="on">
                        <h1> Student Sign up </h1>

                        <p>
                            <label for="fullname" class="fullname" data-icon="p">Your password </label>
                            <input id="fullname" name="fullname" required="required" type="password" placeholder="Enter Full name" onkeyup="validateFullReg()" onchange="validateFullReg()"/>
                        </p>
                        <p>
                            <label for="facidsignup" class="uname" data-icon="u">Your username</label>
                            <input id="facidsignup" name="facidsignup" required="required" type="text" placeholder="Enter username here" onkeyup="validateUserReg()" onchange="validateUserReg()"/>
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="Enter email here" onkeyup="validateEmailReg()" onchange="validateEmailReg()"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="Enter password" onkeyup="validatePassReg()" onchange="validatePassReg()"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="Re enter password" onkeyup="validatePassConfirmReg()" onchange="validatePassConfirmReg()"/>
                        </p>
                        <p>
                            <label for="imageurl" class="imageurl" data-icon="p">Please confirm your password </label>
                            <input id="imageurl" name="imageurl" required="required" type="text" placeholder="eg. X8df!90EO" onkeyup="validateImageURL()" onchange="validateImageURL()"/>
                        </p>
                        <p>
                            <label for="mobile" class="mobile" data-icon="p">Please confirm your password </label>
                            <input id="mobile" name="mobile" required="required" type="number" placeholder="eg. X8df!90EO" onkeyup="validateMobile()" onchange="validateMobile()"/>
                        </p>
                        <input type="hidden" name="actiontype" value="signup">
                        <p class="signin button">
                            <input type="submit" value="Sign up"/>
                        </p>
                        <p class="change_link">
                            Already a member ?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
<script src="./authentication/js/index_stud.js"></script>
</body>
</html>
