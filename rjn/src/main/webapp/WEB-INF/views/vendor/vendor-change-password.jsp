<%@include file="../header/vendor_header.jsp"%>
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-4">
		<form action="${rc.getContextPath()}/vendor/change-password"
			method="POST">
			<label for="old password">Old Password</label> <input type="password"
				class="form-control" name="oldPassword" placeholder="Old Password">
			<label for="new password">New Password</label> <input type="password"
				class="form-control" name="newPassword" placeholder="New Password">
			<label for="conform password">Conform Password</label> <input
				type="password" class="form-control" name="conformPassword"
				placeholder="Conform Password">

			<button type="submit" class="btn btn-default">Submit</button>
			<button type="submit" class="btn btn-default">Cancel</button>
		</form>
	</div>
</div>