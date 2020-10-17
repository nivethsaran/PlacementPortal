function loadPage()
{
    nooq ="<option value=\"1\" selected>1</option>"
    for (var i = 2; i <= 10; i++) {
        nooq += "<option value=" + i + ">" + i + "</option>\n"
    }
    document.getElementById("nooq").innerHTML=nooq


    
    if (document.getElementById("enablepin").checked==true)
    {
        document.getElementById("pin").disabled=false;
    }
    else{
        document.getElementById("pin").disabled = true;
    }
    changeNOOQ()
}

function togglePin()
{
    if (document.getElementById("enablepin").checked==true)
    {
        document.getElementById("pin").disabled=false;
    }
    else{
        document.getElementById("pin").disabled = true;
        document.getElementById("pin-label").innerText = "Pin"
        document.getElementById("pin-label").style.color = "black"
    }
}

function validpin()
{
    var pin= document.getElementById("pin").value
    if(pin=="" || pin.length!=4)
    {   
        document.getElementById("pin-label").innerText="Pin (Invalid)"
        document.getElementById( "pin-label").style.color = "red"
    }
    else{
        document.getElementById("pin-label").innerText = "Pin"
        document.getElementById("pin-label").style.color = "black"
    }
}

function loadXML()
{
    var xmlhttp1 = new XMLHttpRequest();
  xmlhttp1.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadIndex(new DOMParser().parseFromString(this.responseText,"text/xml"))
        // loadIndex(this)
    }
  };
  xmlhttp1.overrideMimeType("text/xml");
  xmlhttp1.open("GET", "..\\..\\review2\\XML\\quiz.xml", true);
  xmlhttp1.send();

  var xmlhttp2 = new XMLHttpRequest();
  xmlhttp2.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadScores(new DOMParser().parseFromString(this.responseText,"text/xml"))
        // loadIndex(this)
    }
  };
  xmlhttp2.overrideMimeType("text/xml");
  xmlhttp2.open("GET", "..\\..\\review2\\XML\\scores.xml", true);
  xmlhttp2.send();

}
function loadQuizXML(){
    var xmlhttp1 = new XMLHttpRequest();
  xmlhttp1.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadQuestions(new DOMParser().parseFromString(this.responseText,"text/xml"))
        // loadIndex(this)
    }
  };
  xmlhttp1.overrideMimeType("text/xml");
  xmlhttp1.open("GET", "..\\..\\review2\\XML\\question.xml", true);
  xmlhttp1.send();
}

function loadQuestions()
{
    var x = xmlDoc.getElementsByTagName("question");
    console.log(x[0]);
    quizlistinnerhtml=""
    for(var i=0;i<x.length;i++)
    {
         var quizid=x[i].getElementsByTagName("quizid")[0].childNodes[0].nodeValue;
        var questionid=x[i].getElementsByTagName("questionid")[0].childNodes[0].nodeValue;
        var questioncontent=x[i].getElementsByTagName("questioncontent")[0].childNodes[0].nodeValue;
        var answer=x[i].getElementsByTagName("answer")[0].childNodes[0].nodeValue;
        var studentscore=x[i].getElementsByTagName("studentscore")[0].childNodes[0].nodeValue;
        quizlistinnerhtml += '<li class="list-group-item">Quiz '+quizid+':'+(studentscore/total*100)+'%</li>'+'\n'
    }
    document.getElementById('scorelist').innerHTML=quizlistinnerhtml
}
function loadScores(xmlDoc)
{
    var x = xmlDoc.getElementsByTagName("score");
    console.log(x[0]);
    quizlistinnerhtml=""
    for(var i=0;i<x.length;i++)
    {
         var scoreid=x[i].getElementsByTagName("scoreid")[0].childNodes[0].nodeValue;
        var quizid=x[i].getElementsByTagName("quizid")[0].childNodes[0].nodeValue;
        var rollno=x[i].getElementsByTagName("rollno")[0].childNodes[0].nodeValue;
        var total=x[i].getElementsByTagName("total")[0].childNodes[0].nodeValue;
        var studentscore=x[i].getElementsByTagName("studentscore")[0].childNodes[0].nodeValue;
        quizlistinnerhtml += '<li class="list-group-item">Quiz '+quizid+':'+(studentscore/total*100)+'%</li>'+'\n'
    }
    document.getElementById('scorelist').innerHTML=quizlistinnerhtml
}


