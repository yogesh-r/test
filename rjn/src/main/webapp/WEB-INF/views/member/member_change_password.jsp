<%@include file="member_header.jsp"%>
<div class="main">
	<div class="container" ng-controller="memberChangePasswordCtrl">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4">
				<label for="old password">Old Password</label> <input
					type="password" ng-model="changePassword.oldPassword"
					class="form-control" name="oldPassword" placeholder="Old Password">
				<label for="new password">New Password</label> <input
					type="password" class="form-control" name="newPassword"
					ng-model="changePassword.newPassword" placeholder="New Password">
				<label for="conform password">Conform Password</label> <input
					type="password" class="form-control"
					ng-model="changePassword.conformPassword" name="conformPassword"
					placeholder="Conform Password">

				<button type="submit" class="btn btn-default"
					ng-click="saveChangePassword();">Submit</button>
				<button type="submit" class="btn btn-default">Cancel</button>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/member_change_password.js"></script>