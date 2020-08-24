const gsmChars = new Set([
'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
',', '.', '\/', ';', '\\', '[', ']', ':', '<', '>',"\'", '{', '}', '!', '@', '#', "$", '%','&', '*', "^", "(", ")", '\u0020']);

const escChars = new Set(['\\', '\/', '\"', '\[', '\]', '\~']);

const asciiChars = new Set([]);

window.onload = function () {
    let messageEditor = CodeMirror.fromTextArea(document.querySelector(".editor"), {
        lineNumbers: false,
        lineWrapping: true
    });
    messageEditor.setSize(400, 250);
    messageEditor.save();
    const widget = document.querySelector('.testWidget');
    let widgetObj = messageEditor.addLineWidget(0, widget, { above: true, insertAt: 0 });


    const editorChange = messageEditor.on('change', function (e) {

        let messageText = messageEditor.getValue();

        let messageLength = messageText.length;

        let count = 0;
        let countArr = {};
        let lineCount = e.doc.lineCount();
        let fromPosition = CodeMirror.Pos(0, 0);
        let toPosition = CodeMirror.Pos(0, 0);
        
        let warningMark;
        let dangerMark;
        
        // Highlight code based on character count
        if (messageLength > 140) {
            toPosition = messageEditor.posFromIndex(messageLength + 1);
            fromPosition = messageEditor.posFromIndex(140);

        
            let markArray = messageEditor.findMarks(fromPosition,
                toPosition);
                markArray.forEach(function (marker, index) {
                    if (marker.className === 'warningMarked') {
                        marker.clear();
                    }
                });

            if (warningMark == undefined) {
                warningMark = messageEditor.markText(fromPosition,
                    toPosition, { className: 'warningMarked' }); 
            } else {
                warningMark.clear()
            }
            
            // Logic for messages over 160
            if (messageLength > 160) {
                toPosition = messageEditor.posFromIndex(messageLength + 1);
                fromPosition = messageEditor.posFromIndex(160);

                let char = messageEditor.getRange(messageEditor.posFromIndex(159),
                    messageEditor.posFromIndex(161));
                
                let markArray = messageEditor.findMarks(fromPosition,
                    toPosition);
                markArray.forEach(function (marker, index) {
                    if (marker.className === 'dangerMarked') {
                        marker.clear();
                    }
                });

                if (dangerMark == undefined) { 
                    dangerMark = messageEditor.markText(fromPosition,
                        toPosition, { className: 'dangerMarked' });
                } else {
                    dangerMark.clear();
                }
                        
            }
        } 

        // Highlights for specific individual characters 
        for (let i = 0; i < lineCount; i++) {
            let lineText = e.doc.getLine(i);
            count += lineText.length;
            countArr[i] = lineText.length;

            if (i > 0) {
                count++;
                countArr[i] = lineText.length + 1;
            }

            for (let j = 0; j < lineText.length; j++) {
                if (!gsmChars.has(lineText[j])) {
                    e.findMarksAt(CodeMirror.Pos(i, j + 1)).forEach((mark) => {
                        if (mark.className === 'ucsMarked')
                       
                        mark.clear();
                    })
                    if (lineText.charCodeAt(j) > 32767) {
                        fromPosition = { line: i, ch: j };
                        messageEditor.markText(fromPosition,
                            CodeMirror.Pos(i, j + 2),
                            { className: 'ucsMarked' });
                        j++;
                    } else {
                        fromPosition = { line: i, ch: j };
                        toPosition = { line: i, ch: j + 1 }
                        messageEditor.markText(fromPosition,
                            toPosition,
                            { className: 'ucsMarked' });
                    }
                }

                if (escChars.has(lineText[j])) {
                    fromPosition = { line: i, ch: j };
                    toPosition = { line: i, ch: j + 1 }
                    messageEditor.markText(fromPosition,
                        toPosition,
                        { className: 'asciiMarked' });
                }

            }
            
        }

        let countdiv = document.querySelector('.count');
        countdiv.innerHTML = count;

        let countdiv2 = document.querySelector('.count2');
        countdiv2.innerHTML = messageLength;

        function findPosition(num) {
            if (countArr[0] > num) {
                return new CodeMirror.Pos(0, num);
            }

            let sum = 0;
            let i = 0;
            while (sum < num) {
                sum += countArr[i];
                i++;
            }
            return new CodeMirror.Pos(i - 1, num - (sum - countArr[i - 1] + 1));
        }

        /* Future functionality for highlighted search */
        // let warningCursor;
        // if (messageLength == 140)
        //     warningCursor = e.doc.getCursor("to");

        // if (messageLength > 140)
        //     search(messageText.substr(140));

        // function search(val) {
        //     let cursor = messageEditor.getSearchCursor(val, warningCursor, {caseFold:false});
        //     console.log(cursor);
        //     while (cursor.findNext()) {
        //         messageEditor.markText(
        //         cursor.from(),
        //         cursor.to(),
        //         { className: 'warningMarked' }
        //         );
        //     }
        // }

    });
}