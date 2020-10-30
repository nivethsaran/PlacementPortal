<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 31-10-2020
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course</title>

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

    <!-- custom styles -->
    <link rel="stylesheet" href="./courses/admin/styles.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
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
    <form class="form-box" action="" id="add-course-form" method="POST">
        <br><br><br><br>
        <h3 class="display-3 text-center">Add Course Videos</h3><br>
        <small>
            <span class="compulsory">*</span> <span class="text-muted">Compulsory</span>
        </small>
        <br><br>
        <!-- course selection for feedback -->
        <div class="form-group">
            <label for="course" class="lead">Course <span class="compulsory">*</span></label>
            <select class="form-control" id="course-name">
                <option class="text-muted" disabled>Select Course</option>
                <option>Course 1</option>
                <option>Course 2</option>
                <option>Course 3</option>
                <option>Course 4</option>
                <option>Course 5</option>
            </select>
        </div><br>
        <!-- course name input -->
        <div class="form-group">
            <label for="topic" class="lead">Enter Topic Name <span class="compulsory">*</span></label>
            <input type="text" class="form-control" id="course-topic-name" name="topic">
        </div><br>
        <!-- course video URL input -->
        <div class="form-group">
            <label for="url" class="lead">Enter URL for course video <span class="compulsory">*</span></label>
            <input type="url" class="form-control" id="course-url" name="url">
        </div><br>
        <!-- preview -->
        <!-- initially hidden -->
        <!-- once the urlfield is filled and out off focus, we must show preview by filling the url in the src of iframe -->
        <div id="preview">
            <h4 class="display-4 text-muted text-center">Preview</h4>
            <iframe id="preview-video" src="#" allowfullscreen="allowfullscreen">
            </iframe>
            <!-- <p id="preview-video"></p> -->
        </div>
        <!-- submit -->
        <input type="submit" class="btn btn-light">
        <br><br>
        <!-- danger box -->
        <div class="alert alert-danger alert-dismissible fade show" role="alert" id="addCourse-danger">
            <strong>Invalid.</strong> Form submission unsuccessful.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <!-- success box -->
        <div class="alert alert-success" role="alert" id="addCourse-success">
            Form submitted successfully!!!
        </div>
        <br><br>
    </form>
</div>

<!-- script -->
<script src="./courses/admin/script.js"></script>
</body>

</html>
