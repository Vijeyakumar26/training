/**
 * 
 */
$(document).ready(function()
{	
//	user details fill
	$('#uname').blur(()=>
	{
	    let data = "uname=" + $('#uname').val();
	    if(data == "uname=")
	    {
	    	$('#unamemsg').html("Please enter username");
	    }
	    else
	    {
	    	$('#unamemsg').hide();
			$.ajax({
					type:"POST",
					url:"getUserDetails",
					data: data,
					dataType: "xml",
					success: function(output) {
						console.log(output);
						let UserName = $(output).find("username").text();
						let Password = $(output).find("pwd").text();
						let Address = $(output).find("address").text();
						let contact = $(output).find("contact").text();
						let Email = $(output).find("email").text();
						let gender = $(output).find("gender").text();
						
						$('#uname').val(UserName);
						$('#pwd').val(Password);
						$('#address').val(Address);
						$('#contact').val(contact);
						$('#email').val(Email);
						$('#gender').val(gender);
						
						if(gender == 'M'){
							$('#gender').prop('checked',true);
						}
						else{
							$('#genderf').prop('checked',true);
						}
					},
					error: function(req, status, error)
					{
						console.log("Status code:" + status);
						console.log("Error :" + error);
					}
			});
	    }	
	});
});