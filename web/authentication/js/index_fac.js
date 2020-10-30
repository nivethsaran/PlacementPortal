function validateUserLogin()
{
    var uname=document.getElementById("facidsignin").value
    if(uname==""||uname==null)
    {
        document.getElementsByClassName("uname")[0].innerHTML="Your faculty ID (data required here)"
        document.getElementsByClassName("uname")[0].style.color='#ff0000';
    }
    else{
        document.getElementsByClassName("uname")[0].innerHTML = "Your faculty ID"
        document.getElementsByClassName("uname")[0].style.color='#2d6277';
    }
}

function validatePassLogin() {
    var password = document.getElementById("password").value
    if (password == "" || password == null) {
        document.getElementsByClassName("youpasswd")[0].innerHTML = "Your password(password cant be empty)"
        document.getElementsByClassName("youpasswd")[0].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("youpasswd")[0].innerHTML = "Your password"
        document.getElementsByClassName("youpasswd")[0].style.color='#2d6277';
    }
}

function validateFullReg() {
    var fname = document.getElementById("fullname").value
    if (fname == "" || fname == null) {
        document.getElementsByClassName("fullname")[0].innerHTML = "Your fullname (data required here)"
        document.getElementsByClassName("fullname")[0].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("fullname")[0].innerHTML = "Your fullname"
        document.getElementsByClassName("fullname")[0].style.color='#2d6277';
    }
}

function validateUserReg() {
    var uname = document.getElementById("facidsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("uname")[1].innerHTML = "Your faculty ID (data required here)"
        document.getElementsByClassName("uname")[1].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("uname")[1].innerHTML = "Your faculty ID"
        document.getElementsByClassName("uname")[1].style.color='#2d6277';
    }
}


function validateEmailReg() {
    var uname = document.getElementById("emailsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youmail")[0].innerHTML = "Your email  (data required here)"
        document.getElementsByClassName("youmail")[0].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("youmail")[0].innerHTML = "Your email"
        document.getElementsByClassName("youmail")[0].style.color='#2d6277';
    }
}

function validatePassReg() {
    var uname = document.getElementById("passwordsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youpasswd")[1].innerHTML = "Your password (data required here)"
        console.log(document.getElementsByClassName("youpasswd"));
        document.getElementsByClassName("youpasswd")[1].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("youpasswd")[1].innerHTML = "Your password"
        document.getElementsByClassName("youpasswd")[1].style.color='#2d6277';
    }
}

function validatePassConfirmReg() {
    var uname = document.getElementById("passwordsignup_confirm").value
    var uname1 = document.getElementById("passwordsignup").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("youpasswd")[2].innerHTML = "confirm password (data required here)"
        document.getElementsByClassName("youpasswd")[2].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("youpasswd")[2].innerHTML = "confirm password"
        document.getElementsByClassName("youpasswd")[1].style.color='#2d6277';
    }
    if(uname1 != uname){
        document.getElementsByClassName("youpasswd")[2].innerHTML = "password not matching"
        document.getElementsByClassName("youpasswd")[2].style.color='#ff0000';
    }
    

}


function validateImageURL() {
    var uname = document.getElementById("imageurl").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("imageurl")[0].innerHTML = "Your image url (data required here)"
        document.getElementsByClassName("imageurl")[0].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("imageurl")[0].innerHTML = "Your image url"
        document.getElementsByClassName("imageurl")[0].style.color='#2d6277';
    }
}

function validateMobile() {
    var uname = document.getElementById("mobile").value
    if (uname == "" || uname == null) {
        document.getElementsByClassName("mobile")[0].innerHTML = "Your phone number (data required here)"
        document.getElementsByClassName("mobile")[0].style.color='#ff0000';
    }
    else {
        document.getElementsByClassName("mobile")[0].innerHTML = "Your phone number"
        document.getElementsByClassName("mobile")[0].style.color='#2d6277';
    }
}
