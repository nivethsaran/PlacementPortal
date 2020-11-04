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
    <link rel="stylesheet" href="./events/styles.css">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <script src = "./events/calendar-script.js"></script>
    <title>Calendar</title>
</head>
<body>
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
<div class="calendar">

    <div class="col leftCol">
        <div class="content">
            <h1 class="date">Friday<span>September 12th</span></h1>

            <ul class = "noteList">
                <li>Add Note<a href="#" title="Add note" class="addNote animate" onclick = "addNote()">+</a></li>
            </ul>
            <br>
            <div class="notes" id = "note_div">
            </div>
        </div>
    </div>

    <div class="col rightCol">
        <div class="content">
            <h2 class="year">2013</h2>
            <ul class="months">
                <li><a href="#" title="Jan" data-value="1" onclick = "highlight_month(this.id)" id = "jan">Jan</a></li>
                <li><a href="#" title="Feb" data-value="2" onclick = "highlight_month(this.id)" id = "feb">Feb</a></li>
                <li><a href="#" title="Mar" data-value="3" onclick = "highlight_month(this.id)" id = "mar">Mar</a></li>
                <li><a href="#" title="Apr" data-value="4" onclick = "highlight_month(this.id)" id = "apr">Apr</a></li>
                <li><a href="#" title="May" data-value="5" onclick = "highlight_month(this.id)" id = "may">May</a></li>
                <li><a href="#" title="Jun" data-value="6" onclick = "highlight_month(this.id)" id = "jun">Jun</a></li>
                <li><a href="#" title="Jul" data-value="7" onclick = "highlight_month(this.id)" id = "jul">Jul</a></li>
                <li><a href="#" title="Aug" data-value="8" onclick = "highlight_month(this.id)" id = "aug">Aug</a></li>
                <li><a href="#" title="Sep" data-value="9" onclick = "highlight_month(this.id)" id = "sep">Sep</a></li>
                <li><a href="#" title="Oct" data-value="10" onclick = "highlight_month(this.id)" id = "oct">Oct</a></li>
                <li><a href="#" title="Nov" data-value="11" onclick = "highlight_month(this.id)" id = "nov">Nov</a></li>
                <li><a href="#" title="Dec" data-value="12" onclick = "highlight_month(this.id)" id = "dec">Dec</a></li>
            </ul>
            <div class="clearfix"></div>
            <ul class="weekday">
                <li><a href="#" title="Mon" data-value="1">Mon</a></li>
                <li><a href="#" title="Tue" data-value="2">Tue</a></li>
                <li><a href="#" title="Wed" data-value="3">Wed</a></li>
                <li><a href="#" title="Thu" data-value="4">Thu</a></li>
                <li><a href="#" title="Fri" data-value="5">Fri</a></li>
                <li><a href="#" title="Say" data-value="6">Sat</a></li>
                <li><a href="#" title="Sun" data-value="7">Sun</a></li>
            </ul>
            <div class="clearfix"></div>
            <ul class="days">
                <script>
                    for (var _i = 1; _i <= 31; _i += 1) {
                        var _addClass = '';
                        if (_i === 12) { _addClass = ' class="selected"'; }

                        switch (_i) {
                            case 8:
                            case 10:
                            case 27:
                                _addClass = ' class="event"';
                                break;
                        }

                        document.write('<li><a href="#" title="' + _i + '" data-value="' + _i + '"' + _addClass + '>' + _i + '</a></li>');
                    }
                </script>
            </ul>
            <div class="clearfix"></div>
        </div>
    </div>

    <div class="clearfix"></div>

</div>


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
<%--<script src="./events/calendar-script.js">--%>
    </body>
    </html>
