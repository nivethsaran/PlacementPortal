var config, editor;

config = {
    lineNumbers: true,
    mode: "text/x-csrc",
    theme: "material",
    indentWithTabs: true,
    // readOnly: true
    screenReaderLabel: "Code",
    smartIndent: true,
    addModeClass: true,
    autoCloseBrackets: true,
    gutters: ["CodeMirror-lint-markers"],
    lint: true
};

editor = CodeMirror.fromTextArea(document.getElementById("code"), config);

// function selectTheme() {
//     editor.setOption("theme", "solarized dark");
// }
// setTimeout(selectTheme, 5000);

function showCode() {
    console.log(editor.getValue().split("\n"));
}

function changeCode(lang)
{
    var mode="text/x-csrc"
    console.log(lang);
    if(lang=="C++")
    {
        
        mode ="text/x-c++src"   
    }
    else if(lang=="JAVA")
    {
        mode ="text/x-java"
    }
    else if(lang=="PYTHON")
    {
        mode ="text/x-python"
    }
    else if(lang=="C")
    {
        mode ="text/x-csrc"
    }
    document.getElementById("language-label").innerText = "Language (" + lang + ")"
    editor.setOption("mode",mode)
}

function validateinput()
{
    var cinput=document.getElementById("custominput").value
    if(cinput=="")
    {
        document.getElementById("custominput-label").innerText="Custom Input (Invalid)"
        document.getElementById("custominput-label").style.color="red"
    }
    else{
        document.getElementById("custominput-label").innerText = "Custom Input"
        document.getElementById("custominput-label").style.color = "black"
    }
}

function toggleinput()
{
    var cb=document.getElementById("custominput-check")
    if(cb.checked)
    {
        document.getElementById("custominput").disabled=false
    }
    else {
        document.getElementById("custominput").disabled = true
        document.getElementById("custominput-label").innerText = "Custom Input"
        document.getElementById("custominput-label").style.color = "black"
    }
}

function copyCode()
{
    navigator.clipboard.writeText(editor.getValue()).then(function () {
        console.log('Async: Copying to clipboard was successful!');
    }, function (err) {
        console.error('Async: Could not copy text: ', err);
    });
}

function clearCode()
{
    editor.setValue("//Enter Code here.....")
}

var problemdescarr = ["Zeroth Element"]
var problemdiffarr = ["Zeroth Element"]

function displayQuestion(i)
{
    document.getElementById("question").innerHTML = "Question" + i+"("+problemdiffarr[i]+")" +":\r\n"+problemdescarr[i]
    document.getElementById("question").hidden=false
}

function hideQuestion(i)
{
    document.getElementById("question").hidden = true
}

function loadXML()
{
    var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      displayProblems(this);
    }
  };
  xmlhttp.open("GET", "..\\..\\review2\\XML\\coding.xml", true);
  xmlhttp.send();

}

function displayProblems(xml) {
  var i;
  var xmlDoc = xml.responseXML;
  var output=''
  var x = xmlDoc.getElementsByTagName("problem");
  console.log(x.length);
  for(i=0;i<x.length;i++)
  
  {
    var problemid=x[i].getElementsByTagName("problemid")[0].childNodes[0].nodeValue;
    var problemname=x[i].getElementsByTagName("problemname")[0].childNodes[0].nodeValue;
    var problemdesc=x[i].getElementsByTagName("problemdesc")[0].childNodes[0].nodeValue;
    var problemdifficulty=x[i].getElementsByTagName("problemdifficulty")[0].childNodes[0].nodeValue;
    var facultyid=x[i].getElementsByTagName("facultyid")[0].childNodes[0].nodeValue;
    output+='<li class="nav-item" onclick="displayQuestion('+problemid+')">'+'\n'+
                        '<a class="nav-link" href="#">'+'\n'+
                            '<span data-feather="home"></span>'+'\n'+
                            problemname+'\n'+'</a></li>'+'\n'
    problemdescarr.push(problemdesc)
    problemdiffarr.push(problemdifficulty)
    console.log(output);
  }
    document.getElementById("leftpanel").innerHTML=output

}