function loadIndex(xmlDoc)
{
    // var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("quiz");
    console.log(x[0]);
    quizlistinnerhtml=""
    for(var i=0;i<x.length;i++)
    {
         var quizid=x[i].getElementsByTagName("quizid")[0].childNodes[0].nodeValue;
        var facultyid=x[i].getElementsByTagName("facultyid")[0].childNodes[0].nodeValue;
        var quizname=x[i].getElementsByTagName("quizname")[0].childNodes[0].nodeValue;
        var quizdescription=x[i].getElementsByTagName("quizdescription")[0].childNodes[0].nodeValue;
        var numofquestions=x[i].getElementsByTagName("numofquestions")[0].childNodes[0].nodeValue;
        var quizdate=x[i].getElementsByTagName("quizdate")[0].childNodes[0].nodeValue;
        var quizstarttime=x[i].getElementsByTagName("quizstarttime")[0].childNodes[0].nodeValue;
        var quizendtime=x[i].getElementsByTagName("quizendtime")[0].childNodes[0].nodeValue;
        var duration=x[i].getElementsByTagName("duration")[0].childNodes[0].nodeValue;
        var department=x[i].getElementsByTagName("department")[0].childNodes[0].nodeValue;
        var topic=x[i].getElementsByTagName("topic")[0].childNodes[0].nodeValue;
        var pin=x[i].getElementsByTagName("pin")[0].childNodes[0].nodeValue;
        quizlistinnerhtml += `<div class="card" onclick=quizonclick(`+i+`)>
                <div class="cardData">
                    <h4 class="cardTitle">`+quizname+`</h4>
                    <p class="cardSubTitle">`+quizdescription+`</p>
                    <p class="cardTime">`+"Number of Questions:"+numofquestions+"<br>Quiz Date:"+quizdate+"<br>Start time:"+quizstarttime+"<br>EndTime:"+quizendtime+"<br>Duration:"+duration+"\n"+
                    " minutes<br>Department"+department+"<br>Topic:"+topic+"<br>Faculty Id:"+facultyid+`</p>
                    <input type="text" placeholder="Enter PIN">
                    <a href="quiz.html" target="_blank" class="pincheck">Start Quiz</a>
                </div>
            </div>`
    }
    document.getElementById('quizlistmain').innerHTML=quizlistinnerhtml
}


function validatenull(idname)
{
    var val=document.getElementById(idname).value
    if(val==''||val==undefined)
    {
        if(idname=="quizname")
        {
            document.getElementById(idname + "-label").innerText = "Quiz Name (*Required)"
        }
        else{
            document.getElementById(idname + "-label").innerText = "Quiz Description (*Required)"
        }
        document.getElementById(idname+"-label").style.color="red"
    }
    else {
        if (idname == "quizname") {
            document.getElementById(idname + "-label").innerText = "Quiz Name"
        }
        else {
            document.getElementById(idname + "-label").innerText = "Quiz Description"
        }
        document.getElementById(idname + "-label").style.color = "black"
    }
}

function validdate(){
    var GivenDate = document.getElementById("date").value;
    var CurrentDate = new Date();
    GivenDate = new Date(GivenDate);

    if (GivenDate < CurrentDate) {
        document.getElementById("date-label").innerText="Date of Exam(Invalid)";
        document.getElementById("date-label").style.color="red"
    } else {
        document.getElementById("date-label").innerText = "Date of Exam";
        document.getElementById("date-label").style.color = "black"
    }
}

function validtime()
{
    starttime=document.getElementById("starttime").value
    endtime=document.getElementById("endtime").value
    if(starttime!="" && endtime!="")
    {
        sarr = starttime.split(":")
        earr = endtime.split(":")
        sh=parseInt(sarr[0])
        sm=parseInt(sarr[1])
        eh=parseInt(earr[0])
        em=parseInt(earr[1])
        console.log(sh+" "+sm+" "+eh+" "+em);
        if(sh>eh)
        {
            document.getElementById("starttime-label").innerText="Start Window(Invalid)"
            document.getElementById("endtime-label").innerText = "End Window(Invalid)"
            document.getElementById("starttime-label").style.color = "red"
            document.getElementById("endtime-label").style.color = "red"
        }
        else if(sh==eh && sm>em)
        {
            document.getElementById("starttime-label").innerText = "Start Window(Invalid)"
            document.getElementById("endtime-label").innerText = "End Window(Invalid)"
            document.getElementById("starttime-label").style.color = "red"
            document.getElementById("endtime-label").style.color = "red"
        }
        else{
            document.getElementById("starttime-label").innerText = "Start Window"
            document.getElementById("endtime-label").innerText = "End Window"
            document.getElementById("starttime-label").style.color = "black"
            document.getElementById("endtime-label").style.color = "black"
        }

    }
    else{
    }

}

