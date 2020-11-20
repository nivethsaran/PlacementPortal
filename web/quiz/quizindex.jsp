<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Quiz" %>
<%@ page import="models.Scores" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="models.Faculty" %><%--
  Created by IntelliJ IDEA.
  User: Niveth_Saran
  Date: 31-10-2020
  Time: 12:21 AM
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


<%
    String usertype = (String) request.getSession().getAttribute("usertype");

%>
<div class="filtercontainer">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="dept" id="dept-label">Department</label>
            <select id="dept" class="form-control">
                <option disabled selected>Choose</option>
                <option value="CSE">CSE</option>
                <option value="NONCSE">NON-CSE</option>
                <option value="ALL">ALL</option>
            </select>
        </div>

        <div class="form-group col-md-4">
            <label for="topic" id="topic-label">Topic</label>
            <select id="topic" class="form-control">
                <option disabled selected>Choose</option>
                <option value="Technical">Technical</option>
                <option value="Verbal">Verbal</option>
                <option value="Aptitude">Aptitude</option>
                <option value="All">All</option>
            </select>
        </div>
    </div>
</div>
<div class="centerContainer">
    <div class="cardList" id="quizlistmain">
        <%
            ArrayList<Quiz> quizzes = (ArrayList<Quiz>) request.getAttribute("quizzes");
            for(int i=0;i<quizzes.size();i++)
            {
                Quiz quiz = quizzes.get(i);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String endtime = quiz.getQuizdate() + " " + quiz.getQuizendtime();
                long endtimelong = 0;
                try {
                    endtimelong   = sdf.parse(endtime).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(System.currentTimeMillis()<endtimelong)
                {
                    if(usertype.equals("student"))
                    {
                        out.print("<div class=\"card\">\n" +
                                "<form action=\"./questions\" method=\"post\">\n"+
                                "                <div class=\"cardData\">\n" +
                                "                    <h4 class=\"cardTitle\">"+quiz.getQuizname()+"</h4>\n" +
                                "                    <p class=\"cardSubTitle\">"+quiz.getQuizdescription()+"</p>\n" +
                                "                    <p class=\"cardTime\">Number of Questions:"+quiz.getNumofquestions()+"<br>Quiz Date:"+quiz.getQuizdate()+"<br>Start time:"+quiz.getQuizstarttime()+"<br>EndTime:"+quiz.getQuizendtime()+"<br>Duration:"+quiz.getDuration()+
                                "                    minutes<br>Department"+quiz.getDepartment()+"<br>Topic:"+quiz.getTopic()+"<br>Faculty Id:"+quiz.getFacultyid()+"</p>\n" +
                                "                    <input type=\"text\" name=\"pinstud\" placeholder=\"Enter PIN\">\n" +
                                "                    <input type=\"hidden\" name=\"quizid\" value=\""+quiz.getQuizid()+"\">"+
                                "                    <input type=\"submit\" class=\"pincheck\" title=\"Enter Quiz\">\n" +
                                "                </div></form>\n" +
                                "            </div>");
                    }
                    else if(usertype.equals("faculty"))
                    {
                            out.print("<div class=\"card\">\n" +
                                    "                <div class=\"cardData\">\n" +
                                    "                    <h4 class=\"cardTitle\">"+quiz.getQuizname()+"</h4>\n" +
                                    "                    <p class=\"cardSubTitle\">"+quiz.getQuizdescription()+"</p>\n" +
                                    "                    <p class=\"cardTime\">Number of Questions:"+quiz.getNumofquestions()+"<br>Quiz Date:"+quiz.getQuizdate()+"<br>Start time:"+quiz.getQuizstarttime()+"<br>EndTime:"+quiz.getQuizendtime()+"<br>Duration:"+quiz.getDuration()+
                                    "                    minutes<br>Department"+quiz.getDepartment()+"<br>Topic:"+quiz.getTopic()+"<br>Faculty Id:"+quiz.getFacultyid()+"</p>\n" +
                                    "                    <a href=\"./deleteQuiz?quizid="+quiz.getQuizid()+"\" class=\"pincheck\">Delete Quiz Details</a>\n" +
                                    "                </div>\n" +
                                    "            </div>");


                    }
                }


            }
        %>
    </div>
    <div class="topicList">
        <%
            if(usertype.equals("student"))
            {

            }
            else
            {
                out.print("<a type=\"button\" class=\"btn btn-info\" href=\"./addquiz\">Add Quiz</a>");
            }
        %>

        <br>

        <ul id="scorelist" class="list-group">
            <%
                if(request.getAttribute("scores")!=null)
                {
                    out.print("<div class=\"alert alert-light\" role=\"alert\">\n" +
                            "            Quiz Scores List\n" +
                            "        </div>");
                    ArrayList<Scores> scores = (ArrayList<Scores>) request.getAttribute("scores");
                    for(int i=0;i<scores.size();i++)
                    {
                        Scores score= scores.get(i);
                        out.println("<li class=\"list-group-item\">Quiz "+score.getQuizid()+":"+(double)score.getScore()/(double)score.getTotal()*100+"%</li>");
                    }
                }
            %>
        </ul>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="./quiz/index.js"></script>
</body>
</html>