  
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

    	//Insert First Name
        var firstNameCell = row.insertCell(2);
        var firstName = document.createTextNode(record["firstName"]);
        firstNameCell.appendChild(firstName);

   
        //Insert LastName
        var lastNameCell = row.insertCell(3);
        var lastName = document.createTextNode(record["lastName"]);
        lastNameCell.appendChild(lastName);   
      

        //Insert Event Type
        var eventCell= row.insertCell(4);
        var event = document.createTextNode(record["eventType"]);
        eventCell.appendChild(event);
        
        //Insert Description
        var descCell= row.insertCell(5);
        var description = document.createTextNode(record["description"]);
        descCell.appendChild(description);
        
        //Insert Grading Format
        var gradeFormatCell= row.insertCell(6);
        var gradeFormat = document.createTextNode(record["gradingFormat"]);
        gradeFormatCell.appendChild(gradeFormat);
        
        //Insert Grade
        var gradeCell= row.insertCell(7);
        //var event = document.createTextNode(record["eventType"]);
        //eventCell.appendChild(event);
        
    }
}