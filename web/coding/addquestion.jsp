<%@ page import="models.Faculty" %>
<%@ page import="models.Coding" %><%--
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

<%
    Coding problem =null;
    boolean update = false;
    if(request.getAttribute("problem")!=null)
    {
        problem =(Coding)request.getAttribute("problem");
        update = true;
    }

%>

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
    <form action="./addproblem" method="post">
        <div class="form-group">
            <%
                if(request.getAttribute("inserted")!=null)
                {
                    if((boolean)request.getAttribute("inserted"))
                    {
                        out.print("<div class=\"alert alert-success\" role=\"alert\">\n" +
                                "  Added successfully\n" +
                                "</div>");
                    }
                    else
                    {
                        out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                                "  Server error, try again later\n" +
                                "</div>");
                    }
                    request.setAttribute("inserted",null);
                }
            %>
            <a href="./ide" class="btn btn-primary"> View Problems </a>
            <br>
            <%
                if(!update)
                {
                    out.print("<h1>Add a new problem</h1>");
                }
                else
                {
                    out.print("<h1>Update the problem</h1>");
                }
            %>

            <br>
            <label for="questioname">Question Name</label>
            <input class="form-control" type="text" id="questioname" name="questionname" required value="<%
                if(update && problem!=null)
                    {
                        out.print(problem.getProblemname());
                    }
            %>"><br>
            <label for="questiondesc">Question Desciprtion</label>
            <textarea class="form-control" id="questiondesc" name="questiondesc" maxlength="500"
                      required><%
                if(update&& problem!=null)
                {
                    out.print(problem.getProblemdesc());
                }
            %></textarea><br>
            <label for="difficulty">Difficulty</label>
            <select class="form-control" id="difficulty" name="difficulty"><br>
                <%
                    if(update&& problem!=null)
                    {
                        if(problem.getProblemdifficulty().equals("Easy"))
                        {
                            out.print("<option value=\"Choose\" disabled></option>\n" +
                                    "                <option value=\"Easy\" selected>Easy</option>\n" +
                                    "                <option value=\"Medium\">Medium</option>\n" +
                                    "                <option value=\"Difficult\">Difficult</option>");
                        }
                        else if(problem.getProblemdifficulty().equals("Medium"))
                        {
                            out.print("<option value=\"Choose\" disabled></option>\n" +
                                    "                <option value=\"Easy\" >Easy</option>\n" +
                                    "                <option value=\"Medium\" selected>Medium</option>\n" +
                                    "                <option value=\"Difficult\">Difficult</option>");
                        }
                        else if(problem.getProblemdifficulty().equals("Difficult"))
                        {
                            out.print("<option value=\"Choose\" disabled></option>\n" +
                                    "                <option value=\"Easy\" >Easy</option>\n" +
                                    "                <option value=\"Medium\" >Medium</option>\n" +
                                    "                <option value=\"Difficult\" selected>Difficult</option>");
                        }
                        else
                        {
                            out.print("<option value=\"Choose\" disabled></option>\n" +
                                    "                <option value=\"Easy\" selected>Easy</option>\n" +
                                    "                <option value=\"Medium\">Medium</option>\n" +
                                    "                <option value=\"Difficult\">Difficult</option>");
                        }
                    }
                    else
                    {
                        out.print("<option value=\"Choose\" disabled></option>\n" +
                                "                <option value=\"Easy\" selected>Easy</option>\n" +
                                "                <option value=\"Medium\">Medium</option>\n" +
                                "                <option value=\"Difficult\">Difficult</option>");
                    }
                %>

            </select><br>
            <input type="hidden" name="facid" value="<%
                Faculty facid = (Faculty)request.getSession().getAttribute("userdata");
                out.print(facid.getFacultyid());%>">
            <input type="hidden" name="actiontype" value="<%
                if(update)
                {
                    out.print("update");
                }
                else
                {
                    out.print("add");
                }
            %>">
            <%
                if(update&& problem!=null) {
                    out.print("\n" +
                            "            <input type=\"hidden\" name=\"probid\" value=\""+problem.getProblemid()+"\">");
                }
            %>
            <input class="btn btn-primary" type="submit" title="<% if(request.getAttribute("update")!=null)
            {
                if((boolean)request.getAttribute("update"))
                {
                    out.print("Update");
                }
                else
                {
                    out.print("Add Problem");
                }
            }else
            {
                out.print("Add Problem");
            }
            %>">
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
