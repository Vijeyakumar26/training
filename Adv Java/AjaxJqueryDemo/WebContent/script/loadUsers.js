/**
 * 
 */

$(document).ready(()=>
{	  
	  $.ajax({
			type:"GET",
			url:"GetAllUserServlet",
			dataType: "xml",
			success: function(output) 
			{
				console.log(output);
				$(output).find("user").each(function () 
				{					
					$('#usernames').append(new Option($(this).find("username").text()));	
			
				});
//				$(output).find("user").each(()=>
//				{
////					$('#usernames').append(new Option($(this).find("username").text()));
//				});
			},
			error: function(req, status, error)
			{
				console.log("Status code:" + status);
				console.log("Error :" + error);
			}
	  });
});  