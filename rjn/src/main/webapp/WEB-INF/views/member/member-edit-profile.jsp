<%@include file="member_header.jsp"%>
<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4">
				<form action="${rc.getContextPath()}/member/edit-profile"
					method="post">
					<label for="first name">First Name</label> <input type="text"
						class="form-control" name="firstName"
						value="${memberDetails.firstName} "> <label
						for="last name">Last Name</label> <input type="text"
						class="form-control" name="lastName"
						value="${memberDetails.lastName}"> <label
						for="phone number">Phone Number</label> <input type="text"
						class="form-control" name="contactMobileNo"
						value="${memberDetails.contactMobileNo}"> <label
						for="address">Address</label> <input type="text"
						class="form-control" name="address"
						value="${memberDetails.address}">

					<button type="submit" class="btn btn-default">Submit</button>
					<button type="submit" class="btn btn-default">Cancel</button>
					<input type="hidden" name="id" value="${memberDetails.id} ">
					<input type="hidden" name="profileNumber"
						value="${memberDetails.profileNumber} ">
				</form>
			</div>
		</div>
	</div>
</div>