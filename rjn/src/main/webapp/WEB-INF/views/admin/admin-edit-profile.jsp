<%@include file="admin_header.jsp"%>
<div class="main">
	<div class="container">
		<input type='hidden' id='user_id' value=''>
		<div class="panel panel-info">
			<div class="panel-heading">Edit Profile</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
					
							
							<label for="first name">First Name</label>
							<input type="text" class="form-control" id="first name" placeholder="First Name">
							
							
							<label for="last name">Last Name</label>
							<input type="text" class="form-control" id="last name" placeholder="Last Name">
							
							<label for="phone number">Phone Number</label>
							<input type="text" class="form-control" id="phone number" placeholder="Phone Number">
							
							<label for="address">Address</label>
							<input type="area" class="form-control" id="address" placeholder="Address">
    
  							<button type="submit" class="btn btn-default">Submit</button>
						    <button type="submit" class="btn btn-default">Cancel</button>
					</div>
				</div>
			</div>
		</div>