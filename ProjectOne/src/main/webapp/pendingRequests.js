
//Load the page
window.onload=function(){
    loadRequests();
}

function loadRequests(){
    console.log("Loading Requests");
    //STEP 1
    var xhr = new XMLHttpRequest();
    //STEP 2
    xhr.onreadystatechange = function(){
        if (xhr.readyState==4 && xhr.status==200){
            //console.log(xhr.responseText);
            var body = xhr.response;
            appendTable(body);
        }
    }
    //STEP 3
    xhr.open("GET","http://localhost:8080/ProjectOne/api/loadRequests",true);
    //STEP 4
    xhr.send();
    return;
}

function appendTable(body){
    var table = document.getElementById("RequestTable").getElementsByTagName('tbody')[0];
	var items = JSON.parse(body);

    for (var i = 0; i < items.length; i++){
        var record = items[i];
        
        var row = table.insertRow();

        //Insert Radio Button
        var buttonCell = row.insertCell(0);
        var button = document.createElement('input');
        button.type = 'checkbox';
        button.name = 'selection';
        button.value = record["requestid"];
        buttonCell.appendChild(button);

        //Insert Request id
        var idCell = row.insertCell(1);
        var id = document.createTextNode(record["requestid"]);
        idCell.appendChild(id);

        //Insert First Name
        var firstCell = row.insertCell(2);
        var firstname = document.createTextNode(record["firstName"]);
        firstCell.appendChild(firstname);

        //Insert Last Name
        var lastCell = row.insertCell(3);
        var lastname = document.createTextNode(record["lastName"]);
        lastCell.appendChild(lastname);

        //Insert Event Type
        var eventCell = row.insertCell(4);
        var eventtype = document.createTextNode(record["eventType"]);
        eventCell.appendChild(eventtype);

        //Insert Cost
        var costCell = row.insertCell(5);
        var cost = document.createTextNode("$" + record["cost"]);
        costCell.appendChild(cost);

        //Insert Description
        var descriptionCell = row.insertCell(6);
        var description = document.createTextNode(record["description"]);
        descriptionCell.appendChild(description);

        //Insert Justification
        var justificationCell = row.insertCell(7);
        var justification = document.createTextNode(record["justification"]);
        justificationCell.appendChild(justification);

        //Insert missed hours
        var missedCell = row.insertCell(8);

        //Insert Event Date
        var dateCell = row.insertCell(9);
        var date = document.createTextNode(record["eventDate"]);
        dateCell.appendChild(date);

        //Insert Event Time
        var timeCell = row.insertCell(10);
        var time = document.createTextNode(record["eventTime"]);
        timeCell.appendChild(time);

        //Insert Location
        var locationCell = row.insertCell(11);
        var location = document.createTextNode(record["location"])
        locationCell.appendChild(location);

        //Insert Grading Format
        var gradingCell = row.insertCell(12);
        var grading = document.createTextNode(record["gradingFormat"]);
        gradingCell.appendChild(grading);

        //Insert Documents
        var documentCell = row.insertCell(13);
    }
}