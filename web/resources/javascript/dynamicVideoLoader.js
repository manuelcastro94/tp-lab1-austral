/**
 * Created by Federico on 11/05/2014.
 */
var i = 0;
function add(link) {
    if (link.value != "") {
        var element = document.createElement("input");
        element.type = "text";
        element.name = i;
        element.contenteditable = false;
        element.value = link;
        var div = document.getElementById("youtubeLinks");
        document.getElementById('mediaInput').value = '';
//            var deleteButton = document.createElement("button");
//            deleteButton.value = "Delete";
//            deleteButton.mouseClick = remove(i);
//            div.appendChild(deleteButton);
        div.appendChild(element);
        i++;
    }
}
function remove(val) {
    var child = document.getElementById(val);
    element.removeChild(child);
}