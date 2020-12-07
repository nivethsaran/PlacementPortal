<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 29-10-2020
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="shortcut icon" href="../favicon.ico">--%>
    <link rel="stylesheet" type="text/css" href="./authentication/css/styles_auth.css" />
    <link rel="stylesheet" type="text/css" href="./authentication/css/styles_faculty.css" />
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
<% if(request.getSession().getAttribute("usertype")!=null)
{
    response.sendRedirect("dashboard");
}
%>
<%--NAVBAR--%>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark navgbar">
    <a class="navbar-brand" href="./">Preparely</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link logout" href="./about">About</a>
            </li>
        </ul>
    </div>
</nav>
<%--END OF NAVBAR--%>

<div class="container">
    <header>
        <nav class="codrops-demos">
            <span>Click <strong>"Join us"</strong> to Login</span>
            <a href="faculty_auth" class="current-demo">Faculty</a>
            <a href="student_auth">Student</a>
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form method="POST" action="./dashboard" autocomplete="off" >
                        <h1>Faculty Log in</h1>
                        <%
                            if(request.getAttribute("message")!=null)
                            {
                                out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                                        request.getAttribute("message")+"\n" +
                                        "</div>");
                            }
                        %>


                        <p>
                            <label for="facidsignin" class="uname" data-icon="u" > Your faculty ID </label>
                            <input id="facidsignin" name="facidsignin" required="required" type="text" placeholder="Enter username" onkeyup="validateUserLogin()" onchange="validateUserLogin()"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="Enter password" onkeyup="validatePassLogin()" onchange="validatePassLogin()"/>
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="Yes" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <input type="hidden" name="actiontype" value="faclogin">
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
                    <form method="post" action="./faculty_auth" autocomplete="on">
                        <h1> Faculty Sign up </h1>

                        <p>
                            <label for="fullname" class="fullname" data-icon="u">Your full name</label>
                            <input id="fullname" name="fullname" required="required" type="text" placeholder="Enter Full name" onkeyup="validateFullReg()" onchange="validateFullReg()"/>
                        </p>
                        <p>
                            <label for="facidsignup" class="uname" data-icon="u">Your faculty ID</label>
                            <input id="facidsignup" name="facidsignup" required="required" type="text" placeholder="Enter faculty ID here" onkeyup="validateUserReg()" onchange="validateUserReg()"/>
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
                            <label for="imageurl" class="imageurl" data-icon="u">Enter image url </label>
                            <input id="imageurl" name="imageurl" required="required" type="text" placeholder="Enter image url here" onkeyup="validateImageURL()" onchange="validateImageURL()"/>
                        </p>
                        <p>
                            <label for="mobile" class="mobile" data-icon="u">Enter mobile Number </label>
                            <input id="mobile" name="mobile" required="required" type="number" placeholder="Enter mobile number here" onkeyup="validateMobile()" onchange="validateMobile()"/>
                        </p>
                        <input type="hidden" name="actiontype" value="facsignup">
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
<script src="./authentication/js/index_fac.js"></script>
</body>
</html>