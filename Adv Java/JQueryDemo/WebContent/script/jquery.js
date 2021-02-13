/**
 * 
 */
$(document).ready(function()
{
	console.log("Page Loaded!");
	console.log("Jquery Loaded!");
	$("div").hide();
	
	$("#submit").click(function(event)
	{
			
		let uname = $('#uname').val();
		let pwd = $('#pwd').val();
		let contact = $('#contact').val();
		let email = $('#email').val();
		
		if(uname=="")
		{
			event.preventDefault();
			$('#unamemsg').show();
			$('#unamemsg').html('Username is Mandatory!');
			$('#unamemsg').css('color', 'blue');
		}
		else
		{
			$('#unamemsg').fadeOut(3000);
		}
		//password Validation
		if(pwd=="")
		{
			event.preventDefault();
			$('#pwdmsg').show();
			$('#pwdmsg').html('Password is Mandatory!');
			$('#pwdmsg').css('color', 'blue');
		}
		else
		{
			$('#pwdmsg').fadeOut(3000);
		}
		//contact Validation
		if(contact=="")
		{
			event.preventDefault();
			$('#contactmsg').show();
			$('#contactmsg').html('Contact No is Mandatory!');
			$('#contactmsg').css('color', 'blue');
		}
		else
		{
			if(/^([6-9]{1}[0-9]{9})$/.test(contact))
			{
				$('#contactmsg').fadeOut('slow');
			}
			else
			{
				event.preventDefault();
				$('#contactmsg').html('Invalid Mobile Number');
				$('#contactmsg').css('color', 'red');
				$('body').css('background-color', '#FA8072');
			}
		}
		//Email Validation
		if(email=="")
		{
			event.preventDefault();
			$('#emailmsg').show();
			$('#emailmsg').html('Email is Mandatory!');
			$('#emailmsg').css('color', 'blue');
		}
		else
		{
			let emailpattern= /^(?=.{7,30}$)[^.@]+@{1}[a-zA-Z.-]+.(m|n)$/;
			if(emailpattern.test(email))
			{
				$('#emailmsg').fadeOut('slow');
			}
			else
			{
				event.preventDefault();
				$('#emailmsg').html('Invalid Email ID');
				$('#emailmsg').css('color', 'red');
				$('body').css('background-color', '#FA8072');
			}
		}
	});
	
	$("#skills").change(()=>
	{
		$('#skillmsg').html('<h5>Selected :</h5>'+ $("#skills").val().css("color", "blue"));
	});
	
	$("#submit").click(function()
	{
		$("div").animate({
		    });
	}); 
	$("h1").click(function()
	{
		$("div").slideDown(2000);
		
	}); 
});