function validdur()
{
    duration=document.getElementById("duration").value
    starttime = document.getElementById("starttime").value
    endtime = document.getElementById("endtime").value
    if (starttime != "" && endtime != "") {
        sarr = starttime.split(":")
        earr = endtime.split(":")
        sh = parseInt(sarr[0])
        sm = parseInt(sarr[1])
        eh = parseInt(earr[0])
        em = parseInt(earr[1])
        dur=(eh-sh)*60+(em-sm)
        if(duration!="")
        {
            if (parseInt(duration) > dur) {
                document.getElementById("duration-label").innerText = "Duration (Enter Valid Data)"
                document.getElementById("duration-label").style.color = "red"
            }
            else {

                document.getElementById("duration-label").innerText = "Duration (in minutes)"
                document.getElementById("duration-label").style.color = "black"
            }
        }
        else{
            document.getElementById("duration-label").innerText = "Duration (Enter Valid Data)"
            document.getElementById("duration-label").style.color = "red"
        }
    }
    else{
        document.getElementById("starttime-label").innerText = "Start Window(Fill these)"
        document.getElementById("endtime-label").innerText = "End Window(Fill these)"
        document.getElementById("starttime-label").style.color = "red"
        document.getElementById("endtime-label").style.color = "red"
    }
}

function questionvalid(i)
{
    
    var question=document.getElementById("question"+i).value
    console.log(question)
    if(question=="")
    {
        document.getElementById("question"+i+"-label").innerText = "Question"+i+"(Invalid)";
        document.getElementById("question"+i+"-label").style.color = "red"
    }
    else
    {
        document.getElementById("question"+i+"-label").innerText = "Question" + i;
        document.getElementById("question"+i+"-label").style.color = "black"
    }
}

function optionavalid(i) {

    var question = document.getElementById("opt" + i+"a").value
    console.log(question)
    if (question == "") {
        document.getElementById("opt" + i + "a" + "-label").innerText = "Invalid Option";
        document.getElementById("opt" + i + "a" + "-label").style.color = "red"
    }
    else {
        document.getElementById("opt" + i + "a"+ "-label").innerText = "";
        document.getElementById("opt" + i + "a" + "-label").style.color = "black"
    }
}
function optionbvalid(i) {

    var question = document.getElementById("opt" + i + "b").value
    console.log(question)
    if (question == "") {
        document.getElementById("opt" + i + "b" + "-label").innerText = "Invalid Option";
        document.getElementById("opt" + i + "b" + "-label").style.color = "red"
    }
    else {
        document.getElementById("opt" + i + "b" + "-label").innerText = "";
        document.getElementById("opt" + i + "b" + "-label").style.color = "black"
    }
}
function optioncvalid(i) {

    var question = document.getElementById("opt" + i + "c").value
    console.log(question)
    if (question == "") {
        document.getElementById("opt" + i + "c" + "-label").innerText = "Invalid Option";
        document.getElementById("opt" + i + "c" + "-label").style.color = "red"
    }
    else {
        document.getElementById("opt" + i + "c" + "-label").innerText = "";
        document.getElementById("opt" + i + "c" + "-label").style.color = "black"
    }
}

function optiondvalid(i) {

    var question = document.getElementById("opt" + i + "d").value
    console.log(question)
    if (question == "") {
        document.getElementById("opt" + i + "d" + "-label").innerText = "Invalid Option";
        document.getElementById("opt" + i + "d" + "-label").style.color = "red"
    }
    else {
        document.getElementById("opt" + i + "d" + "-label").innerText = "";
        document.getElementById("opt" + i + "d" + "-label").style.color = "black"
    }
}


function quizonclick(a) {
    // alert(a);
}


function quiztimer()
{
    loadQuizXML();
    var start = new Date().getTime();
    var end = start + (1000 * 60 * 0.2)
    var myfunc = setInterval(function () {
        
        console.log(start + " " + end);
        // code goes here
        var now = new Date().getTime();
        var timeleft = end - now;
        var minutes = Math.floor((timeleft % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((timeleft % (1000 * 60)) / 1000);

        document.getElementById("mins").innerHTML = minutes + "m "
        document.getElementById("secs").innerHTML = seconds + "s"


        
        if (timeleft < 0) {
            clearInterval(myfunc);
            document.getElementById("mins").innerHTML = ""
            document.getElementById("secs").innerHTML = ""
            document.getElementById("end").innerHTML = "TIME UP!!";
            document.getElementById("timer").classList.add("btn-danger")
            submitQuiz()
        }


        
    }, 1000)
    
}

answers=['a','b','c','d','a']
function submitQuiz()
{  
    score=0
    for(var i=0;i<5;i++)
    {
        var ans = document.getElementsByName('question'+(i+1));
        var ans_value;
        for (var j = 0; j < ans.length; j++) {
            if (ans[j].checked) {
                ans_value = ans[j].value;
            }
        }
        if(ans_value==answers[i])
        {
            score++ 
        }
    }
    alert(score)
    document.getElementById("submitbtn").disabled=true
    document.getElementById("messageclose").hidden=false
}

