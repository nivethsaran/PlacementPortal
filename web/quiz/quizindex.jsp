<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 31-10-2020
  Time: 12:21 AM
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
<body onload="loadXML()">
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



<div class="filtercontainer">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="dept" id="dept-label">Department</label>
            <select id="dept" class="form-control">
                <option disabled selected>Choose</option>
                <option value="CSE">CSE</option>
                <option value="NONCSE">NON-CSE</option>
                <option value="ALL">ALL</option>
            </select>
        </div>

        <div class="form-group col-md-4">
            <label for="topic" id="topic-label">Topic</label>
            <select id="topic" class="form-control">
                <option disabled selected>Choose</option>
                <option value="Technical">Technical</option>
                <option value="Verbal">Verbal</option>
                <option value="Aptitude">Aptitude</option>
                <option value="All">All</option>
            </select>
        </div>
    </div>
</div>
<div class="centerContainer">
    <div class="cardList" id="quizlistmain">

    </div>
    <div class="topicList">
        <button type="button" class="btn btn-info" onclick="window.location.href='addQuiz.html'">Add Quiz</button>
        <br>
        <div class="alert alert-light" role="alert">
            Quiz Scores List
        </div>
        <ul id="scorelist" class="list-group">
        </ul>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="./quiz/index.js"></script>
</body>
</html>