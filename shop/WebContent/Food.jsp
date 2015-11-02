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
		var food ={
				id : id
		};
		var data = JSON.stringify(food);
		 $.ajax({	    	
			 type: "DELETE",
             url: "api/food",
             data: data,
             contentType: "application/json; charset=utf-8",
             dataType: "json",
             success: function() {
 	    	    window.location.reload(true);
 	    	}   
 	    });    		
	}
	
    $.getJSON("api/food/"+getParameterByName('id'), function (data) {
        var trHTML = '';
        $.each(data, function (index, value) {
            trHTML +='<tr><td>'+value.id+'</td><td>' + value.food_name + '</td><td>' + value.food_origin + '</td><td>'  + value.food_price + '</td><td><button id="btn_delete" onclick ="deleteFunction('+value.id+')">Delete</button></td></tr>';
        });
        $('#food_table').append(trHTML);
    });	
    
    $(document).ready(function(){
    	$("#btn_create").click(function(){
    		var name = $('input[name="name"]').val();
    	    var origin = $('input[name="origin"]').val();
    	    var price = $('input[name="price"]').val();
    	    var animals_id = getParameterByName('id');
    	    var food ={
    	    		food_name : name,
    	    		food_origin : origin,
    	    		food_price : price,
    	    		animals_id : animals_id	    		
    	    };
    	    var data = JSON.stringify(food);
    	    $.ajax({	    	
    	    	type: "POST",
    	    	url: "api/food",
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
    	    var food ={
    	    		id : id,
    	    		food_name : name,
    	    		food_origin : origin,
    	    		food_price : price
    	    };
    	    var data = JSON.stringify(food);
    	    $.ajax({	    	
    	    	type: "PUT",
    	    	url: "api/food",
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
	<h3>FOOD LIST</h3>
		<table id="food_table" border="1" style="text-align: center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Origin</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</table>
		<br>
		<table style="text-align: center">
			<tr>
				<th>
					<form id="create_form">
						<p>Food name:</p>
						<input name="name">
						<p>Food origin:</p>
						<input name="origin">
						<p>Food price:</p>
						<input name="price">
					</form>
					<button id="btn_create">Create</button>
				</th>
				<th>
					<form id="update_form">
						<p>Food Id</p>
						<input name="id">
						<p>New food name:</p>
						<input name="new_name">
						<p>Food origin:</p>
						<input name="new_origin">
						<p>Food price:</p>
						<input name="new_price">
					</form>
					<button id="btn_update">Update</button>
				</th>
			</tr>
		</table>
	</div>
</body>
</html>