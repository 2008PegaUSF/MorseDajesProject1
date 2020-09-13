
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
    xhr.open("GET","http://localhost:8080/ProjectOne/api/loadRequestsEmployee",true);
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

        
    	//Insert Event Date
        var dateCell = row.insertCell(0);
        var date = document.createTextNode(record["eventDate"]);
        dateCell.appendChild(date);


        //Insert Event Type
        var eventCell = row.insertCell(1);
        var eventtype = document.createTextNode(record["eventType"]);
        eventCell.appendChild(eventtype);

      	//Insert Description
		var descCell=row.insertCell(2);
		var desc=document.createTextNode(record["description"]);
		descCell.appendChild(desc);

        //Insert Grade format
		var gradeCell=row.insertCell(3);
		var gradeFormat=document.createTextNode(record["gradingFormat"]);
		gradeCell.appendChild(gradeFormat);

        //Insert Documents
        var gradeDocCell= row.insertCell(4);
        var gradefile= document.createTextNode(record["file"]);
        gradeDocCell.appendChild(gradefile);
    }
}