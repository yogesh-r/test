<%@include file="admin_header.jsp"%>
<div class="content"  ng-controller="adminChangePasswordCtrl">
	
		<label for="old password">Old Password</label> <input type="password"
			class="form-control" name="oldPassword" ng-model="changePassword.oldPassword" placeholder="Old Password">
		<label for="new password">New Password</label> <input type="password"
			class="form-control" ng-model="changePassword.newPassword" name="newPassword" placeholder="New Password">
		<label for="conform password">Conform Password</label> <input
			type="password" class= ng-model="changePassword.conformPassword" name="conformPassword"
			placeholder="Conform Password">
		<button type="submit" class="btn btn-default" ng-click="saveChangePassword();">Submit</button>
		<button type="submit" class="btn btn-default">Cancel</button>
	
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/admin_change_password.js"></script>