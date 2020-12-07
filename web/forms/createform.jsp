<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 01-11-2020
  Time: 03:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="./forms/styles1.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
</head>
<body>
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
            <li class="nav-item">
                <a class="nav-link logout" href="./logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<%
    if(request.getAttribute("message")!=null)
    {
        out.print("<div class=\"alert alert-secondary\" role=\"alert\">\n" +
                request.getAttribute("message") +
                "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n" +
                "    <span aria-hidden=\"true\">&times;</span>\n" +
                "  </button></div>");
    }
%>
<div align="center">
    <h2>Company Registration Form</h2>

    <form action="./addform" method="post">
        <div class="form-group">
            <label for="companyname">Company Name</label>
            <input type="text" class="form-control col-lg-3" id="companyname" name="companyname"  placeholder="">
        </div>
        <div class="form-group">
            <label for="ctc">CTC in LPA</label>
            <input type="number" class="form-control col-lg-3" id="ctc" name="ctc" placeholder="">
        </div>
        <div class="form-group">
            <label for="deadline">Deadline</label>
            <input type="date" class="form-control col-lg-3" id="deadline" name="deadline" placeholder="">
        </div>
        <div class="form-group">
            <label for="url">Form URL</label>
            <input type="text" class="form-control col-lg-3" id="url" name="url" placeholder="">
        </div>
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
