<%@include file="../header/vendor_header.jsp"%>
<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<form action="${rc.getContextPath()}/vendor/edit-profile" method="post">
					<label for="first name">First Name</label> <input type="text"
						class="form-control" name="vendorFirstName"
						value="${vendorDetails.vendorFirstName}"> <label
						for="last name">Last Name</label> <input type="text"
						class="form-control" name="vendorSurname"
						value="${vendorDetails.vendorSurname}"> <label
						for="phone number">Phone Number</label> <input type="text"
						class="form-control" name="pContact"
						value="${vendorDetails.pContact}"> <label for="address">Address</label>
					
						<input type="textarea" class="form-control" name="addr"
						value="${vendorDetails.address}"> <input type="hidden"
						name="id" value="${vendorDetails.id} ">

					<button type="submit" class="btn btn-default">Submit</button>
					<button type="submit" class="btn btn-default">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</div>