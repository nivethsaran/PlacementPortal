// PART 1:-
// Rendering stuff to the screen
function createTag(element, classname = null, id = null, textContent = null, children = null, targetID = null) {
    elt = document.createElement(element)
    if (classname !== null) {
        elt.className = classname
    }
    if (id !== null) {
        elt.id = id
    }
    if (textContent !== null) {
        text = document.createTextNode(textContent)
        elt.appendChild(text)
    }
    if (children !== null) {
        for (let i = 0; i < children.length; i++) {
            elt.appendChild(children[i])
        }
    }
    if (targetID !== null) {
        document.getElementById(targetID).appendChild(elt)
    }
    return elt
}





// get the data from xml file
function loadXML() {
    console.log('loading xml data...')
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this);
        }
    };
    xhttp.open("GET", "../../../review2/XML/placementexperience.xml", true);
    xhttp.send();
    console.log("loaded: ", list)
}

var list = []
function myFunction(xml) {
    var xmlDoc = xml.responseXML;
    var experienceids = xmlDoc.getElementsByTagName("experienceid");
    var rollnos = xmlDoc.getElementsByTagName("rollno")
    var experiencecontents = xmlDoc.getElementsByTagName("experiencecontent")
    var companynames = xmlDoc.getElementsByTagName("companyname")
    var posttimes = xmlDoc.getElementsByTagName("posttime")

    let l = experienceids.length

    for (let i = 0; i < l; i++) {
        list.push({
            key: experienceids[i].childNodes[0].nodeValue,
            name: rollnos[i].childNodes[0].nodeValue,
            email: experiencecontents[i].childNodes[0].nodeValue,
            company: companynames[i].childNodes[0].nodeValue,
            content: posttimes[i].childNodes[0].nodeValue,
        })
    }

    console.log("for loop to be executed")


    for (let i = 0; i < list.length; i++) {
        // destructure
        let { key, name, email, company, content } = list[i]

        // using the function createTag, i'll create tags to be rendered
        let d0 = createTag('th', classname = null, id = null, textContent = key)
        d0.setAttribute('scope', 'row')

        let d1 = createTag('td', classname = null, id = null, textContent = name)
        let d2 = createTag('td', classname = null, id = null, textContent = email)
        let d3 = createTag('td', classname = null, id = null, textContent = company)

        // let b1 = createTag('a', classname = "btn btn-primary view", id = null, textContent = "View")
        let b2 = createTag('a', classname = "btn btn-danger delete", id = null, textContent = "Delete")

        // let d4 = createTag('td', classname = null, id = null, textContent = null, children = [b1])
        let d4 = createTag('td', classname = null, id = null, textContent = content)
        let d5 = createTag('td', classname = null, id = null, textContent = null, children = [b2])

        let p = createTag('tr', classname = null, id = null, textContent = null, children = [d0, d1, d2, d3, d4, d5], targetID = 'xp-list')
    }
}
// xml script ends here

// PART-2:-
// checking for events like delete or view detail

document.querySelector('.table').addEventListener('click', function (e) {
    item = e.target
    if (item.classList.contains('delete')) {
        // we must remove the tr where the button we clicked was contained
        e.target.parentElement.parentElement.remove()
    } else if (item.classList.contains('view')) {
        window.location.href = "./dummy.html";
    }
    e.preventDefault()
})