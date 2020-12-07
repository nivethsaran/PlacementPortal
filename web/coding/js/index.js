var config, editor;
let lang_global = "C++"
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
    lang_global = lang
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



function displayQuestion(i)
{
    i = parseInt(i) - 1
    document.getElementById("question").innerHTML = "Question " + i+" ("+problemdiffarr[i]+")" +":\r\n"+problemdescarr[i]
    document.getElementById("question").hidden=false
}

function hideQuestion(i)
{
    document.getElementById("question").hidden = true
}

function getLanguageForCompilation(l)
{
    if(l === 'C')
    return 'C'
    else if(l === 'JAVA')
    return 'Java'
    else if(l === 'PYTHON')
    return 'Python'
    else if(l === 'C++')
    return 'C++'
}

function executeCode() {
    let url = baseurl + 'execute';
    let http = new XMLHttpRequest();
    let params = 'code=';
    params += editor.getValue() + '&language=';
    params += getLanguageForCompilation(lang_global) + '&input=';
    params += document.getElementById('custominput').value;

    http.open('POST', url, true);
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    // http.setRequestHeader('Access-Control-Allow-Origin', '*' )
    http.onreadystatechange = function () {//Call a function when the state changes.
        if (http.readyState === 4 && http.status === 200) {
            document.getElementById("output").innerHTML = http.responseText;
        } else {
            document.getElementById("output").innerHTML = "Server Error Try Again Later"
        }
    }

    // http.send(JSON.stringify(params));
    http.send(params);

}
