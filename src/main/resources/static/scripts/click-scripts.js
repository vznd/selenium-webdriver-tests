function contextClicked() {
    var menu = document.getElementById("context-menu");
    if (menu.style.display == "block") {
        menu.style.display = "none"
    } else {
        menu.style.display = "block";
    }
}
            
function doubleClicked() {
    document.getElementById("green-button").style.backgroundColor = "red";
}

function clicked() {
    document.getElementById("green-button").style.backgroundColor = "yellowgreen";
}
