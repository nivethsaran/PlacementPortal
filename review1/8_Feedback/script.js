// 1. Feedback form:-
//    feedback-email
//    course
//    criteria1/criteria2/criteria3/criteria4
//    question1/question2
//    suggestion-box

document.querySelector('#feedback-form').addEventListener('submit', function (e) {
    console.log("submit clicked")
    let ids = {
        "email": document.getElementById("feedback-email").value,
        "course": document.getElementById("course").value,
        "cr1": document.getElementById("criteria1").value,
        "cr2": document.getElementById("criteria2").value,
        "cr3": document.getElementById("criteria3").value,
        "cr4": document.getElementById("criteria4").value,
        "suggestion": document.getElementById("suggestion-box").value
    }
    let names = {
        "q1": getFeedbackChoice(document.getElementsByName("question1")),
        "q2": getFeedbackChoice(document.getElementsByName("question2"))
    }

    if ((ValidateEmail(ids["email"])) & (names["q1"] != null) & (names["q2"] != null)) {
        // console.log("valid")
        document.getElementById("hidden-alert-danger").style.display = "none"
        document.getElementById("hidden-alert-success").style.display = "block"
        setTimeout(function () {
            document.getElementById("hidden-alert-success").style.display = "none"
        }, 3000)
    } else {
        // console.log("invalid")
        document.getElementById("hidden-alert-success").style.display = "none"
        document.getElementById("hidden-alert-danger").style.display = "block"
        setTimeout(function () {
            document.getElementById("hidden-alert-danger").style.display = "none"
        }, 3000)
    }

    e.preventDefault()
})
// function to get the checked choice for questions with yes/no answers
function getFeedbackChoice(ele) {
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked) {
            return ele[i].value
        }
    }
    return null
}
// function to validate email
function ValidateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return (true)
    }
    return (false)
}