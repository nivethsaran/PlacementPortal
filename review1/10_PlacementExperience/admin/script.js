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

let list = [
    {
        "key": 1,
        "name": "Student 1 ",
        "email": "email 1",
        "company": "company 1",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "key": 2,
        "name": "Student 2 ",
        "email": "email 2",
        "company": "company 2",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "key": 3,
        "name": "Student 3 ",
        "email": "email 3",
        "company": "company 3",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "key": 4,
        "name": "Student 4 ",
        "email": "email 4",
        "company": "company 4",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "key": 5,
        "name": "Student 5 ",
        "email": "email 5",
        "company": "company 5",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    }]

for (let i = 0; i < list.length; i++) {
    // destructure
    let { key, name, email, company } = list[i]

    // using the function createTag, i'll create tags to be rendered
    let d0 = createTag('th', classname = null, id = null, textContent = key)
    d0.setAttribute('scope', 'row')

    let d1 = createTag('td', classname = null, id = null, textContent = name)

    let d2 = createTag('td', classname = null, id = null, textContent = email)

    let d3 = createTag('td', classname = null, id = null, textContent = company)

    let b1 = createTag('a', classname = "btn btn-primary view", id = null, textContent = "View")
    let b2 = createTag('a', classname = "btn btn-danger delete", id = null, textContent = "Delete")

    let d4 = createTag('td', classname = null, id = null, textContent = null, children = [b1])
    let d5 = createTag('td', classname = null, id = null, textContent = null, children = [b2])

    let p = createTag('tr', classname = null, id = null, textContent = null, children = [d0, d1, d2, d3, d4, d5], targetID = 'xp-list')
}

// PART-2:-
// checking for events like delete or view detail

document.querySelector('.table').addEventListener('click', function (e) {
    item = e.target
    if (item.classList.contains('delete')) {
        // we must remove the tr where the button we clicked was contained
        e.target.parentElement.parentElement.remove()
    } else if (item.classList.contains('view')) {
        console.log('view clicked')
        window.location.href = "./dummy.html";
    }
    e.preventDefault()
})