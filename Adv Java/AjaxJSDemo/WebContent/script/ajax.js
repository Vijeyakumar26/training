/**
 * 
 */

var req;

function getRequestObject()
{
	if(window.ActiveXObject) 
	{	// Microsoft browser
		console.log("Microsoft Browsers!");
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	}
	else if(window.XMLHttpRequest)
	{  // other browsers
		console.log("Other browsers!!");
		return (new XMLHttpRequest());
	}
	else 
	{
		console.log("No support for AJAX");
		return (null);
	}
}
//Plain text register
function sendGetRequest()
{
	req = getRequestObject();  //request created

	var uname = document.getElementById("uname").value;
	var url = "checkUsername?uname=" + uname;

	req.open("GET", url , true);   //initialize a GET request
	req.onreadystatechange=processResponse;
	req.send();  //request sent
	console.log("Request send!");
}
//XML register
function sendGetRequest2()
{   
	//to get xml response
	req = getRequestObject();  //request created

	var uname = document.getElementById("uname").value;
	var url = "checkUsername?uname=" + uname;

	req.open("GET", url , true);   //initialize a GET request
	req.onreadystatechange=processResponse2;
	req.send();  //request sent
	console.log("Request send!");
}
//checkuser XML
function sendPostRequest()
{
	req = getRequestObject();
	var uname = document.getElementById("uname").value;
	if(uname=="")
	{
		document.getElementById("unamemsg").innerHTML = "Please enter username";
	}
	else
	{
		var url = "getUserDetails";
		req.open("POST", url , true);
		req.onreadystatechange=processXmlResponse;
		req.setRequestHeader("content-type","application/x-www-form-urlencoded");
		req.send("uname=" + uname );
	}
}

function processResponse()
{
	if(req.readyState == 4) 
	{			
		if(req.status == 200) 
		{
			console.log("Successful Response received!");
			document.getElementById("unamemsg").innerHTML = req.responseText;
		}
		else
		{
			console.log("Error status code:" + req.status);
		}
	}
}

function processResponse2() 
{
	if(req.readyState == 4)
	{			
		if(req.status == 200) 
		{
			var response = req.responseXML;
			var output =response.getElementsByTagName("MESSAGE")[0].childNodes[0].nodeValue;
			if(output == "EXISTS") 
			{
				document.getElementById("unamemsg").innerHTML = "Username already exists";
			}
			else
			{
				document.getElementById("unamemsg").innerHTML = "";
			}
		}
		else
		{
			console.log("Error status code:" + req.status);
		}
	}
}


function processXmlResponse()
{
	if(req.readyState == 4)
	{
		if(req.status == 200) 
		{
			console.log("response received!");
			document.getElementById("pwd").value= "";
			document.getElementById("address").value= "";
			document.getElementById("email").value= "";			
			document.getElementById("contact").value= "";
			document.getElementById("gender").value= "";

			var response = req.responseXML;
			let username =response.getElementsByTagName("username")[0].childNodes[0].nodeValue;
			let pwd =response.getElementsByTagName("pwd")[0].childNodes[0].nodeValue;
			let address =response.getElementsByTagName("address")[0].childNodes[0].nodeValue;
			let email =response.getElementsByTagName("email")[0].childNodes[0].nodeValue;
			let phone =response.getElementsByTagName("contact")[0].childNodes[0].nodeValue;
			let gender =response.getElementsByTagName("gender")[0].childNodes[0].nodeValue;

			document.getElementById("pwd").value= pwd;
			document.getElementById("address").value= address;
			document.getElementById("email").value= email;
			document.getElementById("contact").value= phone;
			document.getElementById("gender").value= gender;
			
			if(document.getElementById("gender").value=="M")
			{
				document.getElementById("gender").checked= true;
			}
			if(document.getElementById("gender").value=="F")
			{
				document.getElementById("genderf").checked= true;
			}
		}
		else
		{
			window.alert("Response status:" + req.status);
		}
	}
}