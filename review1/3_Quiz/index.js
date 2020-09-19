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

function changeNOOQ()
{

    

    let count=parseInt(document.getElementById("nooq").value)

    cardlistinnerhtml ="<h2>Questions</h2><br>"
    for(var i=1;i<=count;i++)
    {
        cardlistinnerhtml += `<div class=\"card\">\n
            <div class=\"cardData\">\n
                <label for=\"question`+ i + `\" id=\"question`+ i + `-label\">Question `+i+`</label>\n
                <input type=\"text\\" class=\"form-control\" id=\"question`+ i + `\"  onclick = \"questionvalid(` + i + `)\" onkeyup = \"questionvalid(` + i + `)\" >\n
            <br >\n
            <div class=\"form-row\">\n
            <div class=\"input-group col-md-2\">\n
            <label for=\"opt`+ i + `a\" id=\"opt`+ i + `a-label\"></label>\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i + `a\" placeholder=\"option a\" onclick = \"optionavalid(` + i + `)\" onkeyup = \"optionavalid(` + i + `)\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <label for=\"opt`+ i + `b\" id=\"opt`+ i + `b-label\"></label>\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i + `b\" placeholder=\"option b\" onclick = \"optionbvalid(` + i + `)\" onkeyup = \"optionbvalid(` + i + `)\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <label for=\"opt`+ i + `c\" id=\"opt`+ i + `c-label\"></label>\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i + `c\" placeholder=\"option c\" onclick = \"optioncvalid(` + i + `)\" onkeyup = \"optioncvalid(` + i + `)\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <label for=\"opt`+ i + `d\" id=\"opt`+ i + `d-label\"></label>\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i + `d\" placeholder=\"option d\" onclick = \"optiondvalid(` + i + `)\" onkeyup = \"optiondvalid(` + i + `)\">\n
                          </div >\n
            <div class=\"form-group col-md-4\">\n
            <select id =\"correct`+ i +`\" class=\"form-control\">\n
            <option  disabled> Correct Option</option >\n
            <option selected value =\"a\">a</option>\n
            <option value =\"b\">b</option>\n
            <option value =\"c\">c</option>\n
            <option value =\"d\">d</option>\n
                                                </select >\n
                                            </div >\n
                                        </div >\n
                                    </div></div><br>`
    }
    document.getElementById("cardlist").innerHTML=cardlistinnerhtml
    
}

function loadIndex()
{
    quizlistinnerhtml=""
    for(var i=1;i<=10;i++)
    {
        quizlistinnerhtml += `<div class="card" onclick=quizonclick(`+i+`)>
                <div class="cardData">
                    <h4 class="cardTitle">Quiz `+ i +` title</h4>
                    <p class="cardSubTitle">Content of the quiz description goes here. </p>
                    <p class="cardTime">Details about quiz</p>
                    <input type="text" placeholder="Enter PIN">
                    <a href="quiz.html" class="pincheck">Start Quiz</a>
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

