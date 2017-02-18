<%@include file="../header/vendor_header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content" ng-controller="vendorBranchListCtrl">
	<div class="col-md-1">
		<input ng-click="addForm();"
			class="form-control btn-primary pull-left" value="Add" />
	</div>
	<div ng-if="displayAddForm"></br></br></br>
		<div class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Vendor:</label>
				<div class="col-sm-10">
					<select ng-model="thisBranch.branchOwner" name="branchOwner" class="form-control" id="branch_owner">
						<option value="${vendorDetails.id}">${vendorDetails.id}</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Name:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.branchName"  type="text" value="{{thisBranch.branchName}}"
						id="branchName" name="branchName" class="form-control" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Start Date:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.startDate" value="{{thisBranch.startDate}}" type='text'
						class="form-control" name="startDate" id="duedate"
						placeholder="Start Date" required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">contact No:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.contactNo" value="{{thisBranch.contactNo}}" type='text'
						class="form-control" name="contactNo" placeholder="Contact No"
						required />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Description:</label>
				<div class="col-sm-10">
					<TEXTAREA ng-model="thisBranch.description" name="description" class="form-control" rows="4"
						maxlength="500" required>{{thisBranch.description}}</TEXTAREA>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Address:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.address" id="autocomplete" name="address"
						placeholder="Enter your address" value="{{thisBranch.address}}"
						type="text" class="form-control"></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Address Line 1:</label>
				<div class="col-sm-10">
					<input  ng-model="thisBranch.address" value="{{thisBranch.address}}" class="field form-control"
						id="street_number" name="addr" placeholder="Enter Your Door No."
						required></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Address Line 2:</label>
				<div class="col-sm-10">
					<input  ng-model="thisBranch.address" value="{{thisBranch.address}}" class="field form-control"
						id="route" name="route"></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Location:</label>
				<div class="col-sm-10">
					<input  ng-model="thisBranch.location" class="field form-control" value="{{thisBranch.location}}"
						id="sublocality_level_1" name="location" readOnly required></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">City:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.city" class="field form-control" id="locality"
						value="{{thisBranch.city}}" name="city" required readOnly></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">State:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.state" class="field form-control" name="state"
						value="{{thisBranch.state}}" id="administrative_area_level_1"
						readOnly></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Country:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.country"  value="{{thisBranch.country}}" class="field form-control"
						name="country" id="country" readOnly></input>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">ZipCode:</label>
				<div class="col-sm-10">
					<input ng-model="thisBranch.zipcode" type="text" name="zipcode" id="postal_code"
						value="{{thisBranch.zipcode}}" class="field form-control" readOnly>
				</div>
			</div>

			<input ng-model="thisBranch.latitude"  type="hidden" class="field form-control" id="latitude"
				value="{{thisBranch.latitude}}" name="latitude"></input> 
				
				<input
				ng-model="thisBranch.longitude"  type="hidden" class="field form-control" id="longitude"
				value="{{thisBranch.longitude}}" name="longitude"></input> 
				
				<input
				ng-model="thisBranch.id" type="hidden" class="field form-control" value="{{thisBranch.id}}"
				name="id"></input>
				
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" ng-click="saveBranch(thisBranch)" value="Save" class="form-control btn-primary">
				</div>
			</div>
			<input ng-click="closeForm();" class="form-control btn-primary" value="Close" />
		</div>
		
	</div>
	<div ng-if="!displayAddForm">
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Branch Code</th>
					<th>Branch Name</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="ResultArea">
				<tr ng-repeat="thisBranch in branchList">
					<td>{{thisBranch.id}}</td>
					<td>{{thisBranch.branchName}}</td>
					<td>{{thisBranch.contactNo}}</td>
					<td>{{thisBranch.address}}</td>
					<td><a
						href="${rc.getContextPath()}/vendor/register-branch/{{thisBranch.uniqueId}}">edit</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@include file="../include/js_include.jsp"%>
<script
	src="${rc.getContextPath()}/resources/develoepr-js/vendor-branch-list.js"></script>
