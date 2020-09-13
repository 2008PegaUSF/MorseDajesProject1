  
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
    var table = document.getElementById("grades").getElementsByTagName('tbody')[0];
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

    	//Insert Event Date
        var dateCell = row.insertCell(2);
        var date = document.createTextNode(record["eventDate"]);
        dateCell.appendChild(date);

   
        //Insert Event Type
        var eventCell = row.insertCell(3);
        var eventtype = document.createTextNode(record["eventType"]);
        eventCell.appendChild(eventtype);   
      

        //Insert Documents
        var gradeCell= row.insertCell(4);
        var gradetype= document.createTextNode(record["gradingformat"]);
        gradeCell.appendChild(gradetype);
    }
}