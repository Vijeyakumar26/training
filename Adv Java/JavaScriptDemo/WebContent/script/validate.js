function validateRegistrationForm()
{
	let validationStatus=true;
	let username = document.getElementById("uname").value;
	let password = document.getElementById("pwd").value;
	let address = document.getElementById("address").value;
	let contactno = document.getElementById("contact").value;
	let email = document.getElementById("email").value;
	let gender = document.getElementById("gender").value;

	if(username=="")
	{
		document.getElementById("unamemsg").innerHTML=" Username is Mandatory";
		document.getElementById("unamemsg").style.color="blue";
		validationStatus=false;
	}
	else
	{
		document.getElementById("unamemsg").innerHTML="";
	}

	if( password=="")
	{
		document.getElementById("pwdmsg").innerHTML="Password is mandatory";
		document.getElementById("pwdmsg").style.color="blue";
		validationStatus=false;
	}
	else
	{
		document.getElementById("pwdmsg").innerHTML="";
	}

	if(contactno=="")
	{
		document.getElementById("contactmsg").innerHTML="ContactNo is Mandatory";
		document.getElementById("contactmsg").style.color="blue";
		validationStatus=false;
	}
	else
	{
		
//		let phonepattern= "/^([6-9]1[0-9]{9})$/";                    //"/^[0-9]{10}"
		if(/^([6-9]{1}[0-9]{9})$/.test(contactno))
		{
			document.getElementById("contactmsg").innerHTML="";
		}
		else
		{
			document.getElementById("contactmsg").innerHTML="Invalid Number";
			validationStatus=false;
		}
	}

	//email
	if(email=="")
	{
		document.getElementById("emailmsg").innerHTML="Email is mandatory";
		document.getElementById("emailmsg").style.color="blue";
		validationStatus=false;
	}
	else
	{
		let emailpattern= /^(?=.{7,30}$)[^.@]+@{1}[a-zA-Z.-]+.(m|n)$/;
		if(emailpattern.test(email))
		{
			document.getElementById("emailmsg").innerHTML="";
		}
		else
		{
			document.getElementById("emailmsg").innerHTML="Invalid Email ID";
			validationStatus=false;
		}
	}
	return validationStatus;
}
function showValue()
{
	document.getElementById("skillmsg").innerHTML="Selected : "+ document.getElementById("skills").value;
}
function loadPage()
{
	 alert("Page Loading!");
}
