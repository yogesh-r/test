<%@include file="../header/vendor_header.jsp"%>
<div class="main">
	<div class="container">
		<input type='hidden' id='user_id' value=''>
		<div class="panel panel-info">
			<div class="panel-heading">Change Password</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
					
							
							<label for="old password">Old Password</label>
							<input type="password" class="form-control" id="old password" placeholder="Old Password">
							
							
							<label for="new password">New Password</label>
							<input type="password" class="form-control" id="new password" placeholder="New Password">
							
							<label for="conform password">Conform Password</label>
							<input type="password" class="form-control" id="conform password" placeholder="Conform Password">
    
  							<button type="submit" class="btn btn-default">Submit</button>
						    <button type="submit" class="btn btn-default">Cancel</button>
					</div>
				</div>
			</div>
		</div>
		