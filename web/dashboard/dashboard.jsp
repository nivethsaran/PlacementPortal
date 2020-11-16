<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 30-10-2020
  Time: 04:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Dashboard Module</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,600;0,800;1,900&family=Ubuntu&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/5b3d13b8e0.js" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="./dashboard/dashboard.css">
</head>

<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark navgbar">
    <a class="navbar-brand" href="#">Preparely</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link logout" href="">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<section class="sec1">
    <div class="row">

                <div class="col1">
                    <img class="dp" src="./dashboard/images/dp.png" alt="">
                </div>
                <div class="col2">
                    <h3>Name : Niveth Saran</h3>
                    <br>
                    <h3>Roll Number : cb.en.u4cse17337</h3>
                    <br>
                    <h3>Email ID : niveth24@gmail.com</h3>
                    <br>
                    <div class="dropdown">
                        <button class="dropbtn btnn">View Quiz Score Histroy <i class="fas fa-chevron-down"></i></button>
                        <div id="quizscores" class="dropdown-content ">
                            <h4>38/50</h4>
                            <h4>30/50</h4>
                            <h4>40/50</h4>
                            <h4>45/50</h4>
                            <h4>14/50</h4>
                            <h4>30/50</h4>
                            <h4>48/50</h4>
                        </div>
                    </div>
                </div>
    </div>
</section>

<section class="sec2">
    <div class="row">
        <%  String usertype = (String) request.getSession().getAttribute("usertype");
            if(usertype!=null){
                if(usertype.equals("student"))
                {
                    out.print("<div class=\"col11\">\n" +
                            "            <h2>Other Modules</h2>\n" +
                            "            <a  href=\"./quiz\"><i class=\"fas fa-question-circle tomodules\">Quiz Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./calendar\"><i class=\"fas fa-calendar-week tomodules\">Calendar Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./course\"><i class=\"fas fa-book tomodules\">Courses Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./ide\"><i class=\"fas fa-code tomodules\">Code Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/7_companyreg/students\"><i class=\"fas fa-registered tomodules\">Company Registration Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/8_feedback/\"><i class=\"far fa-comment-dots tomodules\">Feedback Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/9_contact/\"><i class=\"fas fa-address-book tomodules\">Contact Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/10_placementexperience/admin/\"><i class=\"fas fa-scroll tomodules\">Placement Experience</i></a>\n" +
                            "            <br>\n" +
                            "        </div>");
                }
                else
                {
                    out.print("<div class=\"col11\">\n" +
                            "            <h2>Other Modules</h2>\n" +
                            "            <a  href=\"./quiz\"><i class=\"fas fa-question-circle tomodules\">Quiz Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./calendar\"><i class=\"fas fa-calendar-week tomodules\">Calendar Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./addcourse\"><i class=\"fas fa-book tomodules\">Courses Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"./addproblem\"><i class=\"fas fa-code tomodules\">Code Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/7_companyreg/students\"><i class=\"fas fa-registered tomodules\">Company Registration Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/8_feedback/\"><i class=\"far fa-comment-dots tomodules\">Feedback Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/9_contact/\"><i class=\"fas fa-address-book tomodules\">Contact Module</i></a>\n" +
                            "            <br>\n" +
                            "            <a  href=\"https://preparely.netlify.app/10_placementexperience/admin/\"><i class=\"fas fa-scroll tomodules\">Placement Experience</i></a>\n" +
                            "            <br>\n" +
                            "        </div>");
                }
            }
        %>

        <div class="col22">
            <h2>Recently Solved Problems</h2>
            <ul>
                <li><a  class="toprob" href="#" style="color:#FF0000;">3Sum Closest</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Add One Row to Tree</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Adding Two Negabinary Numbers</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Airplane Seat Assignment Probability</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">All Possible Full Binary Trees</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Allocate Mailboxes</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Backspace String Compare</a></li>
                <li><a class="toprob" href="#" style="color:#FF0000;">Best Time to Buy and Sell Stock with Cooldown</a></li>
            </ul>
        </div>
    </div>

</section>

<script src="./dashboard/dashboard.js" charset="utf-8"></script>
</body>

</html>
