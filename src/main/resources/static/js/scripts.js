function dragstart_handler(ev) {
    // Add the target element's id to the data transfer object
    ev.dataTransfer.setData("text/plain", ev.target.id);
    ev.dataTransfer.setData("current-state", ev.target.dataset.state);
    ev.dropEffect = "move";
}

function dragover_handler(ev) {
    ev.preventDefault();
    // Set the dropEffect to move
    ev.dataTransfer.dropEffect = "move"
}

function drop_handler(ev) {
    // TODO: tarkista että vanhat toiminnallisuudet kuten "sortable" eivät häviä uusien ominaisuuksien myötä
    ev.preventDefault();
    // Get the id of the target and add the moved element to the target's DOMö
    console.log(ev.dataTransfer.getData("current-state"));
    var currentId = ev.dataTransfer.getData("text/plain");
    console.dir(ev.target);
    console.dir(ev.target.classList.contains("droppable-box"));

    if(ev.target.classList.contains("pool-box")) {
        console.log("pool box");
        location.href="http://localhost:8080/main?taskId=" + currentId + "&state=0";
    }
    if(ev.target.classList.contains("todo-box")) {
        console.log("todo box");
        location.href="http://localhost:8080/main?taskId=" + currentId + "&state=1";
    }
    if(ev.target.classList.contains("doing-box")) {
        console.log("doing box");
        location.href="http://localhost:8080/main?taskId=" + currentId + "&state=2";
    }
    if(ev.target.classList.contains("done-box")) {
        console.log("done box");
        location.href="http://localhost:8080/main?taskId=" + currentId + "&state=3";
    }
    if(ev.target.classList.contains("trash-box")) {
        console.log("trash box");
        location.href="http://localhost:8080/main?taskId=" + currentId + "&state=4";
    }
    // TODO: tähän "roskis" box jonka state=4
    console.log(ev.dataTransfer.getData("current-state"));
    if(ev.target.classList.contains("droppable-box")){
        ev.target.appendChild(document.getElementById(currentId));
    } else {
        ev.target.parentNode.appendChild(document.getElementById(currentId));
    }
    // välitä esim. task id rest-palvelulle
    // esim. @{"/changestate"}


    // TODO: lisää tähän jotain mikä tarkistaa että oikean tyyppinen target
    // TODO: tai - tarkista ettei ole target-parentin child

}

function paskafunktio() {
    // ottaa yhteyden put-requestiin controllerissa
}