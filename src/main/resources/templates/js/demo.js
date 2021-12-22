var xhr = new XMLHttpRequest();
xhr.open("GET", "/getGroup");
xhr.onreadystatechange = function (e) {
    if (xhr.readyState === 4) {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
        } else {
            console.log(xhr.statusText);
        }
    }
};
xhr.send();


$("Obtain").on("click", function () {
    alert("クリックされました");
})

