function dragstart_handler(ev) {
    // Add the target element's id to the data transfer object
    ev.dataTransfer.setData("text/plain", ev.target.id);
    ev.dataTransfer.setData("current-state", ev.target.dataset.state);
    ev.dropEffect = "move";
}
/* OMA KOKEILU */
function dragenter_handler(ev) {
    $(".dragged-task").addClass("being-moved");
}

function dragleave_handler(ev) {
    $(".dragged-task").removeClass("being-moved");
}

function dragover_handler(ev) {
    ev.preventDefault();
    // Set the dropEffect to move
    ev.dataTransfer.dropEffect = "move"
}
function drop_handler(ev) {
    ev.preventDefault();
    // Get the id of the target and add the moved element to the target's DOM
    console.log(ev.dataTransfer.getData("current-state"));
    var data = ev.dataTransfer.getData("text/plain");
    console.dir(ev.target);
    console.dir(ev.target.classList.contains("droppable-box"));

    if(ev.target.classList.contains("pool-box")) {
        ev.dataTransfer.setData("current-state", "0");
        console.log("pool box")
    }
    if(ev.target.classList.contains("todo-box")) {
        ev.dataTransfer.setData("current-state", "1");
        console.log("todo box")
    }
    if(ev.target.classList.contains("doing-box")) {
        ev.dataTransfer.setData("current-state", "2");
        console.log("doing box")
    }
    if(ev.target.classList.contains("done-box")) {
        ev.dataTransfer.setData("current-state", "3");
        console.log("done box")
    }
    console.log(ev.dataTransfer.getData("current-state"));
    if(ev.target.classList.contains("droppable-box")){
        ev.target.appendChild(document.getElementById(data));
    } else {
        ev.target.parentNode.appendChild(document.getElementById(data));
    }
    // välitä esim. task id rest-palvelulle
    // esim. @{"/changestate"}


    // TODO: lisää tähän jotain mikä tarkistaa että oikean tyyppinen target
    // TODO: tai - tarkista ettei ole target-parentin child

}