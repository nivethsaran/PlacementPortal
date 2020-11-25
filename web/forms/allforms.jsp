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
