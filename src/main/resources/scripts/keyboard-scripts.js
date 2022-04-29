function onEnter(event) {
    if(event.key == "Enter") {
        document.getElementById("green-button").style.backgroundColor = "red";
    }
}

function setText() {
    document.getElementById("input").text = document.getElementById("input").value;
}
