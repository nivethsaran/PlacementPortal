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