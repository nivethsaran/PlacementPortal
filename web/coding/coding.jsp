<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Coding" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 29-10-2020
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Coding" %>
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
<% String usertype = (String) request.getSession().getAttribute("usertype");
    if (request.getAttribute("problems") != null) {
        ArrayList<Coding> problems = (ArrayList<Coding>) request.getAttribute("problems");
        out.print("<script>var problemdescarr = [");
        for (int i = 0; i < problems.size(); i++) {
            out.print("'" + problems.get(i).getProblemdesc() + "',");
        }
        out.print("]\n");
        out.print("var problemdiffarr = [");
        for (int i = 0; i < problems.size(); i++) {
            out.print("'" + problems.get(i).getProblemdifficulty() + "',");
        }
        out.print("]");
        out.print("</script>");
    }
%>



<div class="container-fluid">

    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>Sample Questions</span>
                    <a class="d-flex align-items-center text-muted" href="#">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6>
                <ul id="leftpanel" class="nav flex-column">
                    <% if (request.getAttribute("problems") != null && usertype != null) {
                        ArrayList<Coding> problems = (ArrayList<Coding>) request.getAttribute("problems");
                        if (usertype.equals("student")) {
                            for (int i = 0; i < problems.size(); i++) {
//                            if(request.getSession().)
                                out.println("<li class=\"nav-item\" onclick=\"displayQuestion(" + problems.get(i).getProblemid() + ")\">\n" +
                                        "                        <a class=\"nav-link\" href=\"#\">\n" +
                                        "                            <span data-feather=\"home\"></span>\n"
                                        + problems.get(i).getProblemname() + "\n" +
                                        "                        </a>\n" +
                                        "                    </li>");
                            }
                        } else if (usertype.equals("faculty")) {
                            for (int i = 0; i < problems.size(); i++) {
//                            if(request.getSession().)
                                out.println("<li class=\"nav-item\">\n" +
                                        "<a href=\"addproblem?pid=" + problems.get(i).getProblemid() + "&edit=true\" class=\"nav-link\">" + problems.get(i).getProblemname() + "</a></li>");

                            }
                        }

                    }
                    %>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Code Module</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <button class="btn btn-sm btn-outline-secondary" onclick="clearCode()">Clear Code</button>
                        <button class="btn btn-sm btn-outline-secondary" onclick="copyCode()">Share</button>
                        <button class="btn btn-sm btn-outline-secondary" onclick="hideQuestion()">Hide Question</button>
                    </div>
                    <div class="dropdown">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="language-label"
                           data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Language (C)
                        </a>

                        <div class="dropdown-menu" id="language">
                            <a class="dropdown-item" onclick="changeCode('C')" href="#">C</a>
                            <a class="dropdown-item" onclick="changeCode('C++')" href="#">C++</a>
                            <a class="dropdown-item" onclick="changeCode('JAVA')" href="#">JAVA</a>
                            <a class="dropdown-item" onclick="changeCode('PYTHON')" href="#">PYTHON</a>
                        </div>
                    </div>
                </div>

            </div>
            <div class="question">

            </div>
            <textarea class="form-control" id="question" rows="5"
                      disabled hidden></textarea><br>
            <textarea name="code" id="code">//Enter Code here.....</textarea>
            <br>
            <br>

            <div class="form-group">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="custominput-check" onchange="toggleinput()">
                    <label class="form-check-label" for="custominput" id="custominput-label">Custom Input</label>
                </div>

                <textarea class="form-control" id="custominput" rows="5" onchange="validateinput()"
                          onkeyup="validateinput()"></textarea>
            </div>
            <input type="submit" value="Compile and Run" class="btn btn-dark" onclick="showCode()">
            <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>


        </main>
    </div>
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
<script src="https://codemirror.net/lib/codemirror.js"></script>
<script src="https://codemirror.net/mode/javascript/javascript.js"></script>
<script src="https://codemirror.net/mode/python/python.js"></script>
<script src="https://codemirror.net/mode/clike/clike.js"></script>
<script src="https://codemirror.net/addon/edit/closebrackets.js"></script>
<script src="https://codemirror.net/addon/lint/lint.js"></script>
<script src="./coding/js/index.js"></script>
</body>


</html>