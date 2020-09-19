var note_id = 0;
var months = ["jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"];


function noteChange(note_id, name){
    var note_box = document.getElementById(note_id);
    note_box.innerText = name;
}

function genNoteID(){
    val = note_id.toString();
    note_id += 1;
    return val;
}

function addNote(){
    var mydiv = document.getElementById("note_div");
    var myNoteID = ("note" + genNoteID()).toString();
    mydiv.innerHTML += 
    `
    <div id = temp>
        <p>
            <input type="text" id = "temp1" value="" placeholder="Enter Note Name.." onchange = "noteChange(this.id, this.value)"/>
        </p>
        <ul class="noteList">
            <input type="text" id = "temp3" value = "" placeholder = "Enter details" onchange = "noteChange(this.id, this.value)"/><a href="#" title="Remove note" class="removeNote animate" onclick = "removeNote(this.parentNode.parentNode.id)">x</a>
        </ul>
    </div>
    `;
    setNoteID(myNoteID);
}

function setNoteID(noteID){
    var div = document.getElementById("temp");
    div.setAttribute("id", noteID);
    var myNote = document.getElementById("temp1");
    myNote.setAttribute("id", "name" + noteID);
    var myNotedet = document.getElementById("temp3");
    myNotedet.setAttribute("id", "note_det" + noteID);
}

function removeNote(noteID){
    myNote = document.getElementById(noteID);
    myNote.remove();
}

function highlight_month(selected_month){
    months.forEach(remove_highlight);
    myMonth = document.getElementById(selected_month);
    myMonth.setAttribute("class", "selected");
}

function remove_highlight(item, index){
    myMonth = document.getElementById(item);
    myMonth.setAttribute("class", "");
}