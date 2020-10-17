// course view for users
// no validation of any kind required here....

function embedURL(url) {
    if (url.includes("watch?")) {
        return "https://www.youtube.com/embed/" + url.split("=")[1].split('&')[0]
    } else if (url.includes("youtu.be")) {
        return "https://www.youtube.com/embed/" + url.split("/")[3]
    }
}

function loadXML() {
    console.log('loading xml data...')
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this);
        }
    };
    xhttp.open("GET", "../../../review2/XML/courses.xml", true);
    xhttp.send();
    console.log("loaded: ", list)
}

var list = []

function myFunction(xml) {
    var xmlDoc = xml.responseXML;
    var courseids = xmlDoc.getElementsByTagName("courseid");
    var coursenames = xmlDoc.getElementsByTagName("coursename")
    var topicnames = xmlDoc.getElementsByTagName("topicname")
    var departments = xmlDoc.getElementsByTagName("department")
    var courseurls = xmlDoc.getElementsByTagName("courseurl")
    var facultyids = xmlDoc.getElementsByTagName("facultyid")
    let l = courseids.length

    for (let i = 0; i < l; i++) {
        list.push({
            cid: courseids[i].childNodes[0].nodeValue,
            cname: coursenames[i].childNodes[0].nodeValue,
            tname: topicnames[i].childNodes[0].nodeValue,
            department: departments[i].childNodes[0].nodeValue,
            curl: embedURL(courseurls[i].childNodes[0].nodeValue),
            fid: facultyids[i].childNodes[0].nodeValue
        })
    }

    children = ''

    for (let i = 0; i < list.length; i++) {
        child = `<div id="1" class="child">
                    <h4>${list[i]['tname']}</h4><br>
                    <iframe id="preview-video" src="${list[i]['curl']}"
                        allowfullscreen="allowfullscreen"></iframe>
                    <p class="lead">
                    Course name: ${list[i]['cname']}, Faculty incharge:${list[i]['fid']}, Department: ${list[i]['department']}
                    </p>
                </div>`

        children = children + child
    }

    console.log(children)

    document.getElementById('mainWrapper').innerHTML = children
}
