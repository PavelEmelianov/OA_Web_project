<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<script type="application/javascript">
					
    	function deleteFunction(id){
    		var id = id;
    		var animal ={
    				id : id
    		};
    		var data = JSON.stringify(animal);
    		 $.ajax({	    	
    			 type: "DELETE",
                 url: "api/animals",
                 data: data,
                 contentType: "application/json; charset=utf-8",
                 dataType: "json",
                 success: function() {
     	    	    window.location.reload(true);
     	    	}   
     	    });    		
    	}
    $.getJSON("api/animals", function (data) {
        var trHTML = '';
        $.each(data, function (index, value) {
            trHTML +='<tr><td>'+value.id+'</td><td>' + value.animal_name + '</td><td>' + value.animal_price + '</td><td><form action="Food.jsp?id='+value.id+'" method="POST"><input type="submit" value="Show Food"></form></td><td><form action="Tools.jsp?id='+value.id+'" method="POST"><input type="submit" value="Show Tools"></form></td><td><button id="btn_delete" onclick ="deleteFunction('+value.id+')">Delete</button></td></tr>';
        });
        $('#animals_table').append(trHTML);
    });
    $(document).ready(function(){
    	$("#btn_create").click(function(){
    		var name = $('input[name="name"]').val();
    	    var price = $('input[name="price"]').val();
    	    var animal ={
    	    		animal_name : name,
    	    		animal_price : price
    	    };
    	    var data = JSON.stringify(animal);
    	    $.ajax({	    	
    	    	type: "POST",
    	    	url: "api/animals",
    	    	data: data,
    	    	contentType: "application/json; charset=utf-8",
    	    	dataType: "json",  	  
    	    	success: function() {
    	    	    window.location.reload(true);
    	    	}   	    	
    	    });    	      		
    	}); 
    	$("#btn_update").click(function(){
    		var id = $('input[name="animal_id"]').val();
    		var name = $('input[name="new_name"]').val();
    	    var price = $('input[name="new_price"]').val();
    	    var animal ={
    	    		id : id,
    	    		animal_name : name,
    	    		animal_price : price
    	    };
    	    var data = JSON.stringify(animal);
    	    $.ajax({	    	
    	    	type: "PUT",
    	    	url: "api/animals",
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
		<h3>ANIMALS LIST</h3>
		<table id="animals_table" border="1" style="text-align: center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Food</th>
				<th>Tools</th>
				<th>Action</th>
			</tr>
		</table>
		<br>
		<table style="text-align: center">
			<tr>
				<th>
					<form id="create_form">
						<p>Animal name:</p>
						<input name="name">
						<p>Animal price:</p>
						<input name="price">
					</form>
					<button id="btn_create">Create</button>
				</th>
				<th>
					<form id="update_form">
						<p>Animal Id</p>
						<input name="animal_id">
						<p>New animal name:</p>
						<input name="new_name">
						<p>New animal price:</p>
						<input name="new_price">
					</form>
					<button id="btn_update">Update</button>
				</th>
			</tr>
		</table>
	</div>
</body>
</html>