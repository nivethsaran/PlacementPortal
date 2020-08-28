// 2. Adding course content:-
//    add-course-form
//    course-name
//    course-topic-name
//    course - url
//    preview/preview-video
console.log("script.js is working")
document.getElementById("course-url").addEventListener("blur", function (e) {
    if (document.getElementById("course-url").value.length < 10) {
        document.getElementById("preview-video").src = ""
        document.getElementById("preview").style.display = "none"
    }
    let url = YouTubeEmbedURL(document.getElementById("course-url").value)
    console.log(url)
    if (validYouTubeURL(url)) {
        document.getElementById("preview-video").src = url
        document.getElementById("preview").style.display = "block"
    } else {
        document.getElementById("preview-video").src = ""
        document.getElementById("preview").style.display = "none"
    }
    e.preventDefault()
})

// function which uses regex to check if url is youtube url
function validYouTubeURL(url) {
    var pattern = /^(http(s)?:\/\/)?((w){3}.)?youtu(be|.be)?(\.com)?\/.+/gm;
    if (url.match(pattern)) {
        return true
    } else {
        return false
    }
}

// function to convert youtube url to embed url...
function YouTubeEmbedURL(url) {
    let baseURL = "https://www.youtube.com/embed/"
    let embed = url.split("=")[1].split('&')[0]
    baseURL = baseURL + embed
    return baseURL
}

// form validation
document.getElementById("add-course-form").addEventListener("submit", function (e) {
    ids = {
        "courseName": document.getElementById("course-name").value,
        "courseTopic": document.getElementById("course-topic-name").value,
        "courseURL": document.getElementById("course-url").value,
    }
    // console.log("submit pressed", ids["courseTopic"], ids["courseURL"])
    if ((ids["courseTopic"] != "") & (validYouTubeURL(ids["courseURL"]))) {
        // console.log(true)
        document.getElementById("addCourse-danger").style.display = "none"
        document.getElementById("addCourse-success").style.display = "block"
        setTimeout(function () {
            document.getElementById("addCourse-success").style.display = "none"
        }, 3000)
    } else {
        // console.log(false)
        document.getElementById("addCourse-success").style.display = "none"
        document.getElementById("addCourse-danger").style.display = "block"
        setTimeout(function () {
            document.getElementById("addCourse-danger").style.display = "none"
        }, 3000)
    }
    e.preventDefault()
})