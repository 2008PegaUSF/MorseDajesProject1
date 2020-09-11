//Load the page
window.onload=function(){
	console.log("I'm on the page (Poggers)")
	this.document.getElementById("logout").addEventListener("click",logout,true);
}

//Logout
function logout(event){
	console.log("I'm logging out (Poggers)");
	//STEP 1
	 var xhr = new XMLHttpRequest();
	//STEP 2
	xhr.onreadystatechange = function(){
		if (xhr.readyState==4 && xhr.status==200){
			console.log("Poggers McPoggers");
            //console.log(xhr.responseText);
        }
	}
	//STEP 3
	xhr.open("GET","http://localhost:8080/ProjectOne/api/logout",true);
	//Step 4
	xhr.send();
}