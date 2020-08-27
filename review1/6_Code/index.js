var config, editor;

config = {
    lineNumbers: true,
    mode: "text/x-java",
    theme: "material",
    indentWithTabs: true,
    // readOnly: true
    screenReaderLabel: "Code",
    smartIndent: true,
    addModeClass: true,
    autoCloseBrackets: true,
    gutters: ["CodeMirror-lint-markers"],
    lint: true
};

editor = CodeMirror.fromTextArea(document.getElementById("code"), config);

// function selectTheme() {
//     editor.setOption("theme", "solarized dark");
// }
// setTimeout(selectTheme, 5000);

function showCode() {
    console.log(editor.getValue().split("\n"));
}