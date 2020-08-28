// 1. Experience form:-
//    Name (experience-name)
//    Email (experience-email)
//    Company (experience-company)
//    Experience (experience-box)

document.querySelector('#feedback-form').addEventListener('submit', function (e) {
    console.log("submit clicked")
    let ids = {
        "name": document.getElementById("experience-name").value,
        "email": document.getElementById("experience-email").value,
        "company": document.getElementById("experience-company").value,
        "exp": document.getElementById("experience-box").value
    }

    if ((ValidateEmail(ids["email"])) & (String(ids["name"]).length > 4) & (String(ids["company"]).length > 4) & (String(ids["exp"]).length > 4)) {
        console.log("valid", ids)
        document.getElementById("hidden-alert-danger").style.display = "none"
        document.getElementById("hidden-alert-success").style.display = "block"
        setTimeout(function () {
            document.getElementById("hidden-alert-success").style.display = "none"
        }, 3000)
    } else {
        console.log("invalid", ids)
        document.getElementById("hidden-alert-success").style.display = "none"
        document.getElementById("hidden-alert-danger").style.display = "block"
        setTimeout(function () {
            document.getElementById("hidden-alert-danger").style.display = "none"
        }, 3000)
    }

    e.preventDefault()
})

// function to validate email
function ValidateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return (true)
    }
    return (false)
}