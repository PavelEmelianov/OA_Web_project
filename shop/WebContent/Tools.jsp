<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<script type="application/javascript">
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	function deleteFunction(id){
		var id = id;
		var tool ={
				id : id
		};
		var data = JSON.stringify(tool);
		 $.ajax({	    	
			 type: "DELETE",
             url: "api/tools",
             data: data,
             contentType: "application/json; charset=utf-8",
             dataType: "json",
             success: function() {
 	    	    window.location.reload(true);
 	    	}   
 	    });    		
	}
	
    $.getJSON("api/tools/"+getParameterByName('id'), function (data) {
        var trHTML = '';
        $.each(data, function (index, value) {
            trHTML +='<tr><td>'+value.id+'</td><td>' + value.tool_name + '</td><td>' + value.tool_origin + '</td><td>' + value.tool_weight + '</td><td>' + value.tool_price + '</td><td><button id="btn_delete" onclick ="deleteFunction('+value.id+')">Delete</button></td></tr>';
        });
        $('#tools_table').append(trHTML);
    });	
    
    $(document).ready(function(){
    	$("#btn_create").click(function(){
    		var name = $('input[name="name"]').val();
    	    var origin = $('input[name="origin"]').val();
    	    var price = $('input[name="price"]').val();
    	    var weight = $('input[name="weight"]').val();
    	    var animals_id = getParameterByName('id');
    	    var tool ={
    	    		tool_name : name,
    	    		tool_origin : origin,
    	    		tool_price : price,
    	    		tool_weight : weight,
    	    		animals_id : animals_id	    		
    	    };
    	    var data = JSON.stringify(tool);
    	    $.ajax({	    	
    	    	type: "POST",
    	    	url: "api/tools",
    	    	data: data,
    	    	contentType: "application/json; charset=utf-8",
    	    	dataType: "json",  	  
    	    	success: function() {
    	    	    window.location.reload(true);
    	    	}    	    	
    	    });    	      		
    	}); 
    	$("#btn_update").click(function(){
    		var id = $('input[name="id"]').val();
    		var name = $('input[name="new_name"]').val();
    	    var origin = $('input[name="new_origin"]').val();
    	    var price = $('input[name="new_price"]').val();
    	    var weight = $('input[name="new_weight"]').val();
    	    var tool ={
    	    		id : id,
    	    		tool_name : name,
    	    		tool_origin : origin,
    	    		tool_price : price,
    	    		tool_weight : weight
    	    };
    	    var data = JSON.stringify(tool);
    	    $.ajax({	    	
    	    	type: "PUT",
    	    	url: "api/tools",
    	    	data: data,
    	    	contentType: "application/json; charset=utf-8",
    	    	dataType: "json",  	  
    	    	success: function() {
    	    	    window.location.reload(true);
    	    	}    	    	
    	    });    	      		
    	}); 
    }); 
	</script>

	<div align="center">
	<h3>TOOLS LIST</h3>
		<table id="tools_table" border="1" style="text-align: center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Origin</th>
				<th>Weight</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</table>
		<br>
		<table style="text-align: center">
			<tr>
				<th>
					<form id="create_form">
						<p>Tool name:</p>
						<input name="name">
						<p>Tool origin:</p>
						<input name="origin">
						<p>Tool price:</p>
						<input name="price">
						<p>Tool weight:</p>
						<input name="weight">
					</form>
					<button id="btn_create">Create</button>
				</th>
				<th>
					<form id="update_form">
						<p>Tool Id</p>
						<input name="id">
						<p>New tool name:</p>
						<input name="new_name">
						<p>Tool origin:</p>
						<input name="new_origin">
						<p>Tool price:</p>
						<input name="new_price">
						<p>Tool weight:</p>
						<input name="new_weight">
					</form>
					<button id="btn_update">Update</button>
				</th>
			</tr>
		</table>
	</div>
</body>
</html>