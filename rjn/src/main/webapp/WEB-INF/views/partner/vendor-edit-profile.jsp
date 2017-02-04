<%@include file="../header/vendor_header.jsp"%>
<div class="main">
	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">Edit Profile</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-3">
						<form action="${rc.getContextPath()}/vendor/edit-profile"
							method="post">
							<label for="first name">First Name</label> <input type="text"
								class="form-control" name="partFName"
								value="${PartnerDetails.partFName}"> <label
								for="last name">Last Name</label> <input type="text"
								class="form-control" name="partSurname"
								value="${PartnerDetails.partSurname}"> <label
								for="phone number">Phone Number</label> <input type="text"
								class="form-control" name="pContact"
								value="${PartnerDetails.pContact}"> 
								
								<label for="address">Address</label>
								<input type="textarea" class="form-control" name="addr"
								value="${PartnerDetails.addr}"> <input type="hidden"
								name="id" value="${PartnerDetails.id} ">

							<button type="submit" class="btn btn-default">Submit</button>
							<button type="submit" class="btn btn-default">Cancel</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>