<%@include file="../header/vendor_header.jsp"%>
<div class="main">
	<div class="content" ng-controller="vendorEditProfileCtrl">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<br>
				<div ng-show="enableEdit">
					<div class="pull-right ng-scope">
						<div ng-click="enableEditFunction();" style="cursor:pointer;"><a>Edit</a></div>
					</div>
					<div class="data-row">
						<label>First Name: </label>
						<div>{{thisProfile.vendorFirstName}}</div>
					</div>
					<div class="col-lg-12">
						<br>
					</div>
					<div class="data-row">
						<label>Last Name: </label>
						<div>{{thisProfile.vendorSurname}}</div>
					</div>
					<div class="col-lg-12">
						<br>
					</div>
					<div class="data-row">
						<label>Phone Number: </label>
						<div>{{thisProfile.pContact}}</div>
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
						ng-model="thisProfile.vendorFirstName" class="form-control"
						name="vendorFirstName" value="{{thisProfile.vendorFirstName}}">

					<label for="last name">Last Name</label> <input type="text"
						ng-model="thisProfile.vendorSurname" class="form-control"
						name="vendorSurname" value="{{vendorDetails.vendorSurname}}">

					<label for="phone number">Phone Number</label> <input type="text"
						ng-model="thisProfile.pContact" class="form-control"
						name="pContact" value="{{vendorDetails.pContact}}"> <label
						for="address">Address</label> <input
						ng-model="thisProfile.address" type="textarea"
						class="form-control" name="addr" value="{{vendorDetails.address}}">
					<input type="hidden" name="id" value="{{vendorDetails.id}} ">

					<button ng-click="saveVendorProfile();" class="btn btn-default">Submit</button>
					<div ng-click="enableEditFunction();" class="btn btn-default">Close</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-edit-profile.js"></script>