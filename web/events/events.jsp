<%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 01-11-2020
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src = "./events/calendar-script.js"></script>

    <link rel="stylesheet" type="text/css" href="./events/styles.css" />
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <title>Calendar</title>
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

<br>
<br>
<br>

<div class="content">
    <div class="calendar-container">
        <div class="calendar">
            <div class="year-header">
                <span class="left-button" id="prev"> &lang; </span>
                <span class="year" id="label"></span>
                <span class="right-button" id="next"> &rang; </span>
            </div>
            <table class="months-table">
                <tbody>
                <tr class="months-row">
                    <td class="month">Jan</td>
                    <td class="month">Feb</td>
                    <td class="month">Mar</td>
                    <td class="month">Apr</td>
                    <td class="month">May</td>
                    <td class="month">Jun</td>
                    <td class="month">Jul</td>
                    <td class="month">Aug</td>
                    <td class="month">Sep</td>
                    <td class="month">Oct</td>
                    <td class="month">Nov</td>
                    <td class="month">Dec</td>
                </tr>
                </tbody>
            </table>

            <table class="days-table">
                <td class="day">Sun</td>
                <td class="day">Mon</td>
                <td class="day">Tue</td>
                <td class="day">Wed</td>
                <td class="day">Thu</td>
                <td class="day">Fri</td>
                <td class="day">Sat</td>
            </table>
            <div class="frame">
                <table class="dates-table">
                    <tbody class="tbody">
                    </tbody>
                </table>
            </div>

            <%
                //Remove '@'
                if (request.getSession().getAttribute("usertype") == "faculty")
                {
            %>
                <button class="button" id="add-button">Add Event</button>

            <% }
            %>

        </div>
    </div>
    <div class="events-container">
    </div>
    <div class="dialog" id="dialog">
        <h2 class="dialog-header"> Add New Event </h2>
        <form class="form" id="form" action = "./calendar" method = "POST">
            <div class="form-container" align="center">
                <label class="form-label" id="valueFromMyButton" for="name">Event name</label>
                <input class="input" type="text" id="name" maxlength="36" name = "eventname">
                <label class="form-label" id="valueFromMyButton1" for="count">Event description</label>
                <input class="input" type="text" id="count" name = "eventdesc">
                <input type = "hidden" name = "eventdate" value = "2020-12-08" id = "inDate">
                <input type = "hidden" name = "eventid" value = "23451" id = "inID">
                <input type="button" value="Cancel" class="button" id="cancel-button">
                <input type="submit" value="OK" class="button" id="ok-button">
                <script>
                    setValues();
                </script>

            </div>
        </form>
    </div>
</div>
<!-- Dialog Box-->
<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous">
</script>
<script src="./calendar-script.js"></script>
</body>
</html>
