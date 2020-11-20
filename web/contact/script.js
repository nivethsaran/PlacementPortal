// contactList = [
//     {
//         "name": "Amanda Smith",
//         "gender": "f"
//     }, {
//         "name": "Brian Smith",
//         "gender": "m"
//     }, {
//         "name": "Brian Smith",
//         "gender": "m"
//     }, {
//         "name": "Crystal Smith",
//         "gender": "f"
//     }, {
//         "name": "Doug Smith",
//         "gender": "m"
//     }, {
//         "name": "Erin Smith",
//         "gender": "m"
//     }, {
//         "name": "Frank Smith",
//         "gender": "m"
//     }, {
//         "name": "Glinda Smith",
//         "gender": "f"
//     }, {
//         "name": "Hank Smith",
//         "gender": "m"
//     }, {
//         "name": "Izzy Smith",
//         "gender": "f"
//     },
// ]
//
// imageURL = {
//     "m": "https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-80/newboy-02.svg",
//     "f": "https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-80/newgirl-01.svg",
// }
//
// function createToRender(name, gender) {
//     sectionTag = document.createElement('section')
//     sectionTag.className = "Contact"
//
//     imgTag = document.createElement('img')
//     imgTag.setAttribute('src', imageURL[gender])
//     imgTag.className = "Contact-avatar"
//
//     nameTag = document.createElement('h5')
//     nameTag.className = "Contact-name"
//
//     nameText = document.createTextNode(name)
//     nameTag.appendChild(nameText)
//
//     sectionTag.appendChild(imgTag)
//     sectionTag.appendChild(nameTag)
//
//     return sectionTag
// }
//
// function renderContacts(start = null) {
//     if (start === null) {
//         for (let i = 0; i < contactList.length; i++) {
//             section = createToRender(contactList[i]["name"], contactList[i]["gender"])
//             document.getElementById('ContactList').appendChild(section)
//         }
//     } else {
//         for (let i = 0; i < contactList.length; i++) {
//             if (contactList[i]["name"].toLowerCase().startsWith(start)) {
//                 section = createToRender(contactList[i]["name"], contactList[i]["gender"])
//                 document.getElementById('ContactList').appendChild(section)
//             }
//         }
//     }
// }
//
// renderContacts()
//
// function removeAllChildNodes(parent) {
//     while (parent.firstChild) {
//         parent.removeChild(parent.firstChild);
//     }
// }
//
// document.querySelector('.AlphabetNav').addEventListener('click', function (e) {
//     item = e.target.id;
//
//     var letters = /^[A-Za-z]+$/;
//     if (item.match(letters)) {
//         // do something
//         removeAllChildNodes(document.getElementById('ContactList'))
//         renderContacts(item)
//     }
//     e.preventDefault()
// })