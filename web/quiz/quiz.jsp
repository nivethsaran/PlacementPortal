<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Question" %>
<%@ page import="models.Quiz" %><%--
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

<body <%
    ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
    Quiz quiz = (Quiz) request.getAttribute("quiz");
    if(questions!=null){
        long endTime = (long) request.getAttribute("endtime");
        out.print("onload=quiztimer("+endTime+")");
    }

%>>

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


<div id="quiz" class="quiz">


    <div id="timer" class="timer btn btn-info"><span>Timer:</span><span  id="mins"></span> <span  id="secs"></span> <span  id="end"></span></div>

    <div id="questions" class="questions">
        <%

            if(questions!=null)
            {
                out.print("<form id=\"mainquizform\" action=\"./submitquiz\" method=\"post\">");
                for(Question i : questions)
                {
                    out.print("<p>Question "+i.getQuestionid()+":"+i.getQuestioncontent()+"</p>" +
                            "<label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"a\">" + i.getOptiona() +"</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"b\">" + i.getOptionb() +"</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"c\">" + i.getOptionc() +"</label><label><input type=\"radio\" name=\"question"+i.getQuestionid()+"\" id=\"question"+i.getQuestionid()+"\" " +
                            "value=\"d\">" + i.getOptiond() +"</label><hr>");
                }

            }

        %>
    </div>
    <br>
    <%out.print("<input type=\"hidden\" value=\""+quiz.getQuizid()+"\" name=\"quizid\">");%>
    <input type="submit" id="submitbtn" class="btn btn-danger" title="Submit">
    <% out.print("</form>"); %>
    <h6 id="messageclose" hidden>Close the tab after the quiz is over</h6>
</div><br>

<script src="./quiz/index.js" ></script>
</body>
</html>
