<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Question" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 31-10-2020
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Preparely</title>
    <link rel="stylesheet" href="./quiz/styles.css">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
          integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
</head>

<body onload="quiztimer()">
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


<div id="quiz" class="quiz">


    <div id="timer" class="timer btn btn-info"><span>Timer:</span><span  id="mins"></span> <span  id="secs"></span> <span  id="end"></span></div>

    <div id="questions" class="questions">
        <%
            ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
            if(questions!=null)
            {
                for(Question i : questions)
                {
                    out.print("<p>Question "+i.getQuestionid()+":"+i.getQuestioncontent()+"</p>" +
                            "<label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"a\">" +" optiona</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"b\">" + "optionb</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"c\">" + "optionc</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"d\">" + "optiond</label><hr>");
                }
            }

        %>
    </div>
    <br>
    <button type="button" id="submitbtn" onclick="submitQuiz()" class="btn btn-danger">Submit</button>
    <h6 id="messageclose" hidden>Close the tab after the quiz is over</h6>
</div><br>

<script src="./quiz/index.js" ></script>
</body>
</html>
