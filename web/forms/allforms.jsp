<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Companyregistration" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 01-11-2020
  Time: 03:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title></title>
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
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Company Name</th>
        <th scope="col">Pay(In LPA)</th>
        <th scope="col">Application Deadline</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Companyregistration> forms = (ArrayList<Companyregistration>) request.getAttribute("forms");
        if (forms != null) {
            for (Companyregistration form : forms) {
                out.println("<tr>\n" +
                        "        <th scope=\"row\">"+form.getCompanyname()+"</th>\n" +
                        "        <td>"+form.getPay()+"</td>\n" +
                        "        <td>"+form.getDeadline()+"</td>\n" +
                        "        <td><a href=\"./apply?formid="+form.getFormid()+"\">Apply</a></td>\n" +
                        "    </tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
