<%@ page import="models.Faculty" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 31-10-2020
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Preparely</title>
    <link rel="stylesheet" href="./quiz/styles.css">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
</head>

<body onload="loadPage()">
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
<div style="margin-top: 50px;">

    <%
        if(request.getAttribute("message")!=null)
        {
            out.print("<div class=\"alert alert-primary\" role=\"alert\">\n" +
                    request.getAttribute("message") +
                    "</div>");
        }
    %>
    <form action="./addquiz" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="quizname" id="quizname-label">Quiz Name</label>
                <input type="text" class="form-control" name="quizname" id="quizname" onchange="validatenull('quizname')" onkeyup="validatenull('quizname')">
            </div>
            <div class="form-group col-md-6">
                <label for="nooq" id="nooq-label">Number of Questions</label>
                <select class="custom-select" id="nooq" name="nooq" onclick="changeNOOQ()" >
                </select>
            </div>

        </div>
        <div class="form-group">
            <label for="quizdesc" id="quizdesc-label">Quiz Description</label>
            <input type="text" class="form-control" name="quizdesc" id="quizdesc" placeholder="This quiz tests your knowledge on ...." onchange="validatenull('quizdesc')" onkeyup="validatenull('quizdesc')">
        </div>
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="date" id="date-label">Date of Exam</label>
                <input type="date" class="form-control" name="date" id="date" onblur="validdate()" onchange="validdate()">
            </div>
            <div class="form-group col-md-3">
                <label for="starttime" id="starttime-label">Start Window</label>
                <input type="time" class="form-control" name="starttime" id="starttime" onkeyup="validtime()" onchange="validtime()">
            </div>
            <div class="form-group col-md-3">
                <label for="endtime" id="endtime-label">End Window</label>
                <input type="time" class="form-control" name="endtime" id="endtime" onkeyup="validtime()" onchange="validtime()">
            </div>
            <div class="form-group col-md-3">
                <label for="duration" id="duration-label">Duration(in minutes)</label>
                <input type="number" class="form-control" name="duration" id="duration" onkeyup="validdur()" onchange="validdur()">
            </div>
        </div>
        <div class="form-row">

            <div class="form-group col-md-4">
                <label for="dept" id="dept-label">Department</label>
                <select id="dept" name="dept" class="form-control">
                    <option disabled selected>Choose</option>
                    <option value="CSE">CSE</option>
                    <option value="NONCSE">NON-CSE</option>
                    <option value="ALL">ALL</option>
                </select>
            </div>

            <div class="form-group col-md-4">
                <label for="topic" id="topic-label">Topic</label>
                <select name="topic" id="topic" class="form-control">
                    <option disabled selected>Choose</option>
                    <option value="Technical">Technical</option>
                    <option value="Verbal">Verbal</option>
                    <option value="Aptitude">Aptitude</option>
                    <option value="All">All</option>
                </select>
            </div>


            <div class="form-group col-md-4">
                <div class="custom-control custom-switch">
                    <input name="pinenabled" value="" type="checkbox" class="custom-control-input" id="enablepin" onclick="togglePin()">
                    <label class="custom-control-label" id="pin-label" for="enablepin">Pin</label>
                </div>
                <input type="hidden" name="facid" value="<%
                    Faculty faculty = (Faculty) request.getSession().getAttribute("userdata");
                    out.print(faculty.getFacultyid());
                %>">
                <input name="pin" type="number" class="form-control pin-ed-adjust" id="pin" placeholder="" onchange="validpin()" onkeyup="validpin()">
            </div>

        </div>

        <br>

        <br>

        <div class="questiondiv">
            <div class="cardList" id="cardlist"></div>
        </div>

        <br>
        <button type="submit" class="btn btn-info btn-submit-quiz">Add Quiz</button>
    </form>


</div>
<br><br>
<script src="./quiz/index.js"></script>
</body>

</html>
