<%@include file="member_header.jsp"%>
<div class="main">
	<div class="content" ng-controller="memberEditProfileCtrl">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<br>
				
				<div ng-show="enableEdit">
					<div class="pull-right ng-scope">
						<div ng-click="enableEditFunction();">Edit</div>
					</div>
					<div class="data-row">
						<label>First Name: </label>
						<div>{{thisProfile.firstName}}</div>
					</div>
					<div class="col-lg-12">
						<br>
					</div>
					<div class="data-row">
						<label>Last Name: </label>
						<div>{{thisProfile.lastName}}</div>
					</div>
					<div class="col-lg-12">
						<br>
					</div>
					<div class="data-row">
						<label>Phone Number: </label>
						<div>{{thisProfile.contactMobileNo}}</div>
					</div>
					<div class="col-lg-12">
						<br>
					</div>
					<div class="data-row">
						<label>Address: </label>
						<div>{{thisProfile.address}}</div>
					</div>
				</div>

				<div ng-show="!enableEdit">
					<label for="first name">First Name</label> <input type="text"
						ng-model="thisProfile.firstName" class="form-control"
						name="vendorFirstName" value="{{thisProfile.firstName}}">

					<label for="last name">Last Name</label> <input type="text"
						ng-model="thisProfile.lastName" class="form-control"
						name="vendorSurname" value="{{thisProfile.lastName}}">

					<label for="phone number">Phone Number</label> <input type="text"
						ng-model="thisProfile.contactMobileNo" class="form-control"
						name="pContact" value="{{thisProfile.contactMobileNo}}"> <label
						for="address">Address</label> <input
						ng-model="thisProfile.address" type="textarea"
						class="form-control" name="addr" value="{{thisProfile.address}}">
					<input type="hidden" name="id" value="{{thisProfile.id}} ">

					<button ng-click="saveMemberProfile();" class="btn btn-default">Submit</button>
					<div ng-click="enableEditFunction();" class="btn btn-default">Close</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/member-edit-profile.js"></script>