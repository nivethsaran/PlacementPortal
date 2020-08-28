// admin can see all the experience forms submitted by the user

document.querySelector('.card-container').addEventListener('click', function (e) {
    item = e.target
    if (item.classList.contains('delete')) {
        console.log('delete clicked')
        e.target.parentElement.parentElement.remove()
        console.log(parent)
    } else if (item.classList.contains('accordian')) {
        console.log('accordian clicked')
        id = e.target.parentElement.parentElement.parentElement.id
        console.log(id)
        tohide = document.getElementById(`content-${id}`)
        console.log(tohide)
        if (tohide.style.display == "block") {
            tohide.style.display = "none"
        }
        else {
            tohide.style.display = "block"
        }
    }

    e.preventDefault()
})


function createExperienceCards(info) {

    // create outer div
    cardexpdiv = document.createElement('div')
    cardexpdiv.className = "card experiences"
    cardexpdiv.id = `${info["id"]}`

    // stuff to go inside outer div (1)
    // inner div
    cardHeader = document.createElement('div')
    cardHeader.className = "cardHeader"

    // stuff to go inside inner div
    cardTitle = document.createElement('span')
    cardTitle.className = "cardTitle"
    accordian = document.createElement('i')
    accordian.className = "fas fa-caret-down accordian"
    accordian.id = `accordian${info["id"]}`
    deleteico = document.createElement('i')
    deleteico.className = "fas fa-times delete"
    deleteico.id = `delete${info["id"]}`
    cardTitle.appendChild(document.createTextNode(`${info["name"]}`))
    cardTitle.appendChild(accordian)
    // append those to the inner div
    cardHeader.appendChild(cardTitle)
    cardHeader.appendChild(deleteico)

    // stuff to go inside outer div (2)
    email_company = document.createElement('p')
    email_company.className = "text-muted"
    email_company.appendChild(document.createTextNode(`${info["email"]}, ${info["company"]}`))

    // stuff to go inside outer div (3)
    xp = document.createElement('p')
    xp.className = "card-text"
    xp.appendChild(document.createTextNode(`${info["content"]}`))

    // inner div 2
    innerdiv2 = document.createElement('div')
    innerdiv2.className = "exp"
    innerdiv2.id = `content-${info["id"]}`
    innerdiv2.appendChild(xp)

    // append those to the outter div
    cardexpdiv.appendChild(cardHeader)
    cardexpdiv.appendChild(email_company)
    cardexpdiv.appendChild(innerdiv2)

    // append the outer div to the experience-container
    document.querySelector('#experience-container').appendChild(cardexpdiv)

}

let list = [
    {
        "id": 1,
        "name": "Student 1 ",
        "email": "email 1",
        "company": "company 1",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "id": 2,
        "name": "Student 2 ",
        "email": "email 2",
        "company": "company 2",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "id": 3,
        "name": "Student 3 ",
        "email": "email 3",
        "company": "company 3",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "id": 4,
        "name": "Student 4 ",
        "email": "email 4",
        "company": "company 4",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    },
    {
        "id": 5,
        "name": "Student 5 ",
        "email": "email 5",
        "company": "company 5",
        "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reiciendis quasi alias aperiam in cum! Consequatur suscipit quasi distinctio perferendis eligendi odit debitis earum quas animi nemo, provident enim ipsum fuga deserunt mollitia voluptates at aliquam accusantium quia, harum explicabo! Cumque?"
    }
]


for (let i = 0; i < list.length; i++) {
    createExperienceCards(list[i])
}
