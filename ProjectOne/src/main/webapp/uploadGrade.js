  
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
      	
      	//Insert Event Description
      	var descCell = row.insertCell(4);
      	var description = document.createTextNode(record["description"]);
      	descCell.appendChild(description);

        //Insert Grading Format
        var gradeCell= row.insertCell(5);
        var gradetype= document.createTextNode(record["gradingFormat"]);
        gradeCell.appendChild(gradetype);
        
        //Insert File Cell
        var fileCell = row.insertCell(6);
        
        
        //Get Files
        var requestid = record["requestid"];
        
        function loadFiles() {
		    var xhreq;
		    if (window.XMLHttpRequest) {
		        xhreq = window.XMLHttpRequest();
		    } else {
		        xhreq = new ActiveXObject("MicrosoftXMLHTTP");
		    }
		
		    xhreq.onreadystatechange = function () {
		        if (this.readystate == 4 && this.status == 200) {
		            var fileJSON =  xhreq.response;
		            viewFiles(fileJSON);
		        }
		    }
		    xhreq.open("get", "http://localhost:8080/ProjectOne/api/uploadGrade.html/" + requestid, true)
		    
		    xhreq.send();
	    }
	    
	    function viewFiles(fileJSON){
	    	var fileObjectList = JSON.parse(fileJSON);
	    	
	    	var bytes = function base64ToArrayBuffer(fileObjectList) {
     			var binaryString = window.atob(fileObjectList);
     			var binaryLength = binaryString.length;
     			var bytes = new Uint8Array(binaryLength);
     			for (var i = 0; i < binaryLength; i++) {
        			var ascii = binaryString.charCodeAt(i);
        			bytes[i] = ascii;
     			}
     			return bytes;
 			}
	    	
	    	for (let i = 0; i < bytes.length; i++) {
	    		var fileObject = bytes[i];
	
		        var fileRequestId = fileObject["requestid"];
		        
		        if (fileRequestId == requestid) {
			        var fileByteArray = fileObject["file"];
			        var fileName = fileObject["filename"];
			        var extension = fileObject["extension"];
			
			        function saveByteArray() {
			            var blob = new Blob(fileByteArray, {type: "application/" + extension});
			            var link = document.createElement('a');
			            var linkText = document.createTextNode(fileName);
			            link.appendChild(linkText);
			            link.title = fileName;
			            link.href = window.URL.createObjectURL(blob);
			            link.download = fileName;
			            link.click();
			        }
			        
			    //Put link in cell
			    var gradeOrPres= document.createTextNode(link);
	        	fileCell.appendChild(gradeOrPres);    
			        
		        }
		    }
    	}
	}    
}
