/**
 * 
 */
$(document).ready(function()
	{	
//	user details fill
	$('#show').click(function(event)
		{
			let data = "serviceid=" + $('#serviceid').val();
			if(data == "serviceid=")
			{
				$('#serviceidmsg').html("Serviceid Is Mandatory");
			}
		else
		{
			$('#serviceidmsg').hide();
			if($('#serviceid').val()=="")
			{
				$('#serviceidmsg').html("No Such ServiceID");
			}
			else
			{
				$('#serviceidmsg').hide();
			$.ajax({
				type:"POST",
				url:"getServiceDetails",
				data: data,
				dataType: "xml",
				success: function(output) {
					console.log(output);
					let serviceid = $(output).find("serviceid").text();
					let servicedesc = $(output).find("servicedesc").text();
					let price = $(output).find("price").text();
					let status = $(output).find("status").text();

					if(serviceid=="")
					{
						$('#serviceidmsg').html("No Such ServiceID");
					}
					
					$('#serviceid').val(serviceid);
					$('#servicedesc').val(servicedesc);
					$('#price').val(price);
					$('#status').val(status);
					
					
				},
				error: function(req, status, error)
				{
					console.log("Status code:" + status);
					console.log("Error :" + error);
				}
			});
			}
		}
	});
	
	$('#submit').click(()=>{
		
		 let serviceId = $('#serviceid').val(); 
		 let servicedesc = $('#servicedesc').val(); 
		 let price = $('#price').val(); 
		 let status = $('#status').val(); 
		 
		 if(serviceId == "" || serviceId == null)
		 {			 			 
			$('#serviceidmsg').show();			
			 $('#serviceidmsg').html("ServiceId is Mandatory");
			 event.preventDefault();
		 }
		 
		 if(servicedesc == "" || servicedesc == null)
		 {			 			 
			$('#servicedescmsg').show();			
			 $('#servicedescmsg').html("Service Desc is Mandatory");
			 event.preventDefault();
		 }
		 
		 if(price == "" || price == null)
		 {			 			 
			$('#pricemsg').show();			
			 $('#pricemsg').html(" Price is Mandatory ");
			 event.preventDefault();
		 }
		 
		 if(status == "" || status == null)
		 {			 			 
			$('#statusmsg').show();			
			 $('#statusmsg').html("Status is Mandatory");
			 event.preventDefault();
		 }	 
	});
});