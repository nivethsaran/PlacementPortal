<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 16-11-2020
  Time: 02:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="./coding/css/styles.css">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://codemirror.net/lib/codemirror.css">
    <link rel="stylesheet" href="https://codemirror.net/theme/material.css">
    <link rel="stylesheet" href="https://codemirror.net/addon/lint/lint.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
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

<div style="margin-top: 100px" class="container-fluid">
    <form action="/addproblem" method="post">
        <div class="form-group">
            <label for="questioname">Question Name</label>
            <input class="form-control" type="text" id="questioname" name="questionname" required><br>
            <label for="questiondesc" >Question Desciprtion</label>
            <textarea class="form-control" id="questiondesc" name="questiondesc" maxlength="500" required></textarea><br>
            <label for="difficulty">Difficulty</label>
            <select class="form-control" id="difficulty" name="difficulty"><br>
                <option value="Choose" disabled></option>
                <option value="Easy" selected>Easy</option>
                <option value="Medium">Medium</option>
                <option value="Difficult">Difficult</option>
            </select><br>
            <input class="btn btn-primary" type="submit" title="Add question">
        </div>
    </form>
</div>
<!-- JavaScript Libs -->

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script src="./coding/js/index.js"></script>
</body>


</html>
