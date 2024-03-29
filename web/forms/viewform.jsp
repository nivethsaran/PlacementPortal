<%@ page import="models.Companyregistration" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 01-11-2020
  Time: 03:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./forms/styles1.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
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
    Companyregistration form = (Companyregistration) request.getAttribute("form");
%>
<div align="center">
    <h2>Amrita CIR Application Form</h2>
    <h2>Company Name: <% out.print(form.getCompanyname()); %></h2>
    <h2>CTC: <% out.print(form.getPay()); %></h2>
    <h2>Application Deadline: <% out.print(form.getDeadline()); %></h2>
    <iframe src="<%out.print(form.getFormurl());%>?embedded=true" width="640" height="703" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe>
</div>
</body>
</html>
