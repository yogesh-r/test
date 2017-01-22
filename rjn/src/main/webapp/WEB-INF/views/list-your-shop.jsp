<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="common/meta.jsp"%>
<link rel="shortcut icon" href="favicon.png" type="image/png" />
<title>List your Shop</title>
</head>
<body>
	<%@include file="header/application_header.jsp"%>
	<main class="main-contents list-your-space">
	<div class="container">
		<div class="row no-gutter">
			<div class="col-md-6">
				<h4>Business Enquiry</h4>
				<form class="business-enquiry-form" action="${rc.getContextPath()}/public/list_your_space"
					method="post">
					<div class="form-group">
						<label for="contact_person">Contact Person</label> <input
							type="text" name="venueManagerName" id="contact_person" class="form-control"
							required>
					</div>
					<div class="form-group">
						<label for="property_name">Property Name</label> <input
							type="text" name="propertyName" id="property_name"
							class="form-control" required>
					</div>
					<div class="form-group">
						<label for="contact_number">Contact Number</label> <input
							type="text" name="mobileNo" id="contact_number" required
							pattern=[0-9]{10} maxlength="10"
							title="phone number should be 10 digits(Ex:9749692397)"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="alt_contact_number">Alt. Contact Number</label> <input
							type="text" name="altMobileNo" id="alt_contact_number"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email" name="email"
							id="email" required class="form-control">
					</div>
					<div class="form-group">
						<label for="address">Address</label>
						<textarea name="address" id="address" rows="4" cols="40"
							class="form-control" required></textarea>
					</div>
					<div class="form-group">
						<label for="additional_notes">Additional Notes</label>
						<textarea name="addtionalNotes" id="additional_notes" rows="6"
							cols="40" class="form-control"></textarea>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-md-5 col-md-offset-1">
				<img
					src="${rc.getContextPath()}/resources/images/list-your-space/fb.jpg"
					alt="List your space" class="img-responsive">
			</div>
		</div>
	</div>
	</main>
	<%@include file="footer/application_footer.jsp"%>
</body>
</html>