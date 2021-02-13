/**
 * 
 */
$(document).ready(function()
{
	$('#uname').blur(()=>
	{
		let data = "uname=" + $('#uname').val();
		if(data =="uname=") 
		{
			$('#unamemsg').show();	
			$('#unamemsg').html("Please enter username");	
		}
		else
		{
			$('#unamemsg').hide();
			$.ajax(
					{
						type:"GET",
						url:"checkUsername",
						data: data,
						dataType: "xml",
						success: function(output)
						{
							console.log(output);
							let message = $(output).find("MESSAGE").text();
							console.log(message);
							if(message == 'EXISTS') 
							{
								$('#unamemsg').show();	
								$('#unamemsg').html("Username already exists");
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
