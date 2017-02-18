<%@include file="../header/vendor_header.jsp"%>
<div class="content" ng-controller="vendorChangePasswordCtrl">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-4">
			<label for="old password">Old Password</label> 
			<input type="password"
				ng-model="changePassword.oldPassword" class="form-control" name="oldPassword" placeholder="Old Password">
			<label for="new password">New Password</label> 
			<input type="password"
				ng-model="changePassword.newPassword" class="form-control" name="newPassword" placeholder="New Password">
			<label for="conform password">Conform Password</label> 
			<input
				ng-model="changePassword.conformPassword" type="password" class="form-control" name="conformPassword"
				placeholder="Conform Password">

			<button ng-click="saveChangePassword();" class="btn btn-default">Submit</button>
			<button class="btn btn-default">Cancel</button>
		</div>
	</div>
</div>

<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-change-password.js"></script>