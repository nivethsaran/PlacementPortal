function validateUserLogin() {
    var uname = document.getElementById("username").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("uname")[0].innerHTML = "Your email or username (data required here)"
    }
    else {
        document.getElementsByClassName("uname")[0].innerHTML = "Your email or username"
    }
}

function validatePassLogin() {
    var uname = document.getElementById("password").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youpasswd")[0].innerHTML = "Your password(data required here)"
    }
    else {
        document.getElementsByClassName("youpasswd")[0].innerHTML = "Your password"
    }
}

function validateUserReg() {
    var uname = document.getElementById("usernamesignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("uname")[1].innerHTML = "Your username (data required here)"
    }
    else {
        document.getElementsByClassName("uname")[1].innerHTML = "Your username"
    }
}


function validateEmailReg() {
    var uname = document.getElementById("emailsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youmail")[0].innerHTML = "Your email or username (data required here)"
    }
    else {
        document.getElementsByClassName("youmail")[0].innerHTML = "Your email or username"
    }
}

function validatePassReg() {
    var uname = document.getElementById("passwordsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youpasswd")[1].innerHTML = "Your email or username (data required here)"
        console.log(document.getElementsByClassName("youpasswd"));
    }
    else {
        document.getElementsByClassName("youpasswd")[1].innerHTML = "Your email or username"
    }
}

function validatePassConfirmReg() {
    var uname = document.getElementById("passwordsignup_confirm").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youpasswd")[2].innerHTML = "Your email or username (data required here)"
    }
    else {
        document.getElementsByClassName("youpasswd")[2].innerHTML = "Your email or username"
    }
}