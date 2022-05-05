function openTabs() {
    var initialWindow = window;
    for (let i = 0; i < 2; i++) {
        window.open("/iframes", '_blank');
    }
}

function openSimpleAlert() {
    window.open("/simple-alert","_self")
}
